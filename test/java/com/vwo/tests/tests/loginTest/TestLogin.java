package com.vwo.tests.tests.loginTest;


import com.vwo.main.pages.DashboardPage;
import com.vwo.main.pages.LoginPage;
import com.vwo.main.utils.PropertyReader;
import com.vwo.tests.base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends TestBase {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Login to VWO")
    @Test
    public void loginToVwo(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToVWO();
        takeScreenShot("Login to VWO");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Logged in User")
    @Test
    public void verifyLoggedInUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToVWO();
        DashboardPage dashboardPage = loginPage.afterLogin();
        Assert.assertEquals(dashboardPage.loggedInUserName(), PropertyReader.readItem("expectedusername"));
        takeScreenShot("Verify Logged in User");
    }
}
