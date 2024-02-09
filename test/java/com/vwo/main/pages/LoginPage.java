package com.vwo.main.pages;


import com.vwo.main.base.BasePage;
import com.vwo.main.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    // Page Locators
    By username = By.id("login-username" );
    By password = By.id("login-password" );
    By signButton = By.id("js-login-btn" );

    // Page Actions
    public void openLoginPage(){
        goToUrl(PropertyReader.readItem("url"));
    }

    public void loginToVWO(){
        writeText(username,PropertyReader.readItem("username"));
        writeText(password,PropertyReader.readItem("password"));
        click(signButton);
    }

    public DashboardPage afterLogin(){
        return new DashboardPage(driver);
    }





}
