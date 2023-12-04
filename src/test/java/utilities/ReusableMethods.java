package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class ReusableMethods {
    static TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
    public static void tiklamaMetodu(int x , int y,int beklemeSuresiSaniye) throws InterruptedException {

        action.press(PointOption.point(x,y))
                .release()
                .perform();
        Thread.sleep(beklemeSuresiSaniye*1000);
    }

    public static void screenScroolMetodu(){


    }

}
