package com.AllureReports.Pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AllureReports.Utilities.BaseClass;

public class LoginPage extends BaseClass {

	// WebDriver driver;
	@FindBy(xpath = "//input[contains(@placeholder,'active Email ID')]")
	WebElement txboxUserid;

	@FindBy(xpath = "//input[contains(@placeholder,'password')]")
	WebElement txboxPassword;

	@FindBy(xpath = "//button[contains(@type,'submit') and contains(text(),'Login')]")
	WebElement btnLogin;

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void enterUserid(String userId) {
		enterText(txboxUserid,userId);
	}

	

	public void enterPassword(String password) {
		enterText(txboxPassword,password);
	}

	public void clickOnLogin() {
		clickOn(btnLogin);
	}

}
