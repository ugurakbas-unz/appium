package kurulumTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.TimeUnit;
public class Test01 {

    AndroidDriver<MobileElement> driver;

    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\Ugur\\IdeaProjects\\appiumDeneme\\apps\\Calculator_8.4.1 (520193683)_Apkpure.apk");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // kullanici gerekli kurulumlari yapar
        //    (yukarısı)

        // uygulamanin yuklendigini dogrular(isInstalled)
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));
        // uygulamanin acildigini dogrular
        Assert.assertTrue(driver.findElementByAccessibilityId("2").isDisplayed());
        // 100 un 5 katininin 500 oldugunu hesap makinasindan dogrulayalim
        driver.findElementByAccessibilityId("1").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("5").click();

        String sonuckutusu = driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        Assert.assertEquals(Integer.parseInt(sonuckutusu),500);
        }
    }

