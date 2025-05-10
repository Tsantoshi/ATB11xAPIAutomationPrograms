package com.thetestingacademy.ex_06_TestAssetions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting026_TestNG_Assertions {

    @Test(enabled = false)
    public void test_hardAssertExample(){

        System.out.println("Start the program");
        Assert.assertEquals("santoshi","Santoshi");
        System.out.println("end of the program");
    }

    @Test
    public void test_softAssertExample(){

        System.out.println("start the program");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("santoshi", "Santoshi");
        System.out.println("End of the program");
        softAssert.assertAll();
    }
}
