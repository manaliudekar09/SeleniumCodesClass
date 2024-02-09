package com.tta.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HeatMapExample {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver();
        String URL = "https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1";
        driver.get(URL);

        String mainWindowHandle = driver.getWindowHandle();
        System.out.println(mainWindowHandle);
        // There is only 1 window

        //[data-qa="yedexafobi"]

        Actions ac = new Actions(driver);
        List<WebElement> elementList = driver.findElements(By.cssSelector("[data-qa=\"yedexafobi\"]"));
        ac.moveToElement(elementList.get(1)).click().perform();

        // Widows?

        Set<String> windowsHandles = driver.getWindowHandles();
        System.out.println(windowsHandles);

        //
        Iterator<String> iterator  = windowsHandles.iterator();

        while (iterator.hasNext()){
            String childWindow = iterator.next();
            if(!mainWindowHandle.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                driver.switchTo().frame("heatmap-iframe");
                driver.findElement(By.cssSelector("[data-qa=\"liqokuxuba\"]")).click();
            }
        }

    }
}
