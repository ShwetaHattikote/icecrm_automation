package com.icrhrm_automation.login;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.icrhrm_automation.utility.BaseClass;

public class IceCrmLoginTest extends BaseClass {
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is launch browser method within @BeforeMethod");
		launchBrowser("chrome");
		driver.navigate().to("https://cybersuccess.icehrm.com/");
		enterText(By.id("username"), "admin");
		enterText(By.id("password"), "2zuzfakn");
		click(By.xpath("//button[contains(text(),'Log in')]"));
		click(By.xpath("//span[text()='Employees']"));
		click(By.xpath("//ul[@id='admin_Employees']/li[1]/a[1]"));
	}

	@Test
	public void addEmp() {
		System.out.println("This is Create Employee method within @Test");
		click(By.xpath("//span[@aria-label='plus-circle']/following-sibling::span[1]"));
		enterText(By.xpath("//input [@id='employee_id']"), "991");
		enterText(By.xpath("//input [@id='first_name']"), "Shweta");
		enterText(By.xpath("//input [@id='middle_name']"), "Gireesh");
		enterText(By.xpath("//input [@id='last_name']"), "Korre");
		// mousemove(200,1000);
		// click(By.xpath("//input[@id=\"rc_select_0\"]"));
		// enterText(By.xpath("//input[@id=\"rc_select_0\"]"), "Indian");
		// click
		// selectBirthDayFromCalender(9, "5", "1988");
		click(By.xpath("//div[@label='Female']/div"));
		enterText(By.xpath("//div[@label='Female']/div"), "Female");
		click(By.xpath("//div[@label='Married']/div"));
		enterText(By.xpath("//div[@label='Married']/div"), "Married");
		click(By.xpath("//span[text()='Save']"));
		click(By.xpath("//span[contains(text(),'Next')]"));
		click(By.xpath("//span[contains(text(),'Next')]"));// 2nd page

	}

	@AfterMethod
	public void tearDown() {
		System.out.println("This is tearDown method within @AfterMethod");
		driver.close();
	}
}
