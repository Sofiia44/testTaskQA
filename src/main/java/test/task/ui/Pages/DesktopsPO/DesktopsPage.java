package test.task.ui.Pages.DesktopsPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.task.ui.Pages.DesktopsPO.ExpensivePO.ExpensiveComputerPage;
import test.task.ui.pageComponents.HeaderComponent;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static org.openqa.selenium.By.*;

public class DesktopsPage extends HeaderComponent {

    private WebElement productsPageSize = driver.findElement(id("products-pagesize"));
    private WebElement productsOrderBy = driver.findElement(id("products-orderby"));
    private WebElement fourItemsPerPage = driver.findElement(xpath("//option[text()='4']"));
    private WebElement fromHighToLowPrice = driver.findElement(xpath("//option[text()='Price: High to Low']"));


    public DesktopsPage(WebDriver driver) {
        super(driver);
    }


    public DesktopsPage clickProductsPageSizeButton() {
        click(productsPageSize);
        return new DesktopsPage(driver);
    }

    public DesktopsPage clickFourItemsButton() {
        visibleClick(fourItemsPerPage);
        return new DesktopsPage(driver);
    }

    public DesktopsPage clickProductsOrderByButton() {
        click(productsOrderBy);
        return new DesktopsPage(driver);
    }

    public DesktopsPage clickFromHighToLowButton() {
        visibleClick(fromHighToLowPrice);
        return new DesktopsPage(driver);
    }


    public String getExpensiveName(){
       return getText(driver.findElement(xpath(format("//span[text()='%s']//ancestor::div[@class='details']//h2/a",findExpensive()+"0"))));
    }

    public ExpensiveComputerPage addToCartExpensiveComputer(){
        click(driver.findElement(xpath(format("//span[text()='%s']//ancestor::div[@class='add-info']//input",findExpensive()+"0"))));
        return new ExpensiveComputerPage(driver);
    }

    public double findExpensive(){
     List<String> list = driver.findElements(cssSelector(".actual-price")).stream().map(element -> element.getText()).sorted().collect(Collectors.toList());
        double expensive = list.stream()
                .mapToDouble(Double::parseDouble)
                .max()
                .orElse(-1);
     return expensive;
    }

}
