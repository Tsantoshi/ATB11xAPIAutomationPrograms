package com.thetestingacademy.ex_06_TestAssetions;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class APITesting025_RestAsssured_Assertions {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Owner("santoshi")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC#1 - Verify that the Create Booking is working fine, booking ID is not null")
    @Test
    public void test_Booking_Post() {

        String payload = "{\n" +
                "  \"firstname\" : \"Pramod\",\n" +
                "  \"lastname\" : \"Brown\",\n" +
                "  \"totalprice\" : 111,\n" +
                "  \"depositpaid\" : true,\n" +
                "  \"bookingdates\" : {\n" +
                "    \"checkin\" : \"2018-01-01\",\n" +
                "    \"checkout\" : \"2019-01-01\"\n" +
                "  },\n" +
                "  \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .body(payload)
                .log().all();

        response = requestSpecification.when().post();

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);
        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Brown"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
    }
}
