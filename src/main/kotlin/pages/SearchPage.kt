package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class SearchPage(driver: WebDriver) {

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[3]/div[2]/div/div[1]/form/div/div/div/input")
    lateinit var searchField: WebElement

    init {
        PageFactory.initElements(driver, this)
    }
}