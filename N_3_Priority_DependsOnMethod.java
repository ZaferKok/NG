package com.techproed.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

public class N_3_Priority_DependsOnMethod {
    /*
    In testNG, test methods runs by alphabetical order. They don't run from top to bottom.
    To prioritize test cases, we use priority annotation
    When the priority numbers same, then the execution is in alphabetical order
    If the test method doesn't have the priority annotation, it execute before
     */
    //Make search() dependent on login():Answer: we write dependsOnMethod="login" inside the search() method
    @Test(priority =1)
    public void login(){
        System.out.println("This is login page");
    }
    @Test(priority = 2)
    public void homePage(){
        System.out.println("This is homePage");
    }
    @Test(priority=3)
    public void search(){
        System.out.println("This is search page");
        //Assert.assertTrue(false);
        //Assert.assertEquals(3,5);//This method will fail
        //Since this method fails, result() method will be ignored."Test ignored." message will be displayed
    }
    //To Make result() depends on search(), we
    @Test(priority = 4,dependsOnMethods = "search")//result() is now dependent on result.search() is not dependent on result()
    public void result(){
        System.out.println("This is result page");
    }
}