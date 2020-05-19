package com.AllureReports.Pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AllureReports.Utilities.BaseClass;


public class LoginPage extends BaseClass {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) throws IOException {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}

	@FindBy(xpath = "//input[contains(@placeholder,'active Email ID')]")	
	WebElement txboxUserid;
	
	@FindBy(xpath = "//input[contains(@placeholder,'password')]")
	WebElement txboxPassword;
	
	@FindBy(xpath = "//button[contains(@type,'submit') and contains(text(),'Login')]")	
	WebElement btnLogin;
	
	public void enterUserid(String userId){		
		smartWait(txboxUserid).clear();
		txboxUserid.sendKeys(userId);		
	}
	
	public void enterPassword(String password){
		txboxPassword.clear();
		txboxPassword.sendKeys(password);		
	}
	public void clickOnLogin(){
		btnLogin.click();
		
	}


}
