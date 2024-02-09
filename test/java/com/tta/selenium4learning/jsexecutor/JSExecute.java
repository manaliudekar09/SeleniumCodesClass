package com.tta.selenium4learning.jsexecutor;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class JSExecute {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver();
        String URL = "https://the-internet.herokuapp.com/add_remove_elements/";
        driver.get(URL);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Find an element
        WebElement element = driver.findElement(By.cssSelector("button[onclick=\"addElement()\"]"));
        // Use the JavaScript Executor to click the element
        jsExecutor.executeScript("arguments[0].click();", element);

        String TitleName = jsExecutor.executeScript("return document.title;").toString();
        jsExecutor.executeScript("window.scrollBy(0,600)");

        List<WebElement> added = driver.findElements(By.className("added-manually"));
        System.out.println(TitleName);
        System.out.println(added.size());
        driver.close();
    }
}
