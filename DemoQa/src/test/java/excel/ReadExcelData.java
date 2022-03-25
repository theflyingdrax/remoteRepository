package excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelData {

	@Test
	public ArrayList<String> excelData(String testCase) throws IOException {
		ArrayList<String> data=new ArrayList<String>();
		
		FileInputStream fis=new FileInputStream("C:\\Users\\imonkarkole\\eclipse-workspace\\DemoQa\\resources\\sample2.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis); 
		int numberOfSheets = workbook.getNumberOfSheets();
		for(int i=0;i<numberOfSheets;i++) {
			String sheetName = workbook.getSheetName(i);
			if(sheetName.equalsIgnoreCase("Sheet1")) {
			  XSSFSheet sheet = workbook.getSheetAt(i);
			 
			  Iterator<Row> rows = sheet.rowIterator();
			 Row firstrow = rows.next();
			 Iterator<Cell> cells = firstrow.cellIterator();
			 int a=0;
			 int column = 0;
			 
			     while(cells.hasNext()) {
			    	 Cell cell = cells.next();
			    	if(cell.getStringCellValue().equalsIgnoreCase("Title")) {
			    		column=a;
			    	
			    	 }
			    	a++;
			     }
				
			   while(rows.hasNext()) {
				   Row row = rows.next();
				  if(row.getCell(column).getStringCellValue().equalsIgnoreCase(testCase)) {
					  Iterator<Cell> rowCells = row.cellIterator();
                    
					  while(rowCells.hasNext()) {
						  Cell rc = rowCells.next();
						  if(rc.getCellType()==CellType.STRING) {
						  data.add(rc.getStringCellValue());
						  }else {
							 data.add( NumberToTextConverter.toText(rc.getNumericCellValue()));
						  }
					  }
                      
				  
				  }
				   
			   }
			   
			   }
		
			
		
		}
		
		return data; 
	}
	
		
	
	
}
