package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//        Create a new class: FaceLogin
//        Create a test method: logInTest() and test the following user story
//        When user enter invalid credentials, we should see sign up page
//        https://www.facebook.com/
//        Username: fakeusername
//        Passwork: fakepassword
public class FaceLogin extends TestBase {
    @Test
    public void login() throws InterruptedException{
        driver.get("https://www.facebook.com/");
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
        email.sendKeys("fakeusername");
        password.sendKeys("fakepassword");
        login.click();
        Thread.sleep(3000);
        WebElement signUp = driver.findElement(By.linkText("Forgot Password?"));
        Assert.assertTrue(signUp.isDisplayed());
    }

}
