
package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailInput = By.id("input-email");
    private By passwordInput = By.id("input-password");
    private By loginButton = By.xpath(".//input[@value = 'Login']");


    public void insertEmail(String firstName) {
        driver.findElement(emailInput).sendKeys(firstName);
    }

    public void insertPassword(String firstName) {
        driver.findElement(passwordInput).sendKeys(firstName);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}