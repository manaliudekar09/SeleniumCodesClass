package com.tta.selenium4learning.jsexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class JSUtils {

    WebDriver driver;
    Duration maximumTimeout = Duration.ofSeconds(5000);

    public JSUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void makeAlertFromJS(String msg) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('" + msg + "')");
    }

    public void clickElementByJSE(WebElement element) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            Assert.fail("Test failed with exception ---> " + e.toString());
        }
    }


    public static void refreshBrowserByJS(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("history.go(0)");
    }

    public static String getTitleByJS(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    public static String getPageInnerText(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String pageText = js.executeScript("return document.documentElement.innerText;").toString();
        return pageText;
    }

    public static void scrollPageDown(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public static void scrollIntoView(WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Method is to wait for the page to load
     */
    public void waitForPageLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, maximumTimeout);
        wait.until(pageLoadCondition);
        System.out.println("*****Page loaded successfully*****");
    }

    // xhr, timeout



}
