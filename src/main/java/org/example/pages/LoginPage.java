package org.example.pages;

import org.example.utils.PropertyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    private final WebDriver driver;
    public static final By usernameBox = By.xpath("//form/div[1]/div/div[2]/input");
    public static final By passwordBox = By.xpath("//form/div[2]/div/div[2]/input");
    public static final By loginButton = By.xpath("//form//button");
    public static final By loginContainerBox = By.xpath("//div[@class='orangehrm-login-layout']");
    public static final By invalidCredentialsBox = By.xpath("//p[text()='Invalid credentials']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isLoginPageDisplayed(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d ->driver.findElement(loginContainerBox).isDisplayed());
        return driver.findElement(loginContainerBox).isDisplayed();
    }

    public boolean login(){
        DashboardPage dashboardPage = new DashboardPage(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String username = PropertyUtils.getProperty("user.name");
        String password = PropertyUtils.getProperty("user.password");

        WebElement usernameInput = driver.findElement(usernameBox);
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(passwordBox);
        passwordInput.sendKeys(password);
        WebElement loginButtonInput = driver.findElement(loginButton);
        loginButtonInput.click();

        wait.until(d->dashboardPage.getSidebarHeader().isDisplayed());
        return dashboardPage.getSidebarHeader().isDisplayed();
    }

    public boolean loginWithExpected(String username, String password, String expedtedResult){
        DashboardPage dashboardPage = new DashboardPage(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement usernameInput = driver.findElement(usernameBox);
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(passwordBox);
        passwordInput.sendKeys(password);
        WebElement loginButtonInput = driver.findElement(loginButton);
        loginButtonInput.click();

        if(expedtedResult.equals("allow")){
            wait.until(d->dashboardPage.getSidebarHeader().isDisplayed());
            return dashboardPage.getSidebarHeader().isDisplayed();
        }
        else if(expedtedResult.equals("deny")){
            wait.until(d ->driver.findElement(invalidCredentialsBox).isDisplayed());
            return driver.findElement(invalidCredentialsBox).isDisplayed();
        }
        return false;
    }
}
