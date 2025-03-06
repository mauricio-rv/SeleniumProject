package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Unit test for simple App.
 */
public class LoginTest extends BaseTest
{


    @Test
    @Description("This test tries to login with correct credentials")
    @Owner("Chipa")
    @Issue("Idk, page not working :(")
    public void TestLogin() throws Exception{
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        loginPage.login();
        boolean headerExists = dashboardPage.getDashboardHeader().isDisplayed();
        Assert.assertTrue(headerExists);
    }

    @Test
    public void TestLogout() throws Exception{
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.logout();
    }
}
