package com.icrhrm1_automation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DatePickerExample  {
	static WebDriver driver;
	
	public static void selectDayFromCalender(int futureDay) throws InterruptedException {
		driver.findElement(By.id("onward_cal")).click();
		List<WebElement> days = driver.findElements(By.xpath("//td[@class=\"current day\" or @class=\"wd day\" or @class=\"we day\"]"));
		int currentDay = LocalDateTime.now().getDayOfMonth();
		System.out.println(currentDay);
		int dateToSelect = currentDay + futureDay;
		System.out.println(dateToSelect);
		for (WebElement element : days) {
			String day = element.getText();
			String selecteday = String.valueOf(dateToSelect);
			System.out.println("1-" + day);
			Thread.sleep(5000);
			if (day.equals(selecteday)) {
				element.click();
				System.out.println(selecteday);
				break;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "edgedriver.exe");
		driver = new EdgeDriver();
		//String date5 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-mm-yyyy HH:mm:ss"));
		   //System.out.print(date5);
		driver.navigate().to("https:www.redbus.in");
		Thread.sleep(3000);
		selectDayFromCalender(4);
		//driver.close();*/

		// TODO Auto-generated method stub

	}

}
