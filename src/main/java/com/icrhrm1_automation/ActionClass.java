package com.icrhrm1_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://cybersuccess.icehrm.com/");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("2zuzfakn");
		
		Actions actions = new Actions(driver);
	//	actions.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).build().perform();
//actions.click(driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).build().perform();
//actions.contextClick().build().perform();
//actions.contextClick(driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).build().perform();
		
		
		
		
		// TODO Auto-generated method stub

	}

}
