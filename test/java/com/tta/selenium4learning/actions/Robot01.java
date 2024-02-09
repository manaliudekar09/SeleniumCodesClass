package com.tta.selenium4learning.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Robot01 {
    public static void main(String[] args) throws AWTException {

        WebDriver driver = new FirefoxDriver();
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);
        driver.manage().window().maximize();

        driver.findElement(By.className("input-file")).click();

        // Wait for 3 seconds
        try { Thread.sleep(3000);}
        catch (InterruptedException e){ e.printStackTrace();}

        // Get Location of the file to be uploaded
        String fileLocation = System.getProperty("user.dir") + "/screenshot.jpeg";
        StringSelection filepath = new StringSelection(fileLocation);

        // Copy the file path
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

        // Try block
        try {
            // Create object of Robot class
            Robot robot = new Robot();

            // Press Ctrl key
            robot.keyPress(KeyEvent.VK_CONTROL);
            // Press Ctrl + V key - It will paste the file path in windows dialog
            robot.keyPress(KeyEvent.VK_V);

            // Now release V + Ctrl key
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Click Enter Key
            robot.keyPress(KeyEvent.VK_ENTER);

            // Release Enter Key
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (AWTException e) {e.printStackTrace();}


    }

}
