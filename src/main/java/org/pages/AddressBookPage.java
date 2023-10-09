package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AddressBookPage extends BasePage {

    public AddressBookPage(WebDriver driver) {
        this.driver = driver;
    }
    private By titleElement = By.xpath("//*[@id='content']/h1");

    private By noResults = By.xpath("//*[@id='content']/p");

    public String noResultsText = "No results!";


    private By backButton = By.xpath(".//*[@id='content']/div/div[1]/a");

    private By newAddressButton = By.xpath(".//div/div/div/div[2]/a[contains(@class, 'btn-primary')]");


    public String getTitle() {
        return driver.findElement(titleElement).getText();
    }

    public WebElement getBackButton() {
        return driver.findElement(backButton);
    }

    public WebElement getNewAddressButton() {
        return driver.findElement(newAddressButton);
    }

    public String getNoResultsText() {
        return driver.findElement(noResults).getText();
    }
    public void clickNewAddressButton() {
        getNewAddressButton().click();
    }

}


