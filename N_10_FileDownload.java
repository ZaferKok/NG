package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

        /*Create a class:FileDownload
        Create two test method: isExist() and downloadTest()
        In the downloadTest() method, do the following test:
        Go to https://the-internet.herokuapp.com/download
        Download text.txt file
        Then verify if the file downloaded successfully.*/

public class N_10_FileDownload extends TestBase {

    @Test
    public void isExist(){
        String currentFolder=System.getProperty("user.dir"); // Gives me the path of the current folder
        System.out.println("Current Folder = > " + currentFolder);

        String userFolder=System.getProperty("user.home"); // Gives me the path of the user folder
        System.out.println("User Folder = > " + userFolder);

        String pathOfFile = userFolder + "/Downloads/logo9.png";
        // String pathOfFile = "C:/Users/CIMBOM/Downloads/logo9.png"; // This is also work but not much dynamic

        // Now that I have he path the file, I can verify if the file exist or not, using JAVA
        boolean isFileExist = Files.exists(Paths.get(pathOfFile));
        Assert.assertTrue(isFileExist); //If file exist, this will be true. If not false.


    }
    @Test
    public void downloadTest() throws InterruptedException {
        // I am going to the link
        driver.get("https://the-internet.herokuapp.com/download");
        // Finding he element that I want to download
        WebElement file = driver.findElement(By.linkText("upload.jpg"));
        // Clicking on the file
        file.click();
        // We need to wait for dowloading the file. If not it can not find the file
        Thread.sleep(3000); // This Thread is not recommended. Because, if it is downloaded
        // in 1 second, selenium still needs to wait for 2 seconds. Not dynamics.
        // getting the user folder
        String userFolder = System.getProperty("user.home");
        //  finding the path of the downloaded file
        String pathOfFile = userFolder + "/Downloads/upload.jpg";
        //  String pathOfFile = "C:/Users/CIMBOM/Downloads/upload.jpg"; This is also usable.
        // Checking if the file path exist or not
        boolean isDownloaded = Files.exists(Paths.get(pathOfFile));
        // Asserting if the test case is true or false
        Assert.assertTrue(isDownloaded);
    }
}
