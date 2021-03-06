package com.AllureReports.Pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.AllureReports.Utilities.BaseClass;

public class HomePageAfterLogin extends BaseClass {

	@FindBy(xpath = "//div[contains(@title,'Murali')]")
	WebElement txtUserName;

	@FindBy(xpath = "//div[text()='My Naukri']")
	WebElement menuMyNaukri;

	@FindBy(xpath = "//a[@title='Edit Profile']")
	WebElement menuOptionEditProfile;

	public HomePageAfterLogin() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public String getUserName() {
		return txtUserName.getText();
	}

	public void validateLogin() {
		// HomePageAfterLogin homePageAfterLogin = new HomePageAfterLogin();
		String actual = getUserName();
		// String actual = "success";
		String expected = "Murali";

		Assert.assertEquals(actual, expected);
		System.out.println("Actual  " + actual + " \nExpected  " + expected + "\n  Test passed");
	}

	public void loginSuccessfull() throws IOException, InterruptedException {
		/*
		 * HomePage homePage = new HomePage(driver); homePage.clickOnLogin();
		 * LoginPage loginPage = new LoginPage(driver);
		 * loginPage.enterUserid(ReadConfig.getUsername());
		 * loginPage.enterPassword(ReadConfig.getPassword());
		 * loginPage.clickOnLogin(); validateLogin();
		 */
	}

	public void hoverOverOnMyNaukri() throws InterruptedException {
		// WebElement menuMyNaukri=null;
		// Thread.sleep(6000);
		String xpath = "//div[text()='My Naukri']";
		menuMyNaukri = fluentWait(driver, xpath);
		// waitUntilElementVisible(menuMyNaukri);
		hoverOverOnMenu(menuMyNaukri, menuOptionEditProfile);
	}

	public void clickOnMyNaukri() {
		checkElementExist(menuMyNaukri);
		clickOn(menuMyNaukri);	
		System.out.println("cliked on 'menuMyNaukri'");
	}

	public void clickOnEditProfileOption() {
		checkElementExist(menuOptionEditProfile);
		clickOn(menuOptionEditProfile);
	}
}
