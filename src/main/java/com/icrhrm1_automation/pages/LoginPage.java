














package com.icrhrm1_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.icrhrm_automation.utility.BaseClass;

public class LoginPage extends BaseClass { 
	//Declare all the Locators 
	By username = By.name("username");
	By password = By.name("password");
By loginButton = By.xpath("//button[contains(text(),'Log in')]");
By resetPasswordLink = By.xpath("//div[contains (@class,'alert-danger')]");

public LoginPage(WebDriver driver) {
	this.driver = driver;
	
	// TODO Auto-generated constructor stub
}

public void login(String username, String password) {
	enterText(this.username, username);
	enterText(this.password, password);
	click(loginButton);
	
	
}

}
