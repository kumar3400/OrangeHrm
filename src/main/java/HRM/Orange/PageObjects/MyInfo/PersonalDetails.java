package HRM.Orange.PageObjects.MyInfo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import HRM.Orange.PageObjects.GenericMethods;

public class PersonalDetails {
	
	
	
        WebDriver driver;
	
	
	public PersonalDetails(WebDriver driver) {
			
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//b[contains(text(),'My Info')]")
	WebElement MyInfoLink;
	
	@FindBy(xpath="//a[contains(text(),'Personal Details')]")
	WebElement Persnldtls;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement editbtn;
	
	@FindBy(xpath="//input[@id='personal_txtEmpFirstName']")
	WebElement FullName;
	
	@FindBy(xpath="//input[@id='personal_txtEmpLastName']")
	WebElement Lastname;
	
	@FindBy(xpath="//input[@id='personal_txtEmployeeId']")
	WebElement Empid;
	
	@FindBy(xpath="//input[@id='personal_txtLicExpDate']")
	WebElement LicenseExpiry;
 
	
	@FindBy(id="personal_optGender_1")
	WebElement gender;
	
	@FindBy(xpath="//select[@id='personal_cmbMarital']")
	WebElement MaritalStatus;
	
	@FindBy(xpath="//select[@id='personal_cmbNation']")
	WebElement Nationality;
	
	@FindBy(xpath="//input[@id='personal_DOB']")
	WebElement DOB;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement Savebtn;
	
	
	
	public void SelectElement(WebElement ele,String ele1) {
		
		Select sel = new Select(ele);
		
		sel.selectByVisibleText(ele1);
	}
	
	public void AddPersonalData(String fullname,String lstname,String empid,String Date,String Marritaistatus,
 String DAOB){
		
		
		MyInfoLink.click();
		
		Persnldtls.click();
		
		editbtn.click();
		
		
		FullName.clear();
		FullName.sendKeys(fullname);
		
		Lastname.clear();
		Lastname.sendKeys(lstname);
		
		Empid.clear();
		Empid.sendKeys(empid);
		
		LicenseExpiry.click();
		GenericMethods.DatePicker(Date);
		
		gender.click();
		
	    SelectElement(MaritalStatus, Marritaistatus);
	    
	    
	 // SelectElement(Nationality, Natinlty);
	    
	    
	    DOB.click();
	    GenericMethods.DatePicker(DAOB);
	   
	    
	    Savebtn.click();
		
	}
		
  
	

}
