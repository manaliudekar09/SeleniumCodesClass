package com.tta.practice.svgDemo1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SD02 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();


       WebElement div =  driver.findElement(By.xpath("//div[@class='jackPart']"));
       //Scroll To View ?

        // iframe -> shadow
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",div);

        WebElement inputPizza = (WebElement)js.executeScript("return document.querySelector('div.jackPart').shadowRoot.querySelector('div#app2').shadowRoot.querySelector('input#pizza');");
        inputPizza.sendKeys("FarmHouse");









    }
}
