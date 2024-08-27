package com.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PatientApiTests {
	private String baseUrl;

	@BeforeClass
	public void setup() {
		baseUrl = System.getProperty("baseUrl", "https://apimgmt-dev-crisp.azure-api.net/patients/query/");
		RestAssured.baseURI = baseUrl;
	}

	@Test
	public void testResponseStatusCodeIs200() {
		given().when().get().then().statusCode(200);
	}

	@Test
	public void testResponseHasRequiredFields() {
		Response response = given().when().get();

		response.then().assertThat().body("$", everyItem(hasKey("Id")));
		response.then().assertThat().body("$", everyItem(hasKey("Name")));
		response.then().assertThat().body("$", everyItem(hasKey("DateOfBirth")));
		response.then().assertThat().body("$", everyItem(hasKey("Address")));
	}

	@Test
	public void testPatientIdIsNonEmptyString() {
		Response response = given().when().get();

		response.then().assertThat().body("Id", everyItem(not(isEmptyOrNullString())));
	}

	@Test
	public void testNameDateOfBirthAndAddressShouldBeNonEmptyStrings() {
		Response response = given().when().get();

		response.then().assertThat().body("Name", everyItem(not(isEmptyOrNullString())));
		response.then().assertThat().body("DateOfBirth", everyItem(not(isEmptyOrNullString())));
		response.then().assertThat().body("Address", everyItem(not(isEmptyOrNullString())));
	}

	@Test
	public void testVerifyResponseForMissingRequiredQueryParameter() {
		Response response = given().when().get();

		response.then().assertThat().body("Id", everyItem(not(isEmptyOrNullString())));
		response.then().assertThat().body("Name", everyItem(not(isEmptyOrNullString())));
		response.then().assertThat().body("DateOfBirth", everyItem(not(isEmptyOrNullString())));
		response.then().assertThat().body("Address", everyItem(not(isEmptyOrNullString())));
	}
}
