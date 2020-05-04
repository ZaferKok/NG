package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

public class N_7_Soft_Hard_Assertion {
//    When user goes to http://a.testaddressbook.com/sign_in
//    Locate the elements of email textbox,password textbox, and signin button
//    Enter below username and password then click sign in button
//    Username :  testtechproed@gmail.com
//    Password : Test1234!
//    Then Assert/
//    Verify that the expected user id  testtechproed@gmail.com using different assertions
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test()
    public void login(){
        WebElement emailBox=driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");
        WebElement passBox=driver.findElement(By.id("session_password"));
        passBox.sendKeys("Test1234!");
        WebElement logInButton=driver.findElement(By.name("commit"));
        logInButton.click();
    }
    @Test(dependsOnMethods = "login")
    public void homePage(){
        WebElement wellcomeMessage=driver.findElement(By.xpath("//h1"));
        //System.out.println(wellcomeMessage.getText());
        Assert.assertTrue(wellcomeMessage.isDisplayed());//Hard Assertion
        System.out.println("This line will not run if hard assertion fails");
        //SOFT ASSERT
        //Step 1: Create the object
        SoftAssert softAssert = new SoftAssert();
        //Step 2: use that object for assertion
        softAssert.assertTrue(wellcomeMessage.isDisplayed());//passes
//        softAssert.assertEquals(3,5);//fail
//        softAssert.assertTrue(!wellcomeMessage.isDisplayed());//fails
        //Verify that the expected user id  testtechproed@gmail.com using different assertions
        WebElement idElement = driver.findElement(By.className("navbar-text"));
        String actualID = idElement.getText();
        String expectedID = "testtechproed@gmail.com";
        System.out.println(expectedID);
        softAssert.assertEquals(expectedID, actualID);//Fail
        softAssert.assertAll();//THIS LINE IS VERY IMPORTANT. assertAll() does the actual assertion
        System.out.println("This is after assert all assertion. Won't run if assertAll fails");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}