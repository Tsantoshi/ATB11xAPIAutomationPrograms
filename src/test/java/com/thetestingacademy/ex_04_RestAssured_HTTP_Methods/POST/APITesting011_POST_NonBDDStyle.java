package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_POST_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;


    @Test
    public void test_POST_NonBDDStyle(){

        String payload =  "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        // Part 1 - Pre Condition - Preparing Request - URL, Headers, Auth...
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        System.out.println("........");

        // Making HTTP Request -> Part 2
        response = r.when().log().all().post();

        System.out.println("...........");

        // Verification Part -> Part 3
        vr = response.then().log().all();
        vr.statusCode(200);

    }
}
