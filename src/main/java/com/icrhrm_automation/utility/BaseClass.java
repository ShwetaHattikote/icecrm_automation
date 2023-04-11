package com.icrhrm1_automation.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
  protected WebDriver driver;
   public void luanchBrowser(String browser) {   
	   switch (browser) {
	   case "chrome":
		   //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		   WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver(setChromeOptions());		   
			break;
			
	   case "edge":
		  // System.setProperty("webdriver.msedge.driver", "edgedriver.exe");
		   WebDriverManager.edgedriver().setup();
		   driver = new EdgeDriver(setEdgeOptions());
			break;
			
	   case "firefox":
		   //System.setProperty("webdriver.gecko.driver", "firefoxdriver.exe");
		   WebDriverManager.firefoxdriver().setup();
		   driver = new FirefoxDriver(setFirefoxOptions());
			break;
			
	 default : 
		   //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver(setChromeOptions());	
			break;
	   }
	     }
   
   public ChromeOptions setChromeOptions() {
	   ChromeOptions option = new ChromeOptions();
	   option.addArguments("start-maximized");
	   option.addArguments("--remote-allow-origins=*");
	   option.addArguments("incognito");
	  // option.setHeadless(false);
	   option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-clocking"));
	   Map<String,String>prefs = new HashMap<>();
	   prefs.put("download.default.directory", "c:/newfolder/download/");
	   option.setExperimentalOption("prefs", prefs);
	   option.setAcceptInsecureCerts(true);
	   return option;
	   
   }
   public FirefoxOptions setFirefoxOptions() {
	   FirefoxOptions option = new FirefoxOptions();
	   option.addArguments("start-maximized");
	   option.addArguments("--remote-allow-origins=*");
	   option.addArguments("incognito");
	   //option.setHeadless(false);
	   option.addPreference("excludeSwitches", Arrays.asList("disable-popup-clocking"));
	   Map<String,String>prefs = new HashMap<>();
	   prefs.put("download.default.directory", "c:/newfolder/download/");
	   option.addPreference("prefs", prefs);
	   option.setAcceptInsecureCerts(true);
	   return option;
	   
   }

   public EdgeOptions setEdgeOptions() {
	   EdgeOptions option = new EdgeOptions();
	   option.addArguments("start-maximized");
	   option.addArguments("--remote-allow-origins=*");
	   option.addArguments("incognito");
	 //  option.setHeadless(false);
	   option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-clocking"));
	   Map<String,String>prefs = new HashMap<>();
	   prefs.put("download.default.directory", "c:/newfolder/download/");
	   option.setExperimentalOption("prefs", prefs);
	   option.setAcceptInsecureCerts(true);
	   return option;
   }
   
   public void enterText(By by, String text) {
	   try {
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		   wait.until(ExpectedConditions.presenceOfElementLocated(by));
		   driver.findElement(by).sendKeys(text);
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
   public void click(By by) {
	   try {
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		   wait.until(ExpectedConditions.presenceOfElementLocated(by));
		   driver.findElement(by).click();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
   public  void selectBirthDayFromCalender(int day, String month, String year) {
	     while (true) { // while loop to jump on year
				if (year.equals(driver.findElement(By.xpath("//span[@class='ant-picker-super-prev-icon']")).getText())) {
					while (true) { // while loop to jump on expected month
						if (month.equals(driver.findElement(By.xpath("//span[@class=\'ant-picker-prev-icon\']")).getText())) {
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
						} else {//write the logic for to compare month and according to that click the arrow forword or backword
							driver.findElement(By.className("ant-picker-header-next-btn")).click();
						}
					}
				} else {
					driver.findElement(By.className("ant-picker-super-prev-icon")).click();
				}
			}
		}
   
   public void mousemove(int x,int y)  {
	   try {
	   Robot robot = new Robot();
	   robot.mouseMove(x, y);
	   
   }catch(Exception e) {
	   e.printStackTrace();
   }
}
}