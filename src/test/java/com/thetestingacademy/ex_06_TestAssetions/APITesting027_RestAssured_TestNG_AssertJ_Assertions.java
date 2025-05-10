package com.thetestingacademy.ex_06_TestAssetions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class APITesting027_RestAssured_TestNG_AssertJ_Assertions {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingId;

    public void test(){

        String payload_POST = "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 123,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();

        response = requestSpecification.when().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers; %4-%5
        // Matchers.equalto()

        validatableResponse.body("booking.firstname", Matchers.equalTo("Promod"));
        validatableResponse.body("booking.lastname",Matchers.equalTo("Datta"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
        validatableResponse.body("bookingid", Matchers.notNullValue());

        // TestNG - Extract the details of the firstname, bookingId, lastname from Response.

        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        // TestNG Assertions - 75%
        // SoftAssert vs
        // HardAssert -
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.

    }
}
