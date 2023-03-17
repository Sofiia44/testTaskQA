package test.task.ui.Pages.ComputersPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.task.ui.Pages.DesktopsPO.DesktopsPage;
import test.task.ui.components.HeaderComponent;

import static org.openqa.selenium.By.xpath;

public class ComputersProducts extends HeaderComponent {

    private WebElement desktops = driver.findElement(xpath("//h2[@class='title']//a[contains(text(),'Desktops')]"));

    public ComputersProducts(WebDriver driver) {
        super(driver);
    }

    public DesktopsPage clickDesktopsButton() {
        click(desktops);
        return new DesktopsPage(driver);
    }


}
