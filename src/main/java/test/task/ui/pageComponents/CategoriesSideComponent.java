package test.task.ui.pageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.task.ui.Pages.ComputersPO.ComputersProducts;

import static org.openqa.selenium.By.xpath;

public class CategoriesSideComponent extends HeaderComponent {
    private WebElement computers = driver.findElement(xpath("//div[@class='listbox']//a[contains(text(),'Computers')]"));

    public CategoriesSideComponent(WebDriver driver) {
        super(driver);
    }

    public ComputersProducts clickComputersButton() {
        click(computers);
        return new ComputersProducts(driver);
    }


}
