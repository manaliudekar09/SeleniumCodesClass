package com.tta.selenium4learning.miniProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login01 {

    public static void main(String[] args) {

        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

        WebDriver dr = new FirefoxDriver();
        String URL = "https://promodedatta-trials77.orangehrmlive.com/";
        dr.get(URL);
        dr.manage().window().maximize();


        WebElement uname = dr.findElement(By.id("txtUsername"));        //username
        uname.sendKeys("Admin");

        WebElement pwd = dr.findElement(By.name("txtPassword"));     //password
        pwd.sendKeys("0@dr3dIPCS");

        //$("#emp_birthday").val("Sun, 06 Mar 2023");

        WebElement login_button =
                dr.findElement(By.xpath("//input[@id='btnLogin']"));
        login_button.click();                            //login button

        WebElement admin = dr.findElement(By.id("menu_admin_viewAdminModule"));
        admin.click();




    }
}
