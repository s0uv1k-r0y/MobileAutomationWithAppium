package Applications.BookMyShow.bookMyShowpages;

import base.AppiumConfiguration;
import org.openqa.selenium.By;

public class LoginPage extends AppiumConfiguration {

    public static void clickSkipBtnInSignUp() {
        driver.findElement(By.id("com.bt.bms:id/launcher_tv_for_skip")).click();
    }

    public static void selectCityManuallyOption() {
        driver.findElement(By.id("com.bt.bms:id/btn_negative")).click();
    }

    public static void selectCity(String cityName) {
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + cityName + "']")).click();
    }
}
