package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    AppiumDriver<MobileElement>driver;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public String getTextElement(MobileElement el){
        return el.getText().toUpperCase().trim();
    }
    public boolean isTextEqual(MobileElement el, String text){
        if(getTextElement(el).equals(text.toUpperCase().trim()))
            return true;
            else{
            System.out.println("text element: " + getTextElement(el) + "not equal text: " + text);
            return false;
        }
    }

    public void pause(int second){
        try {
            Thread.sleep(second*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void click(MobileElement el){
        el.click();
    }

    public void type(MobileElement el, String text){
        el.click();
        el.clear();
        el.sendKeys(text);
    }

   public boolean isElementVisible(MobileElement element, int time){
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception e){
            return false;
        }
   }

   public boolean textInElementPresent(WebElement element, String text, int  time){
       return new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElement(element, text));
   }

   public void clickButtonBack(){
        driver.navigate().back();
   }
}
