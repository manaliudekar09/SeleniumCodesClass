package com.tta.selenium4learning.relaticeLocatorsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RL02 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        driver.manage().window().maximize();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement searchelement = driver.findElement(By.xpath("//input[@id=\"search_city\"]"));

        searchelement.sendKeys("India"+Keys.ENTER);

        List<WebElement> list = driver.findElements(By.xpath("//table[@id=\"example\"]/tbody/tr/td[2]"));

        for (WebElement l : list){
            if(l.getText().contains("India")) {
                System.out.println(l.getText());
                System.out.println("\t");
                String s =driver.findElement(with(By.tagName("p")).toRightOf(l)).getText();
                String s1 =driver.findElement(with(By.tagName("p")).toLeftOf(l)).getText();
//                String s2 =driver.findElement(with(By.tagName("p")).below(l)).getText();
//                String s3 =driver.findElement(with(By.tagName("p")).above(l)).getText();
                System.out.println(s);
                System.out.println(s1);
//                System.out.println(s2);
//                System.out.println(s3);
            }
        }



        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();

    }
}
