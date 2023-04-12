package com.icrhrm_automation.login;

import org.testng.annotations.Test;

import com.icrhrm_automation.utility.ExcelUtil;

import org.testng.annotations.DataProvider;

public class ExcelTest {
 

  @DataProvider
  public Object[][] getTestData() {
	  ExcelUtil excelutil  = new ExcelUtil();
	  String filepath = "E:/Selenium Data/DataProvider Excel.xlsx";
	  String sheetName = "Shweta";
    return excelutil.getExcelData(filepath, sheetName);
  }
  @Test(dataProvider = "getTestData")
  public void test(String userName, String password) {
	  System.out.println("USERNAME: " + userName + ", PASSWORD: " + password);
  }
}
