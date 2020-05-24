package com.AllureReports.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.AllureReports.Utilities.BaseClass;


public class EditProfilePage extends BaseClass {
	//public WebDriver driver;

	@FindBy(xpath = "//em[@class='icon edit' and text()='Edit']")
	WebElement iconEdit;	
	
	@FindBy(xpath = "//div/span[text()='Profile Last updated']/following-sibling::span")
	WebElement txtUpdateDate;	

	public EditProfilePage() throws IOException {
		//super();
		//this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	

	public void clickOnEdit(){
		//waitUntilElementClickable(iconEdit);
		iconEdit.click();		
	}
	

	public String getUpdateDate(){		
		return txtUpdateDate.getText();
	}

	

	public void validateUpdate(){
		//HomePageAfterLogin homePageAfterLogin = new HomePageAfterLogin();
		String actual = getUpdateDate();
		// String actual = "success";
		String expected = "today";

		Assert.assertEquals(actual, expected);
		System.out.println("Actual  " + actual + " \nExpected  " + expected + "\n  Test passed");
	}
	
}
