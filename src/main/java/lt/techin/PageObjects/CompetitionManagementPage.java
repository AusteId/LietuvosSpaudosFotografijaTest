package lt.techin.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CompetitionManagementPage extends BasePage {

    @FindBy(xpath = "//button[text()='Sukurti konkursą']")
    private WebElement buttonCreateCompetition;

    @FindBy(css = "div[class='justify-content-xl-center container'] > div")
    private List<WebElement> competitions;

    public CompetitionManagementPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonCreateCompetition() {
        buttonCreateCompetition.click();
    }

    public boolean isCompetition(String competition) {
        return competitions.stream().anyMatch(a -> a.getText().contains(competition));
    }
}

