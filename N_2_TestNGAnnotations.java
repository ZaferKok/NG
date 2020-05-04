package com.techproed.tests;

import org.testng.annotations.*;

public class N_2_TestNGAnnotations {
    //create a method name:setUp() and use@BeforeMethod annotation
    @BeforeMethod
    public void beforeMethod(){
        //@BeforeMethod runs before each Method that has @Test annotation
        System.out.println("This is Before Method");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("This is Before Class only once");
    }
    @Ignore
    @Test
    public void test1(){
        //@Test is used to create test cases or test method.
        //@Test annotation helps us run the test
        System.out.println("This is test 1 method");
    }
    @Test
    public void test2(){
        System.out.println("This is test 2 method");
    }
    //How do you skip test3
    //Answer: We use @Ignore annotation to skip certain test cases.
    @Ignore
    @Test
    public void test3(){
        System.out.println("This is test 3 method");
    }
    @AfterMethod
    public void afterMethod(){
        //This will run after every @Test annotation
        System.out.println("This is after method");
    }
    @AfterClass
    public void afterClass(){
        //This will run after the whole class is done only once
        System.out.println("This is after class runs only once");
    }
}
