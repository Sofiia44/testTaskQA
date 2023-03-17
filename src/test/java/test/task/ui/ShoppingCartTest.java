package test.task.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.task.ui.Pages.DesktopsPO.DesktopsPage;
import test.task.ui.Pages.DesktopsPO.ExpensivePO.ExpensiveComputerPage;
import test.task.ui.Pages.ShoppingCartPO.ShoppingCartPage;
import test.task.ui.runners.BaseTestRunner;

public class ShoppingCartTest extends BaseTestRunner {

    @Test(priority = 1)
    public void addTheMostExpensiveItemToShoppingCart() {
        String expectedResult = new HomePage(driver)
                .clickComputersButton()
                .clickDesktopsButton()
                .clickProductsPageSizeButton()
                .clickFourItemsButton()
                .clickProductsOrderByButton()
                .clickFromHighToLowButton()
                .getExpensiveName();

        String actualResult = new DesktopsPage(driver)
                .addToCartExpensiveComputer()
                .clickNewAddToCartButton()
                .clickShoppingCartButton()
                .isItemInShoppingCart();
        Assert.assertEquals(expectedResult, actualResult, "There are different computer");
    }

    @Test(priority = 2)
    public void addFilteredItemToShoppingCartAndDeleteIt() {
        driver.get(configProperties.getComputerWebUrl());
        String expectedPrice = new ExpensiveComputerPage(driver)
                .clickFastProcessorButton()
                .clickRamButton()
                .clickImageViewerButton()
                .clickOfficeSuiteButton()
                .clickOtherOfficeSuiteButton()
                .clickNewAddToCartButton()
                .getPrice();
        String expectedQuantity = new HomePage(driver)
                .getShoppingCartQuantity();
        String actualPrice = new HomePage(driver)
                .clickShoppingCartButton()
                .getPrice();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedQuantity, "(1)");
        softAssert.assertEquals(expectedPrice, actualPrice);

        boolean actualSummary = new ShoppingCartPage(driver)
                .clickRemoveCheckBox()
                .clickUpdateCartButton()
                .successMessageDisplayed("Your Shopping Cart is empty!");

        softAssert.assertTrue(actualSummary);
        softAssert.assertAll();


    }


}
