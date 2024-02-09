package com.tta.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;

public class EC01 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");
        WebElement ele = null;
        //Locate the search text box
        try {
            ele = driver.findElement(By.xpath("//input[@title=\"Search\"]"));
            //Refresh the web page
            driver.navigate().refresh();
            //Pass string using sendkeys to the web element
            ele.sendKeys("The Testing Academy");
        }
        catch (NoSuchElementException |StaleElementReferenceException e){
            System.out.println("Element not found!!");
            System.out.println(e.getMessage());
        }

    }
}
