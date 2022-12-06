package Applications.BookMyShow.bookMyShowTests;

import Applications.BookMyShow.bookMyShowpages.LoginPage;
import Applications.BookMyShow.bookMyShowpages.ProfilePage;
import base.AppiumConfiguration;
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
