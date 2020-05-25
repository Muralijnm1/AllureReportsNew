package com.AllureReports.GUI_Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.AllureReports.Pages.HomePage;
import com.AllureReports.Pages.HomePageAfterLogin;
import com.AllureReports.Pages.LoginPage;
import com.AllureReports.Utilities.BaseClass;
import com.AllureReports.Utilities.ReadConfig;
import com.AllureReports.Pages.EditProfilePage;
import com.AllureReports.Pages.EditBasicDetailsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({ com.AllureReports.ReportsGeneration.AllureListener.class })
public class LoginTest extends BaseClass {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		super.setUp();
		//this.driver = getDriver();
		System.out.println("in BeforeMethod ");	
		
			closeAllPopups();
			closeAllAlerts();
			pageScrollUp();
			wait(3000);
			pageScrollDown();
	}

	/*@Severity(SeverityLevel.MINOR)
	@Test(priority = 1, description = "Verify Logo presence on Home Page")
	@Description("Verify Logo presence on Home Page........")
	@Epic("EP001")
	@Feature("Feature1: Logo")
	@Story("Story:Logo Presence")
	@Step("Verify logo Presence")
	public void logoPresence() throws InterruptedException {
		boolean dispStatus = driver.findElement(By.xpath("//div[@class='header-logo']//a//img")).isDisplayed();
		Assert.assertEquals(dispStatus, true);
	}*/

	@Severity(SeverityLevel.BLOCKER)
	@Test(enabled=true,priority = 1, description = "Verify login")
	@Description("Verify login with Valid Credentials........")
	@Epic("EP001")
	@Feature("Feature2: Login")
	@Story("Story:Valid login")
	@Step("Verify login")
	public void loginTest() throws InterruptedException, IOException {
		
		HomePage homePage = new HomePage();
		homePage.clickOnLogin();
		Thread.sleep(6000);
		closeAllAlerts();
		LoginPage loginPage = new LoginPage();
		loginPage.enterUserid(ReadConfig.getUsername());
		loginPage.enterPassword(ReadConfig.getPassword());
		loginPage.clickOnLogin();
		HomePageAfterLogin homePageAfterLogin = new HomePageAfterLogin();
		homePageAfterLogin.validateLogin();		
	}

	
	@Severity(SeverityLevel.BLOCKER)
	@Test(enabled=true,priority = 2, description = "Verify Profile Edit")
	@Description("Verify Profile Edit........")
	@Epic("EP001")
	@Feature("Feature2: Profile Edit")
	@Story("Story:Profile Edit")
	@Step("Verify Profile Edit")
	public void profileEditTest() throws InterruptedException, IOException {
		
		HomePage homePage = new HomePage();
		homePage.clickOnLogin();
		Thread.sleep(6000);
		closeAllAlerts();
		LoginPage loginPage = new LoginPage();
		loginPage.enterUserid(ReadConfig.getUsername());
		loginPage.enterPassword(ReadConfig.getPassword());
		loginPage.clickOnLogin();
		HomePageAfterLogin homePageAfterLogin = new HomePageAfterLogin();	
		homePageAfterLogin.hoverOverOnMyNaukri();
		homePageAfterLogin.clickOnEditProfileOption();
		EditProfilePage editProfilePage = new EditProfilePage();
		editProfilePage.clickOnEdit();
		EditBasicDetailsPage editBasicDetailsPage = new EditBasicDetailsPage();
		editBasicDetailsPage.clickOnSave();
		//EditProfilePage editProfilePage = new EditProfilePage();
		editProfilePage.validateUpdate();	
	}

	/*@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3, description = "Verify user Registration")
	@Description("Verify user Registration........")
	@Epic("EP001")
	@Feature("Feature3: Registration")
	@Story("Story:User registration")

	public void registrationTest() {
		System.out.println("I am in registrationTest");
		//throw new SkipException("Skipping this Test");
	}
*/
	@AfterMethod
	public void tearDown() {
		super.tearDown();
		//driver.quit();
	}

}
