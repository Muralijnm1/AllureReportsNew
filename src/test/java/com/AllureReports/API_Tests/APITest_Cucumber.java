package com.AllureReports.API_Tests;

import static org.testng.Assert.assertEquals;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class APITest_Cucumber {
  @Test(enabled=false)
  public void getWeatherTest() {
	  given()
	  .when()
	  		.get("http://restapi.demoqa.com/utilities/weather/city/hyderabad")
	  .then()
	  		.statusCode(200)
	  		.statusLine("HTTP/1.1 200 OK")
	  		.assertThat().body("City",equalTo("Hyderabad"))
	  		.header("Content-Type","application/json")	  		
	  		.log().all();
	  
  }
  @Test(enabled=false)
  public void getWeatherTestBody() throws UnrecognizedPropertyException {
	  	  
	  Weather1 weather = get("http://restapi.demoqa.com/utilities/weather/city/hyderabad").as(Weather1.class);
	  
	  System.out.println(weather.getTemperature());

	  //Assert.assertEquals(weather.getCity(),"Hyderabad");
	  }

  @Test(enabled=false)
  public void authentication() {
	  given()
	  	.auth().preemptive()
	  	.basic("ToolsQA", "TestPassword")
	  .when()
	  		.get("http://restapi.demoqa.com/authentication/CheckForAuthentication/")
	  .then()
	  		.statusCode(200)/*
	  		.statusLine("HTTP/1.1 200 OK")
	  		.assertThat().body("City",equalTo("Hyderabad"))
	  		.header("Content-Type","application/json")*/	  		
	  		.log().all();	
	  
	  
  }
  
  @Test(enabled=false)
  public void googleAPI() {
	  given()
	  	
	  .when()
	  	.get("https://www.googleapis.com/oauth2/v3/certs")
	  .then()
	  		.statusCode(200)/*
	  		.statusLine("HTTP/1.1 200 OK")
	  		.assertThat().body("City",equalTo("Hyderabad"))
	  		.header("Content-Type","application/json")*/	  		
	  		.log().all();	  
	  
  }
  
  @Test(enabled=true)
  public void googleAPI1() {
	  
	  GoogleAPI gAPI =  get("https://www.googleapis.com/oauth2/v3/certs").as(GoogleAPI.class);
	  System.out.println(gAPI.getKeys().size());
	  System.out.println(gAPI.getKeys().get(0).getAlg());
  }
}
