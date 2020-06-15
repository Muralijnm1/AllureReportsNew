package com.AllureReports.API_Tests;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.hasItems;
import java.util.HashMap;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class APItestsEmployeeOperations {

	
	/*@BeforeClass
	public void setUp() {
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		RestAssured.authentication=RestAssured.preemptive().basic("ToolsQA", "TestPassword");
		
		 }*/
	
	@Test(enabled = false,priority=1)
	public void postRequest_createNewEmployee() {
		
		 HashMap map = new HashMap();
		 map.put("first_name", "employee14_firstname");
		 map.put("last_name", "employee14_firstname");		 
		 given()
		 		.contentType(ContentType.JSON)
		 		.body(map)
		 .when()
		 		.post("http://localhost:3000/employee")
		 .then()
		 		.statusCode(201)
		 		.assertThat()		 		
		 		//.root("employee")
		 		//.body("first_name",hasItems("employee14_firstname"))
		 		.body("first_name",equalTo("employee14_firstname"))
		 		.body("last_name",equalTo("employee14_firstname"));
		 }
	@Test(enabled = false,priority=2)
	public void getRequest_getEmployee() {
		
		 HashMap map = new HashMap();
		 map.put("first_name", "employee14_firstname");
		 map.put("last_name", "employee14_firstname");		 
		 given()
		 		.contentType(ContentType.JSON)
		 		.body(map)
		 .when()
		 		.post("http://localhost:3000/employee/26")
		 .then()
		 		.statusCode(200)
		 		.assertThat()		 		
		 		//.root("employee")
		 		//.body("first_name",hasItems("employee14_firstname"))
		 		.body("first_name",equalTo("employee14_firstname"))
		 		.body("last_name",equalTo("employee14_firstname"));
		 }
	@Test(enabled = false,priority=3)
	public void putRequest_updateEmployee() {
		
		 HashMap map = new HashMap();
		 map.put("first_name", "employee14_firstname");
		 map.put("last_name", "employee14_firstname");		 
		 given()
		 		.contentType(ContentType.JSON)
		 		.body(map)
		 .when()
		 		.post("http://localhost:3000/employee/3")
		 .then()
		 		.statusCode(201)
		 		.assertThat()		 		
		 		//.root("employee")
		 		//.body("first_name",hasItems("employee14_firstname"))
		 		.body("first_name",equalTo("employee14_firstname"))
		 		.body("last_name",equalTo("employee14_firstname"));
		 }
	
	@Test(enabled = false,priority=4)
	public void patchRequest_patchEmployee() {
		
		 HashMap map = new HashMap();
		 map.put("first_name", "employee14_firstname");
		 map.put("last_name", "employee14_firstname");		 
		 given()
		 		.contentType(ContentType.JSON)
		 		.body(map)
		 .when()
		 		.post("http://localhost:3000/employee/3")
		 .then()
		 		.statusCode(201)
		 		.assertThat()		 		
		 		//.root("employee")
		 		//.body("first_name",hasItems("employee14_firstname"))		 		
		 		.body("last_name",equalTo("employee14_firstname"));
		 }
	
	@Test(enabled = true,priority=4)
	public void deleteRequest_Employee() {
		
		 Response response = 
		 given()
		 			 		
		 .when()
		 		.delete("http://localhost:3000/employee/13")
		 .then()
		 		.statusCode(200)
		 		//.assertThat()		 		
		 		//.root("employee")
		 		//.body("first_name",hasItems("employee14_firstname"))		 		
		 		.extract().response();
		 
		 String jsonAsString=response.asString();
		 System.out.println("The Json value "+jsonAsString);
		 Assert.assertEquals("{}", jsonAsString);
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
