package com.tta.selenium4learning.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DropDownDemo {

    @Test
    public void dynamicDropDown() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        Actions action =  new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("div[data-testid=\"to-testID-origin\"] >div > div > input"))).click().perform();
        Thread.sleep(20000000);




    }
}
