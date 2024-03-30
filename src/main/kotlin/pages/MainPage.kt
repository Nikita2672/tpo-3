package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory


class MainPage(driver: WebDriver) {

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/header/div[2]/nav/div[3]/div/a/span/div")
    lateinit var mailButton: WebElement

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/header/div[2]/nav/div[2]/div/a/span/div")
    lateinit var vdsAndVpsButton: WebElement

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/header/div[2]/nav/div[5]/div/a/span/div")
    lateinit var dedicatedServerButton: WebElement

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/header/div[2]/nav/div[6]/div/a/span/div")
    lateinit var constructorButton: WebElement

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/header/div[2]/nav/div[7]/div/a/span/div")
    lateinit var webmastersButton: WebElement

    init {
        PageFactory.initElements(driver, this)
    }
}