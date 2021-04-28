package HRM.Orange.PageObjects.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import HRM.Orange.PageObjects.GenericMethods;

public class Admin  {
	
	WebDriver driver;
	
	
	public Admin(WebDriver driver) {
			
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	 
	
	
	
	@FindBy(xpath="//input[@id='searchSystemUser_userName']")
	WebElement username;
	
	@FindBy(id="searchSystemUser_userType")
	WebElement Userrole;
	
	@FindBy(name="searchSystemUser[employeeName][empName]")
	WebElement employeename;
	
	@FindBy(id="searchSystemUser_status")
	WebElement Status;
	
	@FindBy(id="searchBtn")
	WebElement searchbutton;
	
	
	
	
	
	public void openAdminlink(String uname, String role, String empname, String status) {
		
		
		
		username.sendKeys(uname);
		
		 Select se = new Select(Userrole);
		 se.selectByVisibleText(role);
		 
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 employeename.sendKeys(empname);
		 
		Select se1 = new Select(Status);
		
		se1.selectByVisibleText(status);
		
		searchbutton.click();
		
		
		
		
		
		
		 
		 
		 
		 
		 
		 
		
		
	}

}
