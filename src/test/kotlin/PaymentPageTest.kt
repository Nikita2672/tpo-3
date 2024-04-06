import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import pages.PaymentPage
import java.time.Duration

class PaymentPageTest: AbstractPageTest("https://timeweb.com/ru/services/domains") {

    private lateinit var paymentPage: PaymentPage

    @ParameterizedTest
    @MethodSource("browserProvider")
    fun `check payment info`(browser: Browser) {
        browserSetup(browser)
        paymentPage = PaymentPage(driver)
        paymentPage.paymentInfoButton.click()
        WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.urlToBe("https://timeweb.com/ru/services/domains/#pay"))
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/div/div/div[3]/div/div/div[1]/div[2]/div[3]")))
        val elementSBP = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/div/div/div[3]/div/div/div[1]/div[2]/div[3]"))
        assertEquals("СБП", elementSBP.text)
        val elementBankCard = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/div/div/div[3]/div/div/div[1]/div[1]/div[3]"))
        assertEquals("Банковские карты", elementBankCard.text)
        val elementReceipt = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/div/div/div[3]/div/div/div[1]/div[5]/div[3]"))
        assertEquals("Квитанция", elementReceipt.text)
        val elementUMoney = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/div/div/div[3]/div/div/div[1]/div[4]/div[3]"))
        assertEquals("ЮMoney", elementUMoney.text)
        val elementAccountPay = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/div/div/div[3]/div/div/div[1]/div[3]/div[3]"))
        assertEquals("Счет на оплату", elementAccountPay.text)
    }
}