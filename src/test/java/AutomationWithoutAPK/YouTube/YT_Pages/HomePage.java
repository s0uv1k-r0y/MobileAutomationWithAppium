package AutomationWithoutAPK.YouTube.YT_Pages;

import AutomationWithoutAPK.base.AppiumConfiguration;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;

public class HomePage extends AppiumConfiguration {

    static By permissionAllowButton = By.id("com.android.permissioncontroller:id/permission_allow_button");
    static By accessibilityMessage = By.id("com.google.android.youtube:id/mealbar_message");
    static By dismissButton = By.id("com.google.android.youtube:id/mealbar_dismiss_button");

    static By searchButton = By.xpath("//android.widget.ImageView[@content-desc='Search']");

    static By shortsButton = By.xpath("//android.widget.Button[@content-desc='Shorts']/android.widget.TextView");

    static By searchField = By.id("com.google.android.youtube:id/search_edit_text");

    static AndroidDriver androidDriver = ((AndroidDriver) driver);
    public static void clickAllowPermission() {
        try {
            if (driver.findElement(permissionAllowButton).isDisplayed())
                driver.findElement(permissionAllowButton).click();
        } catch (NullPointerException e) {
            driver.findElement(AppiumBy.accessibilityId("Home")).click();
        }
    }

    public static void dismissAccessibilityPopUp() {
        try {
            if (driver.findElement(accessibilityMessage).isDisplayed())
                driver.findElement(dismissButton).click();
        } catch (NullPointerException e) {

        }
    }

    public static void clickSearchButton() {
        driver.findElement(AppiumBy.accessibilityId("Home")).click();
        driver.findElement(searchButton).click();
    }

    public static void clickShortsButton() {
        driver.findElement(AppiumBy.accessibilityId("Home")).click();
        driver.findElement(shortsButton).click();
    }

    public static void enterTextInSearchField(String text) {
        driver.findElement(searchField).sendKeys(text);
        androidDriver.hideKeyboard();
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public static void scrollIntoElementView(String text) {
        //use when scroll is known prior - using androidUIAutomator by Google
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));

        //use when no prior idea
//        boolean canScrollMore;
//        int i = 0;
//        do {
//            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of
//                    ("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
//            i++;
//        } while (canScrollMore && i < 15);
    }

    public static void scrollIntoElement() {
        //        driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));

//        RemoteWebElement slider = (RemoteWebElement) driver.findElement(By.id("com.google.android.youtube:id/inline_player_container"));
//        driver.addCommand(HttpMethod.POST, String.format("/session/%s/plugin/actions/swipe", driver.getSessionId()), "swipe");
//        driver.execute("swipe", Map.of("elementId", slider.getId(), "percentage", 50, "direction", "up"));

    }

    public static void clipBoardActions(String text) {
        androidDriver.setClipboardText(text);
        driver.findElement(searchField).sendKeys(androidDriver.getClipboardText());
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public static void rotateDevice() throws InterruptedException {
        DeviceRotation landscape = new DeviceRotation(0,0,90);
        androidDriver.rotate(landscape);
        Thread.sleep(5000);
        DeviceRotation portrait = new DeviceRotation(90,0,0);
        androidDriver.rotate(portrait);

    }

}
