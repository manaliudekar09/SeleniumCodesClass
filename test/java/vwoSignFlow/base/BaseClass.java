package vwoSignFlow.base;


import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseClass {


    // Open the Browser
    // Close the Browser
    public static WebDriver driver;
    public static ChromeOptions chromeOptions;


    @BeforeTest
    public void launchBrowser(){
        chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setHeadless(false);
        driver = new ChromeDriver(chromeOptions);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeBrowser(){
        if(driver!=null) {
            driver.quit();
        }
    }

    void existingEmailId(){

    }


}
