package by.aston;

import by.aston.config.ChromeDriverConnector;
import by.aston.mtsPage.BasePage;
import by.aston.mtsPage.MtsHomePage;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    WebDriver driver = ChromeDriverConnector.getChromeDriver();
    BasePage basePage = new BasePage(driver);
    MtsHomePage mtsHomePage = new MtsHomePage(driver);
}
