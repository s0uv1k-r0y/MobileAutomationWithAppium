package AutomationUsingAPKs.Applications.BookMyShow.bookMyShowpages;

import AutomationUsingAPKs.base.AppiumConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProfilePage extends AppiumConfiguration {

    public static void gotoProfile() {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Profile']")).click();
    }

    public static void clickAccAndSettingsIfDisplayed() {
        WebElement accAndSettings = driver.findElement(By.xpath("//android.widget.TextView[@text='Accounts & Settings']"));
        if (accAndSettings.isDisplayed()) {
            System.out.println("Accounts & Settings is Displayed");
            accAndSettings.click();
        }
    }

    public static void getStatusOfBoxOfficePickupRadioBtn() {
        boolean status = driver.findElement(By.xpath("(//android.widget.RadioButton[@index='1'])[2]")).isSelected();
        System.out.println(status);
    }
}
