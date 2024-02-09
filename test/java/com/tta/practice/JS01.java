package com.tta.practice;

import com.tta.selenium4learning.jsexecutor.JSUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JS01 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // get title
        //driver.getTitle()
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title").toString();
        System.out.println(title);


        // Click on the button
        // Find the button and JS
        WebElement button = driver.findElement(By.cssSelector("button[onclick=\"addElement()\"]"));
        js.executeScript("arguments[0].click()",button);

        // We don't any second -> scrollToBottom 1
        // ScrollToView - button or element scroll ( 2)
        driver.get("https://thetestingacademy.com");
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        WebElement ele = driver.findElement(By.xpath("//a[@class='dorik-btn symbol--gir4ppoo dorik-button-85r90xp4']"));
        js.executeScript("arguments[0].scrollIntoView(true)",ele);


//        JSUtils js = new JSUtils(driver);
//        js.waitForPageLoad(driver);
//        js.clickElementByJSE();











    }
}
