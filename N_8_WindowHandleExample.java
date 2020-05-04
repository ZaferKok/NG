package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

//        Given user is on the https://the-internet.herokuapp.com/windows
//        Then user verifies the text : “Opening a new window”
//        Then user verifies the title of the page is “The Internet”
//        When user clicks on the Click Here button
//        Then user verifies the new window title is “New Window”
//        Then user verifies the text:  “New Window”
//        When user goes back to the previous window and then verifies the title :
//        “The Internet”
public class N_8_WindowHandleExample extends TestBase {
    @Test
    public void newWindowTest(){
        // Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindowHadle = driver.getWindowHandle();//PARENT WINDOW HANDLE
        System.out.println("Parent Window Handle ==> " + parentWindowHadle);
        // Then user verifies the text : "Opening a new window"
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(actualText,expectedText);
        // Then user verifies the title of the page is "The Internet"
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);
        // When user clicks on the Click Here button
        driver.findElement(By.linkText("Click Here")).click(); // Now I have two windows open

        Set<String> allWindowHandles = driver.getWindowHandles();

        //Switching o child window
        for (String handle : allWindowHandles){
            if(!handle.equals(parentWindowHadle)){
                driver.switchTo().window(handle);
                System.out.println("Child Window Handle ==> " + handle);
            }
        }
        // Then user verifies the new window title is “New Window”
        String newWindowTitle = driver.getTitle();
        Assert.assertEquals(newWindowTitle,"New Window");
        // Then user verifies the text : "New Window"
        String actualNewWindowText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(actualNewWindowText,"New Window");

        // When user goes back to the previous window and then verifies the title :
        // “The Internet”
        driver.switchTo().window(parentWindowHadle);
        String parentTitle = driver.getTitle();
        Assert.assertEquals(parentTitle,"The Internet");
    }
}
