package com.tta.selenium4learning.assignment;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageAutomation {
    ChromeOptions options;
    WebDriver driver;


    @BeforeSuite
    public void setUp() {
        options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
    }


    @Test(priority = 0)
    @Description("Verify that with Invalid username and Valid password, Login is successfull !!")
    public void testInValidLogin() throws InterruptedException {
        driver.get("https://app.vwo.com/#/login");
        driver.findElement(By.id("login-username")).sendKeys("93npu2yyb0@esiix.co");
        driver.findElement(By.id("login-password")).sendKeys("Wingify@123");
        driver.findElement(By.id("js-login-btn")).click();
        Thread.sleep(2000);
        String errorString = driver.findElement(By.cssSelector("#js-notification-box-msg")).getText();
        Assert.assertEquals(errorString,"Your email, password, IP address or location did not match");
    }


    @Test(priority = 1)
    @Description("Verify that with Valid username and Valid password, Login is successfull !!")
    public void testValidLogin() throws InterruptedException {

        driver.get("https://app.vwo.com/#/login");
        driver.findElement(By.id("login-username")).sendKeys("93npu2yyb0@esiix.com");
        driver.findElement(By.id("login-password")).sendKeys("Wingify@123");
        driver.findElement(By.id("js-login-btn")).click();
        Thread.sleep(10000);
        String headerString = driver.findElement(By.cssSelector("[data-qa='page-heading']")).getText();
        Assert.assertEquals(headerString,"Dashboard");
        Assert.assertTrue(driver.findElement(By.className("page-heading")).isDisplayed());

    }



    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
