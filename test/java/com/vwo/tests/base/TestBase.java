package com.vwo.tests.base;


import com.vwo.main.utils.DriverManger;
import com.vwo.main.utils.Log;
import com.vwo.main.utils.PropertyReader;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.ByteArrayInputStream;

public class TestBase extends DriverManger {

    // Setup and TearDown
    public WebDriver driver;
    PropertyReader pr = new PropertyReader();

    public  TestBase(){
        this.driver = super.getDriver();
    }

    @Parameters("BrowserType")
    @BeforeMethod(alwaysRun = true)
    public void setup(String sBrowserType){
        //Read from Properties file and set the Webdriver
        try{
//            if(PropertyReader.readItem("browser").equalsIgnoreCase("firefox")){
            if(sBrowserType.equalsIgnoreCase("FireFox")){
                driver = new FirefoxDriver();
                driver.manage().window().maximize();

            } else if (sBrowserType.equalsIgnoreCase("Chrome")) {
                driver = new ChromeDriver(  );
                driver.manage().window().maximize();
                
            } else {
                try{
                    throw new Exception( "Browser Driver is not supported." );
                }
                catch (Exception e)
                {
                    Log.error("No Compatible browser found.",e );
                }
            }

        }catch (Exception e){
            Log.error("Browser Launch error", e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    public void takeScreenShot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

}
