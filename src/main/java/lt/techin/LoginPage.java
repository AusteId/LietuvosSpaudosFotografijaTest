package lt.techin;
//Created by E.V
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"dropdown-basic\"]/span")
    private WebElement burger;
    @FindBy(xpath = "//*[@id=\"root\"]/nav/div/div/div/a[2]")
    private WebElement login;
    @FindBy(xpath = "//*[@id=\"formGroupEmail\"]")
    private WebElement email;
    @FindBy(xpath = "//*[@id=\"formGroupPassword\"]")
    private WebElement password;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/form/div[4]/div/div[1]/button")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/h3")
    private WebElement profilePage;

    public void clickOnBurger() {
        burger.click();
    }

    public void clickOnLogin() {
        login.click();
    }

    public void inputEmail(String email1) {
        email.sendKeys(email1);
    }

    public void inputPassword(String password1) {
        password.sendKeys(password1);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public String profilePageTitle() {
       return profilePage.getText();

    }
    public void waiterForProfile(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(3, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/h3")));
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
