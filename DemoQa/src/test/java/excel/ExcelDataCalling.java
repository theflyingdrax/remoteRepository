package excel;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class ExcelDataCalling {

	@Test
	public void call() throws IOException {
		ReadExcelData readExcelData=new ReadExcelData();
		ArrayList<String> data = readExcelData.excelData("The best image ever");
		
	System.out.println(data.get(4));	  
	}
	
	
	
}
