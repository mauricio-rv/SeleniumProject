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
    private By emailBox = By.xpath("//form/div[3]/div/div[1]/div/div[2]/input");
    private By contactNumberBox = By.xpath("//form/div[3]/div/div[2]/div/div[2]/input");
    private By candidateProfileBox = By.xpath("//h6[text()='Candidate Profile']");
    private By requiredSpan = By.xpath("//span[text()='Required']");
    private By emailFormatSpan = By.xpath("//span[text()='Expected format: admin@example.com']");
    private By numberFormatSpan = By.xpath("//span[text()='Allows numbers and only + - / ( )']");

    public AddCandidatePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void goToAddCandidatePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(d -> driver.findElement(addCandidateBtn).isDisplayed());
        driver.findElement(addCandidateBtn).click();
        wait.until(d -> driver.findElement(candidateForm).isDisplayed());
    }


    public boolean addCandidate(String firstname, String middlename, String lastname, String email, String contactNumber, String expectedResult) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
        wait.until(d -> driver.findElement(vacancySelections).isDisplayed());
        driver.findElement(vacancySelections).click();
        emailInput.sendKeys(email);
        contactNumberInput.sendKeys(contactNumber);

        driver.findElement(candidateForm).submit();

        boolean result;

        switch (expectedResult){
            case "pass":
                wait.until(d -> driver.findElement(candidateProfileBox).isDisplayed());
                result = true;
                break;
            case "email_error":
                    wait.until(d -> driver.findElement(emailFormatSpan).isDisplayed());
                    result = true;
                    break;
            case "required_error":
                wait.until(d -> driver.findElement(requiredSpan).isDisplayed());
                result = true;
                break;
            case "number_error":
                wait.until(d -> driver.findElement(numberFormatSpan).isDisplayed());
                result = true;
                break;
            default:
                result = false;
        }
        return result;
    }
}
