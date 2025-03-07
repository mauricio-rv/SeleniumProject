package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage extends BasePage {
    private WebDriver driver;
    private final By adminPageButton = By.xpath("//a/span[text()='Admin']");
    private final By systemUsersTitle = By.xpath("//div[@class='oxd-table-filter-header']");
    private final By systemUsersUsername = By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[1]/div/div/input");
    private final By systemUsersUserrole = By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[2]/div/div/div");
    private final By systemUsersStatus = By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[4]/div/div/div");
    private final By userRoleOption = By.xpath("//div[@class='oxd-select-option']//span[contains(text(),'Admin')]");
    private final By statusOption = By.xpath("//div[@class='oxd-select-option']//span[contains(text(),'Enabled')]");
    private final By form = By.xpath("//form[@class='oxd-form']");
    private final By recordFound = By.xpath("//span[text()='(1) Record Found']");


    public AdminPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void goToAdminPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(adminPageButton).isDisplayed());
        driver.findElement(adminPageButton).click();
        wait.until(d -> driver.findElement(systemUsersTitle).isDisplayed());
    }

    public boolean filterUsers(String username){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameInput = driver.findElement(systemUsersUsername);
        WebElement userroleInput = driver.findElement(systemUsersUserrole);
        WebElement statusInput = driver.findElement(systemUsersStatus);

        usernameInput.sendKeys(username);
        userroleInput.click();
        wait.until(d -> driver.findElement(userRoleOption).isDisplayed());
        driver.findElement(userRoleOption).click();
        statusInput.click();
        wait.until(d -> driver.findElement(statusOption).isDisplayed());
        driver.findElement(statusOption).click();
        driver.findElement(form).submit();

        wait.until(d -> driver.findElement(recordFound).isDisplayed());
        return driver.findElement(recordFound).isDisplayed();
    }
}
