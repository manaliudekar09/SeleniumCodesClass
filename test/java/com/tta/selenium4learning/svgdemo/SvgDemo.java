package com.tta.selenium4learning.svgdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SvgDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://flipkart.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("AC");
        WebElement searchELement = driver.findElement(By.xpath("//*[local-name()='svg']/*[local-name()='g' and @fill-rule=\"evenodd\"] "));
        Actions actions = new Actions(driver);
        actions.moveToElement(searchELement).click().perform();

        //vwo - (//*[name()='svg'][@class='icon'])[8]

        driver.get("https://www.amcharts.com/svg-maps/?map=india");

        List<WebElement> states = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
        for(WebElement s : states){
            System.out.println(s.getAttribute("aria-label"));
            if(s.getAttribute("aria-label").equals("Tripura  ")){
                actions.moveToElement(s).click().perform();
                break;
            }
        }

        //driver.findElement(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path' and @aria-label='Tripura  ']")).click();
        ////*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path' and @aria-label='Tripura  ']

        //driver.findElement(By.cssSelector("[placeholder=\"Search Brand\"]")).sendKeys("Samsung");



//
//        WebElement sliderInitial = driver.findElement(By.xpath("//div[@class=\"_31Kbhn WC_zGJ\"]/div"));
////
//        actions.dragAndDropBy(sliderInitial, 30, 0).build().perform();


    }
}
