package com.vwo.main.pagefactory;


import com.vwo.main.base.BasePage;
import com.vwo.main.pages.DashboardPage;
import com.vwo.main.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePF extends BasePage {

    WebDriver driver;

    @FindBy(id="login-username")
    WebElement username;

    @FindBy(id="login-password")
    WebElement password;

    @FindBy(id="js-login-btn")
    WebElement signButton;

    public LoginPagePF(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page Methods

    public WebElement getUserName(){
        return username;
    }

    public WebElement getPassword(){
        return password;
    }

    public WebElement clickSbmit(){
        return signButton;
    }

    // Page Actions
    public void openLoginPage(){
        goToUrl(PropertyReader.readItem("url"));
    }

    public void loginToVWO(){
        writeText(getUserName(),PropertyReader.readItem("username"));
        writeText(getPassword(),PropertyReader.readItem("password"));
        click(signButton);
    }

    public DashboardPage afterLogin(){
        return new DashboardPage(driver);
    }





}
