package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class APITesting018_TestNG_DependsOnMethod {

    @Test
    public void serverStartedOK(){
        System.out.println("I will run first");
    }
    @Test(dependsOnMethods = "serverStartedOK")
    public void test1(){
        System.out.println("Method1");
    }

    @Test(dependsOnMethods = "serverStartedOK")
    public void test2(){
        System.out.println("Method2");
    }
}
