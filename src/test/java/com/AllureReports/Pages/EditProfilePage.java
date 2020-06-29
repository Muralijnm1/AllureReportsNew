package com.AllureReports.Pages;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.AllureReports.Utilities.BaseClass;

public class EditProfilePage extends BaseClass {

	@FindBy(xpath = "//em[@class='icon edit' and text()='Edit']")
	WebElement iconEdit;

	@FindBy(xpath = "//div/span[text()='Profile Last updated']/following-sibling::span")
	WebElement txtUpdateDate;

	public EditProfilePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void clickOnEdit() throws InterruptedException {
		WebElement iconEditAfterWait=null; 
		Thread.sleep(20000);
		try{
			iconEditAfterWait=waitUntilElementVisible(iconEdit);
			iconEditAfterWait.click();			
		}catch(NoSuchElementException e){
			System.out.println("The Element not found in DOM \n"+this.getClass().toString()+"\n"+e.getMessage());	
		}
		
		//clickOn(iconEdit);
	}

	public String getUpdateDate() {
		return txtUpdateDate.getText();
	}

	public void validateUpdate() {
		// HomePageAfterLogin homePageAfterLogin = new HomePageAfterLogin();
		String actual = getUpdateDate();
		// String actual = "success";
		String expected = "day";

		Assert.assertTrue(actual.contains(expected));
		System.out.println("Actual  " + actual + " \nExpected  " + expected + "\n  Test passed");
	}

}
