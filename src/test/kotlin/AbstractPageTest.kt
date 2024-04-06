import org.junit.jupiter.api.AfterEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.time.Duration
import java.util.stream.Stream

abstract class AbstractPageTest(
    private var url: String
) {
    lateinit var driver: WebDriver

    companion object {
        private val browsers = Browser.entries.toTypedArray()

        @JvmStatic
        fun browserProvider(): Stream<Browser> {
            return Stream.of(*browsers)
        }
    }

    protected fun browserSetup(browser: Browser) {
        driver = when (browser) {
            Browser.CHROME -> ChromeDriver()
            Browser.FIREFOX -> FirefoxDriver()
        }
        driver.manage().window().maximize()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2))
        driver.get(url)
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}

enum class Browser {
    CHROME,
    FIREFOX,
}
