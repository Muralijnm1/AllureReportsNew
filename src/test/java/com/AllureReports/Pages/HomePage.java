package com.AllureReports.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AllureReports.Utilities.BaseClass;

public class HomePage extends BaseClass {
	WebDriver driver;
	@FindBy(xpath = "//*[@id='login_Layer']/div[contains(text(),'Login')]")
	WebElement lnkLogin;
	public HomePage(WebDriver driver) throws IOException {		
		this.driver = driver;			
		PageFactory.initElements(driver, this);		
	}
	
	public void clickOnLogin() throws InterruptedException{
		lnkLogin.click();
		
	}

}
