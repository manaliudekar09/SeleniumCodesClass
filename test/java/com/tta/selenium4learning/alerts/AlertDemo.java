package com.tta.selenium4learning.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertDemo {

    public static void main(String[] args) throws InterruptedException {

        //https://the-internet.herokuapp.com/javascript_alerts

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


        // driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();
//        driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
        driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());


// Get the alert
        Alert alert = driver.switchTo().alert();
//        String alertText = alert.getText();
        alert.sendKeys("Pramod");
        alert.accept();

        String result = driver.findElement(By.id("result")).getText();
//        Assert.assertEquals(result,"You successfully clicked an alert");
//        Assert.assertEquals(result,"You clicked: Ok");
//        Assert.assertEquals(result,"You entered: Pramod");

        Thread.sleep(20000000);



    }
}
