package HandsonWebElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class DataDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataDriven exceldata=new DataDriven();
		ArrayList<String> data= exceldata.DataDrivenFromExcel();
		for(String al : data)
			System.out.println(al);
		
	}
	
public ArrayList<String> DataDrivenFromExcel() throws IOException {
	
	ArrayList<String> a = new ArrayList<String>();
	FileInputStream fis=new FileInputStream("C:\\Users\\swarn\\Downloads\\Selenium Automation SWs\\DataDrivenTestFromExcel.xlsx");
	XSSFWorkbook excel=new XSSFWorkbook(fis);
	int totalSheets= excel.getNumberOfSheets();
	
	for (int i=0;i<totalSheets;i++)
	{
		if(excel.getSheetName(i).equalsIgnoreCase("testdata")) {
			
			XSSFSheet sheet = excel.getSheetAt(i);//fetched 'testdata' sheet for validation
			Iterator<Row> rows=sheet.iterator();
			Row row=rows.next();//1st row of the sheet
			Iterator<Cell> cells=row.cellIterator();
			
			int k=0;
			int colNo=0;
			while(cells.hasNext()){
				Cell cell=cells.next();//1st cell of the 1st row
				if(cell.getStringCellValue().equalsIgnoreCase("Ref")) {
						colNo=k;
						System.out.println(colNo);//Col number of Column "Ref" to print row value of "3rd Page"
				}
				k++;
			
			}
			while(rows.hasNext()){
				
				Row row1= rows.next();
				if(row1.getCell(colNo).getStringCellValue().equalsIgnoreCase("Locator")) {
					Iterator<Cell> c=row1.cellIterator();
					while(c.hasNext())
						a.add(c.next().getStringCellValue());
				}
				
			}
						
		} 
		
	}
	return a;

}
}
