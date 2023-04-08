package com.icrhrm1_automation;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.navigate().to("https://www.amazon.in/");
		List<WebElement> links = driver.findElements(By.tagName("a"));//get all elements for weblink always refer tagname "a"
		
		for(int i=0; i<links.size(); i++) {
			WebElement element = links.get(i);//
			String url = element.getAttribute("href");
			//System.out.println(url);   //it gives all links on that page
			if(url!=null && !url.equals("javascript: void(0)")) {      //gives the actual url links in which not includes null &java scripts
				try {	
					URL a =new URL(url);  //it converts string of url into URL i.e type casting occurs
					URLConnection b= a.openConnection();    //open the url connection
					HttpURLConnection c = (HttpURLConnection)b;     //url links forms httpconnection
					c.connect();     //hitting the url
					int statusCode = c.getResponseCode();    //get the sorce code of httpurl
					if(statusCode>=300) {     //if source code is <300 then it works link fine. Otherwise it is broken
						System.out.println("Broken URL: " + url+ " status code" +  statusCode );
					}
					c.disconnect();
					}catch (Exception ignored) {
						
					}
			}
		}
		
		driver.close();
	}
}
