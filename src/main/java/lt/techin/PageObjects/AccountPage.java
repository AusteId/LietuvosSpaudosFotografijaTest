package lt.techin.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(xpath = "//h3")
    private WebElement accountPageHeadline;
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountPageHeadline() {
        return accountPageHeadline.getText();
    }

    public WebElement getAccountPageHeadlinewebElement() {
        return accountPageHeadline;
    }
}
