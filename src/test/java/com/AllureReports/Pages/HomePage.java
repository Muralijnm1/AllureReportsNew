package com.AllureReports.Pages;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AllureReports.Utilities.BaseClass;

public class HomePage extends BaseClass {	
	@FindBy(xpath = "//*[@id='login_Layer']/div[contains(text(),'Login')]")
	WebElement lnkLogin;
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);		
	}
	
	public void clickOnLogin() throws InterruptedException{
		try{
			lnkLogin.click();			
		}catch(NoSuchElementException e){
			System.out.println("The Element not found in DOM \n"+this.getClass().toString()+"\n"+e.getMessage());	
		}		
	}
}
