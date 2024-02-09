package com.tta.selenium4learning.relaticeLocatorsDemo;

import com.tta.selenium4learning.jsexecutor.JSUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.locators.RelativeLocator.*;
public class RL01 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.xpath("//span[.='Years of Experience']"));

        driver.findElement(with(By.id("exp-1")).toRightOf(element)).click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();

    }
}
