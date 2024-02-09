package com.tta.selenium4learning;

// Import the necessary modules

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ElementNotVisibleException;


public class ExceptionsDemo {
    public static void main(String[] args) {
        // Set the path to the web driver

        // Create a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();


            // Open a webpage
            driver.get("http://app.vwo.com");

            // Find an element that does not exist on the page
            WebElement element = driver.findElement(By.id("nonexistent-element"));
            element.click();

//            // Switch to a frame that does not exist on the page
//            driver.switchTo().frame(1);
//
//            // Attempt to accept an alert that is not present on the page
//            driver.switchTo().alert().accept();
//
//            // Find an element that is not visible on the page
//            element = driver.findElement(By.id("invisible-element"));
//
//            // Attempt to interact with an element that is not enabled or displayed
//            element.click();
//
//            // Find an element and store it in a variable
//            element = driver.findElement(By.id("some-element"));
//
//            // Remove the element from the DOM
//           // driver.executeScript("arguments[0].parentNode.removeChild(arguments[0]);", element);
//
//            // Attempt to interact with the removed element
//            element.click();

            // Set an implicit wait timeout that is too short
    }
}