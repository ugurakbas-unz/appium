package tests.day03;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class KiwiApp {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    KiwiPage kiwiPage = new KiwiPage();

    @Test
    public void kiwiAppTest() throws InterruptedException {

        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
        Thread.sleep(4000);
        // uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(kiwiPage.misafirButonu.isDisplayed());
        Thread.sleep(4000);
        // misafir olarak devam et e tiklanir
        kiwiPage.misafirButonu.click();
        Thread.sleep(4000);
        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        for (int i = 0; i <3; i++) {
            ReusableMethods.tiklamaMethodu(540,1690,2000);
        }
        Thread.sleep(4000);
       // Trip type,one way olarak secilir
       ReusableMethods.tiklamaMethodu(300,600,1000);
        Thread.sleep(4000);
       ReusableMethods.tiklamaMethodu(1013,1454,1000);
        Thread.sleep(4000);
       // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
       ReusableMethods.tiklamaMethodu(360,760,1000);
        Thread.sleep(4000);
       ReusableMethods.tiklamaMethodu(1020,130,1000);
        Thread.sleep(4000);
       // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
       if (!driver.isKeyboardShown()){
           kiwiPage.textBox.sendKeys("ANKARA");
       }else {
           driver.getKeyboard().pressKey("ISTANBUL");
       }
        Thread.sleep(4000);
        ReusableMethods.tiklamaMethodu(250,300,1000);
        Thread.sleep(4000);
        ReusableMethods.tiklamaMethodu(800,1000,1000);
        Thread.sleep(4000);
        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        ReusableMethods.tiklamaMethodu(400,900,1000);
        if (!driver.isKeyboardShown()){
            kiwiPage.textBox.sendKeys("ADANA");
        }else {
            driver.getKeyboard().pressKey("ANKARA");
        }
        Thread.sleep(4000);
        ReusableMethods.tiklamaMethodu(250,300,1000);
        Thread.sleep(4000);
        ReusableMethods.tiklamaMethodu(800,1000,1000);
        Thread.sleep(4000);
        // gidis tarihi aralık ayinin 21 i olarak secilir ve set date e tiklanir
        ReusableMethods.tiklamaMethodu(400,1050,1000);
        Thread.sleep(4000);
        ReusableMethods.tiklamaMethodu(687,1108,1000);
        Thread.sleep(4000);
        ReusableMethods.tiklamaMethodu(687,1715,1000);
        Thread.sleep(4000);
        // search butonuna tiklanir
        ReusableMethods.tiklamaMethodu(550,1200,1000);
        Thread.sleep(4000);
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        ReusableMethods.tiklamaMethodu(260,250,1000);
        Thread.sleep(4000);
        ReusableMethods.tiklamaMethodu(1013,573,1000);
        Thread.sleep(4000);
        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        String fiyat = kiwiPage.priceBox.getText();
        Thread.sleep(4000);
        driver.sendSMS("111111111",fiyat);
        Thread.sleep(4000);
        System.out.println(fiyat);


    }
}
