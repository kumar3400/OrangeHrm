package HRM.Orange.PageTests.MyInfo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HRM.Orange.PageObjects.BaseClass;
import HRM.Orange.PageObjects.MyInfo.EmergencyContacts;
import HRM.Orange.Utilities.ExcelUtility;
import junit.framework.Assert;

public class EmergencyContactsTest extends BaseClass {
	
	private String sheetName = "Sheet1";


	@Test(dataProvider="EmergencyContacts")

	public void EmergencyContactData(String name, String relation, String Telephn, String user) {
	

		EmergencyContacts emerg = new EmergencyContacts(driver);

		emerg.ADDEmergencyContacts();

		emerg.ADDEmergencyData(name, relation, Telephn);
		
		emerg.getExpectedRowNum(user);

		if (emerg.getExpectedRowNum(user) != 0) {
             
			
			Assert.assertTrue(true);
		}

		else {

			Assert.assertTrue(false);
		}
             
	}
	
	
	@DataProvider(name = "EmergencyContacts")
	public Object[][] dataProvider() {
		try {
			ExcelUtility.setExcelFile(xlFilepath, sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Object[][] testData = ExcelUtility.getTestData("Emergency Contacts");
		return testData;
	}

}
