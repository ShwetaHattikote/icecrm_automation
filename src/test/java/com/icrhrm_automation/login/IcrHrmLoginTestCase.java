package com.icrhrm_automation.login;

import org.testng.annotations.Test;

import com.icrhrm_automation.utility.BaseClass;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;

public class IcrHrmLoginTestCase extends BaseClass {
	@BeforeClass
	public void beforeClass() {
		System.out.println("Here we are launching Browser and Navigate To IcrHRM URL ");
		launchBrowser("edge");
		driver.navigate().to("https://cybersuccess.icehrm.com/");
		System.out.println(driver.getTitle());
	}

	@Test
	public void loginWithValidCredentials() {
		System.out.println("Here we are login with valid inputs");
		enterText(By.id("username"), "admin");
		enterText(By.id("password"), "2zuzfakn");
		click(By.xpath("//button[contains(text(),'Log in')]"));
		String homePage = driver.getTitle();
		System.out.println(homePage);
		/*
		 * if (dashboardText.equals("Dashboard")) {
		 * System.out.println("Succefully Loaded on the homepage of an application"); }
		 * else { throw new Exception("Failed to login to application"); }
		 */
		click(By.xpath("//i[@class=\"caret\"]"));
		click(By.xpath("//a[contains(text(),'Sign out')]"));

	}

	@Test
	public void loginWithInvalidPassword() {
		System.out.println("Here we are login with valid usernsme, Invalid Password");
		enterText(By.id("username"), "admin");
		enterText(By.id("password"), "123456");
		click(By.xpath("//button[contains(text(),'Log in')]"));
		String errmsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		System.out.println(errmsg);
		if (errmsg.equals("Login failed")) {
			System.out.println("Test case is passed for valid username and Invalid Password");
		} else {
			System.out.println("Test case is failed for valid username and Invalid Password");
		}
	}

	@Test
	public void loginWithInvalidUsername() {
		System.out.println("Here we are login with Invalid usernsme, valid Password");
		enterText(By.id("username"), "Shweta");
		enterText(By.id("password"), "2zuzfakn");
		click(By.xpath("//button[contains(text(),'Log in')]"));
		String errmsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		System.out.println(errmsg);
		if (errmsg.equals("Login failed")) {
			System.out.println("Test case is passed for Invalid username and valid Password");
		} else {
			System.out.println("Test case is failed Invalid username and valid Password");
		}
	}

	@Test
	public void loginWithBothInvalid() {
		System.out.println("Here we are login with Invalid usernsme, Invalid Password");
		enterText(By.id("username"), "Shweta");
		enterText(By.id("password"), "1234567");
		click(By.xpath("//button[contains(text(),'Log in')]"));
		String errmsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		System.out.println(errmsg);
		if (errmsg.equals("Login failed")) {
			System.out.println("Test case is passed for Invalid username and Invalid Password");
		} else {
			System.out.println("Test case is failed for Invalid username and Invalid Password");
		}
	}

	@Test
	public void loginWithBothBlank() {
		System.out.println("Here we are login with Blank usernsme, Blank Password");
		enterText(By.id("username"), "");
		enterText(By.id("password"), "");
		click(By.xpath("//button[contains(text(),'Log in')]"));
		String errmsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		System.out.println(errmsg);
		if (errmsg.equals("Login failed")) {
			System.out.println("Test case is passed for Blank username and Blank Password");
		} else {
			System.out.println("Test case is failed for Blank username and Blank Password");
		}
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Here we are Exit from the browser");
		// driver.close();
	}

}
