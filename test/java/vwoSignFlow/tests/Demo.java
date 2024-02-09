package vwoSignFlow.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import vwoSignFlow.utils.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        String emailId = "automation"+ (int)Math.floor(Math.random()*1000)+"@vwoo.com";
        System.out.println(emailId);

        String emailIdFakerJS = Utils.giveMeEmail();
        System.out.println(emailIdFakerJS);
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

//        Select select = new Select(driver.findElement(By.id("dropdown")));
//        select.selectByIndex(2);
//        Thread.sleep(100000000);


        Utils.verifyFindEmail("","");

    }
}