package HRM.Orange.PageObjects.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobPage  {
	
	
	WebDriver driver;
	
	
	public JobPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement adminlink;
	
	@FindBy(id="menu_admin_UserManagement")
	WebElement usermang;
	
	@FindBy(id="menu_admin_Job")
	WebElement Joblink;
	
	@FindBy(id="menu_admin_viewJobTitleList")
	WebElement jobtitle;
	
	
	@FindBy(xpath="//input[@id='btnAdd']")
	WebElement buttonadd;
	
	
	@FindBy(id="jobTitle_jobTitle")
	WebElement texttitle;
	
	
	@FindBy(name="jobTitle[jobDescription]")
	WebElement jobdescription;
	
    @FindBy(id="jobTitle_jobSpec")
    WebElement choosefile;
    
    @FindBy(name="jobTitle[note]")
    WebElement Note;
    
    @FindBy(name="btnSave")
    WebElement Save;
    
    @FindBy(xpath="//body/div[@id='wrapper']/div[@id='branding']/a[1]/img[1]")
  public  WebElement oranghrmlogo;
    
    
    
    public void  adminlink() throws InterruptedException  {
    	
    	Actions action = new Actions(driver);
    	
    	System.out.println(adminlink.isDisplayed());
    	action.moveToElement(adminlink).click().build().perform();
    	
    	action.moveToElement(usermang).build().perform();
    	 
			Thread.sleep(2000);
		 
	 
    	action.moveToElement(Joblink).build().perform();
    	Thread.sleep(2000);
    	jobtitle.click();
    	
    }
    
    public void Addjobdata() {
    	
    	buttonadd.click();
    	texttitle.sendKeys("Automation tester");
    	jobdescription.sendKeys("Automation selenium");
    	
    	choosefile.sendKeys("C:\\Users\\sr464\\OneDrive - DXC Production\\Documents\\debug.log");
    	
    	Note.sendKeys("selenium webdriver");
    	
    	
    	Save.click();
    	
    }
	 
}
