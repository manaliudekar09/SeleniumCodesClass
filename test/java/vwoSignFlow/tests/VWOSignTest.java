package vwoSignFlow.tests;


import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import vwoSignFlow.base.BaseClass;
import vwoSignFlow.utils.Utils;

import java.time.Duration;


public class VWOSignTest extends BaseClass {

    @Test(priority = 1)
    @Description("Verify that the Sign of the VWO is working fine")
    public void testVWOSignupNegative() throws InterruptedException {
        driver.get("https://vwo.com/free-trial/");
        String emailId = "automation@vwoo.com";

        WebElement email_Element = driver.findElement(By.cssSelector("#page-v1-step1-email"));
        email_Element.clear();
        email_Element.sendKeys(emailId);

        WebElement createButton_Element = driver.findElement(By.xpath("//button[text()=\"create a free trial account\"]"));
        createButton_Element.click();

        Thread.sleep(5000);

        WebElement errorMessageElement = driver.findElement(By.xpath("//form[@id=\"page-free-trial-signup-form-step1\"]/div/div"));
        String errorMessage = errorMessageElement.getText();
        Assert.assertEquals(errorMessage, "An account with this email already exists. Login Here");


    }

    @Test(priority = 0)
    @Description("Verify that the Sign of the VWO is working fine")
    public void testVWOsignupAccountVerify() {
//        driver.get("https://vwo.com/free-trial/");
//        // Dynamic Generate the email Id
//        String email = Utils.dynamicId+"@"+ Utils.dynamicDomain;
//        // Enter the email Id in the Textbox and click on the create account button.
//
//        WebElement email_Element = driver.findElement(By.cssSelector("#page-v1-step1-email"));
//        email_Element.clear();
//        email_Element.sendKeys(email);
//
//        WebElement createButton_Element = driver.findElement(By.xpath("//button[text()=\"create a free trial account\"]"));
//        createButton_Element.click();
//
//        // Explicit Wait
//        // h4
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Set up your password to get started')]")));
//
//
//        driver.findElement(By.id("page-v1-fname")).sendKeys("First");
//        driver.findElement(By.id("page-v1-lname")).sendKeys("Last");
//        driver.findElement(By.cssSelector("[data-qa=\"page-su-v1-pnumber\"]")).sendKeys("9898989899");
//        driver.findElement(By.id("page-v1-pwd")).sendKeys("Wingify@1234");
//        driver.findElement(By.xpath("//button[text()='create account']")).click();
//
//
//        WebDriverWait waitForURLChange = new WebDriverWait(driver, Duration.ofSeconds(30));
//        waitForURLChange.until(ExpectedConditions.urlContains("setup/account-setup"));

//        driver.findElement(By.cssSelector("li[id='select-box-next-option-0-3'] option-slot")).click();
//        driver.findElement(By.cssSelector("li[id='select-box-next-option-1-6'] option-slot")).click();
//        driver.findElement(By.cssSelector("span[data-qa='geyexojovu']")).click();

        // There is no proper way to handle the timings and waits


        String verifyURL = Utils.verifyFindEmail("automation998",Utils.dynamicDomain);
       // String verifyURL = Utils.verifyFindEmail(Utils.dynamicId,Utils.dynamicDomain);
        verifyURL = verifyURL.replace("\"","");
        driver.get(verifyURL);


    }


}
