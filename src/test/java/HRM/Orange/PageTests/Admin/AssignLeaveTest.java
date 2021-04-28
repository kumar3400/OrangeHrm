package HRM.Orange.PageTests.Admin;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HRM.Orange.PageObjects.BaseClass;
import HRM.Orange.PageObjects.Admin.AssignLeave;
import HRM.Orange.Utilities.ExcelUtility;
 
 

public class AssignLeaveTest  extends BaseClass{

	private String sheetName ="Sheet1";
	
	//public String xlFilepath =System.getProperty("user.dir")+"/src/main/java/HRM/Orange/TestData/HrmNewData.xlsx";
	/*@Test

	public void assignleave() throws InterruptedException {
		
		AssignLeave asn = new  AssignLeave();
		
		asn.leaveasgn();
		
			
		
	}
	
	*/
	@Test(dataProvider="AssignLeave")
	
	public void Assignleave(String leavetype, String Date, String Date1 , String comment) throws InterruptedException {
		
		AssignLeave asgn = new AssignLeave();
		
		asgn.assgnleave(leavetype, Date, Date1, comment);
	}
	
	
	@DataProvider(name = "AssignLeave")
	public Object[][] dataProvider(){
		try {
			ExcelUtility.setExcelFile(xlFilepath, sheetName);
		}catch (Exception e) {
			e.printStackTrace();
		}
			Object[][] testData = ExcelUtility.getTestData("AssignLeave");
			return testData;			
		}
	     
	     
}

