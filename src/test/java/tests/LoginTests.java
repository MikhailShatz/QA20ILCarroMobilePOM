package tests;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchPage;
import pages.SplashPage;

public class LoginTests extends AppiumConfig {
    boolean flagIsUserLogin = false;
    boolean flagIsErrorDisplayed = false;
    @Test
    public void loginPositiveTest(){
        UserDTO user = UserDTO.builder()
                .email("testqa30@gmail.com")
                .password("123456Aa$")
                .build();
        flagIsUserLogin = true;
       Assert.assertTrue(new SplashPage(driver)
                .goToSearchPage()
                .clickDots()
                .clickLogin()
                .typeEmailPassword(user)
                .clickYallaPositiveActions()
                .isElementVisible_Location());
    }

    @Test
    public void loginNegativeTest(){
        UserDTO user = UserDTO.builder()
                .email("testqa30gmail.com")
                .password("123456Aa$")
                .build();
        flagIsErrorDisplayed = true;
        Assert.assertTrue(new SplashPage(driver)
                .goToSearchPage()
                .clickDots()
                .clickLogin()
                .typeEmailPassword(user)
                .clickYallaNegativeActions()
                .validateErrorMessage());
    }

    @AfterMethod
    public void afterMethod(){
        if(flagIsErrorDisplayed&&!flagIsUserLogin){
            flagIsUserLogin = true;
            flagIsErrorDisplayed =false;
            new LoginPage(driver)
                    .clickButtonOkErrorMessage()
                    .typeEmailPassword(UserDTO.builder()
                            .email("testqa30@gmail.com")
                            .password("123456Aa$")
                            .build())
                    .clickYallaPositiveActions();

        }
        if (flagIsUserLogin) {
            new SearchPage(driver).clickDots().logout();
            flagIsUserLogin = false;
            flagIsErrorDisplayed= true;
        }
    }
}

