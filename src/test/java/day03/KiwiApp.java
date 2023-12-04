package day03;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPages;
import utilities.Driver;
import utilities.ReusableMethods;

public class KiwiApp {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    KiwiPages kiwiPages = new KiwiPages();

    @Test
    public void kiwiappTest() throws InterruptedException {

        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
    // uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(kiwiPages.misafir.isDisplayed());
    // misafir olarak devam et e tiklanir
        //534*2048 Pixel 4 için
        TouchAction action = new TouchAction<>(driver);
        Thread.sleep(1000);
        for (int i = 0; i <3; i++) {
            ReusableMethods.tiklamaMetodu(534,2048,1);

        }
    // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
    // Trip type,one way olarak secilir
    // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
    // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
    // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
    // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
    // search butonuna tiklanir
    // en  ucuz ve aktarmasiz filtrelemeleri yapilir
    // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir


    }
}
