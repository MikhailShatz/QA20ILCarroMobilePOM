package tests;

import config.AppiumConfig;
import org.testng.annotations.Test;
import pages.SplashPage;

public class SearchTests extends AppiumConfig {
    @Test
    public void searchPositiveTest(){
        new SplashPage(driver)
                .goToSearchPage()
                .typeFindCarFrom("Haifa", "21/11/2023", "22/11/2023");
    }
}
