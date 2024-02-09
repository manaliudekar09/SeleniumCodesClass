package com.tta.selenium4learning.L1;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.testng.Assert.assertEquals;

public class Wait {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        //options.setPageLoadStrategy(PageLoadStrategy.NONE); // document.readyState -> complete
        //options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://sdet.dorik.io/wait");
        WebElement element = driver.findElement(By.tagName("p"));
        assertEquals(element.getText(), "Hello from JavaScript!");
        driver.quit();

    }
}
