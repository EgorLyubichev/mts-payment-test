package by.aston.mtsPage;

import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.mts.by");
    }
}
