package HRM.Orange.PageObjects.MyInfo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmergencyContacts {

	WebDriver driver;

	public EmergencyContacts(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//b[contains(text(),'My Info')]")
	WebElement MyInfoLink;

	@FindBy(xpath = "//a[contains(text(),'Emergency Contacts')]")
	WebElement EmergencyContacts;

	@FindBy(xpath = "//input[@type='button' and  @id='btnAddContact']")
	WebElement Add;

	@FindBy(xpath = "//input[@name='emgcontacts[name]']")
	WebElement Name;

	@FindBy(xpath = "//input[@type='text' and @name='emgcontacts[relationship]']")
	WebElement Relationship;

	@FindBy(xpath = "//input[@type='text' and @name='emgcontacts[homePhone]']")
	WebElement HomeTelephone;

	@FindBy(xpath = " //input[@name='btnSaveEContact']")
	WebElement SaveButton;

	// Get total number of rows present in the table to find expected row.
	public int getRowCount() {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='emgcontact_list']//tr//td[2]"));
		int rowCount = rows.size();
		return rowCount;
	}

	// Get expected Row by matching the provided criteria to be used in and click
	// the data of table
	public int getExpectedRowNum(String user) {
		int expectedRowNum = 0;
		int rowCount = getRowCount();
		for (int i = 1; i <= rowCount; i++) {
			WebElement checkU = driver.findElement(By.xpath("//table[@id='emgcontact_list']//tr[" + i + "]/td[2]"));
			String manageAgentExpc = checkU.getText();
			if (manageAgentExpc.equalsIgnoreCase(user)) {

				System.out.println("the username is:" + manageAgentExpc);
				
				
				expectedRowNum = i;
				System.out.println("the usrname is"+manageAgentExpc);
				checkU.click();
				System.out.println(expectedRowNum);
				break;
			}
		}
		return expectedRowNum;

	}
	
	public static void Sleep(long time) {
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ADDEmergencyContacts() {

		MyInfoLink.click();

		EmergencyContacts.click();

		Add.click();

	}

	public void ADDEmergencyData(String name, String relation, String Telephn) {

		Name.clear();
		Name.sendKeys(name);
		Sleep(3000);
		

		Relationship.clear();
		Relationship.sendKeys(relation);
		
		Sleep(3000);

		HomeTelephone.clear();
		HomeTelephone.sendKeys(Telephn);
		
		Sleep(3000);

		SaveButton.click();
 
		

	}

}
