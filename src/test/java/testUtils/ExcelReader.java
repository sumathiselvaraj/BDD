package testUtils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
		
		public static String[][] getExcelInfo(String sheetName) throws IOException
		{
			XSSFWorkbook wb = new XSSFWorkbook("./src/test/resources/SampleExcel.xlsx");
			XSSFSheet sheet= wb.getSheet("Sheet1");
			XSSFRow row=null;
			XSSFCell cell;
			int rowCnt = sheet.getLastRowNum(); 
			int cellCnt = 0;
			int i,j=0;
			String [][] data = new String[rowCnt+1][sheet.getRow(0).getLastCellNum()]; 
			
			for(i=0;i<=rowCnt;i++)
			{
				cellCnt = sheet.getRow(i).getLastCellNum();
				row = sheet.getRow(i); 
				
				for(j=0;j<cellCnt;j++)
				{
					
				cell = row.getCell(j);
			    DataFormatter formatter = new DataFormatter();
				data[i][j]=formatter.formatCellValue(cell);
				
				}
			}
			wb.close();
			return data;
			
		
		
	}

}
