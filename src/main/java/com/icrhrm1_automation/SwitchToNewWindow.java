package com.icrhrm1_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToNewWindow {
	public static void main(String [] arg)
	{
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
      driver.navigate().to("https://omayo.blogspot.com/");
      String parentWindowId = driver.getWindowHandle();// return the id of current window
 	 System.out.println(parentWindowId);

      String input = "Seleium";
      driver.switchTo().frame("navbar-iframe");//id,name,xpath,index-- alway start from zero(0). if frame[2]on HTML page then index one(1)
		driver.findElement(By.id("b-query")).sendKeys(input);
		
		driver.findElement(By.id("b-query-icon")).click();
		driver.switchTo().window(parentWindowId);
       // driver.switchTo().defaultContent();
		String output=driver.findElement(By.xpath("//div[@class='status-msg-body']/b")).getText();
     if(output.equals(input))
     {
    	 System.out.println("successful able to verify selenium text in search");
     }
     else
     {
    	 System.out.println("something went wrong");

     }
     //driver.close();
	}
}
