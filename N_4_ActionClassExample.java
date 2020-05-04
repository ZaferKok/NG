package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class N_4_ActionClassExample extends TestBase {
//    Create a class: ActionsClassExample
//    Create a test method : contextClickMethod() and test the following scenario:
//    Given user is on the https://the-internet.herokuapp.com/context_menu
//    When use Right clicks on the box
//    Then verify the alert message is “You selected a context menu”
//    Then accept the alert

    @Test
    public void contextClickMethod() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //When use Right clicks on the box
        // 1. Identify the webelement
        WebElement rectangle = driver.findElement(By.id("hot-spot"));
        // 2. Create Actions Object
        // no need for ==> Actions actions = new Actions(driver); Because it is created in TestBase Class
        // 3. Now I have actions object, I can perform mouse and keyboard actions
        // cations.contextClick().perform();// This is not going to click on the specific element
        actions.contextClick(rectangle).perform();
        String actualText = driver.switchTo().alert().getText();
        String expectedText = "You selected a context menu";
        Assert.assertEquals(actualText, expectedText);
        // Then accept the alert
        driver.switchTo().alert().accept();
        // actions.contextClick(rectangle).build();

        // Homework ==> Right Click on Element selenium
        WebElement elementalSeleniumText = driver.findElement(By.xpath("//a[@target='_blank']"));
        actions.contextClick(elementalSeleniumText).perform(); // Ama olmadı!!!!!!!

    }
    @Test
    public void hoverOver() {
        /*Create another test method : hoverOver() and test the following scenario:
        Given user is on the https://www.amazon.com/
        When use click on “Your Account” link
        Then verify the page title contains “Your Account”
         */
        driver.get("https://www.amazon.ca/");
        WebElement signInBox = driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));

        // no need for ==> Actions actions = new Actions(driver); Because it is created in TestBase Class

        actions.moveToElement(signInBox).perform();
        WebElement yourAccount = driver.findElement(By.linkText("Your Account"));
        yourAccount.click();
        String actualTitle = driver.getTitle();
        String expetedTitle = "Your Account";
        Assert.assertTrue(actualTitle.contains(expetedTitle));
    }

    @Test
    public void imageTest(){
        driver.get("https://www.amazon.ca/");
        WebElement primeTry = driver.findElement(By.id("nav-link-prime"));
        // no need for ==> Actions actions = new Actions(driver); Because it is created in TestBase Class
        actions.moveToElement(primeTry).perform();
        Assert.assertTrue(driver.findElement(By.id("nav-flyout-prime")).isDisplayed());
    }
//    Create a method in the same class: keysUpDown()
//    Go to google
//    Search for IPHONE X PRICES (all capital)
//    And double click on the text box
    @Test
    public void keysUpDown(){
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
       // searchBox.sendKeys("iphone x prices");

        //input => iphone x prices. output => IPHONE X PRICES
        //METHOD 1 TO SEND UPPER CASE:
        //searchBox.sendKeys(Keys.SHIFT+"iphone x prices");

        //METHOD 2 : ACTIONS CLASS
        //using Keys.Shift we are pressing shift key on the keyboard
//        actions.
//                moveToElement(searchBox).
//                click().
//                keyDown(Keys.SHIFT).
//                sendKeys("iphone x prices").
//                perform();
        actions.//using the actions object
                keyDown(searchBox, Keys.SHIFT).//pressing shift on the keyboard
                sendKeys("iphone x prices").//typing
                keyUp(searchBox,Keys.SHIFT).//releasing the shift button
                perform();//performing the action
        actions.doubleClick(searchBox).perform();//Go and double click on searchBox
    }
    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Thread.sleep(5000);
        //Scrolling down the page
        actions.sendKeys(Keys.PAGE_DOWN).perform(); // 1 page down
        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        //ARROW_DOWN also scrolls down the page, but it scroll less amount
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(5000);
        //Scroll Up A Page using sendKeys(Keys.PAGE_UP)
        actions.sendKeys(Keys.ARROW_UP).perform();

    }
}
