package org.example;

import org.example.pages.BasePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    public String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public WebDriver driver;

    @BeforeTest
    public void TestApp() throws Exception{
        driver = new FirefoxDriver();
        driver.navigate().to(baseURL);

        Thread.sleep(2000);
    }

    @Test
    public void TestLogin() throws Exception{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        String pagetitle = driver.getTitle();

        System.out.println(pagetitle);
    }
}
