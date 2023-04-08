package com.icrhrm1_automation;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.in/");
		Thread.sleep(2000);
		String parentWindowId = driver.getWindowHandle();// return the id of current window
		System.out.println("First Tab ID:" + parentWindowId);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='nav-swmslot']/div/a")).click();// Locating link which opens in new or
																				// second window
		Set<String> allIDs = driver.getWindowHandles();// Set gives unique link ID's avioding duplicate links. In list
														// itgives duplicate values too.
		//System.out.println("Print all window ID's "+allIDs);
		for (String id : allIDs) {
			if (!id.equals(parentWindowId)) { // in if condition not want to the first i.e parent url because we want
												// control on Second tab
				System.out.println("Second Tab ID:" + id);
				driver.switchTo().window(id); // this commands help to switch from 1st window to 2nd window
				//driver.switchTo().newWindow(WindowType.TAB);
				//driver.switchTo().newWindow(WindowType.WINDOW);

				System.out.println("Control switched from first tab to second tab");
				String secondTabTitle = driver.getTitle(); // this method gives the title of 2nd window
				System.out.println("Second Tab ID:" + secondTabTitle);
				// Following logic for getting all links on 2nd window web page.
				List<WebElement> links = driver.findElements(By.tagName("a"));// get all elements for weblink always
																				// refer tagname "a"
				for (int i = 0; i < links.size(); i++) {
					WebElement element = links.get(i);//
					String url = element.getAttribute("href");
					System.out.println(url);
					/*if (url != null && !url.equals("javascript: void(0)")) {
						try {
							URL a = new URL(url);
							URLConnection b = a.openConnection();
							HttpURLConnection c = (HttpURLConnection) b;
							c.connect();
							System.out.println("URL: "+ url);
							/*int statusCode = c.getResponseCode();
							if (statusCode < 300) {
								System.out.println("Current Running URL: " + url + "status code " + statusCode);
							}
							c.disconnect();
						} catch (Exception ignored) {

						}*/
					}
				}

				driver.close();

			
		}
		driver.switchTo().window(parentWindowId);
		String firstTabTitle = driver.getTitle();
		System.out.println("Control switched from second tab to first tab");
		System.out.println("First Tab ID:" + firstTabTitle);
		driver.quit();

	}

}
