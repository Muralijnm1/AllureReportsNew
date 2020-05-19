package com.AllureReports.Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AllureReports.Utilities.BaseClass;


public class EditBasicDetailsPage extends BaseClass {
	WebDriver driver;

	@FindBy(xpath = "//button[@id='saveBasicDetailsBtn']")
	WebElement btnSave;	
	

	public EditBasicDetailsPage(WebDriver driver) throws IOException {
		//super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public void clickOnSave(){
		//waitUntilElementVisible(btnSave);
		btnSave.click();
	}
	
}
