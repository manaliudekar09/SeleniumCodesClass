package com.tta.selenium4learning.assignment;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class LoginPageAutomationFluentWait {
    ChromeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setHeadless(true);
        driver = new ChromeDriver(options);
    }

    @Test
    @Description("Verify that with Valid username and Valid password, Login is successfull !!")
    public void testValidLogin() throws InterruptedException {

        driver.get("https://app.vwo.com/#/login");
        driver.findElement(By.id("login-username")).sendKeys("93npu2yyb0@esiix.com");
        driver.findElement(By.id("login-password")).sendKeys("Wingify@123");
        driver.findElement(By.id("js-login-btn")).click();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))  // 30 , 5 poll
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector(".page-heading"));
            }
        });

        Assert.assertTrue(driver.findElement(By.cssSelector(".page-heading")).isDisplayed());

    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
