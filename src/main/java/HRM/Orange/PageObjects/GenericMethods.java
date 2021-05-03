package HRM.Orange.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.jcraft.jsch.Logger;

import HRM.Orange.Utilities.WaitTypes;

public class GenericMethods extends BaseClass {

	// Get total number of rows present in the table to find expected row.
	public int getRowCount() {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table hover']//tr/td[2]"));
		int rowCount = rows.size();
		return rowCount;
	}

	// Get expected Row by matching the provided criteria to be used in and click
	// the data
	public int getExpectedRowNum(String user) {
		int expectedRowNum = 0;
		int rowCount = getRowCount();
		for (int i = 1; i <= rowCount; i++) {
			WebElement checkU = driver.findElement(By.xpath("//table[@class='table hover']//tr[" + i + "]/td[2]"));
			String manageAgentExpc = checkU.getText();
			if (manageAgentExpc.equalsIgnoreCase(user)) {
				//checkU.click();
				expectedRowNum = i;
				System.out.println(expectedRowNum);
				break;
			}
		}
		return expectedRowNum;

	}

	// Clicking syndicate Button against your desired Managing Agent
	public void clickSyndicatesLink(String user) {
		int rowNum = getExpectedRowNum(user);
		WaitTypes wt = new WaitTypes(driver);
		WebElement synView = wt.waitForElement(By.xpath("//table[@class='table hover']//tr[" + rowNum + "]/td[2]"), 30);
		synView.getText();

		if (synView.getText().equalsIgnoreCase("Admin")) {

			synView.click();

			System.out.println("admin link is clicked");
		} else {

			System.out.println("admin link is not clicked");
		}

		System.out.println("the element is " + synView.getText());
		// logger.info("the element is "+synView.getText());
	}
	
	//OrangeHRM datePicker

	public static void DatePicker(String Date) {

	//	driver.findElement(By.xpath(WebElement)).click();

		//String date = "2021-Sep-20";
		
		String date =  Date;

		String dateArr[] = date.split("-");
		
		String year = dateArr[0];
		String month = dateArr[1];
		String day = dateArr[2];

		Select select = new Select(
				driver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[1]")));

		select.selectByVisibleText(month);

		Select select1 = new Select(
				driver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[2]")));
		select1.selectByVisibleText(year);

		// table//tbody/tr[1]/td[3]/a[1]
		// table//tbody/tr[2]/td[3]/a[1]
		// table//tbody/tr[3]/td[4]/a[1]

		// inside the rows cloumns xpth needs to take dynamic through loop
		String BeforeXpath = "//table[1]//tbody/tr[";

		String AfterExpath = "]/td[";

		final int totalweekdays = 7;

		// 1-1,1-2,1-3,1-4,1-5,1-6,1-7
		// 2-1,2-2,2-3,2-4,2-5,2-6,2-7

		boolean flag = false;
		for (int rownum = 1; rownum < 6; rownum++) {

			for (int colnum = 1; colnum <= totalweekdays; colnum++) {
                //String Dayvalue =driver.findElement(By.xpath("//table[1]//tbody/tr["+rownum+"]/td["+colnum+"]")).getText();
				String Dayvalue = driver.findElement(By.xpath(BeforeXpath + rownum + AfterExpath + colnum + "]"))
						.getText();

				System.out.println(Dayvalue);

				if (Dayvalue.equals(day)) {

					driver.findElement(By.xpath(BeforeXpath + rownum + AfterExpath + colnum + "]")).click();
					flag = true;
					break;
				}

			}
			if (flag) {

				break;
			}

		}

	}

}
