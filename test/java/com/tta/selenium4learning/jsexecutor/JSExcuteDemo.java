package com.tta.selenium4learning.jsexecutor;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class JSExcuteDemo {

    @Test
    public void test1(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
            WebElement element = driver.findElement(By.cssSelector("button[onclick='addElement1()']"));

    }
    @Test
    public void test2(){

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        try {
            WebElement element = driver.findElement(By.cssSelector("button[onclick='addElement1()']"));
            //dsdadsadas
        } catch (NoSuchElementException | ElementNotInteractableException  e) {
            e.printStackTrace();
            System.out.println("I am unable to find the element");
            // log.error("printStackTrace");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void test3(){

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        try {
            WebElement element = driver.findElement(By.cssSelector("button[onclick='addElement1()']"));
            //dsdadsadas
        } catch (NoSuchElementException | ElementNotInteractableException  e) {
            e.printStackTrace();
            System.out.println("I am unable to find the element");
            // log.error("printStackTrace");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}