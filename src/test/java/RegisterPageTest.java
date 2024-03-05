//Created by E.V

import lt.techin.HomePage;
import lt.techin.RegisterPage;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



public class RegisterPageTest extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;


    @Test
    void userCanRegister() {
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);


        homePage.clickOnBurger();
        homePage.clickOnRegister();

        registerPage.setInputName("name");
        registerPage.setInputSurname("surname");
        registerPage.setInputEmail();
        registerPage.setInputPassword("Password1");
        registerPage.setInputConfirmPassword("Password1");
        registerPage.setInputBirthYear("1999");
        registerPage.setInputPhoneNumber("686 86611");
        registerPage.setClickTermsOfService();
        registerPage.setClickOnRegister();

        registerPage.alertClick();



        String titleLoginPage = "Prisijunkite prie savo paskyros";
        String actualTitleLoginPage = registerPage.titleLoginPage();

       assertThat(actualTitleLoginPage).isEqualTo(titleLoginPage);
    }
}
