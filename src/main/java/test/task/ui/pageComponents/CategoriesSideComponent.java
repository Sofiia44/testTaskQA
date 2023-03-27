package test.task.ui.pageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.task.ui.Pages.ComputersPO.ComputersProducts;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class CategoriesSideComponent extends HeaderComponent {
    private WebElement computers = driver.findElement(xpath("//div[@class='listbox']//a[contains(text(),'Computers')]"));

    public ComputersProducts clickComputersButton() {
        click(computers);
        return new ComputersProducts(driver);
    }
    public CategoriesSideComponent(WebDriver driver) {
        super(driver);
    }




}
