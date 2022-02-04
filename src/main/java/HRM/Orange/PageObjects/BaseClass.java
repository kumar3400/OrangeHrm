package HRM.Orange.PageObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import HRM.Orange.PageObjects.Admin.AssignLeave;
import io.github.bonigarcia.wdm.WebDriverManager;
 



public class BaseClass {
 ReadConfig readconfig = new ReadConfig();
	 
	 public String BaseURL =readconfig.getApplicationURL();
	 
	 public static WebDriver driver;
	 
	 public String username = readconfig.getUsername();
	 
	 public String password = readconfig.getPassword();
	
	//setup method need to run before every test case
	
	public Logger logger;
	
	
	
	public static String xlFilepath = System.getProperty("user.dir")+"/src/main/java/HRM/Orange/TestData/HrmNewData.xlsx";
	
	public static void sleep(long slep) throws InterruptedException {
		
		Thread.sleep(slep);
	}
	
	// (parameter="browser")
	@BeforeClass
	public void setupMethod() throws InterruptedException
	{
		 
		String  browserName =readconfig.getBroswer();
			
		logger=Logger.getLogger("HRM");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(browserName.equals("chrome"))
		{
		//System.setProperty("webdriver.chrome.driver",readconfig.getCromePath());
			
			WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEpath());
			
			
			//added  17/03/2021 by saikumar 
			
			//in internet explorer the element is not able to clck so we are using desired capabities
			
		InternetExplorerOptions ieCapabilities = new InternetExplorerOptions();

			 ieCapabilities.setCapability("nativeEvents", false);
			ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
			ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
			ieCapabilities.setCapability("disable-popup-blocking", true);
			ieCapabilities.setCapability("enablePersistentHover", true);
			ieCapabilities.setCapability("ignoreZoomSetting", true);
			driver=new InternetExplorerDriver(ieCapabilities);
			
			
			//driver = new InternetExplorerDriver();	
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
		driver.get(BaseURL);	
		
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		logger.info("username is entered");
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		logger.info("password is entered");
		driver.findElement(By.id("btnLogin")).click();
		logger.info("login the  HRM Page");
		
		  		
		
		
		
		
	}
	
	//teardown method after every test case
	@AfterClass
	public void tearDown()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String testname) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + testname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot saved");
	}
	
	
	public static void Sleep(long time) {
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
