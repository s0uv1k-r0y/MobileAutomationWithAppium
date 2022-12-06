package Applications.BookMyShow.bookMyShowTests;

import Applications.BookMyShow.bookMyShowpages.HomePage;
import Applications.BookMyShow.bookMyShowpages.LoginPage;
import base.AppiumConfiguration;
import org.testng.annotations.Test;

public class SearchMovieUsingBasicActions extends AppiumConfiguration {
    @Test
    public void searchMovie() throws InterruptedException {
        LoginPage.clickSkipBtnInSignUp();
        LoginPage.selectCityManuallyOption();
        LoginPage.selectCity("Hyderabad");
        AppiumConfiguration.clickAllowPermission();
        Thread.sleep(5000);
        HomePage.clickSearchButton();
        HomePage.enterSearchText("Avatar");
        HomePage.getSearchResult();
    }
}
