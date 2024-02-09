package com.tta.selenium4learning.vwosignup;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class VWOSignupTC  extends BaseTest{


    @Test
    @Description("Verify Sign up is completed with email")
    public void testVWOSignUpE2E() throws InterruptedException {

        driver.get("https://vwo.com/free-trial/");
        WebElement email = driver.findElement(By.cssSelector("[placeholder='name@yourcompany.com']"));
        String emailId = Util.randomEmail;
        email.sendKeys(emailId);
        System.out.println("Random Email - > "+emailId);
        driver.findElement(By.xpath("//button[text()=\"create a free trial account\"]")).click();
        Util.waitVisibilityOfElementLocated(driver,By.xpath("//h4[contains(text(),\'Set up your password to get started\')]"),10);

        driver.findElement(By.id("page-v1-fname")).sendKeys("First");
        driver.findElement(By.id("page-v1-lname")).sendKeys("Last");
        driver.findElement(By.cssSelector("[data-qa=\"page-su-v1-pnumber\"]")).sendKeys("9898989899");
        driver.findElement(By.id("page-v1-pwd")).sendKeys("Wingify@1234");
        driver.findElement(By.xpath("//button[text()='create account']")).click();

        new WebDriverWait(driver,Duration.ofSeconds(25)).until(ExpectedConditions.urlContains("https://app.vwo.com/#/setup/account-setup"));

        // $('div.select-box-full-button')[0].click();

        List<WebElement> dropDownList = driver.findElements(By.cssSelector("div.select-box-full-button"));
        dropDownList.get(0).click();
        driver.findElement(By.xpath("//option-slot[text()=\"up to 200k visitors/month\"]")).click();
        Thread.sleep(2000);

        dropDownList.get(1).click();
        driver.findElement(By.xpath("//option-slot[text()=\"Entertainment\"]")).click();

        Actions action = new Actions(driver);


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement nextButton=driver.findElement(By.xpath("//button/span[text()=\"Next\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();


        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://app.vwo.com/#/setup/product-selection"));



        WebElement combo2Radio = driver.findElement(By.xpath("//label[@for=\"combo2\"]"));
        action.moveToElement(combo2Radio).clickAndHold();


        WebElement nextButtonProduct = driver.findElement(By.xpath("//span[@data-qa='sulegipeka']"));
        action.moveToElement(nextButtonProduct).click();


        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://app.vwo.com/#/setup/track-goal"));
        driver.findElement(By.cssSelector("span[data-qa='rigetitali']")).click();

        driver.findElement(By.xpath("//input[@name='primaryUrl']")).clear();
        driver.findElement(By.xpath("//input[@name='primaryUrl']")).sendKeys("htps://thetestingacademy.com");

        driver.findElement(By.xpath("//span[@data-qa='hukugurepa']")).click();
        driver.findElement(By.xpath("//span[@data-qa='hezoconado']")).click();

        driver.findElement(By.xpath("//span[@data-qa='qaddoutiro']")).click();

        String successMesasge = driver.findElement(By.xpath("//h3[@data-qa='mevubifeda']")).getText();
        Assert.assertEquals(successMesasge,"Your setup is complete!");


    }

}
