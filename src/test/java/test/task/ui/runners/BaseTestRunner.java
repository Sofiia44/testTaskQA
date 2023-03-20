package test.task.ui.runners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import test.task.utils.ConfigProperties;

import java.time.Duration;

public class BaseTestRunner {

    protected WebDriver driver;
    protected static final ConfigProperties configProperties = new ConfigProperties();

    @BeforeSuite
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected void setDriver(ITestContext context) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        context.setAttribute("myDriver", driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(configProperties.getBaseWebUrl());
    }

    @AfterMethod
    public void quiteDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
