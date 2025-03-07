package org.example;

import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.example.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


public abstract class BaseTest {
    private String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    protected WebDriver driver;


    @BeforeClass
    public void Setup() throws Exception{
        driver = new FirefoxDriver();

        driver.navigate().to(baseURL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isLoginPageDisplayed();


        String className = BaseTest.this.getClass().getSimpleName();
        if(className.equals("LoginTest")) return;
        loginPage.login();
    }


    @AfterMethod
    public void Logout() throws Exception{
        String url = driver.getCurrentUrl();
        assert url != null;
        if(!url.equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")) {
            DashboardPage dashboardPage = new DashboardPage(driver);
            dashboardPage.logout();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.isLoginPageDisplayed();

            String className = BaseTest.this.getClass().getSimpleName();
            if(className.equals("LoginTest")) return;
            loginPage.login();
        }

    }

    @AfterClass
    public void Teardown() throws Exception{
        driver.quit();
    }
}
