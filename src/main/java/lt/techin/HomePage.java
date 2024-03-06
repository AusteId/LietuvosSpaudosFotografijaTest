package lt.techin;
//Created by E.V

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//div[contains(@class, 'image-header-text')]/h3")
    private WebElement title;
    @FindBy(xpath = "//span[@class='navbar-toggler-icon']")
    private WebElement burger;
    @FindBy(xpath = "//a[@href='/registration']")
    private WebElement registerBurger;
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginBurger;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public void clickOnBurger() {
        burger.click();
    }

    public void clickOnRegister() {
        registerBurger.click();
    }

    public void clickOnLogin() {
        loginBurger.click();
    }

}
