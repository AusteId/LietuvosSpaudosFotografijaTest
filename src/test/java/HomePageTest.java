
import lt.techin.PageObjects.HomePage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HomePageTest extends BaseTest {
    HomePage homePage;

    @Test
    void yourTitleIsVisible() {
        homePage = new HomePage(driver);
        String expectedTitle = "PRAEITŲ KONKURSŲ NUGALĖTOJAI";
        String actualTitle = homePage.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
}



