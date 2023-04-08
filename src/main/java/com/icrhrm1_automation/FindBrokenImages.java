package com.icrhrm1_automation;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenImages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.navigate().to("https://www.amazon.in/");
		List<WebElement> images = driver.findElements(By.tagName("img"));
		for(int i=0; i<images.size(); i++) {
			WebElement element = images.get(i);//
			String image = element.getAttribute("src");
			//System.out.println(image);  //given all images links
			if(image!=null && !image.equals("javascript: void(0)")) {   //given pure links which never includes any null & javascript 
				try {
					URL a =new URL(image);  //it converts string of url into URL i.e type casting occurs
					URLConnection b= a.openConnection(); //open the url connection
					HttpURLConnection c = (HttpURLConnection)b; //url links forms httpconnection
					c.connect();     //hitting the url
					int statusCode = c.getResponseCode();   //get the sorce code of httpurl
					if(statusCode>=300) {   //if source code is <300 then it works link fine. Otherwise it is broken
						System.out.println("Broken URL: " + image + " status code " + statusCode );
					}
					c.disconnect();
					}catch (Exception ignored) {
						
					}
			}
		}
		
		driver.close();

	}

}
