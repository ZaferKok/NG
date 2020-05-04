package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class N_9_UploadFile extends TestBase {
    @Test
    public void uploadFileMethod(){
        driver.get("https://the-internet.herokuapp.com/upload");
        // When we upload a file, do manual testing to understand the steps.
        // finding the choosefile button
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        // find the path of the file you want to upload
        String filePath = "C:/Users/CIMBOM/Desktop/logo9.png";

        // We need to send the file path to the choose file button
        chooseFile.sendKeys(filePath);

        // We need to click the upload bultton
        WebElement uploadButton = driver.findElement(By.className("button"));
        uploadButton.click();

        // We are doing assertion to verfy the upload is successful
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),"File Uploaded!");
    }
}
