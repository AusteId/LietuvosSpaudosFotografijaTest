package lt.techin.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='formGroupEmail']")
    private WebElement inputEmail;
    @FindBy(xpath = "//input[@id='formGroupPassword']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@class='container']/h3")
    private WebElement accountPageHeadline;
    @FindBy(xpath = "//p")
    private WebElement errorMessageWrongCredentials;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setInputEmail(String email1) {
        inputEmail.sendKeys(email1);
    }

    public void setInputPassword(String password1) {
        inputPassword.sendKeys(password1);
    }

    public void clickButtonLogin() {
        loginButton.click();
    }

    public String profilePageTitle() {
        return accountPageHeadline.getText();

    }
    public void waiterForProfile(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(3, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/h3")));
    }

    public void login(String email, String password) {
        setInputEmail(email);
        setInputPassword(password);
        clickButtonLogin();
    }

    public String getErrorMessageWrongCredentials() {
        return errorMessageWrongCredentials.getText();
    }

    public WebElement getErrorMessageWrongCredentialsWebElement() {
        return errorMessageWrongCredentials;
    }
}
