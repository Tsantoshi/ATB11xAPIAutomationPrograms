package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

@Test
public class APITesting011_PUT_NONBddStyle {

    // PUT

    // token, booking id - A

//    public void get_token(){ }
//    public void get_booking_id(){}

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    public void test_PUT_NonBDD(){

        String token = "e8e3e2dda3810c3";
        String bookingid = "356";

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

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingid);
        r.contentType(ContentType.JSON);
        r.header("Cookie", "token=" + token);
        r.body(payload).log().all();

        response = r.when().log().all().put();

        vr = response.then().log().all();
        vr.statusCode(200);

    }
}
