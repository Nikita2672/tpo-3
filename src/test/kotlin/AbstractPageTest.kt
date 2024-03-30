import org.junit.jupiter.api.AfterEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import util.ConfProperties
import java.time.Duration
import java.util.stream.Stream

abstract class AbstractPageTest(
    private var url: String
) {
    lateinit var driver: WebDriver

    companion object {
        private val browser = arrayOf("Chrome")

        @JvmStatic
        fun browserProvider(): Stream<String> {
            return Stream.of(*browser)
        }
    }

    protected fun browserSetup(browser: String) {
        if (browser == "Chrome") {
            System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
            driver = ChromeDriver()
        } else if (browser == "Firefox") {
            System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("firefoxdriver"));
            driver = FirefoxDriver()
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