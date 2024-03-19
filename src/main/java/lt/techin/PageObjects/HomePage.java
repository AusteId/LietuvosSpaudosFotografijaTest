package lt.techin.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//div[contains(@class, 'image-header-text')]/h3")
    private WebElement title;
    @FindBy(xpath = "//button[text()='PRISIJUNGTI']")
    private WebElement buttonLoginHomePage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public void clickButtonLoginHomePage() {
        buttonLoginHomePage.click();
    }

}
