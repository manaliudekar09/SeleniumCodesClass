package com.tta.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AP01 {

    public static void main(String[] args) {

        WebDriver dr = new FirefoxDriver();
        String URL = "https://awesomeqa.com/practice.html";
        dr.get(URL);
        dr.manage().window().maximize();

        WebElement firstName = dr.findElement(By.name("firstname"));

        Actions actions = new Actions(dr);

        actions.keyDown(Keys.SHIFT).sendKeys(firstName,"the testing academy").keyUp(Keys.SHIFT).build().perform();

        // THETESTINGACDEMY


        WebElement date = dr.findElement(By.id("datepicker"));
        actions.sendKeys(date,"23/12/2025").perform();

        WebElement link = dr.findElement(By.xpath("//a[contains(text(),\"Click here to Download File\")]"));
        actions.contextClick(link).perform();







    }
}
