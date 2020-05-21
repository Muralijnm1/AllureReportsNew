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
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
	
	}
	
	
  @Test(enabled=false)
  public void customerRegistration() {
	  map.put("FirstName", "Venu10");
		map.put("LastName", "Janjanam8");
		map.put("UserName", "Venu.J8");
		map.put("Password", "VenuPassword8");
		map.put("Email", "Venu8@gmail.com");
	  RestAssured.basePath="/register";
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
  
  @Test(enabled=true)
  public void getCustomer() {
	  RestAssured.basePath="/Retrive?FirstName='Venu10'";
	  given()
	  		
	  .when()
	  		.get()
	  .then()
	  .log().all()
	  		/*.statusCode(201)
	  		.body("SuccessCode",equalTo("OPERATION_SUCCESS"))
	  		.body("Message",equalTo("Operation completed successfully") )
	  		.statusLine("HTTP/1.1 201 Created")	  		
	  		.header("Content-Type","application/json")*/; 
	  
  }


}
