package HRM.Orange.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException 
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;		
	}
	
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
	}
	
//	************* Data Provider method for Class TC_CUAS_49_Create_User_DDT using ArrayList<Object[]> ******
	
	public ArrayList<Object[]> pickDataFromXL(String xlFilePath, String sheetName) throws IOException {		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();		
		int rowNumV = XLUtils.getRowCount(xlFilePath, sheetName);		
		for(int i=1;i<=rowNumV;i++)
			{
				String utcAccCode = XLUtils.getCellData(xlFilePath, sheetName, i, 0);
				String utcUserID = XLUtils.getCellData(xlFilePath, sheetName, i, 1);
				String utcFirstName = XLUtils.getCellData(xlFilePath, sheetName, i, 2);
				String utcIncidentRef = XLUtils.getCellData(xlFilePath, sheetName, i, 3); 
				String utcEmailId = XLUtils.getCellData(xlFilePath, sheetName, i, 4); 
				String utcCompany = XLUtils.getCellData(xlFilePath, sheetName, i, 5);
				
				Object ob[]= {utcAccCode, utcUserID, utcFirstName, utcIncidentRef, utcEmailId, utcCompany};
				myData.add(ob);			}
		return myData;
		}
	
//	********* DataProvider Object[][] method for TC_CUAS_49,57 *************
	
	public Object[][] cTestData(String xlFilepath, String sheetName) throws IOException
	{		
		int rows = XLUtils.getRowCount(xlFilepath, sheetName);
		int columns = XLUtils.getCellCount(xlFilepath, sheetName, 1);
		
		Object[][] cExcelData = new Object[rows][columns];
		
		for(int i=1; i<=rows; i++)
		{
			for(int j=0; j<columns; j++)
			{
				cExcelData[i-1][j] = XLUtils.getCellData(xlFilepath, sheetName, i, j);
			}
		}
		return cExcelData;				
	}
	
	
}