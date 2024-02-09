package com.tta.selenium4learning.iframeDemo;

import com.tta.selenium4learning.jsexecutor.JSUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class JSE02 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://codepen.io/mmoonn/full/PwvraE");
        driver.manage().window().maximize();
        JSUtils jsUtils = new JSUtils(driver);
        //jsUtils.makeAlertFromJS("Pramod");

        // Iframe
        // Hover and Click

        driver.switchTo().frame("result");

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.cssSelector("body > div"));
        actions.moveToElement(element).build().perform();


        //jsUtils.clickElementByJSE(element);

    }
}
