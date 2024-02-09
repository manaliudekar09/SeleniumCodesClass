package com.tta.selenium4learning.jsexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JSE01 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.spicejet.com/");
        JSUtils jsUtils = new JSUtils(driver);
        //jsUtils.makeAlertFromJS("Pramod");

        WebElement element = driver.findElement(By.xpath("//div[@data-testid=\"home-page-flight-cta\"]"));
        jsUtils.clickElementByJSE(element);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();

    }
}
