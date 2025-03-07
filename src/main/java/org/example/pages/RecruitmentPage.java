package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecruitmentPage extends BasePage {
    private final WebDriver driver;

    private By recruitmentButton = By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']");
    private By addCandidateBtn = By.xpath("//div[@class='orangehrm-paper-container']/div[1]/button");

    public RecruitmentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void goToRecruitmentPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(recruitmentButton).isDisplayed());
        driver.findElement(recruitmentButton).click();
    }

}
