package HRM.Orange.PageTests.Admin;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HRM.Orange.PageObjects.BaseClass;
import HRM.Orange.PageObjects.GenericMethods;
import HRM.Orange.PageObjects.Admin.Admin;
import HRM.Orange.Utilities.ExcelUtility;

import junit.framework.Assert;

public class AdminPageTest extends BaseClass {

	private String sheetName = "Sheet1 ";

	@Test(dataProvider = "AdminPage")
	public void AdminTest(String uname, String role, String empname, String status, String user) {

		Actions action = new Actions(driver);

		WebElement element = driver.findElement(By.id("menu_admin_viewAdminModule"));

		System.out.println(element.isDisplayed());
		action.moveToElement(element).click().build().perform();

		Admin ad = new Admin(driver);

		ad.openAdminlink(uname, role, empname, status);

		GenericMethods gen = new GenericMethods();

		gen.clickSyndicatesLink(user);

		if (gen.getExpectedRowNum(user) != 0) {

			Assert.assertTrue(true);

		}

		else {

			Assert.assertTrue(false);
		}

	}

	@DataProvider(name = "AdminPage")
	public Object[][] dataProvider() {
		try {
			ExcelUtility.setExcelFile(xlFilepath, sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Object[][] testData = ExcelUtility.getTestData("AdminPageData");
		return testData;
	}
}
