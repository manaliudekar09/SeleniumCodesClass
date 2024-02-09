package com.tta.selenium4learning.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;

public class ActionsDragDrop {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver();
        String URL = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(URL);
        driver.manage().window().maximize();
//Actions class method to drag and drop
        Actions builder = new Actions(driver);
        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));
//Perform drag and drop
        //builder.dragAndDrop(from,to).perform();


        builder.clickAndHold(from)
                .moveToElement(to)
                .release(to)
                .build();
//verify text changed in to 'Drop here' box
        String textTo = to.getText();
        if (textTo.equals("Dropped!")) {
            System.out.println("PASS: File is dropped to target as expected");
        } else {
            System.out.println("FAIL: File couldn't be dropped to target as expected");
        }
        driver.close();
    }
}
