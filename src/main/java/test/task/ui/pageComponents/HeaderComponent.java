package test.task.ui.pageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.task.ui.BasePage;
import test.task.ui.Pages.RegisterPO.RegisterPage;
import test.task.ui.Pages.ShoppingCartPO.ShoppingCartPage;

import static org.openqa.selenium.By.*;

public class HeaderComponent extends BasePage {

    private WebElement shoppingCart = driver.findElement(id("topcartlink"));
    private WebElement shoppingCartQuantity = driver.findElement(cssSelector("span.cart-qty"));
    private WebElement registerButton = driver.findElement(cssSelector("a.ico-register"));

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartPage clickShoppingCartButton() {
        click(shoppingCart);
        return new ShoppingCartPage(driver);
    }

    public String getShoppingCartQuantity() {
        return getText(shoppingCartQuantity);
    }

    public RegisterPage clickRegisterButton() {
        click(registerButton);
        return new RegisterPage(driver);
    }
}

