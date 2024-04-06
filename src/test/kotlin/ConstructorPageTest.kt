import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import pages.ConstructorPage
import java.time.Duration


class ConstructorPageTest: AbstractPageTest("https://timeweb.com/ru/services/constructor/") {

    private lateinit var constructorPage: ConstructorPage

    @ParameterizedTest
    @MethodSource("browserProvider")
    fun `check search template`(browser: Browser) {
        browserSetup(browser)
        constructorPage = ConstructorPage(driver)
        constructorPage.searchTemplateField.sendKeys("универсальный шаблон")

        // Явное ожидание появления элемента
        val wait = WebDriverWait(driver, Duration.ofSeconds(5)) // Максимальное время ожидания в секундах
        val template = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tslider-craftum-b\"]/div[3]/div[1]/div/div[2]")))
        val templateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[3]/div[2]/div[2]/div[2]/div/div[3]/div[1]/div/div[2]/button")))

        (driver as JavascriptExecutor).executeScript("arguments[0].scrollIntoView(true);", templateButton)

        // Проверка наличия элемента
        assertTrue(template != null)
        assertTrue(templateButton != null)

        val windowsHandleCounterBefore = driver.windowHandles.size
        // Клик по кнопке
        templateButton.click()
        val windowsHandleCounterAfter = driver.windowHandles.size

        // Проверка открытия новой страницы
        assertTrue(windowsHandleCounterAfter == (windowsHandleCounterBefore + 1))
    }
}