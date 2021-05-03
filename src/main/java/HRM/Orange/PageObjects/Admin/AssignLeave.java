package HRM.Orange.PageObjects.Admin;

 

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import HRM.Orange.PageObjects.BaseClass;
import HRM.Orange.PageObjects.GenericMethods;
import HRM.Orange.Utilities.WaitTypes;

public class AssignLeave extends BaseClass {
	
	  
	
	
	
	
	
	@FindBy(xpath="//tbody/tr[1]/td[1]/div[1]/a[1]/img[1]")
   WebElement Assignleave;
	
	@FindBy(id="assignleave_txtEmployee_empName")
	WebElement Employeename;
	
	@FindBy(css="#assignleave_txtLeaveType")
	WebElement leaveType;
	
	
	@FindBy(xpath="//input[@id='assignleave_txtFromDate']")
	WebElement FromDate;
	
	@FindBy(xpath="assignleave_txtToDate")
	WebElement ToDate;
	
	@FindBy(id="assignleave_txtComment")
	WebElement Comment;
	
	@FindBy(id="assignBtn")
	WebElement asgnbtn;

	
	public AssignLeave() {
		
		 
	PageFactory.initElements(driver, this);
		
	}
	
	 public void autocomplete() throws InterruptedException {
		 
		 String textToSelect ="Sania Shaheen";
		 
		 WebElement autoOptions= driver.findElement(By.id("assignleave_txtEmployee_empName"));
		    autoOptions.sendKeys("Sania");

		    List<WebElement> optionsToSelect = driver.findElements(By.xpath("//body/div[6]/ul[1]/li[1]"));

		    for(WebElement option : optionsToSelect){
		        System.out.println(option);
		        if(option.getText().equals(textToSelect)) {
		            System.out.println("Trying to select: "+textToSelect);
		            Thread.sleep(1000);
		            option.click();
		            break;
		        }
		        
		    }
	 }
	
	
	
	
	public void assgnleave(String leavetype,String Date,String Date1,String comment ) throws InterruptedException {
		
	Assignleave.click();
	
	  autocomplete();

		Sleep(3000);
		
	      Select sel = new Select(leaveType);
	      sel.selectByVisibleText(leavetype);
	      
	      Sleep(1000);
	      
		FromDate.click();
		GenericMethods.DatePicker(Date);
		
	
		Sleep(2000);
		ToDate.clear();
		ToDate.click();
	    
		
		GenericMethods.DatePicker(Date1);
		
		Sleep(2000);
		Comment.sendKeys(comment);
		
		
		
		asgnbtn.click();
		
	}
	
}
