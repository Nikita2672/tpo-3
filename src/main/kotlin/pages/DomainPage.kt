package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class DomainPage(driver: WebDriver) {

    @FindBy(xpath = "//*[@id=\"select-domain\"]/form/div[1]/div/div/input")
    lateinit var domainInput: WebElement

    @FindBy(xpath = "//*[@id=\"select-domain\"]/form/div[1]/div/div/div/div/button")
    lateinit var checkButton: WebElement

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/header/div[2]/nav/div[8]/div")
    lateinit var searchButton: WebElement

    init {
        PageFactory.initElements(driver, this)
    }
}