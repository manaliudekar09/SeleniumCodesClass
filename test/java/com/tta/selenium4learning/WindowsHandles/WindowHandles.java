package com.tta.selenium4learning.WindowsHandles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;


public class WindowHandles {
    public static void main(String[] args) {
        // Create a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Open the page
        driver.get("https://the-internet.herokuapp.com/windows");

        // Store the handle of the current window
        String mainWindowHandle = driver.getWindowHandle();

        // Find the "Click Here" link
        WebElement link = driver.findElement(By.linkText("Click Here"));

        // Click the link to open a new window
        link.click();

        // Store the handles of all open windows in a list
        Set<String> windowHandles = driver.getWindowHandles();

        // Iterate through the list of window handles
        for (String handle : windowHandles) {
            // Switch the focus to each window in turn
            driver.switchTo().window(handle);

            // Check if the text "New Window" is present in the window
            if (driver.getPageSource().contains("New Window")) {
                System.out.println("The text 'New Window' was found in the new window.");
                break;
            }
        }

        // Switch the focus back to the main window
        driver.switchTo().window(mainWindowHandle);

        // Close the web driver
        driver.quit();
    }
}

