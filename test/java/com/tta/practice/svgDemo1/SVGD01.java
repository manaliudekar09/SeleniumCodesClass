package com.tta.practice.svgDemo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SVGD01 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://flipkart.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("AC");

        WebElement searchElement = driver.findElement(By.xpath("//*[local-name()='svg']/*[local-name()='g' and @fill-rule='evenodd']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(searchElement).click().perform();



        driver.get("https://www.amcharts.com/svg-maps/?map=india");



        List<WebElement> statesList = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
        for(WebElement s : statesList){
            System.out.println(s.getAttribute("aria-label"));
            if(s.getAttribute("aria-label").equals("Tripura  ")){
                actions.moveToElement(s).click().perform();
                break;
            }
        }



    }
}
