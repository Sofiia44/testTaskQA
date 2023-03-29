package test.task.ui;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.task.ui.Pages.RegisterPO.FinalRegisterPage;
import test.task.ui.Pages.RegisterPO.RegisterPage;
import test.task.ui.runners.BaseTestRunner;

public class RegisterTest extends BaseTestRunner {


    @Test
    public void registerNewUser() {
        RegisterPage registerPage = new HomePage(driver)
                .clickRegisterButton()
                .clickFemaleButton()
                .enterFirstName("Sofiia")
                .enterLastName("Ometiukh")
                .enterEmail("sofiya.ometiukh@gmail.com")
                .enterPassword("D8065479")
                .enterConfirmPassword("D8065479");
        SoftAssert softAssert = new SoftAssert();

        boolean actualEmailResult = new RegisterPage(driver)
                .clickRegisterButton()
                .errorEmailMessageDisplayed("The specified email already exists");
        softAssert.assertTrue(actualEmailResult);

        boolean actualPasswordResult = new RegisterPage(driver)
                .enterPassword("2564")
                .clickRegisterButton()
                .errorPasswordLengthMessageDisplayed("The password should have at least 6 characters.");
        softAssert.assertTrue(actualPasswordResult);

        boolean actualResult = new RegisterPage(driver)
                .enterEmail(generateRandomEmailAddress())
                .enterPassword("D8065479")
                .enterConfirmPassword("D8065479")
                .clickRegisterButton()
                .successfulRegisterMessageDisplayed("Your registration completed");
        softAssert.assertTrue(actualResult);
        softAssert.assertAll();


    }
}
