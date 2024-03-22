package lt.techin.PageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class RegisterPage extends BasePage {
    @FindBy(xpath = "//input[@id='name']")
    private WebElement inputName;
    @FindBy(xpath = "//input[@id='surname']")
    private WebElement inputSurname;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//input[@id='confirm_password']")
    private WebElement inputConfirmPassword;
    @FindBy(xpath = "//input[@id='birth_year']")
    private WebElement inputBirthYear;
    @FindBy(xpath = "//input[@id='phone_number']")
    private WebElement inputPhoneNumber;
    @FindBy(xpath = "//input[@id='user_agreement']")
    private WebElement checkBoxUserAgreement;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonRegister;
    @FindBy(xpath = "//div[@class='my-5 card']/h2")
    private WebElement loginPageHeadline;
    @FindBy(xpath = "//button[text()=\"Tęsti\"]")
    private WebElement acceptModalButton;
    @FindBy(xpath = "//div[@class='modal-footer']")
    private WebElement visibilityOfModalFooter;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void setInputName(String name) {
        inputName.sendKeys(name);
    }

    public void setInputSurname(String surname) {
        inputSurname.sendKeys(surname);
    }

    public void setInputEmail() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10000);
        inputEmail.sendKeys("username" + randomInt + "@gmail.com");
    }

    public void setInputPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void setInputConfirmPassword(String confirmPassword) {
        inputConfirmPassword.sendKeys(confirmPassword);
    }

    public void setInputBirthYear(String birthYear) {
        inputBirthYear.sendKeys(birthYear);
    }

    public void setInputPhoneNumber(String phoneNumber) {
        inputPhoneNumber.sendKeys(phoneNumber);
    }

    public void setCheckboxUserAgreement() {
        checkBoxUserAgreement.click();
    }

    public void clickButtonRegister() {
        buttonRegister.click();
    }

    public String loginPageHeadline() {
        return loginPageHeadline.getText();
    }

    public void alertClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOf(visibilityOfModalFooter));
        acceptModalButton.click();
    }
}
