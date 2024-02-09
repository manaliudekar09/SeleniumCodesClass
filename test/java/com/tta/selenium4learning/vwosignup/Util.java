package com.tta.selenium4learning.vwosignup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Util {

    static String randomEmail = "contact" + (int)Math.floor(Math.random() * 100) + "@Wingify.com";


    static void waitVisibilityOfElementLocated(WebDriver driver,By xpath,long time){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }

}
