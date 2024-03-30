package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class ConstructorPage(driver: WebDriver) {

    @FindBy(xpath = "//*[@id=\"tslider-craftum-b\"]/div[1]/div/div/div/input")
    lateinit var searchTemplateField: WebElement

    init {
        PageFactory.initElements(driver, this)
    }
}