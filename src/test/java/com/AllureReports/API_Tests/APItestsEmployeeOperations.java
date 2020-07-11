package com.AllureReports.API_Tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@Listeners({ com.AllureReports.ReportsGeneration.AllureListener.class })
public class APItestsEmployeeOperations {

	public static Integer id = null;

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "http://localhost:3000";
	}

	@Severity(SeverityLevel.BLOCKER)
	@Test(enabled = false, priority = 1, description = "Verify empolyee creation")
	@Description("Verify empolyee creation........")
	@Epic("EP001")
	@Feature("Feature1: empolyee creation")
	@Story("Story:Empolyee creation")
	@Step("Verify Empolyee creation")
	public void postRequest_createNewEmployee() {
		RestAssured.basePath = "/employee";
		HashMap map = new HashMap();
		map.put("first_name", "employee16_firstname");
		map.put("last_name", "employee16_lastname");

		Response resp = given().contentType(ContentType.JSON).body(map).when().post().then().statusCode(201)
				.assertThat().body("first_name", equalTo("employee16_firstname"))
				.body("last_name", equalTo("employee16_lastname")).extract().response();
		resp.prettyPrint();
		JsonPath extractor = resp.jsonPath();
		id = extractor.get("id");
	}

	@Severity(SeverityLevel.BLOCKER)
	@Test(enabled = false, priority = 2, description = "Retrive empolyee")
	@Description("Retrive empolyee creation........")
	@Epic("EP001")
	@Feature("Feature2: empolyee Retrive")
	@Story("Story:Empolyee retrive")
	@Step("Verify Empolyee retrive")
	public void getRequest_getEmployee() {
		RestAssured.basePath = "employee/" + id;
		given().when().get().then().statusCode(200).assertThat().body("first_name", equalTo("employee16_firstname"))
				.body("last_name", equalTo("employee16_lastname"));
	}

	@Severity(SeverityLevel.BLOCKER)
	@Test(enabled = true, priority = 2, description = "Retrive empolyees")
	@Description("Retrive empolyees created........")
	@Epic("EP001")
	@Feature("Feature2: empolyees Retrive")
	@Story("Story:Empolyees retrive")
	@Step("Verify Empolyees retrive")
	public void getRequest_getEmployees() {
		RestAssured.basePath = "employee/";
		Response resp = given().when().get().then().statusCode(200).extract().response();
		String jsonAsString = resp.asString();
		JsonPath jp = resp.jsonPath();
		System.out.println(jp.prettyPrint());
		int recordCount = jp.getInt("employee.size()");
		System.out.println("The record count is  " + recordCount);

		for (int i = 1; i < recordCount; i++) {
			String id = jp.get("id[" + i + "]").toString();

			if (id.equalsIgnoreCase("26")) {
				System.out.println("The current id is " + id);
				System.out.println("The first name " + jp.get("first_name[" + i + "]").toString());
				System.out.println("The last name " + jp.get("last_name[" + i + "]").toString());
				break;
			}
		}

	}

	@Severity(SeverityLevel.BLOCKER)
	@Test(enabled = false, priority = 3, description = "Update empolyee")
	@Description("Update empolyee creation........")
	@Epic("EP001")
	@Feature("Feature3: empolyee update")
	@Story("Story:Empolyee update")
	@Step("Verify Empolyee update")
	public void putRequest_updateEmployee() {
		RestAssured.basePath = "employee/" + id;
		HashMap map = new HashMap();
		map.put("first_name", "employee16_firstname");
		map.put("last_name", "employee16_lastname");
		given().contentType(ContentType.JSON).body(map).when().put().then().statusCode(200).assertThat()
				.body("first_name", equalTo("employee16_firstname")).body("last_name", equalTo("employee16_lastname"));
	}

	@Severity(SeverityLevel.BLOCKER)
	@Test(enabled = false, priority = 4, description = "Patch empolyee")
	@Description("Patch empolyee........")
	@Epic("EP001")
	@Feature("Feature4: empolyee patch")
	@Story("Story:Empolyee patch")
	@Step("Verify Empolyee patch")
	public void patchRequest_patchEmployee() {
		RestAssured.basePath = "employee/" + id;
		HashMap map = new HashMap();
		map.put("first_name", "employee17_firstname");
		given().contentType(ContentType.JSON).body(map).when().patch().then().statusCode(200).assertThat()
				.body("first_name", equalTo("employee17_firstname")).body("last_name", equalTo("employee16_lastname"));
	}

	@Severity(SeverityLevel.BLOCKER)
	@Test(enabled = false, priority = 5, description = "Delete empolyee")
	@Description("Patch empolyee........")
	@Epic("EP001")
	@Feature("Feature4: empolyee delete")
	@Story("Story:Empolyee delete")
	@Step("Verify Empolyee delete")
	public void deleteRequest_Employee() {
		RestAssured.basePath = "employee/" + id;
		Response response = given().when().delete().then().statusCode(200).extract().response();

		String jsonAsString = response.asString();
		System.out.println("The Json value " + jsonAsString);
		Assert.assertEquals("{}", jsonAsString);
	}

}
