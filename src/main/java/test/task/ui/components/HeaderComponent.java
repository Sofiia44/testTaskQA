package test.task.ui.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.task.ui.BasePage;
import test.task.ui.Pages.DesktopsPO.ExpensivePO.ExpensiveComputerPage;
import test.task.ui.Pages.ShoppingCartPO.ShoppingCartPage;

import static org.openqa.selenium.By.*;

public class HeaderComponent extends BasePage {

    private WebElement shoppingCart = driver.findElement(id("topcartlink"));
    private WebElement shoppingCartQuantity = driver.findElement(cssSelector("span.cart-qty"));

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartPage clickShoppingCartButton() {
        click(shoppingCart);
        return new ShoppingCartPage(driver);
    }

    public String getShoppingCartQuantity(){
       return getText(shoppingCartQuantity);
    }
}

