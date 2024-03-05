package lt.techin;
//Created by E.V


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class RegisterPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement inputName;
    @FindBy(xpath = "//*[@id=\"surname\"]")
    private WebElement inputSurname;
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement inputEmail;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement inputPassword;
    @FindBy(xpath = "//*[@id=\"confirm_password\"]")
    private WebElement inputConfirmPassword;
    @FindBy(xpath = "//*[@id=\"birth_year\"]")
    private WebElement inputBirthYear;
    @FindBy(xpath = "//*[@id=\"phone_number\"]")
    private WebElement inputPhoneNumber;
    @FindBy(xpath = "//*[@id=\"user_agreement\"]")
    private WebElement clickTermsOfService;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/form/button")
    private WebElement clickOnRegister;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/h2")
    private WebElement loginPageTitle;


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

    public void setClickTermsOfService() {
        clickTermsOfService.click();
    }

    public void setClickOnRegister() {
        clickOnRegister.click();
    }

    public String titleLoginPage() {
        return loginPageTitle.getText();
    }

    public void alertClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.dismiss();

    }
}
