package test.task.ui.Pages.ShoppingCartPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.task.ui.components.HeaderComponent;

import static java.lang.String.format;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class ShoppingCartPage extends HeaderComponent {

    private WebElement removeCheckBox = driver.findElement(xpath("//input[@name='removefromcart']"));

    private WebElement updateCartButton = driver.findElement(xpath("//input[@name='updatecart']"));

    private WebElement price = driver.findElement(cssSelector("span.product-unit-price"));


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public String isItemInShoppingCart() {
        return getText(driver.findElement(xpath("//a[@class='product-name']")));
    }

    public ShoppingCartPage clickRemoveCheckBox() {
        click(removeCheckBox);
        return new ShoppingCartPage(driver);
    }

    public ShoppingCartPage clickUpdateCartButton() {
        click(updateCartButton);
        return this;
    }

    public String getPrice() {
        return getText(price);
    }

    public boolean successMessageDisplayed(String successMessage) {
        visibility(xpath(format("//div[@class='order-summary-content']", successMessage)));
        return driver.findElement(xpath(format("//div[@class='order-summary-content']", successMessage))).isDisplayed();
    }
}
