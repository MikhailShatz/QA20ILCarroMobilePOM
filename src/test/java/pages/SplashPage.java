package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SplashPage extends BasePage {
    public SplashPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/versionText']")
    MobileElement versionApp;

    public boolean validateVersionApp(){
        return isTextEqual(versionApp, "Version 1.0.0");
    }

    public SearchPage goToSearchPage(){
        pause(10);
        return new SearchPage(driver);
    }
}
