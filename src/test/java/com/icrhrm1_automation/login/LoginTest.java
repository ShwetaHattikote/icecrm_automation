package com.icrhrm1_automation.login;

import org.testng.annotations.Test;

import com.icrhrm1_automation.pages.LoginPage;
import com.icrhrm1_automation.utility.BaseClass;
import com.icrhrm1_automation.utility.PropertyHandling;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class LoginTest extends BaseClass {
	PropertyHandling property;
	LoginPage loginPage;
	
	@BeforeClass
	public void start() {
		property = new PropertyHandling();
		luanchBrowser(property.getProperty("browser"));
		driver.get(property.getProperty("icehrmurl"));
		loginPage = new LoginPage(driver);
		
	}
	
	
	
  @Test(dataProvider = "getLoginData")
  public void verifyLogin(String username,String password, String errormsg) {
	  loginPage.login(username, password);
	//  if(!)
	  
	  
	  
	  
	  
	  
  }
  
 
}
