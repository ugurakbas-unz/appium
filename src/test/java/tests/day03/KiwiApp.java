package day03;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPages;
import utilities.DriverKiwi;
import utilities.ReusableMethods;

public class KiwiApp {

    AndroidDriver<AndroidElement> driver = DriverKiwi.getAndroidDriver();
    KiwiPages kiwiPages = new KiwiPages();

    @Test
    public void kiwiAppTest() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
        // uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(kiwiPages.misafirButonu.isDisplayed());
        // misafir olarak devam et e tiklanir
        kiwiPages.misafirButonu.click();
        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        //544,2048
        for (int i=0; i<3; i++){
            ReusableMethods.tiklamaMethodu(544,2048,1000);
        }
        Thread.sleep(1500);
        // Trip type,one way olarak secilir
        ReusableMethods.tiklamaMethodu(274,617,500);
        Thread.sleep(1000);
        kiwiPages.oneWayButton.click();

    // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        // 400-900
        //1018-239
    // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir

    // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
    // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
    // search butonuna tiklanir
    // en  ucuz ve aktarmasiz filtrelemeleri yapilir
    // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir


    }
}
