package AutomationWithoutAPK.YouTube;

import AutomationWithoutAPK.YouTube.YT_Pages.HomePage;
import AutomationWithoutAPK.YouTube.YT_Pages.ShortsPage;
import AutomationWithoutAPK.base.AppiumConfiguration;
import AutomationWithoutAPK.base.TestNGListeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)
public class YouTubeTests extends AppiumConfiguration {

    @Test(enabled = true)
    public void searchTextAndScroll() {
        HomePage.clickAllowPermission();
        HomePage.clickSearchButton();
        HomePage.enterTextInSearchField("MKBHD");
        HomePage.scrollIntoElementView("Marques Brownlee");
    }

    @Test(enabled = true)
    public void searchUsingClipboard() {
        HomePage.clickAllowPermission();
        HomePage.clickSearchButton();
        HomePage.clipBoardActions("MKBHD");
        HomePage.scrollIntoElementView("Marques Brownlee");
    }

    @Test(enabled = true)
    public void rotateAction() throws InterruptedException {
        HomePage.clickAllowPermission();
        HomePage.clickSearchButton();
        HomePage.clipBoardActions("MKBHD");
        HomePage.scrollIntoElementView("Marques Brownlee");
        HomePage.rotateDevice();
    }

    @Test(enabled = true)
    public void scrollFewShorts() throws InterruptedException {
        HomePage.clickAllowPermission();
        HomePage.clickShortsButton();
        for (int i = 0; i < 5; i++) {
            ShortsPage.swipeUp();
            Thread.sleep(15000);
        }
    }


}
