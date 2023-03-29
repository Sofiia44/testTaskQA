package test.task.ui.Pages.RegisterPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.task.ui.pageComponents.HeaderComponent;

import static java.lang.String.format;
import static org.openqa.selenium.By.*;

public class RegisterPage extends HeaderComponent {

    private WebElement femaleButton = driver.findElement(id("gender-female"));
    private WebElement firstNameInput = driver.findElement(id("FirstName"));
    private WebElement lastNameInput = driver.findElement(id("LastName"));
    private WebElement emailInput = driver.findElement(id("Email"));
    private WebElement passwordInput = driver.findElement(id("Password"));
    private WebElement confirmPasswordInput = driver.findElement(id("ConfirmPassword"));
    private WebElement finishedRegisterButton = driver.findElement(id("register-button"));



    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage clickFemaleButton() {
        click(femaleButton);
        return this;
    }

    public RegisterPage enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegisterPage enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public RegisterPage enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public RegisterPage enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public RegisterPage enterConfirmPassword(String confirmPassword) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
        return this;
    }

    public RegisterPage clickRegisterButton() {
        click(finishedRegisterButton);
        return this;
    }

    public boolean errorConfirmPasswordMessageDisplayed(String errorConfirmMessage) {
        visibility(xpath(format("//span[text()='The password and confirmation password do not match.']", errorConfirmMessage)));
        return driver.findElement(xpath(format("//span[text()='The password and confirmation password do not match.']", errorConfirmMessage))).isDisplayed();
    }

    public boolean errorPasswordLengthMessageDisplayed(String errorMessage) {
        visibility(xpath(format("//span[text()='The password should have at least 6 characters.']", errorMessage)));
        return driver.findElement(xpath(format("//span[text()='The password should have at least 6 characters.']", errorMessage))).isDisplayed();
    }

    public boolean successfulRegisterMessageDisplayed(String successMessage) {
        visibility(xpath(format("//div[@class='result']", successMessage)));
        return driver.findElement(xpath(format("//div[@class='result']", successMessage))).isDisplayed();
    }

    public boolean errorEmailMessageDisplayed(String errMessage) {
        visibility(xpath(format("//li[text()='The specified email already exists']", errMessage)));
        return driver.findElement(xpath(format("//li[text()='The specified email already exists']", errMessage))).isDisplayed();
    }


}
