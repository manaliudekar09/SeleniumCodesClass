package com.tta.selenium4learning.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Actions01 {
    public static void main(String[] args) throws AWTException {

        WebDriver driver = new FirefoxDriver();
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement FIRSTNAME = driver.findElement(By.name("firstname"));

        /* KeyUP and KeyDown
         */
        // Create object of Actions class
        Actions actions = new Actions(driver);

        // This will type Username in Uppercase as we are typing using Shift key pressed
        actions.keyDown(Keys.SHIFT)
                .sendKeys(FIRSTNAME, "the testing acadey")
                .keyUp(Keys.SHIFT)
                .build()
                .perform();


        WebElement date = driver.findElement(By.id("datepicker"));
        actions.sendKeys(date,"23/12/2025").perform();

        WebElement link = driver.findElement(By.xpath("//a[contains(text(),\"Click here to Download File\")]"));
        actions.contextClick(link).build().perform();


    }

}
