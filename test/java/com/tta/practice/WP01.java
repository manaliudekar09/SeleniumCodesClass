package com.tta.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;

public class WP01 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        // Window -> 1
        String parentHandle = driver.getWindowHandle();
        System.out.println(parentHandle);

        driver.findElement(By.xpath("//a[text()=\"Click Here\"]")).click();

        Set<String> windowHanles = driver.getWindowHandles();

        for(String handle :  windowHanles){

            driver.switchTo().window(handle);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("Found it");
            }

        }


        Iterator<String> iterator  = windowHanles.iterator();

        while (iterator.hasNext()){
            String childWindow = iterator.next();
            if(!parentHandle.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
            }
        }



    }
}
