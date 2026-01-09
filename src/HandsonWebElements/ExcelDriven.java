package HandsonWebElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import TestngFiles.DataDrivenExcel;

public class ExcelDriven {
	public static void main(String[] args) throws IOException {
		HashMap<String, ArrayList<String>> Ids= new HashMap<String, ArrayList<String>>();
//		public void ExcelDataForAllPages() throws IOException {
	ArrayList<String> a=new ArrayList<String>();
	FileInputStream fis= new FileInputStream("C:\\Users\\swarn\\Downloads\\Selenium Automation SWs\\DataDrivenTestFromExcel.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheetAt(1);
	Iterator<Row> rows=sheet.iterator();
	
	while(rows.hasNext()) {
		a.clear();
		Row row= rows.next();
		ArrayList<String> al=new ArrayList<String>();
		if(row.getCell(0).getStringCellValue().equalsIgnoreCase("portal"))
			row =rows.next();

		for(int i=1;i<row.getLastCellNum()-1;i++) {
			a.add(row.getCell(i).getStringCellValue());
			al.addAll(a);
//			System.out.println(a);
//			System.out.println(al);
//			Ids.put(row.getCell(0).getStringCellValue(), al);
		}
	
		Ids.put(row.getCell(0).getStringCellValue(), a);
	}
//	 return Ids;
	 Set set=Ids.entrySet();
		Iterator it=set.iterator();
		while(it.hasNext()) { 
			Map.Entry mp=(Map.Entry)it.next();
		    System.out.println( mp.getKey() +", "+ mp.getValue());
		}
//	System.out.println(a);
	}
	
	
// Retrieve data for specific page from Excel and store in HashMap as (key,value) pair
//	public void ExcelDataForSpecificPage() throws IOException {
//	ArrayList<String> a=new ArrayList<String>();
//	HashMap<String, ArrayList<String>> Ids= new HashMap<String, ArrayList<String>>();
//		
//		
//	FileInputStream fis= new FileInputStream("C:\\Users\\swarn\\Downloads\\Selenium Automation SWs\\DataDrivenTestFromExcel.xlsx");
//	XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	XSSFSheet sheet = workbook.getSheetAt(1);
//	Iterator<Row> rows=sheet.iterator();
//	while(rows.hasNext()) {
//		Row row= rows.next();
//		if(row.getCell(0).getStringCellValue().equalsIgnoreCase("Locator practice"))
//		{
//			
//			for(int i=1;i<row.getLastCellNum()-1;i++) 
//				a.add(row.getCell(i).getStringCellValue());	
//				
//			Ids.put(row.getCell(0).getStringCellValue(), a);
//				
//		}
//	}
//	Set s=Ids.entrySet();
//	Iterator it=s.iterator();
//	while(it.hasNext()) { 
//		Map.Entry mp=(Map.Entry)it.next();
//	    
//	    System.out.println( mp.getKey() +", "+ mp.getValue());
//	}
//	}
	
//	Retrieve data for specific page from Excel and store in ArrayList 
//	public void entireDataAsArrayList() throws IOException {
//		
//		ArrayList a=new ArrayList();
//		
//		FileInputStream fis=new FileInputStream("C:\\Users\\swarn\\Downloads\\Selenium Automation SWs\\DataDrivenTestFromExcel.xlsx");
//		XSSFWorkbook workbook=new XSSFWorkbook(fis);
//		int sheets =workbook.getNumberOfSheets();
//		int col=0;
//		for (int i=0;i<sheets;i++) {
//			if(workbook.getSheetName(i).equalsIgnoreCase("credentials")) {
//				XSSFSheet sheet=workbook.getSheetAt(i);
//				Iterator<Row> rows=sheet.iterator();
//				Row row=rows.next();//1st Row
//				while(rows.hasNext()) {
//					Row r=rows.next();//2nd Row
//				
//				Iterator<Cell> cells=r.cellIterator();
//				while(cells.hasNext())
//				{
//					Cell cell=cells.next();//
//					if(cell.getStringCellValue().equalsIgnoreCase("Login Practice")) {
//					 a.add(cells.next().getStringCellValue());
//					 a.add(cells.next().getStringCellValue());
//					 
//					}
//					
//				}
//			}
//		}
//	}System.out.println(a);
//	}

	
}
