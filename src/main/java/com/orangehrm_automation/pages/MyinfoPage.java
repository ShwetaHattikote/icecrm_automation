package com.orangehrm_automation.pages;

import org.openqa.selenium.By;

import com.icrhrm1_automation.utility.BaseClass;

public class MyinfoPage extends BaseClass {

	public By myinfoMenu = By.xpath("//span[text()='My Info']");
	public By profileImg = By.xpath("//img[@class='emplotee-image']");
	public By addImg = By.xpath("//i[@class='oxd-icon bi-plus']");
	public By saveButton = By.xpath("//button[@type='submit']");
	

}
