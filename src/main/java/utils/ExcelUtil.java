package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static String getCellData(
	        String sheetName,
	        int row,
	        int column) throws IOException
	{
	    FileInputStream fis =
	       new FileInputStream("testdata.xlsx");

	    Workbook wb =
	       new XSSFWorkbook(fis);

	    Sheet sheet =
	       wb.getSheet(sheetName);

	    return sheet.getRow(row)
	                .getCell(column)
	                .getStringCellValue();
	}

}
