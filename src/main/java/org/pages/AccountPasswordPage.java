package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AccountPasswordPage extends BasePage {

    public AccountPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    private By titleElement = By.xpath("//*[@id='content']/h1");

    private By password = By.xpath("//*[@id='input-password']");

    private By confirmPassword = By.xpath("//*[@id='input-confirm']");

    private By backButton = By.xpath(".//*[@id='content']/form/div/div[1]/a");

    private By continueButton = By.xpath(".//*[@id='content']/form/div/div[2]/input");

    private By errorMessage = By.xpath(".//*[@id='content']/form/div/div/div");


    public String getTitle() {
        return driver.findElement(titleElement).getText();
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getConfirmPassword() {
        return driver.findElement(confirmPassword);
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

    public void insertPassword(String value) {
        getPassword().sendKeys(value);
    }

    public void insertConfirmPassword(String value) {getConfirmPassword().sendKeys(value);
    }

    public void clearPassword() {
        getPassword().clear();
    }
    public void clearConfirmPassword() {
        getConfirmPassword().clear();
    }
}


