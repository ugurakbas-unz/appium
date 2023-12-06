package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KiwiPage {
    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);

    }


    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement misafirButonu;

    @FindBy(xpath = "//*[@text='One way']")
    public WebElement oneWayButton;

    @FindBy(xpath = "(//*[@class='android.view.View'])[4]")
    public WebElement textBox;

    @FindBy(xpath = "//*[@class='android.view.View'][6]")
    public WebElement fiyat;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[12]")
    public WebElement priceBox;
}
