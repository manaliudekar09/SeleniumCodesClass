package com.tta.selenium4learning.selectDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDemo {

    public static void main(String[] args) {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*"); // Chrome 111
//        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new FirefoxDriver();
        String URL = "https://the-internet.herokuapp.com/dropdown";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.id("dropdown"));
        Select select = new Select(element);
        select.selectByVisibleText("Option 2");








    }
}
