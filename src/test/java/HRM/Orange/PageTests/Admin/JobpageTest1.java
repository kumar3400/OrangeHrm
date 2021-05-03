package HRM.Orange.PageTests.Admin;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HRM.Orange.PageObjects.BaseClass;
import HRM.Orange.PageObjects.Admin.JobPage;
 

public class JobpageTest1 extends BaseClass {

	private String SheetName = "JobData";
	
	
	@Test
	
	public void addData() throws InterruptedException {
		
		JobPage jb = new JobPage(driver);
		
		jb.adminlink();

		jb.Addjobdata();

		if (jb.oranghrmlogo.isDisplayed() == true) {

			Assert.assertTrue(true);
		}

		else {

			Assert.assertTrue(false);
		}

		
	}

	/* @Test(dataProvider="hrmdata",enabled=false)

	public void AddData(String jobtitle, String jd, String nt) throws InterruptedException {

		JobPage jb = new JobPage(driver);

		jb.adminlink();

		jb.Addjobdata(jobtitle, jd, nt);

		if (jb.oranghrmlogo.isDisplayed() == true) {

			Assert.assertTrue(true);
		}

		else {

			Assert.assertTrue(false);
		}

	}

	@DataProvider(name="hrmdata")
	public Object[][] gethrmdata() throws IOException {

		Object data[][] = OrangehrmUtil.getTestData(SheetName);
		return data;

	}
	*/

}
