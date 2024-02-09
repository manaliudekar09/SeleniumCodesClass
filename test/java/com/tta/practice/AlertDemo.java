package com.tta.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertDemo {

    public static void main(String[] args) {

        // There is no need to set the driver in path
        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

//        driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();




//        driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
        driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Pramod");
        alert.accept();

        String resultText = driver.findElement(By.id("result")).getText();

//        Assert.assertEquals(resultText,"You successfully clicked an alert");
//        Assert.assertEquals(resultText,"You clicked: Ok");
        Assert.assertEquals(resultText,"You entered: Pramod");



        //wait.until(ExpectedConditions.urlContains("setup/account-setup"))

        // Not closing the driver

    }
}
