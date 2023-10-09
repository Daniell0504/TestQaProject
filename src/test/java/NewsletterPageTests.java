
import org.pages.AddressBookPage;
import org.pages.NewsletterPage;
import org.pages.RegisterAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static util.TestUtil.generateRandomEmail;

public class NewsletterPageTests extends BaseTest{

    private RegisterAccountPage registerAccountPage;
    private NewsletterPage newsletterPage;
    private String registerUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    private String newsletterPageUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/newsletter";

    @BeforeClass
    public void setUpPreconditions() {
        System.out.println("Creating new account to be logged in...");
        registerAccountPage =  new RegisterAccountPage(driver);
        createAccount();
        System.out.println("Creating new account to be logged in ... Done");
        System.out.println("Go to account password page...");
        goToNewsletterPage();
        System.out.println("Go to account password page ... done");
    }

    @BeforeMethod
    public void beforeMethod() {
        newsletterPage = new NewsletterPage(driver);
    }

    @Test
    public void verifyPageHeader() throws Exception {
        String expectedPageHeader = "Newsletter Subscription";
        Assert.assertEquals(newsletterPage.getTitle(), expectedPageHeader,
                "First section header text is not the expected one");
    }

    @Test
    public void verifyHasBackAndContinueButtons() {
        Assert.assertTrue(newsletterPage.getBackButton().isDisplayed());
        Assert.assertTrue(newsletterPage.getContinueButton().isDisplayed());
    }

    @Test
    public void verifyTheBreadcrumb() {
        goToNewsletterPage();
        Assert.assertEquals(newsletterPage.getBreadcrumbLastItem().getText(), "Newsletter");
    }

    @Test
    public void verifyNewsletterSubscriptionOptions() {
        Assert.assertTrue(newsletterPage.isYesOptionDisplayed());
        Assert.assertTrue(newsletterPage.isNoOptionDisplayed());
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

    public void goToNewsletterPage() {
        driver.get(newsletterPageUrl);
    }
}