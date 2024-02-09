package com.tta.selenium4learning.actions;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class Actions02 {
    public static void main(String[] args) throws AWTException, InterruptedException {

        WebDriver driver = new FirefoxDriver();
        String URL = "https://www.makemytrip.com/";
        driver.get(URL);
        driver.manage().window().maximize();


        Actions actions = new Actions(driver);

        Thread.sleep(5000);



        WebElement fromCity = driver.findElement(By.id("fromCity"));
        actions.moveToElement(fromCity).click().sendKeys("New Delhi, India").build().perform();


        List<WebElement> li = driver.findElements(By.xpath("(//ul[@role='listbox'])/li"));
        for (WebElement element : li) {
                if(element.getText().contains("New Delhi, India")){
                    element.click();
                    break;
                }
        }


        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform(); //Page Down
        System.out.println("Scroll down perfomed");
        Thread.sleep(3000);


    }

}
