package com.AllureReports.API_Tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class APItest3CucumberApproach {

	@Test(enabled = true,priority=1)
	public void postRequest_createNewStudent() {
		
		 HashMap map = new HashMap();
		 map.put("id", 101);
		 map.put("firstName", "Pavan");
		 map.put("email", "abc@gmail.com");
		 map.put("program", "Manager");
		 ArrayList<String> courseList = new ArrayList<String>();
		 courseList.add("Java");
		 courseList.add("Selenium");
		 map.put("courses", courseList);
		 
		 given()
		 		.contentType(ContentType.JSON)
		 		.body(map)
		 .when()
		 		.post("http://Localhost:8085/student")
		 .then()
		 		.statusCode(201)
		 		/*.assertThat()
		 		.body("msg", equals("student added"))*/;		 		
		 		
		 		/*
		 		.assertThat().body(containsString("something else"));
		 		//body("msg",equals("student added"));
		 		*/
		
			}

	
	

/*
	@Test(enabled = false,priority=2)

	public void getRequest() throws NoSuchFieldException, SecurityException {

		System.out.println("#######  The getRequest started ###########");
		
		RestAssured.baseURI = "https://reqres.in";	

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response resp = httpRequest.request(Method.GET, "/api/unknown/12");

		// print response in console

		String responseBody = resp.getBody().asString();
		System.out.println("The response body is " + responseBody);
		
		int code = resp.getStatusCode();
		 Assert.assertEquals(200, code);
		 Assert.assertTrue(responseBody.contains("name : honeysuckle"));
		 
		}

	
	@Test(enabled = false,priority=3)

	public void getRequestWeather() throws NoSuchFieldException, SecurityException {

		System.out.println("#######  The getRequestWeather started ###########");
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// RestAssured.baseURI="https://reqres.in";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response resp = httpRequest.request(Method.GET, "/Hyderabad");

		// print response in console

		String responseBody = resp.getBody().asString();
		System.out.println("The response body is " + responseBody);
		

		
		 * ResponseBody<?> bodyText = resp.getBody(); //int code = 200;
		 * 
		 * System.out.println("Status code  "+bodyText);
		 * //Assert.assertEquals(200, code);
		  
		}
	@Test(enabled = false)

	public void postRequest1() {

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Request payload sending along with post request
		JSONObject requestParams = new JSONObject();

		requestParams.put("FirstName", "Murali2");
		requestParams.put("LastName", "Jan2");
		requestParams.put("UserName", "Murali2");
		requestParams.put("Password", "xyxYYdd2");
		requestParams.put("Email", "xyz2@gmail.com");

		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(requestParams.toJSONString());

		// Response object
		Response resp = httpRequest.request(Method.POST, "/register");

		// print response in console

		String responseBody = resp.getBody().asString();
		System.out.println("The response body is " + responseBody);

		// Status code verify
		int statusCode = resp.getStatusCode();

		System.out.println("Status code  " + statusCode);
		// Assert.assertEquals(statusCode, 200);

		// Success code verify
		int successCode = resp.jsonPath().get("SuccessCode");

		System.out.println("Status code  " + successCode);
		// Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	}

*/}
