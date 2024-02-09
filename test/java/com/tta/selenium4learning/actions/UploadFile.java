package com.tta.selenium4learning.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UploadFile {

    public static void main(String[] args) {

        //https://awesomeqa.com/selenium/upload.html

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver();
        String URL = "https://awesomeqa.com/selenium/upload.html";
        driver.get(URL);
        driver.manage().window().maximize();
        WebElement upload_file = driver.findElement(By.xpath("//input[@id='fileToUpload']"));
        upload_file.sendKeys("/Users/pramod/Documents/Course/apitesting.jpeg");
        driver.findElement(By.name("submit")).click();


    }
}
