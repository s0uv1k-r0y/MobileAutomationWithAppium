package AppiumTests;

import base.AppiumConfiguration;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestCalculator extends AppiumConfiguration {


    @Test(enabled = true)
    public void calculator() throws MalformedURLException, InterruptedException {
        File appDir = new File("C:\\Users\\v1nz\\WorkSpace\\IBM-FST Training\\Training & Assignments\\MobileAutomationUsingAppium\\src\\test\\java\\resources\\calculator.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "P6Pro");
        // caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability("app", appDir.getAbsolutePath());
//        desiredCapabilities.setCapability("appPackage", "ccm.aptoide.pt");
//        desiredCapabilities.setCapability("appActivity", "cm.aptoide.pt.view.MainActivity");

//        desiredCapabilities.setCapability("autoGrantPermissions", true);
//        desiredCapabilities.setCapability("appWaitActivity", "cm.aptoide.pt.view.MainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

//        driver.findElement(By.id("com.ril.ajio:id/llpsTvSearch")).click();
//        WebElement searchField = driver.findElement(By.id("com.ril.ajio:id/searchETV"));
//        searchField.sendKeys("Shirt");
//        WebElement searchButton = driver.findElement(By.id("com.ril.ajio:id/search_image"));
//        searchButton.click();
        Thread.sleep(10000);
    }
}
