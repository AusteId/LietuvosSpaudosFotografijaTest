
import lt.techin.PageObjects.NavigationBar;
import lt.techin.PageObjects.RegisterPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegisterPageTest extends BaseTest {

    RegisterPage registerPage;
    NavigationBar navigationBar;

    @Test
    void userCanRegister() {
        registerPage = new RegisterPage(driver);
        navigationBar = new NavigationBar(driver);

        navigationBar.clickBurger();
        navigationBar.clickRegisterBurger();

        registerPage.setInputName("name");
        registerPage.setInputSurname("surname");
        registerPage.setInputEmail();
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
