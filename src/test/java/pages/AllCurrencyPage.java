package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AllCurrencyPage {
    public AllCurrencyPage(){
        PageFactory.initElements((WebDriver)Driver.getAndroidDriver(),this);
    }


}
