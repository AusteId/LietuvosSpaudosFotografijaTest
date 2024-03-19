
import lt.techin.PageObjects.AccountPage;
import lt.techin.PageObjects.HomePage;
import lt.techin.PageObjects.LoginPage;
import lt.techin.PageObjects.NavigationBar;
import lt.techin.utils.WaitUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    NavigationBar navigationBar;

    @ParameterizedTest
    @CsvFileSource(resources = "/users_DifferentTypes.csv")
    void differentTypesOfUsersCanLoginFromHomePage(String email, String password) throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        navigationBar = new NavigationBar(driver);

        homePage.clickButtonLoginHomePage();
        loginPage.login(email, password);

        Thread.sleep(3000);


        String actualAccountPageHeadlineText = accountPage.getAccountPageHeadline();
        String expectedAccountPageHeadlineText = "Profilis";
        assertThat(actualAccountPageHeadlineText).isEqualTo(expectedAccountPageHeadlineText);

        navigationBar.clickBurger();
        navigationBar.clickLogoutBurger();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/users_DifferentTypes.csv")
    void differentTypesOfUsersCanLoginFromNavBar(String email, String password) throws InterruptedException {
        navigationBar = new NavigationBar(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);

        navigationBar.clickBurger();
        navigationBar.clickLoginBurger();
        loginPage.login(email, password);

        Thread.sleep(3000);

        String actualAccountPageHeadlineText = accountPage.getAccountPageHeadline();
        String expectedAccountPageHeadlineText = "Profilis";
        assertThat(actualAccountPageHeadlineText).isEqualTo(expectedAccountPageHeadlineText);

        navigationBar.clickBurger();
        navigationBar.clickLogoutBurger();
    }
}
