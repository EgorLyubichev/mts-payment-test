package by.aston.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.time.Duration.ofSeconds;

public class ChromeDriverConnector {
    public static WebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(4));
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(8));
        return driver;
    }
}
