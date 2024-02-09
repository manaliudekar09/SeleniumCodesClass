package com.tta.selenium4learning.relaticeLocatorsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RL03 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.manage().window().maximize();

        // Validations

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.switchTo().frame("result");

        WebElement submit = driver.findElement(By.xpath("//form[@id=\"form\"]/button"));

        submit.click();

        WebElement element = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement errorElement = driver.findElement(with(By.tagName("small")).below(element));
        String error = errorElement.getText();
        System.out.println(error);
        Assert.assertTrue(errorElement.isDisplayed());



        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();

    }
}
