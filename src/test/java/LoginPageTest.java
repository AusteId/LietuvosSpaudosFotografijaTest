
 import lt.techin.LoginPage;
 import lt.techin.NavigationBar;
 import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginPageTest extends BaseTest {

    LoginPage loginPage;
    NavigationBar navigationBar;

    @Test
    void userCanLogin() {
        loginPage = new LoginPage(driver);
        navigationBar = new NavigationBar(driver);

        navigationBar.clickBurger();
        navigationBar.clickLoginBurger();

        loginPage.setInputEmail("userE@user.com");
        loginPage.setInputPassword("Qwerty12");
        loginPage.clickButtonLogin();
        loginPage.waiterForProfile();

        String titleProfilePage = "Profilis";
        String actualTitleProfilePage = loginPage.profilePageTitle();
        assertThat(actualTitleProfilePage).isEqualTo(titleProfilePage);
    }
}
