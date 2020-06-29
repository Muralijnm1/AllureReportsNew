package com.AllureReports.ReportsGeneration;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.AfterSuite;

public class GenerateAllureReport {
  @Test
  public void f() {
  }
  @AfterSuite
  public void afterSuite() throws IOException {	  
	  Runtime.getRuntime().exec("cmd /c start F://GitRepository//AllureReports22Apr2020//src//test//java//com//AllureReports//Resources//MavenTestRun.bat");

  }

}
