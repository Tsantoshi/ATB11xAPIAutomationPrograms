package com.thetestingacademy.RestAssuredTask;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class APTTesting01_RA_AllureReport {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Owner("Santoshi")
    @Description("TC1  - verify the create token")
    @Test
    public void test_post_create_token() {

        String payload_token = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_token).log().all();

        response = requestSpecification.when().log().all().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }

    @Owner("Santoshi")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#2 - Verify that the Create Booking")
    @Test
    public void test_Post_CreateBooking() {

        String Payload_CB = "{\n" +
                "    \"firstname\": \"Jim\",\n" +
                "    \"lastname\": \"Brown\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(Payload_CB).log().all();

        response = requestSpecification.when().log().all().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }

    @Owner("Santoshi")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#3 - Verify Get Booking with the Booking ID")
    @Test
    public void test_GET_createBooking() {

        String BookingId = "441";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + BookingId);
        requestSpecification.contentType(ContentType.JSON).log().all();

        response = requestSpecification.when().log().all().get();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }

    @Owner("Santoshi")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#4 - Verify update booking")
    @Test
    public void test_Put_Booking() {

        String token = "88289d6eba1d216";
        String bookingid = "220";

        String payload = "{\n" +
                "    \"firstname\": \"santoshi\",\n" +
                "    \"lastname\": \"Thakur\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payload).log().all();

        response = requestSpecification.when().log().all().put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }

    @Owner("Santoshi")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#6 - Verify Partial update")
    @Test
    public void test_partial_updated_patch() {
        String token = "88289d6eba1d216";
        String bookingid = "3371";

        String payloadPatch = "{\n" +
                "    \"firstname\" : \"Sai\",\n" +
                "    \"lastname\" : \"KiranT\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payloadPatch).log().all();

        response = requestSpecification.when().log().all().patch();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


    }

    @Owner("Santoshi")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#7 - Verify delete booking")
    @Test
    public void test_delete() {


        String token = "d78d89c99f6b0ce";
        String bookingid = "12";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Cookie", "token=" + token);


        response = requestSpecification.when().log().all().delete();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);

    }
}
