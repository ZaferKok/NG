package com.techproed.tests;
import com.techproed.pages.FhcLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
public class NegativeTestCase extends TestBaseFinal {
    //@Ignore (@Ignore and enabled=false do the same thing. Just run button deleted when you write enabled=false)
    //@Test(enabled = false)
    // This test runs 2 times.
    @Test(invocationCount = 2,groups = "regression1",priority = 1)
    public void invalidPass() throws InterruptedException {
        extentTest=extentReports.createTest("TEST NAME","NEGATIVE TEST");
        extentTest.info("Opening the URL");
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        extentTest.info("creating page object");
        FhcLoginPage fhcLoginPage = new FhcLoginPage(Driver.getDriver());
        //correct username but incorrect pass
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("valid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("invalid_password"));
        extentTest.info("clicking");
        fhcLoginPage.login.click();
        Thread.sleep(3000);
        extentTest.info("verifying");
        Assert.assertFalse(fhcLoginPage.errorMessage.getText().contains(ConfigReader.getProperty("login_error_message")));
        extentTest.pass("PASSED");
    }
    @Test(groups = "regression1")
    public void invalidID(){
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        FhcLoginPage fhcLoginPage = new FhcLoginPage(Driver.getDriver());
        // Correct pass but inccorrect username
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("invalid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("valid_password"));
        fhcLoginPage.login.click();
        //Assertion
        Assert.assertTrue(fhcLoginPage.errorMessage.getText().contains(ConfigReader.getProperty("login_error_message2")));
    }
    @Test(groups = "regression1")
    public void invalidIDAndPass(){
        Driver.getDriver().get("http://www.fhctrip.com/Account/Logon");
        FhcLoginPage fhcLoginPage = new FhcLoginPage(Driver.getDriver());
        //Both incorrect username password
        fhcLoginPage.username.sendKeys("minagr2");
        fhcLoginPage.password.sendKeys("Man2ager2");
        fhcLoginPage.login.click();
        //Assertion
        Assert.assertTrue(fhcLoginPage.errorMessage.getText().contains("Try again please"));
    }
}