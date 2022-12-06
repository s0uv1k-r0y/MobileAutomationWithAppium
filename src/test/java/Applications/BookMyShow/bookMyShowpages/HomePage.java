package Applications.BookMyShow.bookMyShowpages;

import base.AppiumConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends AppiumConfiguration {

    public static void clickSearchButton() {
        driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.bt.bms:id/menu_item_container_header_main']//android.widget.ImageView[@resource-id='com.bt.bms:id/imgNotifications'][1]")).click();
    }

    public static void enterSearchText(String searchValue) {
        driver.findElement(By.id("com.bt.bms:id/edtSearch")).sendKeys(searchValue);
    }

    public static void getSearchResult() {
        WebElement parentElement = driver.findElement(By.id("com.bt.bms:id/rvResults"));
        List<WebElement> allSearchElements = parentElement.findElements(By.xpath("*"));
        System.out.println(allSearchElements.size());
    }
}
