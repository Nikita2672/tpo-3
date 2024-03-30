package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class PaymentPage(driver: WebDriver) {

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/header/div[1]/nav/a[1]")
    lateinit var paymentInfoButton: WebElement

    init {
        PageFactory.initElements(driver, this)
    }
}