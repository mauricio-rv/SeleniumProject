package org.example.pages;

import org.example.utils.PropertyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public static final By usernameBox = By.xpath("//form/div[1]/div/div[2]/input");
    public static final By passwordBox = By.xpath("//form/div[2]/div/div[2]/input");
    public static final By loginButton = By.xpath("//form//button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(){
        String username = PropertyUtils.getProperty("user.name");
        String password = PropertyUtils.getProperty("user.password");

        WebElement usernameInput = driver.findElement(usernameBox);
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(passwordBox);
        passwordInput.sendKeys(password);
        WebElement loginButtonInput = driver.findElement(loginButton);
        loginButtonInput.click();
    }
}
