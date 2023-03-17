package test.task.ui.Pages.DesktopsPO.ExpensivePO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.task.ui.components.HeaderComponent;

import static java.lang.String.format;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class ExpensiveComputerPage extends HeaderComponent {

    private WebElement fastProcessor = driver.findElement(xpath("//input[@value='82']"));
    private WebElement ramEightMb = driver.findElement(xpath("//input[@value='85']"));
    private WebElement imageViewer = driver.findElement(xpath("//input[@value='88']"));
    private WebElement officeSuite = driver.findElement(xpath("//input[@value='89']"));
    private WebElement otherOfficeSuite = driver.findElement(xpath("//input[@value='90']"));
    private WebElement addToCartButton = driver.findElement(xpath("//input[@id='add-to-cart-button-74']"));
    private WebElement price = driver.findElement(cssSelector(".product-price span"));
    public ExpensiveComputerPage(WebDriver driver) {
        super(driver);
    }

    public ExpensiveComputerPage clickFastProcessorButton() {
        click(fastProcessor);
        return new ExpensiveComputerPage(driver);
    }

    public ExpensiveComputerPage clickRamButton() {
        click(ramEightMb);
        return new ExpensiveComputerPage(driver);
    }

    public ExpensiveComputerPage clickImageViewerButton() {
        click(imageViewer);
        return new ExpensiveComputerPage(driver);
    }

    public ExpensiveComputerPage clickOfficeSuiteButton() {
        click(officeSuite);
        return new ExpensiveComputerPage(driver);
    }

    public ExpensiveComputerPage clickOtherOfficeSuiteButton() {
        click(otherOfficeSuite);
        return new ExpensiveComputerPage(driver);
    }

    public ExpensiveComputerPage clickNewAddToCartButton() {
        click(addToCartButton);
        closeNotification();
        return new ExpensiveComputerPage(driver);
    }

    public String getPrice() {
        return getText(price);
    }

    public boolean verifyItemQuantity(String addedItemQuantity) {
        visibility(xpath(format("//span[@class='cart-qty'][text()='(%s)']", addedItemQuantity)));
        return driver.findElement(xpath(format("//span[@class='cart-qty'][text()='(%s)']", addedItemQuantity))).isDisplayed();
    }
}
