import lt.techin.PageObjects.*;
import lt.techin.utils.WaitUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CompetitionManagementTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    NavigationBar navigationBar;
    CreateCompetitionPage createCompetitionPage;
    CompetitionManagementPage competitionManagementPage;
    WaitUtils waitUtils;

    @Test
    void adminCanCreateCompetition() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        navigationBar = new NavigationBar(driver);
        createCompetitionPage = new CreateCompetitionPage(driver);
        competitionManagementPage = new CompetitionManagementPage(driver);
        waitUtils = new WaitUtils();
        String competitionTitleLT = "Geriausia mano nuotrauka";

        homePage.clickButtonLoginHomePage();
        loginPage.login("admin@mail.com", "qweQWE123!");
        navigationBar.clickBurger();
        waitUtils.waitForElementToAppear(navigationBar.getBurgerDropdownWebElement(), driver);
        navigationBar.clickManageCompetitions();
        competitionManagementPage.clickButtonCreateCompetition();

        String actualCreateCompetitionPageHeadline = createCompetitionPage.getCreateCompetitionPageHeadline();
        String expectedCreateCompetitionPageHeadline = "Sukurti konkursą";
        assertThat(actualCreateCompetitionPageHeadline).isEqualTo(expectedCreateCompetitionPageHeadline);

        createCompetitionPage.setTitleEN("The best I have");
        createCompetitionPage.setTitleLT(competitionTitleLT);
        createCompetitionPage.setDescriptionEN("Description");
        createCompetitionPage.setDescriptionLT("Apie");
        createCompetitionPage.setPhotoLimit("5");
        createCompetitionPage.selectStatus("Vyksta");
        createCompetitionPage.selectVisibilityOfCompetition("matomas");
        createCompetitionPage.setStartDate("07", "10", "202400", "07", "00", "AM");
        createCompetitionPage.setEndDate("08", "10", "202400", "07", "00", "AM");
        createCompetitionPage.clickButtonSaveCompetition();
        waitUtils.waitForElementToAppear(createCompetitionPage.getPopupMessage(), driver);
        createCompetitionPage.clickPopupButtonYes();

        assertThat(competitionManagementPage.isCompetition(competitionTitleLT));
    }
}
