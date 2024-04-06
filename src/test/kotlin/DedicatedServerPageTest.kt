import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import pages.DedicatedServerPage
import java.time.Duration

class DedicatedServerPageTest : AbstractPageTest("https://timeweb.com/ru/services/dedicated-server/") {

    private lateinit var dedicatedServerPage: DedicatedServerPage

    @ParameterizedTest
    @MethodSource("browserProvider")
    fun `configure dedicated server`(browser: Browser) {
        browserSetup(browser)
        dedicatedServerPage = DedicatedServerPage(driver)

        dedicatedServerPage.configuratorButton.click()
        Thread.sleep(1000)
        val processorSelectSpan = WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/div/span")))
        processorSelectSpan.click()
        val processorIntelButton = WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div/div[4]")))
        processorIntelButton.click()

        Assertions.assertEquals("4941 ₽ в месяц", dedicatedServerPage.priceDiv.text)
    }
}