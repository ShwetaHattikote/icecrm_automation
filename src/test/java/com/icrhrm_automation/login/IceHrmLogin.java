package com.icrhrm_automation.login;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.icrhrm_automation.utility.BaseClass;

public class IceHrmLogin extends BaseClass{
	
	
	@BeforeClass
	public void startUp() {
		launchBrowser("chrome");
	}

	
	@Test
	//System.out.println("add emp method");
		public void addEmployee() {
		System.out.println("add emp method");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}
