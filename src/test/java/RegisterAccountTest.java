import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.AccountCreatedPage;
import org.pages.RegisterAccountPage;
import testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.TestNGAntTask.Mode.testng;


public class RegisterAccountTest {

    @Test
    public void registerNewAccountMandatoryFieldsTest() throws Exception{
      WebDriver driver = new ChromeDriver();
      driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
      RegisterAccountPage registerAccountPage = new RegisterAccountPage(driver);
      registerAccountPage.insertFirstName("Jhon");
      registerAccountPage.insertLastName("Doe");
      // email needs to be changed every new run
        Random random = new Random();
        String email = "johndow" + random.nextLong() + "@email.com";
        System.out.println("Used email is: " + email);
        registerAccountPage.insertEmail(email);
        registerAccountPage.insertPhoneNumber("23759845");
        registerAccountPage.setPassword("Password1234");
        registerAccountPage.setPasswordConfirm("Password1234");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        String actualText = accountCreatedPage.getParagraphText();
        String expectedText = "Congratulations! Your new accont has been succesfully created!";
        Asseert.assertEquals(actualText, expectedText, "")









    }












}
