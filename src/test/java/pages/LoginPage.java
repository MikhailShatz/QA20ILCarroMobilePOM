package pages;

import dto.UserDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLoginEmail']")
    MobileElement fieldEmail;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLoginPassword']")
    MobileElement fieldPassword;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/loginBtn']")
    MobileElement buttonYalla;
    @FindBy(xpath = "//*[@resource-id='android:id/message']")
    MobileElement errorMessage_login_password_incorrect;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement buttonOkErrorMessage;

    public LoginPage typeEmailPassword(UserDTO user){
        type(fieldEmail, user.getEmail());
        type(fieldPassword, user.getPassword());
        return this;
    }

    public SearchPage clickYallaPositive(){
        click(buttonYalla);
        return new SearchPage(driver);
    }
    public SearchPage clickYallaPositiveActions(){
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonYalla,0,-10).click().perform();
        return new SearchPage(driver);
    }

    public LoginPage clickYallaNegativeActions() {
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonYalla,0,-10).click().perform();
        return this;
    }

    public boolean validateErrorMessage() {
        return textInElementPresent(errorMessage_login_password_incorrect,"Login or Password incorrect", 5);
    }

    public boolean validateErrorMessageReg() {
        return textInElementPresent(errorMessage_login_password_incorrect,"Login or Password incorrect", 5);
    }

    public LoginPage clickButtonOkErrorMessage(){
        click(buttonOkErrorMessage);
        return this;
    }
}
