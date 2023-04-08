package com.icrhrm1_automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandling {

	public static void main(String[] args) {
		String filepath ="E:\\Selenium Data.TestData.xlsx";
				String extension =filepath.substring(filepath.indexOf(".")+1);
				Workbook workbook = null;
				try {
					FileInputStream inputstream = new FileInputStream(filepath);
					if(extension.equals("xlsx")) {
						workbook = new XSSFWorkbook(inputstream);
								}else if(extension.equals("xlx")) {
									workbook = new HSSFWorkbook(inputstream);									
								}
					Sheet sheet = workbook.getSheet("TestData");
					if(sheet == null) {
						sheet=workbook.createSheet("testdata");
					}
					Cell cell = sheet.createRow(0).createCell(0);
					cell.setCellValue("Cyber Success");
					FileOutputStream outputStream = new FileOutputStream(filepath);
					workbook.write(outputStream);
					workbook.close();
					}	catch (FileNotFoundException e) {
						throw new RuntimeException(e);						
					}    catch (IOException e) {
						throw new RuntimeException(e);
					}
	}
				
}

	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	