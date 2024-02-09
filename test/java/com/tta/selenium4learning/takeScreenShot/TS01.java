package com.tta.selenium4learning.takeScreenShot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TS01 {
    public static void main(String[] args) throws AWTException, IOException {

        WebDriver driver = new FirefoxDriver();
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);
        driver.manage().window().maximize();
        // Create File object and save screenshot of current webpage inside it
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Copy screenshot file to a location with some name and extension you want
        FileUtils.copyFile(screenshot, new File("screenshot.jpg"));
        // Close browser
        driver.close();


    }

}
