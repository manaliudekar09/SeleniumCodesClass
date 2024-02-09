package com.tta.selenium4learning.shadowDOMDemo;

import com.tta.selenium4learning.actions.Actions01;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ShadowDOMDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();

        //document.querySelector("#userName").shadowRoot.querySelector(".learningHub");

        Thread.sleep(5000);

        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement div= driver.findElement(By.xpath("//div[@class=\"jackPart\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);",div);


        WebElement link = (WebElement) js.executeScript("return document.querySelector(\"div.jackPart\").shadowRoot.querySelector(\"div#app2\").shadowRoot.querySelector(\"input#pizza\");");
        System.out.println(link.getText());
        link.sendKeys("Farmhouse");

        // Notice for the Iframe always



    }
}
