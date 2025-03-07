package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.example.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

/**
 * Unit test for simple App.
 */
public class LoginTest extends BaseTest
{
    @Test(dataProvider = "getData")
    public void TestLogin(String username, String password, String expectedResult) throws Exception{
        LoginPage loginPage = new LoginPage(driver);
        boolean isLoggedIn = loginPage.loginWithExpected(username, password, expectedResult);
        Assert.assertTrue(isLoggedIn);
    }

    @DataProvider
    public String[][] getData() throws IOException {
        ExcelUtils excelUtils = new ExcelUtils();
        String[][] data = excelUtils.getCellData("testdata/DataTests.xlsx", "LoginTests");

        return data;
    }
}
