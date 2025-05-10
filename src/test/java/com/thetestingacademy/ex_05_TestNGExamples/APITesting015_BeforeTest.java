package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting015_BeforeTest {

    // PUT Request -
    // 1. getToken
    // 2. getBookingId
    // 3. test_PUT ( which will use the above two methods)
    // 4. closeAllThings

    @BeforeTest
    public void getToken(){
        System.out.println("before Get Token");
    }

    @BeforeTest
    public void getBookingId(){
        System.out.println("before get Booking");
    }

    @Test
    public void test_PUT(){
        System.out.println("Put request");
    }

    @AfterTest
    public void closeAllThings(){
        System.out.println("closeAllThings");
    }
}
