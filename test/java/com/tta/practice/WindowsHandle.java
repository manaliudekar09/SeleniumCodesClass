package com.tta.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class WindowsHandle {

    public static void main(String[] args) {


        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver();
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);

        String parentHandle = driver.getWindowHandle();
        System.out.println(parentHandle);

        driver.findElement(By.xpath("//a[normalize-space()=\"Click Here\"]")).click();


        // Windows ?
        Set<String> windowsHandles = driver.getWindowHandles();
        for(String handle : windowsHandles){
            driver.switchTo().window(handle);

            if(driver.getPageSource().contains("New Window")){
                System.out.println("Found it");
            }


        }







    }
}
