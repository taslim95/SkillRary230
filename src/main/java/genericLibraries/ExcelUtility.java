package genericLibraries;


import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * this class contains reusable methods to perform actions on excel file
 * @author Abhishek
 *
 */
public class ExcelUtility {

	private Workbook workbook;
	private DataFormatter df;
	
	/**
	 * this method is used to initialize excel file
	 * @param excelpath
	 */
	
	public void excelInit(String excelpath)
	{
		FileInputStream fis=null;
		try {
			fis =new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * this method is used to read single data from excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	
	public String readDataFromExcel(String sheetName, int rowNum, int cellNum)
	{
		df =new DataFormatter();
		return df.formatCellValue(workbook.getSheet(sheetName)
				.getRow(rowNum)
				.getCell(cellNum));
	}
	
	/**
	 * this method is used to read multiple data from excel file
	 * @param sheetname
	 * @return
	 */
	
	public Map<String, String> readDataFromExcel(String sheetname)
	{
		Map<String, String> map =new HashMap<>();
		df =new DataFormatter();
		 Sheet sheet = workbook.getSheet(sheetname);
		 
		 for(int i=0;i<=sheet.getLastRowNum();i++)
		 {
			String key = df.formatCellValue(sheet.getRow(i).getCell(0)) ;
			String value = df.formatCellValue(sheet.getRow(i).getCell(1));
			map.put(key, value);
		 }
		 return map;
	}
	
	/**
	 * this method is used to write and save data to excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @param excelpath
	 */
	
	public void writeToexcel(String sheetName, int rowNum, int cellNum, Date value, String excelpath)
	{
		Cell cell = workbook.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		cell.setCellValue(value);
		FileOutputStream fos =null;
		try {
			fos =new FileOutputStream(excelpath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * this method is used to close excel workbook
	 */
	
	public void closeExcel()
	{
		try {
			workbook.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}