


package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    WebDriver driver;

   private By errorMessage = By.xpath(".//div[@class = 'alert alert-danger alert-dismissible']");
   private By wishlistHeartElement = By.xpath(".//a[@aria-label = 'Wishlist']");
   private By searchInput = By.name("search");

   private By breadcrumbItems = By.xpath("//nav/ol/li");

   private By successAlertBar = By.xpath("//div[contains(@class, 'alert-success')]");

   public String getErrorMessage() {
      return driver.findElement(errorMessage).getText();
   }

   public boolean isSuccessAlertBarDisplayed() {
      return driver.findElement(successAlertBar).isDisplayed();
   }

   public void clickWishlist() {
      driver.findElement(wishlistHeartElement).click();
   }

   public void enterTextToSearch(String searchText) {
      driver.findElement(searchInput).sendKeys(searchText);
   }

   public List<WebElement> getBreadcrumbItems() {
      return driver.findElements(breadcrumbItems);
   }

   public WebElement getBreadcrumbLastItem() {
      List<WebElement> items = getBreadcrumbItems();
      System.out.println(items);
      return items.get(items.size() - 1);
   }

}


