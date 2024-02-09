package com.tta.selenium4learning.L1;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class ChromeOptionsDemo {

    public static void main(String[] args) {

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
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        driver.close(); // Closed the window, Session id != null, Error - Invalid session Id
        driver.quit(); // Closed All the window and Session = null, Error - Session ID is null

        driver.getTitle();




    }
}
