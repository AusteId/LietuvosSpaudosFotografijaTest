package lt.techin.PageObjects;

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
    @FindBy(xpath = "//a[text()='Atsijungti']")
    private WebElement logoutBurger;
    @FindBy(xpath = "//a[@href='/admin-competitions-list']")
    private WebElement manageCompetitions;
    @FindBy(xpath = "//div[contains(@class, 'dropdown-menu')]")
    private WebElement burgerDropdownMenu;

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

    public void clickLogoutBurger() {
        logoutBurger.click();
    }

    public void clickManageCompetitions() {
        manageCompetitions.click();
    }

    public void clickburger() {
        burger.click();
    }

    public WebElement getBurgerDropdownWebElement() {
        return burgerDropdownMenu;
    }
}
