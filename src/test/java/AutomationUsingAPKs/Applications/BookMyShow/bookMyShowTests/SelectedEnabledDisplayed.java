package AutomationUsingAPKs.Applications.BookMyShow.bookMyShowTests;

import AutomationUsingAPKs.Applications.BookMyShow.bookMyShowpages.LoginPage;
import AutomationUsingAPKs.Applications.BookMyShow.bookMyShowpages.ProfilePage;
import AutomationUsingAPKs.base.AppiumConfiguration;
import org.testng.annotations.Test;

public class SelectedEnabledDisplayed extends AppiumConfiguration {

    @Test
    public void checkSelected() throws InterruptedException {
        LoginPage.clickSkipBtnInSignUp();
        LoginPage.selectCityManuallyOption();
        LoginPage.selectCity("Hyderabad");
        AppiumConfiguration.clickAllowPermission();
        Thread.sleep(5000);
        ProfilePage.gotoProfile();
        ProfilePage.clickAccAndSettingsIfDisplayed();
        ProfilePage.getStatusOfBoxOfficePickupRadioBtn();
    }
}
