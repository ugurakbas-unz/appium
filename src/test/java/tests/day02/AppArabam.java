package day02;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AppArabam {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        // eğer kullanmış oldugumuz cihazın android sürümü (bizimki 10.0)
        // 6 ya da 6 dan büyükse UiAutomator2 kullanmamız gerekiyor;
        // 6 dan küçükse UiAutomator kullanmamız gerekiyor
        //capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Ugur\\IdeaProjects\\appiumDeneme\\apps\\arabam.com_5.0.6_Apkpure.apk");
        // apk yı daha önce cihaza yüklediğimiz için bu satıra gerek yok
        capabilities.setCapability("appPackage","com.dogan.arabam");
        // appPackage bir uygulamanın kimlik bilgisidir.
        // Biz bu capability sayesinde hangi uygulama üzerinde çalışacagımızı
        // test öncesinde belirtebiliriz.
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        // appActivity uzerinde calisacak oldugumuz uygulamanin
        // hangi sayfa penceresinden baslyacagimizi belirtir.
        //yani biz bu capability sayesinde uygulama icersindeki
        // farkli pencerelerden uygulamayi baslatabiliriz.
        // Bunun icin gerekli activity degerlerine sahip olmamiz gerekir.
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Test
    public void arabamAppTest() throws InterruptedException {

       // driver.activateApp("com.dogan.arabam");
        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));
        // uygulaminin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElement(By.xpath("//*[@text='Alırken, satarken kullanırken']")).isDisplayed());
        // alt menuden ilan ara butonuna tiklanir
        driver.findElement(By.xpath("//*[@text='İlan Ara']")).click();
        // kategori olarak otomobil secilir
        driver.findElement(By.xpath("//*[@text='Otomobil']")).click();
        // arac olarak Volkswagen secilir
        Thread.sleep(2000);
        TouchAction action = new TouchAction<>(driver);
        action.press(PointOption.point(508,1911))
                // press kismi ekranda tiklama kaydirma islemi icin tiklama yapacagimiz ilk nokta
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(70)))
                // baslangic noktasi ile bitis noktasi arasindaki gecen sure
                // eger wait suresi uzun olursa gidilen yol mesafesi daha AZ olacaktir
                // eger ki wait suresi kisa olursa gidilen yol mesafesi daha FAZLA olacaktir
                .moveTo(PointOption.point(508,398))
                // baslangic noktasindan baslayarak gidilecek bitis noktasinin  koordinatlarini ifade eder
                .release()
                // parmagimizi tipki gunluk kullanimdaki gibi ekrandan kaldirma serbest birakma eylemidir
                .perform();
        // verilen action
        // baslangic noktasi ile bitis noktasi arasindaki gecen sure
            // eger wait suresi uzun olursa gidilen yol mesafesi daha AZ olacaktir
            // eger ki wait suresi kisa olursa gidilen yol mesafesi daha FAZLA olacaktir
        // 230,1620
        action.press(PointOption.point(230,1620))
                .release()
                .perform();
        Thread.sleep(1000);
        // arac markasi olarak passat secilir
        driver.findElementByXPath("//*[@text='Passat']").click();
        // 1.4 TSI BlueMotion secilir
        driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();
        // Paket secimi yapilir
        driver.findElementByXPath("//*[@text='Highline']").click();
        Thread.sleep(750);
        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        driver.findElementById("com.dogan.arabam:id/imageViewSorting").click();
        Thread.sleep(500);
        driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();
        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir
        Thread.sleep(1000);
        String aracFiyati=driver.findElementByXPath("//*[@resource-id=\"com.dogan.arabam:id/tvPrice\"]").getText();
        System.out.println(aracFiyati);
        //  aracFiyati=aracFiyati.replaceAll(".","").replaceAll(" TL","");
        aracFiyati=aracFiyati.replaceAll("\\D","");
        // 735000
        //735000
        Assert.assertTrue(Integer.parseInt(aracFiyati)>500000);



    }
}
