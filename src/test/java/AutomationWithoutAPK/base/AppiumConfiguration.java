package AutomationWithoutAPK.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.ITestOrConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class AppiumConfiguration {

    public static final String PROPERTIES_FILEPATH = System.getProperty("user.dir") + "\\src\\test\\java\\AutomationWithoutAPK\\resources\\youtube.properties";
    public static AppiumDriver driver;
    Properties properties;


    @BeforeMethod
    public void initAppium() throws IOException {
        loadPropertyFile(PROPERTIES_FILEPATH);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "P6Pro");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        desiredCapabilities.setCapability("appPackage", getPackageName("packageName"));
        desiredCapabilities.setCapability("appActivity", getActivityName("activityName"));
//        desiredCapabilities.setCapability("avd", "P6Pro");
//        desiredCapabilities.setCapability("avdLaunchTimeout", "300000");
//        desiredCapabilities.setCapability("readyTimeout", "30000");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        desiredCapabilities.setCapability("autoGrantPermissions", true);
//        desiredCapabilities.setCapability("appWaitActivity", "com.google.android.youtube.HomeActivity");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (driver != null)
            driver.quit();
    }

    public void loadPropertyFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        properties = new Properties();
        properties.load(fileInputStream);
    }

    public String getPackageName(String propertyKey) {
        return properties.getProperty(propertyKey);
    }

    public String getActivityName(String propertyKey) {
        return properties.getProperty(propertyKey);
    }


    public static String getScreenshotPath(String screenshotName, AppiumDriver driver) {
        String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "//Reports//Error//" + screenshotName + "_" + date + ".png";
        File destinationLocation = new File(destination);

        try {
            FileUtils.copyFile(source, destinationLocation.getAbsoluteFile());
        } catch (IOException e) {
            System.out.println("Capture failed" + e.getMessage());
        }
        return destination;
    }

}
