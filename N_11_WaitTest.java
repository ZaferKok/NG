package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
    /*
    Test Case:
    Create a class: WaitTest
    Create two method: 1. implicyWait, 2. explicitWait
    When user goes to https://the-internet.herokuapp.com/dynamic_controls
    And click on Remove button
    Then verify "It's gone!" message displays
     */
public class N_11_WaitTest extends TestBase {

    @Test
    public void implicitWait(){
        // We have implicit wait in our testbase class, we driver will automatically
        // use implicit wait whenever we use driver
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton = driver.findElement(By.xpath("//button[@type='button']"));
        removeButton.click();
        WebElement goneMessage = driver.findElement(By.id("message"));
        String expectedMessage = "It's gone!";
        Assert.assertEquals(goneMessage.getText(),expectedMessage);
    }
    @Test
    public void explicitWait(){
        // Create webdriverwait object. It takes two parameter, driver, and second
        WebDriverWait wait=new WebDriverWait(driver,10);
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton = driver.findElement(By.xpath("//button[@type='button']"));
        removeButton.click();

        WebElement goneMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String expectedMessage = "It's gone!";
        Assert.assertEquals(goneMessage.getText(),expectedMessage);
    }



}
