package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class WhoisPage(driver: WebDriver) {

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[3]/div[2]/div/section/div[2]/form/div/div/div/input")
    lateinit var searchField: WebElement

    init {
        PageFactory.initElements(driver, this)
    }
}