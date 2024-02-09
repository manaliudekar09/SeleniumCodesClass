package com.tta.selenium4learning.L1;

import com.vwo.main.utils.WaitForHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class NavigationSelenium {

    public static void main(String[] args) throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();
        // Not UI, Why? Headless -> Fast execution, Speed, Linux Machine, You don't see UI, Results
        // 8000 -> do we want to see all the 8000 running?
        // headless > 500 1000> Headless, less time of exection
        //incoginto mode
        //



        options.addExtensions(new File("/Users/pramod/Documents/crx/extension_1_6_3_0.crx"));
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(options);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Navigation
        //driver.get("app.vwo.com"); // invalid argument
        driver.get("https://app.vwo.com");

        // Navigation #2
        //driver.navigate().to("https://thetestingacademy.com");
        //driver.navigate().to(new URL("https://thetestingacademy.com"));
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();



        // loginUsername.sendKeys("Hello@Hello.com");


        new WaitForHelper(driver).elementToBeClickable(By.id("login-username"));

        //0 - at click,  5 -> click  10 -> click , 11 ->  Element not not found exception



        System.out.println(driver.getTitle());










    }
}
