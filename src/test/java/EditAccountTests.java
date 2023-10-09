
import org.pages.DashboardPage;
import org.pages.EditAccountPage;
import org.pages.RegisterAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static util.TestUtil.generateRandomEmail;

public class EditAccountTests extends BaseTest{

    private RegisterAccountPage registerAccountPage;
    private EditAccountPage editAccountPage;
    private String registerUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    private String editAccountUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/edit";
    @BeforeClass
    public void setUpPreconditions() {
        System.out.println("Creating new account to be logged in...");
        registerAccountPage =  new RegisterAccountPage(driver);
        createAccount();
        System.out.println("Creating new account to be logged in ... Done");
        System.out.println("Go to edit account page...");
        goToEditAccount();
        System.out.println("Go to edit account page ... done");
    }

    @BeforeMethod
    public void beforeMethod() {
        editAccountPage = new EditAccountPage(driver);
    }

    @Test
    public void verifyEditAccountPageHeader() throws Exception {
        String editAccountPageHeader = "My Account Information";
        Assert.assertEquals(editAccountPage.getTitle(), editAccountPageHeader,
                "First section header text is not the expected one");
    }

    @Test
    public void verifyTheEditAccountPageFields() {
        Assert.assertTrue(editAccountPage.getFirstNameElement().isDisplayed());
        Assert.assertTrue(editAccountPage.getLastNameElement().isDisplayed());
        Assert.assertTrue(editAccountPage.getEmailElement().isDisplayed());
        Assert.assertTrue(editAccountPage.getTelephoneElement().isDisplayed());
    }

    @Test
    public void verifyTheEditAccountPageHasBackAndContinueButton() {
        Assert.assertTrue(editAccountPage.getBackButton().isDisplayed());
        Assert.assertTrue(editAccountPage.getContinueButton().isDisplayed());
    }

    @Test
    public void verifyTheEditAccountPageCannotBeSavedWithEmptyFields() {
        editAccountPage.clearEmail();
        editAccountPage.clearFirstName();
        editAccountPage.clearLastName();
        editAccountPage.clearPhoneNumber();
        editAccountPage.clickTheContinueButton();
        Assert.assertTrue(editAccountPage.getFieldsErrorMessages() > 0);
    }

    @Test
    public void verifyTheEditAccountPagePhoneNumberShouldHaveAtLeast3Chars() {
        editAccountPage.clearPhoneNumber();
        editAccountPage.insertPhoneNumber("12");
        editAccountPage.clickTheContinueButton();
        Assert.assertTrue(editAccountPage.getFieldsErrorMessages() > 0);
    }

    @Test
    public void verifyTheEditAccountPageBreadcrumb() {
        Assert.assertEquals(editAccountPage.getBreadcrumbLastItem().getText(), "Edit Information");
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

    public void goToEditAccount() {
        driver.get(editAccountUrl);
    }
}