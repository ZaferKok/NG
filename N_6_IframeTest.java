package com.techproed.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class N_6_IframeTest {
    /*
    create a class : IframeTest
    create a @BeforeMethod and go to https://the-internet.herokuapp.com/iframe
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void iframeTest(){
        //print the text on the parent iframe
        //I will not get exception when locating below line, because that is not inside the iframe
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
        //Trying to type in the box
        //WebElement textBox=driver.findElement(By.xpath("//p"));//This Fails
        //IF YOUR CODE FAILS WHAT DO YOU DO?
        //1.checking of the webelement is correct
        //2.checking if i have wait problem
        //3.then check the page if you have some iframe
        //I HAVE IFRAME ON THE PAGE. SO I HAVE TO SWITCH TO THAT IFRAME FIRST
        //THERE ARE 3 WAYS TO SWITCH TO AN IFRAME:1.index,2.id,3.webelement
        //driver.switchTo().frame(0);//switching to the first iframe using index
        //driver.switchTo().frame("mce_0_ifr");//switching to the first iframe using ID Value
        WebElement frameElement=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));//switching using teh webelement
        driver.switchTo().frame(frameElement);
        //now i can find the element that is inside this iframe
        WebElement textBox=driver.findElement(By.xpath("//p"));
        //typing the message inside the box
        textBox.clear();//this clears the textbox
        textBox.sendKeys("Hello World");//typing the box
        //Print Elemental Selenium
        //switching back to parent frame
        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        WebElement seleniumText=driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println(seleniumText.getText());

    }
}
//April 5, 2020 (Important!)
//        =====iframes=====
//        iframe means page within a page. Multiple pages in a single webpage
//        Our code may fail, when we have an element inside an iframe.
//        If we have an iframe and want to work inside the iframe, then we have to switch to the iframe first.
//<iframe id="mce_0_ifr" src="javascript:&quot;&quot;" frameborder="0" ></iframe>
//        There are 3 ways to switch to an iframe:
//        1. BY INDEX:      driver.switchTo().frame(0);//first index is 0
//        2. BY ID:         driver.switchTo().frame("mce_0_ifr");
//        3. BY WEBELEMENT: driver.switchTo().frame(webelement);
//        WebElement frameElement=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
//        driver.switchTo().frame(frameElement);
//        HOW TO YOU GET BACK TO PARENT FRAME:
//        1. When you are inside a frame, then you have to get back to parent frame, to perform actions on ouside of the iframe.
//        ====>>>>>>>>  driver.switchTo().parentFrame();
//        iframe======> I want to get here. Then I have to use: driver.switchTo().defaultContent();
//        iframe====> I want to get here. Then I have to use: driver.switchTo().parentFrame();
//        iframe==> I am here.
//        iframe
//        driver.switchTo().defaultContent();
//        defaultContent(); takes you teh default page.
