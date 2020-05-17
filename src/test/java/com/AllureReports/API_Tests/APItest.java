package com.AllureReports.API_Tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

//import static io.restassured.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class APItest {

	@Test(enabled = false)

	public void testResponcecode() {

		Response resp = RestAssured.get("https://reqres.in/api/unknown");

		int code = resp.getStatusCode();
		// int code = 200;

		System.out.println("Status code  " + code);
		Assert.assertEquals(200, code);
	}

	@Test(enabled = true)

	public void postRequestCustomer() {

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Request payload sending along with post request
		JSONObject requestParams = new JSONObject();

		requestParams.put("FirstName", "Murali98");
		requestParams.put("LastName", "Jan98");
		requestParams.put("UserName", "Murali98");
		requestParams.put("Password", "xyxYYdd98");
		requestParams.put("Email", "xyz98@gmail.com");

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
		String successCode = resp.jsonPath().get("SuccessCode");

		System.out.println("Status code  " + successCode);
		// Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	}

	
	@Test(enabled = true)

	public void getRequestCustomer() throws NoSuchFieldException, SecurityException {

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		// RestAssured.baseURI="https://reqres.in";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response resp = httpRequest.request(Method.GET, "/Murali98");

		// print response in console

		String responseBody = resp.getBody().asString();
		System.out.println("The response body is " + responseBody);
		
		/*
		 * ResponseBody<?> bodyText = resp.getBody(); //int code = 200;
		 * 
		 * System.out.println("Status code  "+bodyText);
		 * //Assert.assertEquals(200, code);
		 */ 
		}

	
	@Test(enabled = false)

	public void getRequestWeather() throws NoSuchFieldException, SecurityException {

		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// RestAssured.baseURI="https://reqres.in";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response resp = httpRequest.request(Method.GET, "/Hyderabad");

		// print response in console

		String responseBody = resp.getBody().asString();
		System.out.println("The response body is " + responseBody);
		

		/*
		 * ResponseBody<?> bodyText = resp.getBody(); //int code = 200;
		 * 
		 * System.out.println("Status code  "+bodyText);
		 * //Assert.assertEquals(200, code);
		 */ 
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

}
