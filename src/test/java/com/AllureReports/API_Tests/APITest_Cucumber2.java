package com.AllureReports.API_Tests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;



public class APITest_Cucumber2 {
	
	public static HashMap map = new HashMap();
	@BeforeClass
	public void postData(){
		map.put("FirstName", "Venu8");
		map.put("LastName", "Janjanam8");
		map.put("UserName", "Venu.J8");
		map.put("Password", "VenuPassword8");
		map.put("Email", "Venu8@gmail.com");
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
		
	}
	
	
  @Test(enabled=true)
  public void customerRegistration() {
	  given()
	  		.contentType("application/json")
	  		.body(map)
	  .when()
	  		.post()
	  .then()
	  .log().all()
	  		.statusCode(201)
	  		.body("SuccessCode",equalTo("OPERATION_SUCCESS"))
	  		.body("Message",equalTo("Operation completed successfully") )
	  		.statusLine("HTTP/1.1 201 Created")	  		
	  		.header("Content-Type","application/json"); 
	  
  }


}
