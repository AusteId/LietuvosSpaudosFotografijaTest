package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends BasePage {

    @FindBy(xpath = "//span[@class='navbar-toggler-icon']")
    private WebElement burger;
    @FindBy(xpath = "//a[@href='/registration']")
    private WebElement registerBurger;
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginBurger;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void clickBurger() {
        burger.click();
    }

    public void clickRegisterBurger() {
        registerBurger.click();
    }

    public void clickLoginBurger() {
        loginBurger.click();
    }
}
