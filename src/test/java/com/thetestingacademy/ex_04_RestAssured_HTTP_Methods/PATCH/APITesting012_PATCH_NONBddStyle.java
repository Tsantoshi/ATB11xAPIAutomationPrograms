package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting012_PATCH_NONBddStyle {

    @Test
    public void test_patch_non_bdd(){

        String token = "88de4b10c285b23";
        String bookingid = "17966";

        String payload= "{\n" +
                "    \"firstname\" : \"Lucky\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/" + bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.body(payload).log().all();

        Response response = r.when().patch();

        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(200);

    }
}
