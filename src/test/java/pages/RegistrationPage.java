package pages;

import dto.UserDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
    public RegistrationPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resourse-id='com.telran.ilcarro:id/editRegName']")
    MobileElement fieldName;
    @FindBy(xpath = "//*[@resourse-id='com.telran.ilcarro:id/editRegLastName']")
    MobileElement fieldLastName;
    @FindBy(xpath = "//*[@resourse-id='com.telran.ilcarro:id/editRegEmail']")
    MobileElement fieldEmail;
    @FindBy(xpath = "//*[@resourse-id='com.telran.ilcarro:id/editRegPassword']")
    MobileElement fieldPassword;
    @FindBy(xpath = "//*[@resourse-id='com.telran.ilcarro:id/checkBoxAgre']")
    MobileElement checkBoxAgree;
    @FindBy(xpath = "//*[@resourse-id='com.telran.ilcarro:id/regBtn']")
    MobileElement btnYalla;
    @FindBy(xpath = "//*[@resource-id='android:id/message']")
    MobileElement errorMessageReg;

    public RegistrationPage typeRegistrationForm(UserDTO user){
        type(fieldName, user.getName());
        type(fieldLastName, user.getLastName());
        clickButtonBack();
        type(fieldEmail, user.getEmail());
        clickButtonBack();
        type(fieldPassword, user.getPassword());
        clickButtonBack();
        return this;
    }

    public RegistrationPage clickCheckBoxAgree(){
        click(checkBoxAgree);
        return this;
    }

    public SearchPage clickButtonYallaPositive(){
        click(btnYalla);
        return new SearchPage(driver);
    }

    public RegistrationPage clickButtonYallaNegative(){
        click(btnYalla);
        return this;
    }
    public boolean validateErrorMessage() {
        return textInElementPresent(errorMessageReg,"All fields must be filled and agree terms",5);
    }

}
