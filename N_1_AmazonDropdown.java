package com.techproed.tests;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class N_1_AmazonDropdown extends TestBase { // we extended to Testbase, so we no need more Before and After method.
    // But we need to make WebDriver driver as Protected or Public. Other driver complains.
    @Test
    public void amazonTest(){
        driver.get("https://www.amazon.com/");
        WebElement dropdownElement=driver.findElement(By.id("searchDropdownBox"));

        Select select=new Select(dropdownElement);
        String firstOption=select.getFirstSelectedOption().getText();
        Assert.assertEquals(firstOption,"All Departments");

        //select 4th option by index
        select.selectByIndex(3);
        String forthOption=select.getFirstSelectedOption().getText();
        Assert.assertEquals(forthOption,"Amazon Devices");

        //printing all options
        List<WebElement> allOptions=select.getOptions();
        for (WebElement option : allOptions){
            System.out.println(option.getText());
        }

        //Check if Appliances id in the dropdown. Print True if it is. Print false if it isn't
        boolean flag=false;
        for (WebElement option : allOptions){
            if (option.getText().equals("Appliances")){
                flag=true;
                break;
            }
        }
        System.out.println(flag);
    }

}
// Homework: Amazon dropdown list in Alphabetical order or not. return True or False