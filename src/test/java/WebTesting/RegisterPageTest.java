package WebTesting;

import lt.techin.PageObjects.NavigationBar;
import lt.techin.PageObjects.RegisterPage;
import lt.techin.utils.DataGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegisterPageTest extends BaseTest {

    RegisterPage registerPage;
    NavigationBar navigationBar;

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "edge", "firefox"})
    void userCanRegister(String browser) {
        initializeDriver(browser);
        registerPage = new RegisterPage(driver);
        navigationBar = new NavigationBar(driver);

        navigationBar.clickBurger();
        navigationBar.clickRegisterBurger();

        registerPage.setInputName("name");
        registerPage.setInputSurname("surname");
        registerPage.setInputEmail(DataGenerator.addSixLetters() + "@gmail.com");
        registerPage.setInputPassword("Password1@");
        registerPage.setInputConfirmPassword("Password1@");
        registerPage.setInputBirthYear("1999");
        registerPage.setInputPhoneNumber("686 86611");
        registerPage.setCheckboxUserAgreement();
        registerPage.clickButtonRegister();
        registerPage.alertClick();

        String titleLoginPage = "Prisijunkite prie savo paskyros";
        String actualTitleLoginPage = registerPage.loginPageHeadline();

        assertThat(actualTitleLoginPage).isEqualTo(titleLoginPage);
    }
}
