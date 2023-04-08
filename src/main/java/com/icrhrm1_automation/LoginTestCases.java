package com.icrhrm1_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCases {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://cybersuccess.icehrm.com/");
		Thread.sleep(5000);
		WebElement username=driver.findElement(By.xpath("//input[@id=\'username\']"));
		username.sendKeys("admin");
		WebElement password=driver.findElement(By.xpath("//input[@id=\'password\']"));
		password.sendKeys("2zuzfakn");
		WebElement loginButton=driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		loginButton.click();
		//driver.quit();
		
		
		// TODO Auto-generated method stub

	}

}
