package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelRoomCreation2 extends TestBase {
    @Test
    public void RoomCreateTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Login first
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("manager2");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Man1ager2!");
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        Thread.sleep(3000);
        loginBtn.click();
        Thread.sleep(3000);
        WebElement addHotelRoom = driver.findElement(By.xpath("//span[@class='hidden-480']"));
        addHotelRoom.click();
        // verify opened?
        WebElement verifyOpened = driver.findElement(By.xpath("//div[@class='caption']"));
        Assert.assertEquals(verifyOpened, "Create Hotelroom");
        // dropdown select
        WebElement dropdownHotel = driver.findElement(By.xpath("//select[@title='Select Hotel']"));
        Select select1 = new Select(dropdownHotel);
        select1.selectByIndex(1);
        // Enter code
        WebElement codeBox = driver.findElement(By.xpath("//input[@title='Code']"));
        codeBox.sendKeys("412351");
        // Enter name
        WebElement nameBox = driver.findElement(By.xpath("//input[@title='Name']"));
        nameBox.sendKeys("Zaf KK");
        // Enter description
        WebElement descriptionBox = driver.findElement(By.xpath("//textarea[@dir='ltr']"));
        descriptionBox.sendKeys("This room is only for Royal Family");
        // Drag and drop the price
        WebElement source = driver.findElement(By.xpath("//li[@data-id='400']"));
        WebElement target = driver.findElement(By.name("Price"));
        Thread.sleep(3000);
        actions.dragAndDrop(source,target).perform();
        // Dropdown Room type
        WebElement roomTypeDrop = driver.findElement(By.name("IDGroupRoomType"));
        Select select2 = new Select(roomTypeDrop);
        select2.selectByIndex(1);
        // Enter Max Adult
        driver.findElement(By.name("MaxAdultCount")).sendKeys("1");
        // Enter Max Children
        driver.findElement(By.id("MaxChildCount")).sendKeys("1");
        // Click on save
        driver.findElement(By.id("btnSubmit")).click();
        // Verify message “HotelRoom was inserted successfully”
        Boolean isTrue = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"), "HotelRoom was inserted successfully"));
        Assert.assertTrue(isTrue);
        // Click OK for popup
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        // Click Hotel Rooms
        WebElement hotelRoomLink = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[@href='/admin/HotelRoomAdmin']"))));
        actions.doubleClick(hotelRoomLink).perform();
        // Verify page displayed
        WebElement hotelroomPage = driver.findElement(By.xpath("(//*[.='List Of Hotelrooms'])[2]"));
        Assert.assertTrue(hotelroomPage.isDisplayed());

        String hotelCode = driver.findElement(By.xpath("//tbody//tr[2]//td[3]")).getText();
        Assert.assertTrue(hotelCode.equals("41251"));
    }
}
