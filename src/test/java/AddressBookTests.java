
import org.pages.AccountPasswordPage;
import org.pages.AddressBookPage;
import org.pages.RegisterAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static util.TestUtil.generateRandomEmail;

public class AddressBookTests extends BaseTest{

    private RegisterAccountPage registerAccountPage;
    private AddressBookPage addressBookPage;
    private String registerUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    private String addressBookPageUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/address";
    private String addAddressBookPageUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/address/add";

    @BeforeClass
    public void setUpPreconditions() {
        System.out.println("Creating new account to be logged in...");
        registerAccountPage =  new RegisterAccountPage(driver);
        createAccount();
        System.out.println("Creating new account to be logged in ... Done");
        System.out.println("Go to account password page...");
        goToAddressBookPage();
        System.out.println("Go to account password page ... done");
    }

    @BeforeMethod
    public void beforeMethod() {
        addressBookPage = new AddressBookPage(driver);
    }

    @Test
    public void verifyPageHeader() throws Exception {
        String expectedPageHeader = "Address Book Entries";
        Assert.assertEquals(addressBookPage.getTitle(), expectedPageHeader,
                "First section header text is not the expected one");
    }

    @Test
    public void verifyNoResults() {
        Assert.assertEquals(addressBookPage.getNoResultsText(), addressBookPage.noResultsText);
    }

    @Test
    public void verifyHasBackAndNewAddressButtons() {
        Assert.assertTrue(addressBookPage.getBackButton().isDisplayed());
        Assert.assertTrue(addressBookPage.getNewAddressButton().isDisplayed());
    }

    @Test
    public void verifyTheBreadcrumb() {
        goToAddressBookPage();
        Assert.assertEquals(addressBookPage.getBreadcrumbLastItem().getText(), "Address Book");
    }

    @Test
    public void verifyTheAddAddressBookPage() {
        addressBookPage.clickNewAddressButton();
        Assert.assertEquals(driver.getCurrentUrl(), addAddressBookPageUrl);
    }

    public void createAccount() {
        driver.get(registerUrl);
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01233456");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
    }

    public void goToAddressBookPage() {
        driver.get(addressBookPageUrl);
    }
}