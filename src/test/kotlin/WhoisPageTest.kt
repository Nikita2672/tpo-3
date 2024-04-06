import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import pages.WhoisPage
import java.lang.Thread.sleep
import java.time.Duration

class WhoisPageTest : AbstractPageTest("https://timeweb.com/ru/services/domains/whois") {

    private lateinit var whoisPage: WhoisPage

    @ParameterizedTest
    @MethodSource("browserProvider")
    fun `check google domain exists`(browser: Browser) {
        browserSetup(browser)
        whoisPage = WhoisPage(driver)

        whoisPage.searchField.sendKeys("google.com" + Keys.ENTER)
        sleep(1000)
        WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.urlToBe("https://timeweb.com/ru/services/domains/whois/?d=google.com"))

        val element =  WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__layout\"]/div/div[3]/div[2]/div/section/div[3]/div[2]/pre")))
        assertTrue("Domain Name: GOOGLE.COM" in element.text)
    }
}