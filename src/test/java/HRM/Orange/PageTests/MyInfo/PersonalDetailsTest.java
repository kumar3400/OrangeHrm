package HRM.Orange.PageTests.MyInfo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import HRM.Orange.PageObjects.BaseClass;
import HRM.Orange.PageObjects.MyInfo.PersonalDetails;
import HRM.Orange.Utilities.ExcelUtility;

public class PersonalDetailsTest extends BaseClass {

	private String sheetName = "Sheet1";

	@Test(dataProvider = "Personaldetails")
	public void PersonalDetailsPage(String fullname, String lstname, String empid, String Date, String Marritaistatus,
			 String DAOB) {

		PersonalDetails per = new PersonalDetails(driver);

		per.AddPersonalData(fullname, lstname, empid, Date, Marritaistatus, DAOB);

		String ExpectedURL = driver.getCurrentUrl();
		
 

		String actualURL = "https://opensource-demo.orangehrmlive.com/index.php/pim/viewPersonalDetails/empNumber/7";
		
		  

		if (ExpectedURL.equals(actualURL)) {

			Assert.assertTrue(true);
		}

		else {

			Assert.assertTrue(false);
		}

	}

	@DataProvider(name = "Personaldetails")
	public Object[][] dataProvider() {
		try {
			ExcelUtility.setExcelFile(xlFilepath, sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Object[][] testData = ExcelUtility.getTestData("Personal Details");
		return testData;
	}
}
