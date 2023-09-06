package by.aston.mtsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsHomePage extends BasePage {

    public MtsHomePage(WebDriver driver) {
        super(driver);
    }

    private final By paymentFormContainer = By.xpath("//div[@class='pay__form']");
    private final By inputPhoneField = By.id("connection-phone");
    private final By inputSumField = By.id("connection-sum");
    private final By inputEmailField = By.id("connection-email");
    private final By continueBtn = By.xpath("//form[@id='pay-connection']/button");
    private final By paymentFrame = By.xpath("//iframe[@class='bepaid-iframe']");
    private final By paymentButton = By.xpath("//div[@class='card-page__card']/button");
    private final By headerPaymentAmount = By.xpath("//p[@class='header__payment-amount']");
    private final By headerPaymentInfo = By.xpath("//p[@class='header__payment-info']");

    public MtsHomePage goToPaymentForm() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement payContainerWebElement = driver.findElement(paymentFormContainer);
        js.executeScript("arguments[0].scrollIntoView();", payContainerWebElement);
        return this;
    }

    public MtsHomePage inputTestPhoneNumber(String phoneNumber) {
        WebElement phoneNumberField = driver.findElement(inputPhoneField);
        phoneNumberField.sendKeys(phoneNumber);
        return this;
    }

    public MtsHomePage inputTestSum(String sum) {
        WebElement sumField = driver.findElement(inputSumField);
        sumField.sendKeys(sum);
        return this;
    }

    public MtsHomePage inputTestEmail() {
        WebElement emailField = driver.findElement(inputEmailField);
        emailField.sendKeys("efg@mail.ru");
        return this;
    }

    public MtsHomePage clickContinueButton() {
        WebElement continueButtonElement = driver.findElement(continueBtn);
        continueButtonElement.click();
        return this;
    }

    public MtsHomePage switchToPaymentFrame() {
        WebDriver paymentFrameElement = new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));
        return this;
    }

    public String getTextFromPaymentButton() {
        return getInnerTextFromTag(paymentButton);
    }

    public String getTextFromPaymentFrameHeader() {
        return getInnerTextFromTag(headerPaymentAmount);
    }

    public String getTextFromHeaderPaymentInfo(){
        return getInnerTextFromTag(headerPaymentInfo);
    }

    private String getInnerTextFromTag(By by){
        WebElement buttonElement = driver.findElement(by);
        return buttonElement.getAttribute("innerText");
    }
}
