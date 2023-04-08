package com.icrhrm1_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		//set up chrome driver by using System class method
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		//create instance of chromedriver class to launch the browser
		WebDriver driver=new ChromeDriver();
		//navigating to cybersuccess icehrm website
		driver.get("https://cybersuccess.icehrm.com/");
		//locate username textbox on login screen
				//Search Context-->FindElement method--> return type WebElement which isInterface
				//username = Ref. variable of webElement interface
				//driver=Ref. variable of Chrome driver class
				//findElement()=used for locate to locator by using By class methods for element locating
				//By-->Is a class
				//id=Static method of By class calling with help of classname By.id, By.xpath, By.name
		WebElement username=driver.findElement(By.id("username"));
		//Enter the text as "admin" in username textfield
		username.sendKeys("admin");
		//locate password textbox on login screen
		WebElement password=driver.findElement(By.id("password"));
		//Enter the text as "2zuzfakh" in password textfield
		password.sendKeys("2zuzfakn");
		//Locate login button and perform click operation
		WebElement loginButton=driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		loginButton.click();
		//driver.quit();
		
		
		// TODO Auto-generated method stub

	}

}
