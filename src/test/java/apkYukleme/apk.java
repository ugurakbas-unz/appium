package apkYukleme;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class apk {
    AndroidDriver<AndroidElement> driver;

    @Test
    public void app() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        // eğer kullanmış oldugumuz cihazın android sürümü (bizimki 10.0)
        // 6 ya da 6 dan büyükse UiAutomator2 kullanmamız gerekiyor;
        // 6 dan küçükse UiAutomator kullanmamız gerekiyor
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Ugur\\IdeaProjects\\appiumDeneme\\apps\\Kiwi.com - Book Cheap Flights_2023.14.0_Apkpure (1).apk"); // bu satıra apk yolu yazılır
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}