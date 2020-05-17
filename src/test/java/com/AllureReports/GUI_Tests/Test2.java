package com.AllureReports.GUI_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.AllureReports.Utilities.BaseClass;
import com.AllureReports.Utilities.ReadConfig;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({ allureReports.AllureListener.class })
public class Test2 extends BaseClass {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		setup();
		this.driver = getDriver();
	}

	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1, description = "Verify Logo presence on Home Page")
	@Description("Verify Logo presence on Home Page........")
	@Epic("EP001")
	@Feature("Feature1: Logo")
	@Story("Story:Logo Presence")
	@Step("Verify logo Presence")
	public void logoPresence() throws InterruptedException {
		boolean dispStatus = driver.findElement(By.xpath("//div[@class='header-logo']//a//img")).isDisplayed();
		Assert.assertEquals(dispStatus, true);
	}

	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 2, description = "Verify login")
	@Description("Verify login with Valid Credentials........")
	@Epic("EP001")
	@Feature("Feature2: Login")
	@Story("Story:Valid login")
	@Step("Verify login")
	public void loginTest() throws InterruptedException {
		driver.findElement(By.linkText("Log in")).click();	
		System.out.println(ReadConfig.getUsername());
		driver.findElement(By.id("Email")).sendKeys(ReadConfig.getUsername());
		driver.findElement(By.id("Password")).sendKeys(ReadConfig.getPassword());
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");

	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3, description = "Verify user Registration")
	@Description("Verify user Registration........")
	@Epic("EP001")
	@Feature("Feature3: Registration")
	@Story("Story:User registration")

	public void registrationTest() {
		System.out.println("I am in registrationTest");
		//throw new SkipException("Skipping this Test");
	}

	@AfterMethod
	public void tearDown() {
		super.tearDown();
		//driver.quit();
	}

}
