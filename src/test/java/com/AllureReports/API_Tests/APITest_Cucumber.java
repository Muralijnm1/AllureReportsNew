package com.AllureReports.API_Tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class APITest_Cucumber {
  @Test(enabled=true)
  public void getWeatherTest() {
	  given()
	  .when()
	  		.get("http://restapi.demoqa.com/utilities/weather/city/hyderabad")
	  .then()
	  		.statusCode(200)
	  		.statusLine("HTTP/1.1 200 OK")
	  		.assertThat().body("City",equalTo("Hyderabad"))
	  		.header("Content-Type","application/json");
	  
	  
  }


}
