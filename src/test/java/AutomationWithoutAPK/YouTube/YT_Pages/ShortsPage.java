package AutomationWithoutAPK.YouTube.YT_Pages;

import AutomationWithoutAPK.base.AppiumConfiguration;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class ShortsPage extends AppiumConfiguration {

    static By searchField = By.id("com.google.android.youtube:id/search_edit_text");


    public static void swipeUp() {
        WebElement element = driver.findElement(By.xpath("(//android.widget.FrameLayout)[1]"));
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of
                ("elementId", ((RemoteWebElement)element).getId(), "direction", "up", "percent", 0.75));

    }
}
