import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import pages.MainPage
import java.time.Duration

class MainPageTest : AbstractPageTest("https://timeweb.com/ru/services/domains") {

    private lateinit var mainPage: MainPage

    @ParameterizedTest
    @MethodSource("browserProvider")
    fun `check reg domain`(browser: Browser) {
        browserSetup(browser)
        mainPage = MainPage(driver)
        mainPage.mailButton.click()
        WebDriverWait(
            driver,
            Duration.ofSeconds(2)
        ).until(ExpectedConditions.urlToBe("https://timeweb.com/ru/services/mail/"))
    }

    @ParameterizedTest
    @MethodSource("browserProvider")
    fun `check vds vps redirect`(browser: Browser) {
        browserSetup(browser)
        mainPage = MainPage(driver)
        mainPage.vdsAndVpsButton.click()
        WebDriverWait(
            driver,
            Duration.ofSeconds(2)
        ).until(ExpectedConditions.urlToBe("https://timeweb.com/ru/services/vds/"))
    }

    @ParameterizedTest
    @MethodSource("browserProvider")
    fun `check dedicated server redirect`(browser: Browser) {
        browserSetup(browser)
        mainPage = MainPage(driver)
        mainPage.dedicatedServerButton.click()
        WebDriverWait(
            driver,
            Duration.ofSeconds(2)
        ).until(ExpectedConditions.urlToBe("https://timeweb.com/ru/services/dedicated-server/"))
    }

    @ParameterizedTest
    @MethodSource("browserProvider")
    fun `check constructor redirect`(browser: Browser) {
        browserSetup(browser)
        mainPage = MainPage(driver)
        mainPage.constructorButton.click()
        WebDriverWait(
            driver,
            Duration.ofSeconds(2)
        ).until(ExpectedConditions.urlToBe("https://timeweb.com/ru/services/constructor/"))
    }

    @ParameterizedTest
    @MethodSource("browserProvider")
    fun `check webmasters redirect`(browser: Browser) {
        browserSetup(browser)
        mainPage = MainPage(driver)
        mainPage.webmastersButton.click()
        WebDriverWait(
            driver,
            Duration.ofSeconds(2)
        ).until(ExpectedConditions.urlToBe("https://timeweb.com/ru/partners/webmasters/"))
    }
}