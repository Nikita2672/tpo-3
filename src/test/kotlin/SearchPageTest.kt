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
    fun `check knowledge base`(browser: String) {
        // вот этот тест почему-то не перенаправляет на другую страницу, хотя все если вызывать: val element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__layout\"]/div/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]")))
        //        element.click() в дебаге все работает
        browserSetup(browser)
        searchPage = SearchPage(driver)
        searchPage.searchField.sendKeys("хостинг")
        searchPage.searchField.sendKeys(Keys.ENTER)
        val wait = WebDriverWait(driver, Duration.ofSeconds(10)) // Ждем до 10 секунд
        val element =
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__layout\"]/div/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]")))
        element.click()

        sleep(5000)

        assert(driver.currentUrl == "https://timeweb.com/ru/docs/virtualnyj-hosting")
    }
}