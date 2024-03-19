package lt.techin.utils;

import lt.techin.PageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//public class WaitUtils extends BasePage {
public class WaitUtils {

    WebDriverWait wait;

    public void waitForElementToAppear(WebElement findBy, WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }
}
