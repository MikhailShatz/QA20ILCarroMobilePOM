package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class SearchPage extends BasePage{
    public SearchPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    MobileElement dots;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title']")
    MobileElement buttonLogin;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLocation']")
    MobileElement fieldLocation;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editFrom']")
    MobileElement fieldFrom;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editTo']")
    MobileElement fieldTo;
    @FindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[2]" +
            "/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    MobileElement buttonLogout;
    @FindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[2]" +
            "/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView]")
    MobileElement buttonReg;
    @FindBy(xpath = "//*[@resourse-id='android:id/prev']")
    MobileElement calendarMonthPrev;
    @FindBy(xpath = "//*[@resourse-id='android:id/next']")
    MobileElement calendarMonthNext;
    @FindBy(xpath = "//*[@resourse-id='android:id/button1']")
    MobileElement calendarButtonOk;

    public SearchPage clickDots(){
        click(dots);
        return this;
    }
    public LoginPage clickLogin(){
        click(buttonLogin);
        return new LoginPage(driver);
    }

    public boolean isElementVisible_Location(){
        return isElementVisible(fieldLocation,5);
    }
    public SearchPage logout(){
        System.out.println("-->"+ buttonLogout.getText());
        click(buttonLogout);
        return this;
    }

    public RegistrationPage clickRegistration(){
        click(buttonReg);
        return new RegistrationPage(driver);
    }

    public SearchPage typeFindCarFrom(String city, String dateFrom, String dateTo){
        type(fieldLocation, city);
        click(fieldFrom);
        typeCalendar(dateFrom);
        return this;
    }

    private SearchPage typeCalendar(String date) {//21/11/2023
        int quantityMonth = 0;
        Month monthEnum = LocalDate.parse(date, DateTimeFormatter.ofPattern("/dd/MM/yyyy")).getMonth();
        System.out.println("month enum -->" + monthEnum.name());
        LocalDate dateNow = LocalDate.now();
        int dayNow = dateNow.getDayOfMonth();
        int monthNow = dateNow.getMonthValue();
        int yearNow = dateNow.getYear();
        String[] dateArr = date.split("/");
        int day = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int year = Integer.parseInt(dateArr[2]);

        click(calendarMonthPrev);
        if (yearNow==year){
            quantityMonth=monthNow-month;
            if (quantityMonth>0){
                for (int i = 0; i<quantityMonth;i++) {
                    click(calendarMonthPrev);
                }
            }else if (quantityMonth<0) {
                for (int i = 0; i < Math.abs(quantityMonth); i++) {
                    click(calendarMonthNext);
                }
            }
        }

        String calendarDate = String.format("//android.view.View[@content-desc='%$ December 2023']",dateArr[0]);
        System.out.println("-->" + calendarDate);
        MobileElement elementDateClick = driver.findElement(By.xpath(calendarDate));
        click(elementDateClick);
        return this;
    }
}
