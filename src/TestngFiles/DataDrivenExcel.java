package TestngFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenExcel {
	
	
	@DataProvider(name="ExcelData")
	@Test
	public Object[][] ExcelDataForAllPages() throws IOException {
		Object[][] data=new Object[3][2];
		FileInputStream fis= new FileInputStream("C:\\Users\\swarn\\Downloads\\Selenium Automation SWs\\DataDrivenTestFromExcel.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int totalSheets= workbook.getNumberOfSheets();
		for(int i=0;i<totalSheets;i++) 
		{
	    if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("multidata"))
	    {
	    	XSSFSheet sheet= workbook.getSheetAt(i);
	    	Iterator<Row> rows=sheet.iterator();
	    	Row row=rows.next();
	    	int totalRows=sheet.getLastRowNum();
	    	int actualRows=sheet.getPhysicalNumberOfRows();
	    	int totalCol=row.getLastCellNum();
//	    	data=new Object[totalRows][totalCol];
	    	if(row.getCell(0).getStringCellValue().equalsIgnoreCase("username"))
    			row =rows.next();
	    
	    	for(int r=0;r<totalRows;r++) 
	    	{
	    		for(int j=0;j<totalCol;j++) {
	    			data[r][j]= row.getCell(j).getStringCellValue();
	    		    System.out.println(data[r][j]);
	    		}
	    		if(rows.hasNext()) 
	    			row=rows.next();  		
	        }
	    
	}
    }
		return data;
		
}
@Test(dataProvider="ExcelData")
public void retrieveExcelData(String username, String password)
{
	int i=1;
	System.out.println("Test execution : " + i);
	System.out.println("UserName : "+username+" Password :"+password);
	i++;
}

//@DataProvider(name="ExcelData")
//public void getData() throws IOException {
//		
//	
//}

}
