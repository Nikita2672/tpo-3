import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import pages.SearchPage
import java.lang.Thread.sleep
import java.time.Duration


class SearchPageTest : AbstractPageTest("https://timeweb.com/ru/search/") {

    private lateinit var searchPage: SearchPage

    @ParameterizedTest
    @MethodSource("browserProvider")
    fun `check knowledge base`(browser: Browser) {
        browserSetup(browser)
        searchPage = SearchPage(driver)
        searchPage.searchField.sendKeys("хостинг")
        searchPage.searchField.sendKeys(Keys.ENTER)
        sleep(1000)
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        val element =
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__layout\"]/div/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]")))
        element.click()

        sleep(5000)

        assertEquals(driver.currentUrl, "https://timeweb.com/ru/docs/virtualnyj-hosting")
    }
}