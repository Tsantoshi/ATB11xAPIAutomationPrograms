package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class APITesting022_TestNG_invocationCount {

    @Test(invocationCount = 2)
    public void test01(){
        System.out.println("Hi");
    }

    @Test(invocationCount = 3)
    public void test02(){
        System.out.println("Bye");
    }

    @Test()
    public void test03(){
        System.out.println("hello");
    }
}
