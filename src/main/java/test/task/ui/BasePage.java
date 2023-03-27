package test.task.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
    }

    protected void click(WebElement element) {
        action.scrollToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void visibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        action.scrollToElement(element);
        return element.getText();
    }

    public void closeNotification() {
        click(driver.findElement(By.cssSelector("span.close")));
    }

    protected void visibleClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        action.scrollToElement(element);
        element.click();
    }

}
