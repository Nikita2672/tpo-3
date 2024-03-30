import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.openqa.selenium.By
import kotlin.test.assertEquals

class ComparablePageTest : AbstractPageTest("https://timeweb.com/ru/services/compare/"){

    @ParameterizedTest
    @MethodSource("browserProvider")
    fun `check content`(browser: String) {
        browserSetup(browser)
        val hosting = driver.findElement(By.xpath("//*[@id=\"compare-table\"]/tbody/tr[1]/td[1]/div/div[2]"))
        assertEquals(hosting.text, "Хостинг")

        val hostingPrice = driver.findElement(By.xpath("//*[@id=\"compare-table\"]/tbody/tr[7]/td[1]/div/div[3]/span"))
        assertEquals(hostingPrice.text, "274")

        val powerHosting = driver.findElement(By.xpath("//*[@id=\"compare-table\"]/tbody/tr[1]/td[2]/div/div[2]"))
        assertEquals(powerHosting.text, "Мощный\nхостинг")

        val powerHostingPrice = driver.findElement(By.xpath("//*[@id=\"compare-table\"]/tbody/tr[7]/td[2]/div/div[3]/span"))
        assertEquals(powerHostingPrice.text, "1 197")

        val vdsServer = driver.findElement(By.xpath("//*[@id=\"compare-table\"]/tbody/tr[1]/td[3]/div/div[2]"))
        assertEquals(vdsServer.text, "VDS\nсерверы")

        val vdsServerPrice = driver.findElement(By.xpath("//*[@id=\"compare-table\"]/tbody/tr[7]/td[3]/div/div[3]/span"))
        assertEquals(vdsServerPrice.text, "160")

        val dedicatedServers = driver.findElement(By.xpath("//*[@id=\"compare-table\"]/tbody/tr[1]/td[4]/div/div[2]"))
        assertEquals(dedicatedServers.text, "Выделенные\nсерверы")

        val dedicatedServersPrice = driver.findElement(By.xpath("//*[@id=\"compare-table\"]/tbody/tr[7]/td[4]/div/div[3]/span"))
        assertEquals(dedicatedServersPrice.text, "5 490")
    }
}