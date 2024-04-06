import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.openqa.selenium.By
import pages.DomainPage

class DomainPageTest : AbstractPageTest("https://timeweb.com/ru/services/domains/") {

    private lateinit var domainPage: DomainPage

    @ParameterizedTest
    @MethodSource("browserProvider")
    fun `check domain free`(browser: Browser) {
        browserSetup(browser)
        domainPage = DomainPage(driver)
        domainPage.domainInput.sendKeys("iwaa")
        domainPage.checkButton.click()
        assertTrue(driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[3]/div[2]/div/section/div[5]/div[1]/div[1]/div/div[1]")) != null)
        // проверка что стоимость отображена
        assertTrue(driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[3]/div[2]/div/section/div[5]/div[1]/div[1]/div/div[2]/div[1]/div[1]")).text.contains("₽"))
    }

    @ParameterizedTest
    @MethodSource("browserProvider")
    fun `check search button`(browser: Browser) {
        browserSetup(browser)
        domainPage = DomainPage(driver)
        domainPage.searchButton.click()
        assertTrue(driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/header/div[2]/nav/div[1]/input")) != null)
    }
}