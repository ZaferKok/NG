package com.techproed.tests;
//        Create a class: WebTables
//        Create a method: login() and log in : http://www.fhctrip.com/admin/HotelRoomAdmin
//        manager2
//        Man1ager2!
//        Finding size of the entire table body
//        Find the total number of rows and cells in the table body
//        Print headers, rows, and cells
//        Print the elements of 4th row
//        Print the elements of the 5th column
//        Print the element of a 15th cell

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class N_14_WebTables extends TestBase {
    //        Create a method: login() and log in : http://www.fhctrip.com/admin/HotelRoomAdmin
    public void login(){
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");;
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    //        Finding size of the entire table body
    @Test
    public void entireTable() throws InterruptedException {
        login();//loging in using the login method.
//        Print the element of a 15th cell
        Thread.sleep(3000);
        WebElement tBody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tBody.getText());
        //Finding the size=>find the total number of cells in the table body
        List<WebElement> table=driver.findElements(By.xpath("//tbody//td"));
        System.out.println("The size of the table body is ===>> "+table.size());//Size of the table
        System.out.println(driver.findElements(By.tagName("//tbody//td")).size());//We can use tag name to find the data
        List<WebElement> allHeader=driver.findElements(By.tagName("th"));
        for (WebElement header:allHeader){
            System.out.println(header.getText());
        }
    }
    //        Find the total number of rows and cells in the table body
    @Test
    public void printRows(){
        login();
        System.out.println("There are "+driver.findElements(By.xpath("//tbody//tr")).size()+" rows in the table body");
        //print the rows
        List<WebElement> allRows=driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement row:allRows){
            System.out.println(row.getText());
        }
        //        Print the elements of 4th row
        List<WebElement> elements4th=driver.findElements(By.xpath("//tr[4]//td"));
        for (WebElement element :elements4th){
            System.out.println(element.getText());
        }
    }
    //        Find the total number of cells in the table body
    @Test
    public void printCells(){
        login();
        System.out.println("There are "+driver.findElements(By.xpath("//tbody//td")).size()+" cells in the table body");
        List<WebElement> allCells = driver.findElements(By.xpath("//tbody//td"));
        for (WebElement cell:allCells){
            System.out.println(cell.getText());
        }
    }
    @Test
    public void printColumn(){
        login();
        System.out.println("There are "+driver.findElements(By.xpath("//tr[3]//td")).size()+" column in the table body");
        //        Print the elements of the 5th column
        List<WebElement> columns5th=driver.findElements(By.xpath("//tbody//td[5]"));
        for (WebElement element:columns5th){
            System.out.println(element.getText());
        }
    }
    public void printData(int row, int column){
        //write your code in this method
        //tbody//tr[8]//td[6]
        //Writing the dynamic xpath
        String xpath = "//tbody//tr["+row+"]//td["+column+"]";
        //String xpath1 = "//tbody//tr[8]//td[6]";//=>Studio
        //We are finding the elements  using that xpath
        WebElement data=driver.findElement(By.xpath(xpath));
        //We are and printing the data
        System.out.println(data.getText());
    }
    @Test
    public void printDataTest(){
        login();
        printData(8,6);//Studio
        printData(3,4);//147
        printData(5,2);//Hilton Hotel-1
    }
}

