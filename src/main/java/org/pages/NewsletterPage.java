package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class NewsletterPage extends BasePage {

    public NewsletterPage(WebDriver driver) {
        this.driver = driver;
    }
    private By titleElement = By.xpath(".//*[@id='content']/h1");
    private By yesOption = By.xpath(".//*[@id=\"input-newsletter-yes\"]");
    private By noOption = By.xpath(".//*[@id=\"input-newsletter-no\"]");
    private By backButton = By.xpath(".//*[@id=\"content\"]/form/div/div[1]/a");
    private By continueButton = By.xpath(".//*[@id=\"content\"]/form/div/div[2]/input");


    public String getTitle() {
        return driver.findElement(titleElement).getText();
    }

    public WebElement getBackButton() {
        return driver.findElement(backButton);
    }

    public boolean isYesOptionDisplayed() {
        return driver.findElement(yesOption).isEnabled();
    }

    public boolean isNoOptionDisplayed() {
        return driver.findElement(noOption).isEnabled();
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButton);
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

}


