package tests;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashPage;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {
    @Test
    public void registrationPositive(){
        int i = new Random().nextInt(1000);
        UserDTO user = UserDTO.builder()
                .name("Billy")
                .lastName("Herrington")
                .email("GymBoss"+i+"@gmail.com")
                .password("123456Aa$")
                .build();
        //flagIsUserLogin = true;
        Assert.assertTrue(new SplashPage(driver)
                .goToSearchPage()
                .clickDots()
                .clickRegistration()
                .typeRegistrationForm(user)
                .clickCheckBoxAgree()
                .clickButtonYallaPositive()
                .isElementVisible_Location());
    }
}
