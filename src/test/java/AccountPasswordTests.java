
import org.pages.AccountPasswordPage;
import org.pages.EditAccountPage;
import org.pages.RegisterAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static util.TestUtil.generateRandomEmail;

public class AccountPasswordTests extends BaseTest{

    private RegisterAccountPage registerAccountPage;
    private AccountPasswordPage accountPasswordPage;
    private String registerUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    private String accountPasswordUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/password";
    @BeforeClass
    public void setUpPreconditions() {
        System.out.println("Creating new account to be logged in...");
        registerAccountPage =  new RegisterAccountPage(driver);
        createAccount();
        System.out.println("Creating new account to be logged in ... Done");
        System.out.println("Go to account password page...");
        goToAccountPasswordPage();
        System.out.println("Go to account password page ... done");
    }

    @BeforeMethod
    public void beforeMethod() {
        accountPasswordPage = new AccountPasswordPage(driver);
    }

    @Test
    public void verifyPageHeader() throws Exception {
        String expectedPageHeader = "Change Password";
        Assert.assertEquals(accountPasswordPage.getTitle(), expectedPageHeader,
                "First section header text is not the expected one");
    }

    @Test
    public void verifyPageFields() {
        Assert.assertTrue(accountPasswordPage.getPassword().isDisplayed());
        Assert.assertTrue(accountPasswordPage.getConfirmPassword().isDisplayed());
    }

    @Test
    public void verifyPageHasBackAndContinueButton() {
        Assert.assertTrue(accountPasswordPage.getBackButton().isDisplayed());
        Assert.assertTrue(accountPasswordPage.getContinueButton().isDisplayed());
    }

    @Test
    public void verifyPageCannotBeSavedWithEmptyFields() {
        accountPasswordPage.clearPassword();
        accountPasswordPage.clearConfirmPassword();
        accountPasswordPage.clickTheContinueButton();
        Assert.assertTrue(accountPasswordPage.getFieldsErrorMessages() > 0);
    }

    @Test
    public void verifyThePasswordShouldHaveAtLeast4Chars() {
        goToAccountPasswordPage();
        accountPasswordPage.clearPassword();
        accountPasswordPage.clearConfirmPassword();
        accountPasswordPage.insertPassword("123");
        accountPasswordPage.insertConfirmPassword("123");
        accountPasswordPage.clickTheContinueButton();
        Assert.assertTrue(accountPasswordPage.getFieldsErrorMessages() > 0);
    }

    @Test
    public void verifyTheNotMatchingPasswordsWillShowError() {
        goToAccountPasswordPage();
        accountPasswordPage.clearPassword();
        accountPasswordPage.clearConfirmPassword();
        accountPasswordPage.insertPassword("123");
        accountPasswordPage.insertConfirmPassword("12345677");
        accountPasswordPage.clickTheContinueButton();
        Assert.assertTrue(accountPasswordPage.getFieldsErrorMessages() > 0);
    }

    @Test
    public void verifyPasswordIsSuccessfullySaved() {
        accountPasswordPage.clearPassword();
        accountPasswordPage.clearConfirmPassword();
        accountPasswordPage.insertPassword("12345");
        accountPasswordPage.insertConfirmPassword("12345");
        accountPasswordPage.clickTheContinueButton();
        Assert.assertTrue(accountPasswordPage.isSuccessAlertBarDisplayed());
    }

    @Test
    public void verifyTheEditAccountPageBreadcrumb() {
        goToAccountPasswordPage();
        Assert.assertEquals(accountPasswordPage.getBreadcrumbLastItem().getText(), "Change Password");
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

    public void goToAccountPasswordPage() {
        driver.get(accountPasswordUrl);
    }
}