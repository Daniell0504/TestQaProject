package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class EditAccountPage extends BasePage {

    public EditAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By titleElement = By.xpath("//*[@id='content']/h1");

    private By firstName = By.xpath("//*[@id='input-firstname']");

    private By lastName = By.xpath("//*[@id='input-lastname']");

    private By telephone = By.xpath(".//*[@id='input-telephone']");

    private By email = By.xpath(".//*[@id='input-email']");

    private By backButton = By.xpath(".//*[@id='content']/form/div/div[1]/a");

    private By continueButton = By.xpath(".//*[@id='content']/form/div/div[2]/input");

    private By errorMessage = By.xpath(".//*[@id='content']/form/fieldset/div/div/div");


    public String getTitle() {
        return driver.findElement(titleElement).getText();
    }

    public WebElement getFirstNameElement() {
        return driver.findElement(firstName);
    }

    public WebElement getLastNameElement() {
        return driver.findElement(lastName);
    }

    public WebElement getTelephoneElement() {
        return driver.findElement(telephone);
    }

    public WebElement getEmailElement() {
        return driver.findElement(email);
    }

    public WebElement getBackButton() {
        return driver.findElement(backButton);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButton);
    }

    public void clickTheContinueButton() {
        getContinueButton().click();
    }

    public int getFieldsErrorMessages() {
        return driver.findElements(errorMessage).size();
    }

    public void insertFirstName(String firstNameValue) {
        driver.findElement(firstName).sendKeys(firstNameValue);
    }

    public void insertLastName(String lastNameValue) {
        driver.findElement(lastName).sendKeys(lastNameValue);
    }

    public void insertEmail(String emailValue){
        driver.findElement(email).sendKeys(emailValue);
    }

    public void clearFirstName() {
        getFirstNameElement().clear();
    }
    public void clearLastName() {
        getLastNameElement().clear();
    }
    public void clearEmail() {
        getEmailElement().clear();
    }
    public void clearPhoneNumber() {
        getTelephoneElement().clear();
    }

    public void insertPhoneNumber(String phoneNumberValue){
        driver.findElement(telephone).sendKeys(phoneNumberValue);
    }
}


