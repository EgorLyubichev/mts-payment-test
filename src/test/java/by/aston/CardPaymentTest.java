package by.aston;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class CardPaymentTest extends BaseTest {

    @BeforeMethod
    public void openHomePage() {
        basePage.open();
    }

    @DataProvider(name = "provider")
    public Object[][] setPhoneNumberAndPaymentAmount() {
        return new Object[][]{
                {"297777777", "25.01"},
                {"297777766", "55.55"},
                {"297777755", "13"}
        };
    }

    @Test(dataProvider = "provider")
    public void testInputPhoneNumberAndMoneyValuesAreCorrectIntoFrameHeaderAndFrameButton(String phoneNumber, String sum) {

        mtsHomePage
                .goToPaymentForm()
                .inputTestPhoneNumber(phoneNumber)
                .inputTestSum(sum)
                .inputTestEmail()
                .clickContinueButton()
                .switchToPaymentFrame();
        SoftAssert softAssert = new SoftAssert();
        assertTrue(mtsHomePage.getTextFromPaymentButton().contains(sum));
        assertTrue(mtsHomePage.getTextFromPaymentButton().contains(mtsHomePage.getTextFromPaymentFrameHeader()));
        assertTrue(mtsHomePage.getTextFromHeaderPaymentInfo().contains(phoneNumber));
        softAssert.assertAll();
    }

    @AfterMethod
    public void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
