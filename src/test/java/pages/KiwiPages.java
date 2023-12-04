package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KiwiPages {
    public KiwiPages(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);

    }


    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement misafir;
}
