package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddCandidatePage extends BasePage {
    private final WebDriver driver;

    private By addCandidateBtn = By.xpath("//div[@class='orangehrm-paper-container']/div[1]/button");
    private By candidateForm = By.xpath("//div[@class='orangehrm-card-container']/form");
    private By firstNameBox = By.xpath("//input[@name='firstName']");
    private By middleNameBox = By.xpath("//input[@name='middleName']");
    private By lastNameBox = By.xpath("//input[@name='lastName']");
    private By vacancySelectBox = By.xpath("//div[@class='oxd-select-wrapper']");
    private By vacancySelections = By.xpath("//div[@class='oxd-select-wrapper']/div[2]/div[3]/span");
    private By emailBox = By.xpath("//div[@class='orangehrm-card-container']/form/div[3]/div/div[1]/div/div[2]/input");
    private By contactNumberBox = By.xpath("//div[@class='orangehrm-card-container']/form/div[3]/div/div[2]/div/div[2]/input");

    public AddCandidatePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void goToAddCandidatePage() {
        driver.findElement(addCandidateBtn).click();
        WebElement form = driver.findElement(candidateForm);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(d -> form.isDisplayed());
    }


    public void addCandidate(String firstname, String middlename, String lastname, String email, String contactNumber) {
        WebElement firstNameInput = driver.findElement(firstNameBox);
        WebElement middleNameInput = driver.findElement(middleNameBox);
        WebElement lastNameInput = driver.findElement(lastNameBox);
        WebElement vacancyInput = driver.findElement(vacancySelectBox);
        WebElement emailInput = driver.findElement(emailBox);
        WebElement contactNumberInput = driver.findElement(contactNumberBox);

        firstNameInput.sendKeys(firstname);
        middleNameInput.sendKeys(middlename);
        lastNameInput.sendKeys(lastname);
        vacancyInput.click();
        WebElement vacancySelectionsInput = driver.findElement(vacancySelections);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(d -> vacancySelectionsInput.isDisplayed());
        vacancySelectionsInput.click();
        emailInput.sendKeys(email);
        contactNumberInput.sendKeys(contactNumber);
    }
}
