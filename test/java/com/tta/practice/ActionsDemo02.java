package com.tta.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ActionsDemo02 {
    public static void main(String[] args) throws InterruptedException {

        //div[data-testid='to-testID-origin'] > div > div > input


        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.makemytrip.com/");

        Thread.sleep(5000);

        WebElement fromCity = driver.findElement(By.id("fromCity"));
        //fromCity.sendKeys("New Delhi");


        // Move to elememt -> Enter -> ul -> li getText New ->  select
        Actions actions = new Actions(driver);

        actions.moveToElement(fromCity).click().sendKeys("New Delhi").build().perform();

        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));

        for (WebElement element : list) {

            if (element.getText().contains("New Delhi")) {
                element.click();
                break;
            }

        }


    }
}
