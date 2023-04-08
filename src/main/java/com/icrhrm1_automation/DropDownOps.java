package com.icrhrm1_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownOps {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.amazon.in/");
	Thread.sleep(5000); 
		WebElement searchDropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select select = new Select(searchDropDown);
		select.selectByValue("search-alias=computers");
		//select.selectByVisibleText("");
		//select.selectByIndex("");
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("dell Keyboard");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		String dellKeyboardText =driver.findElement(By.xpath("//span[contains(text(),'1-24 of 136 results for')]/following-sibling::span[2]")).getText();
		System.out.println(dellKeyboardText);
		
		if(dellKeyboardText.equals(dellKeyboardText))	{
			System.out.println(dellKeyboardText);	//searching done for keyboard		
					
		}
		else {
			System.out.println("Something went wrong");
		}		
					driver.quit();
		}// TODO Auto-generated method stub

	}


