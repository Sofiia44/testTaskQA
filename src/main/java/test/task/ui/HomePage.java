package test.task.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.task.ui.Pages.ComputersPO.ComputersProducts;
import test.task.ui.pageComponents.CategoriesSideComponent;

import static org.openqa.selenium.By.*;

public class HomePage extends CategoriesSideComponent {
    private WebElement computers = driver.findElement(xpath("//div[@class='listbox']//a[contains(text(),'Computers')]"));


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ComputersProducts clickComputersButton() {
        click(computers);
        return new ComputersProducts(driver);
    }

}
