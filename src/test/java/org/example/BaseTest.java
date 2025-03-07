package org.example;

import org.example.pages.DashboardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public abstract class BaseTest {
    private String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    protected WebDriver driver;

    @BeforeClass
    public void Setup() throws Exception{
        driver = new FirefoxDriver();
        driver.navigate().to(baseURL);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass
    public void Teardown() throws Exception{
        driver.quit();
    }
}
