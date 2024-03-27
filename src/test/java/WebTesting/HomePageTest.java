package WebTesting;

import lt.techin.PageObjects.HomePage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HomePageTest extends BaseTest {
    HomePage homePage;

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "edge", "firefox"})
    void yourTitleIsVisible(String browser) {
        initializeDriver(browser);
        homePage = new HomePage(driver);
        String expectedTitle = "PRAEITŲ KONKURSŲ NUGALĖTOJAI";
        String actualTitle = homePage.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
}



