package com.icrhrm1_automation;

import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IcehrmAssignment {
	static WebDriver driver;
	public static void selectBirthDayFromCalender(int day, String month, String year) {
     while (true) { // while loop to jump on year
			if (year.equals(driver.findElement(By.xpath("//span[@class='ant-picker-super-prev-icon']")).getText())) {
				while (true) { // while loop to jump on expected month
					int monthValue = LocalDateTime.now().getMonthValue();
					Integer actualmonth = Integer.valueOf(month);
					if(monthValue<actualmonth) {
				driver.findElement(By.xpath("//span[@class=\'ant-picker-prev-icon\']")).getText();
				}else {//write the logic for to compare month and according to that click the arrow forword or backword
					driver.findElement(By.className("ant-picker-header-next-btn")).click();
						while (true) {// while loop to jump on expected day
							String day1 = String.valueOf(day);
				List<WebElement> element = driver.findElements(By.xpath("//button[@class='ant-picker-cell-inner']"));//we r getting 42 results
							for (WebElement dates : element) {
								String birthday = dates.getText();
								if (day1.equals(birthday)) {
									dates.click();
									break;
								}
							}
						}
					}
					}
				
			} else {
				driver.findElement(By.className("ant-picker-super-prev-icon")).click();
			}
		}
	}

	/*
	 * if(!year.equals(driver.findElement(By.xpath("//button[ text()='2023']")).
	 * getText()))// xpath for maincalender // text eg.Feb,2023
	 * 
	 * { driver.findElement(By.xpath("//button[ text()='2023']")).click();// xpath
	 * for maincalender text eg.Feb,2023 // click on that
	 * driver.findElement(By.xpath("//button[contains( text(),'2020')]")).click();
	 * // 2020 to 2029
	 * driver.findElement(By.xpath("//div[contains( text(),'1990-1999')]")).click();
	 * // giving selection windows for // all years
	 * driver.findElement(By.xpath("//div[contains( text(),'1995')]")).click();//
	 * selecting 1995 birth year
	 * driver.findElement(By.xpath("//div[contains( text(),'Jul')]")).click();//
	 * selecting birth month july
	 * driver.findElement(By.xpath("//div[contains( text(),'17')]")).click();//
	 * selecting birth date 17 } }
	 */

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://cybersuccess.icehrm.com/");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("2zuzfakn");
		WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		loginButton.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Employees']")).click(); // homepage select Employees

		driver.findElement(By.xpath("//ul[@id='admin_Employees']/li[1]/a[1]")).click();// In employees dropdown select
																						// employees
		// Landing on subemployees page after click

		driver.findElement(By.xpath("//span[@aria-label='plus-circle']/following-sibling::span[1]")).click();
		// in thatclick on 'AddNew' tab
		// Currently on text field of add new Employee
		// int currentDay=LocalDateTime.now().getDayOfMonth();
		Thread.sleep(2000);
		driver.findElement(By.id("birthday")).click();
		selectBirthDayFromCalender(9, "may", "1988");

		/*
		 * driver.findElement(By.xpath("//input [@id='employee_id']")).sendKeys("456123"
		 * );//emp no.
		 * driver.findElement(By.xpath("//input [@id='first_name']")).sendKeys("Shweta")
		 * ; //first name
		 * driver.findElement(By.xpath("//input [@id='middle_name']")).sendKeys(
		 * "Gireesh"); //Middle Name
		 * driver.findElement(By.xpath("//input [@id='last_name']")).sendKeys("Korre");
		 * //Last name
		 * 
		 * //for selection of 'Nationality' there is DROPDOWN selection & this without
		 * tag of SELECT
		 * driver.findElement(By.xpath("//input[@id=\"rc_select_0\"]")).click();
		 * //Nationality
		 * driver.findElement(By.xpath("//input[@id=\"rc_select_0\"]")).sendKeys(
		 * "Indian");
		 * 
		 * /*Given by sir
		 * driver.findElement(By.xpath("//input[@id=\"rc_select_0\"]")).click();
		 * List<WebElement> nationalitydropdown = driver.findElements(By.xpath(
		 * "//div[@class='rc-virtual-list-holder-inner']/div/div")); Thread.sleep(1000);
		 * For(int i=0; i<nationalitydropdown.size(); i++){ WebElement element =
		 * nationalitydropdown.get(i); String nationality =element.getText();
		 * System.out.println(nationality);//currently it apllicable to only how much
		 * options we can see without scrolldown //So we can choose from those 10options
		 * we can see and selecting country Albanian
		 * 
		 * if(value1.equals("Albanian")) { System.out.println("value1");
		 * element.click(); break; }
		 */

	}// TODO Auto-generated method stub
}
