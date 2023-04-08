package com.icrhrm1_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHrmLoginTest {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmLive.com/");
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("Admin");// enter username
		driver.findElement(By.name("password")).sendKeys("admin123");// enter password
		driver.findElement(By.xpath("//button[@type='submit']")).submit();// click on login button
		Thread.sleep(7000);// wait for 5sec
		// locating text from Homepage of login i.e Dashboard
		String dashboardText = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		// gettext() o/p is in String Format. So checking that String Equals string on
		// login page
		// It shows we are landing or not on homepage of login.
		if (dashboardText.equals("Dashboard")) {
			System.out.println("Succefully Loaded on the homepage of an application");
		} else {
			throw new Exception("Failed to login to application");
		}
		// If we r successfully landing then click on PIM
		// so locate PIM as webelement
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Thread.sleep(7000);
		// Locate Search Button on// PIM page
		WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
		Thread.sleep(5000);
		// Using isDisplayed() which return type is boolean
		if (searchButton.isDisplayed()) {
			System.out.println("Succefully able to navigate on PIM Module");
		} else {
			System.out.println("Unble to navigate on PIM Module");
		}
        //If u are landing on PIM then ur need to minimise first module "Employee Information"
		// so we can locate that minimise button & click on that
		driver.findElement(By.xpath("//button[@class='oxd-icon-button' and @type='button']//i")).click();
		// We can click on id button which is on PIM so whole list get selected
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]/following-sibling::span/i")).click();
        //So we need to check all checkboxes are selected or not. 
		// So we can locating any one of them checkbox and crosscheck.
		// So we are using isSelected() which has return type boolean
		boolean ankitaVivek = driver
				.findElement(By.xpath("//input[@type='checkbox' and @value='1']/following-sibling::span/i"))
				.isSelected();
		if (ankitaVivek = true) {
			System.out.println("Select all check box is selected");
		} else {
			System.out.println("Select all check box isnot selected");
		}
		driver.quit();
		// TODO Auto-generated method stub

	}

}
