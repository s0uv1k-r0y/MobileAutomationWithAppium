package AppiumTests;

import base.AppiumConfiguration;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class TestBookMyShow extends AppiumConfiguration {

    @Test(enabled = true)
    public void bookMyShow() throws MalformedURLException, InterruptedException {
        File appDir = new File("C:\\Users\\v1nz\\WorkSpace\\IBM-FST Training\\Training & Assignments\\MobileAutomationUsingAppium\\src\\test\\java\\resources\\book-my-show.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "P6Pro");
        // caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability("app", appDir.getAbsolutePath());

//        desiredCapabilities.setCapability("autoGrantPermissions", true);
//        desiredCapabilities.setCapability("appWaitActivity", "com.ril.ajio.home.AjioHomeActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

//        WebElement foo = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(driver -> driver.findElement(By.id("com.bt.bms:id/launcher_tv_for_skip")));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.id("com.bt.bms:id/launcher_tv_for_skip")).click();
        driver.findElement(By.id("com.bt.bms:id/btn_negative")).click();

        driver.findElement(By.xpath("//android.widget.TextView[@text='Hyderabad']")).click();
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.bt.bms:id/menu_item_container_header_main']//android.widget.ImageView[@resource-id='com.bt.bms:id/imgNotifications'][1]")).click();
        driver.findElement(By.id("com.bt.bms:id/edtSearch")).sendKeys("Avatar");

        WebElement parentElement = driver.findElement(By.id("com.bt.bms:id/rvResults"));
        List<WebElement> allSearchElements = driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@id='com.bt.bms:id/rvResults']/*"));
        System.out.println(allSearchElements.size());

    }

}