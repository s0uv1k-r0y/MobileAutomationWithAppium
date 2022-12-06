package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumConfiguration {

    File appDir;

    public static AndroidDriver driver;

    public File getAppDir() {
        return appDir;
    }

    public void setAppDirPath(String appDir) {
        this.appDir = new File(appDir);
    }

    @BeforeTest
    public void start() throws MalformedURLException {
        appDir = new File("C:\\Users\\v1nz\\WorkSpace\\IBM-FST Training\\Training & Assignments\\MobileAutomationUsingAppium\\src\\test\\java\\resources\\book-my-show.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "P6Pro");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, appDir.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public static void clickAllowPermission() {
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
    }
}
