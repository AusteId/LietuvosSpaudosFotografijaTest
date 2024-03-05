//Created by E.V
 import lt.techin.HomePage;
import lt.techin.LoginPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;


    @Test
    void userCanLogin() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        homePage.clickOnBurger();
        homePage.clickOnLogin();

        loginPage.inputEmail("userE@user.com");
        loginPage.inputPassword("Qwerty12");
        loginPage.clickOnLoginButton();


        loginPage.waiterForProfile();


        String titleProfilePage = "Profilis";
        String actualTitleProfilePage = loginPage.profilePageTitle();

        assertThat(actualTitleProfilePage).isEqualTo(titleProfilePage);

    }


}
