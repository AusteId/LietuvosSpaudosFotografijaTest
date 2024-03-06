package lt.techin;
//Created by E.V

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/h3")
    private WebElement title;
    @FindBy(xpath = "//*[@id=\"dropdown-basic\"]/span")
    private WebElement burger;
    @FindBy(xpath = "//*[@id=\"root\"]/nav/div/div/div/a[3]")
    private WebElement register;
    @FindBy(xpath = "//*[@id=\"root\"]/nav/div/div/div/a[2]")
    private WebElement login;

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
        register.click();
    }

    public void clickOnLogin() {
        login.click();
    }

}
