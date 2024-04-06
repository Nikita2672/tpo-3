package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class DedicatedServerPage(driver: WebDriver) {

    @FindBy(xpath="//div[2]/div/div/div[2]/div/div/div[2]")
    lateinit var configuratorButton: WebElement

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[3]/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[2]")
    lateinit var priceDiv: WebElement

    init {
        PageFactory.initElements(driver, this)
    }
}