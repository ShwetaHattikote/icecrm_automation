package com.icrhrm1_automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FindElementsExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.amazon.in/");
	Thread.sleep(2000); 
		WebElement searchDropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select select = new Select(searchDropDown);
		select.selectByValue("search-alias=electronics");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Washing Machine");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		Thread.sleep(2000);
		//Here we are locating xpath for result which is on page jst before list of Washing Machines
		//Those are in the form of list
		//So we create List <WebElement> With the help of new x path locating method by use of starts with
		//*  //div[starts-with(@data-cel-widget,'search_result_')][35]/descendant::h2//span   - 35 denotes for how many tags having star with value of attribute and those are matched with 35
		
		//  //tagname[starts-with@attribute, 'value']
		List<WebElement> wmResults= driver.findElements(By.xpath("//div[starts-with(@data-cel-widget,'search_result_')]/descendant::h2//span"));
		Thread.sleep(2000);
		int totalResult=wmResults.size();        //counting total Result for washing machine
		System.out.println(" Total Result "+ totalResult); //count print
		for(int i=3; i<8; i++) {    //(int i=2; i<totalResult; i++)      among 35 results i starts from i=2 becz actual result of washing machine stars from Position[2]for above path
			
					try{  //why in try catch some times Advertise in between actual result of Washing machine so it creates exception.Need to handle writing the 
						//try catch blocks
						Thread.sleep(7000);
					
						String nameXpath= "//div[starts-with(@data-cel-widget,'search_result_')]["+ i +"] /descendant::h2//span";
						String priceXpath= "//div[starts-with(@data-cel-widget,'search_result_')]["+ i +"]/descendant::span[@class=\"a-price-whole\"]";
					
						Thread.sleep(7000);
						String wmName= driver.findElement(By.xpath(nameXpath)).getText();
						String wmPrice= driver.findElement(By.xpath(priceXpath)).getText();
						
						String price= wmPrice.replaceAll("," , "");
						Integer wmPriceRupee = Integer.parseInt(price);
						
						//System.out.println(nameXpath);     //printing  Washing machine name
						//System.out.println(priceXpath);  //printing  Washing machine price
						System.out.println("Price: "+ wmPriceRupee + " Name " + wmName );						
						if(wmPriceRupee>20000) {
							System.out.println("This is costly machine from listof results and its price "+wmPriceRupee);
						}
						else
						{ 
							System.out.println("Price of this machine is less than 20k" +wmPriceRupee);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(e.getMessage());
					}
					
					
			driver.close();		
					
	}
	}

}
