package com.AllureReports.API_Tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.io.File;
import java.io.IOException;
import java.sql.*;
/*import java.util.Properties;*/
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.AllureReports.Resources.EmployeeDetails;
import com.AllureReports.Utilities.BaseClass;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class APItestsJSON extends BaseClass {

	public static Integer id = null;

	@BeforeClass
	public void setUp() {
		super.setUp_API();
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
	@Test(enabled = false, priority = 2, description = "Retrive empolyees")
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

	@Severity(SeverityLevel.BLOCKER)
	@Test(enabled = true, priority = 5, description = "Create empolyee JSON")
	@Description("Create empolyee JSON.....")
	@Epic("EP001")
	@Feature("Feature4: empolyee JSON")
	@Story("Story:Empolyee JSON")
	@Step("Verify Empolyee JSON")
	public void creat_Employee_JSON()
			throws ClassNotFoundException, JsonGenerationException, JsonMappingException, IOException {

		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		// String databaseURL =
		// "jdbc:ucanaccess://e://Java//JavaSE//MsAccess//Employees.accdb";
		String databaseURL = "jdbc:ucanaccess://" + System.getProperty("user.dir")
				+ properties.getProperty("employeeDBpath");
		System.out.println("The Data base URL is " + databaseURL);
		ArrayList<EmployeeDetails> a = new ArrayList<EmployeeDetails>();
		try (Connection connection = DriverManager.getConnection(databaseURL)) {

			String sql = "SELECT * FROM employee";

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				EmployeeDetails e = new EmployeeDetails();
				// 3 different json files, 3 diff java objects
				e.setID(rs.getInt("ID"));
				e.setEmpName(rs.getString("EmpName"));
				e.setEmpDept(rs.getString("Department"));
				e.setEmpSal(rs.getString("Salary"));
				a.add(e);
			}
			for (int i = 0; i < a.size(); i++) {
				ObjectMapper o = new ObjectMapper();

				o.writeValue(new File(System.getProperty("user.dir") + properties.getProperty("resourcePath")
						+ "employeeInfo" + i + ".json"), a.get(i));
			}
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}