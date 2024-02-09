package com.tta.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Problem03 {

    @Test
    public void verifyHeatmap() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
        driver.manage().window().maximize();

        String mainWindowHandle = driver.getWindowHandle();
        System.out.println(mainWindowHandle);

        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(5))//Explicit Wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='view--campaign ng-scope']//li[2]")));


        Actions actions = new Actions(driver);
        List<WebElement> heatmapButtons = driver.findElements(By.cssSelector("[data-qa='yedexafobi']"));
        // li - 1
        actions.moveToElement(heatmapButtons.get(1)).click().perform();

        // 2 Windows

        Set<String> windowsHandles = driver.getWindowHandles();

        // switch to the new window - click on clickmap button

        Iterator<String> iterator = windowsHandles.iterator();

        while(iterator.hasNext()){
            String childWindow = iterator.next();
            if(!mainWindowHandle.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                // switch the frame - #heatmap-iframe
                // click on the button - [data-qa="liqokuxuba"]
                Thread.sleep(15000);
                driver.switchTo().frame("heatmap-iframe");
                driver.findElement(By.cssSelector("[data-qa='liqokuxuba']")).click();

            }

        }







    }
}
