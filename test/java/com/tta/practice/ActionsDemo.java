package com.tta.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args) {

        //div[data-testid='to-testID-origin'] > div > div > input


        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.spicejet.com/");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement((By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input")))).click().perform();





    }
}
