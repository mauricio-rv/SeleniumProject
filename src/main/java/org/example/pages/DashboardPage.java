package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage extends BasePage {
    private final WebDriver driver;

    private final By sidebar = By.xpath("//aside");
    private final By sidebarSearchBox = By.xpath("//aside/nav//div[2]/div/div/input");
    private final By sidebarSearchResponse = By.xpath("cc");
    public static final By userOptions = By.xpath("//header/div[1]/div[3]/ul/li/span");
    public static final By logoutButton = By.xpath("//header/div[1]/div[3]/ul/li/ul/li[4]/a");

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebElement getSidebarHeader() {
        WebElement dashboardHeader = driver.findElement(sidebar);
        return dashboardHeader;
    }

    public void searchSidebar(String text){
        WebElement dashboardSidebar = driver.findElement(sidebarSearchBox);
        dashboardSidebar.sendKeys(text);
    }

    public boolean searchSidebaHasFoundResultsr(String text){
        List<WebElement> dashboardSearch = driver.findElements(sidebarSearchResponse);
        boolean textFound = true;
        for (WebElement element: dashboardSearch){
            if(!element.getText().contains(text)){
                textFound = false;
                break;
            }
        }
        return textFound;
    }

    public void logout() {
        driver.findElement(userOptions).click();
        driver.findElement(logoutButton).click();
    }
}
