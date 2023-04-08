package com.orangehrm_automation;

import org.testng.annotations.Test;

import com.icrhrm1_automation.utility.BaseClass;
import com.icrhrm1_automation.utility.PropertyHandling;
import com.orangehrm_automation.pages.MyinfoPage;
import com.orangehrm_automation.pages.OrangeHrmLoginPage;

import org.testng.annotations.BeforeClass;

public class FileUploadTest extends BaseClass {
	OrangeHrmLoginPage ohLoginPage;
	MyinfoPage myInfoPage;
	PropertyHandling property;
	
  @BeforeClass
  public void beforeClass() {
	  
	  ohLoginPage = new OrangeHrmLoginPage();
	  myInfoPage = new MyinfoPage();
	  property = new PropertyHandling();
	  String username = property.getProperty("orangehrmUsername");
	  String password = property.getProperty("orangehrmPassword");
	  String browser = property.getProperty("browser");
	  String url = property.getProperty("orangehrmurl");
	  luanchBrowser(browser);
	  driver.get(url);
	  ohLoginPage.login(username, password);
	    
  }
  @Test
  public void fileUplLoad() {
	  click(myInfoPage.myinfoMenu);
	  click(myInfoPage.profileImg);
	  click(myInfoPage.addImg);
  }
 
}
