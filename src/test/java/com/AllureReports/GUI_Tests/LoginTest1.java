package com.AllureReports.GUI_Tests;
import org.testng.annotations.Test;

import com.AllureReports.Utilities.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.io.IOException;


public class LoginTest1 extends BaseClass{
  public LoginTest1() throws IOException {
		super();
		
	}

  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("in BeforeMethod ");
/*	  browserIntialization();		
		closeAllPopups();
		closeAllAlerts();
		pageScrollUp();
		wait(3000);
		pageScrollDown();*/
  }

  @Test
  public void loginWithValid() throws IOException {	
	  System.out.println("in Test ");
/*		HomePage homePage = new HomePage(driver);
		homePage.clickOnLogin();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserid(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickOnLogin();
		HomePageAfterLogin homePageAfterLogin = new HomePageAfterLogin(driver);
		homePageAfterLogin.validateLogin();*/

  }
  
  
  @AfterMethod
  public void afterMethod() {
	  System.out.println("in AfterMethod ");
	  try{
		  driver.quit();
	  } catch (Exception e)	  
	  {
		  System.out.println(e.getMessage());
	  }
  }

}
