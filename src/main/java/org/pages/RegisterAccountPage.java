package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterAccountPage extends BasePage {

    public class RegisterAccountPage(WebDriver driver) { this.driver = driver; }

    private By firstNameInput = By.id("input-firstname");
    private By lastNameInput = By.id("input-lastname");
    private By emailInput = By.id("input-email");
    private By telephoneInput = By.id("input-telephone");
    private By passwordConfirmInput = By.id("input-confirme");
    private By privacyPolicyChecbox = By.xpath("//label[@for='input-agree']");
    private By continueButton = By.xpath("//imput[@value='Continue']");
    public void insertFirstName(String firstName) {driver.findElement(firstNameInput).sendKeys(firstName);}
    public void insertLastName(String lastName) { driver.findElement(lastNameInput).sendKeys(lastName);}
    public void insertEmail(String email) { driver.findElement(emailInput).sendKeys(email);}
    public void insertPhoneNumber(String phoneNumber) { driver.findElement(telephoneInput).sendKeys(phoneNumber);}
    public void setPassword(String password) { driver.findElement(passwordInput).sendKeys(password);}
    public void setPasswordConfirm(String passwordConfirm) {
        driver.findElement(passwordConfirmInput).sendKeys(passwordConfirm);
    }

    public void checkPrivacyPolicy() {driver.findElement(privacyPolicyChecbox).click();}

    public void clickContinue() {driver.findElement(continueButton).click();}



}
