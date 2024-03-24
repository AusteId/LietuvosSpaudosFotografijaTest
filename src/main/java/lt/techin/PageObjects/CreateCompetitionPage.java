package lt.techin.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateCompetitionPage extends BasePage {

    @FindBy(xpath = "//div[@class='image-header-text card']")
    private WebElement createCompetitionPageHeadline;
    @FindBy(xpath = "//input[@id='name_en']")
    private WebElement titleEN;
    @FindBy(xpath = "//input[@id='name_lt']")
    private WebElement titleLT;
    @FindBy(xpath = "//textarea[@id='description_en']")
    private WebElement descriptionEN;
    @FindBy(xpath = "//textarea[@id='description_lt']")
    private WebElement descriptionLT;
    @FindBy(xpath = "//input[@id='photo_limit']")
    private WebElement photoLimit;
    @FindBy(xpath = "//select[@id='status']")
    private WebElement status;
    @FindBy(xpath = "//select[@id='visibility']")
    private WebElement competitionVisibility;
    @FindBy(xpath = "//input[@id='start_date']")
    private WebElement startDate;
    @FindBy(xpath = "//input[@id='end_date']")
    private WebElement endDate;
    @FindBy(xpath = "//button[text()='Add category']")
    private WebElement buttonAddCategory;
    @FindBy(xpath = "//div[@class='modal-body']//input[1]")
    private WebElement categoryTitle;
    @FindBy(xpath = "//div[@class='modal-body']//select[@class='form-select']")
    private List<WebElement> categoryTypes;
    @FindBy(xpath = "//div[@class='modal-body']//input[@id='photoLimitCat']")
    private WebElement categoryPhotoLimit;
    @FindBy(xpath = "//button[text()='Išsaugoti']")
    private WebElement buttonSaveCompetition;
    @FindBy(xpath = "//div[@class='modal-footer']//button[text()='Taip']")
    private WebElement buttonYesPopup;
    @FindBy(xpath = "//div[@class='modal-content']")
    private WebElement popupMessage;

    public CreateCompetitionPage(WebDriver driver) {
        super(driver);
    }

    public String getCreateCompetitionPageHeadline() {
        return createCompetitionPageHeadline.getText();
    }

    public void setTitleEN(String titleInEN) {
        titleEN.sendKeys(titleInEN);
    }

    public void setTitleLT(String titleInLT) {
        titleLT.sendKeys(titleInLT);
    }

    public void setDescriptionEN(String descriptionInEN) {
        descriptionEN.sendKeys(descriptionInEN);
    }

    public void setDescriptionLT(String descriptionInLT) {
        descriptionLT.sendKeys(descriptionInLT);
    }

    public void setPhotoLimit(String maxNumberOfPhotos) {
        photoLimit.sendKeys(maxNumberOfPhotos);
    }

    public void selectStatus(String neededStatus) {
        new Select(status).selectByVisibleText(neededStatus);
    }

    public void selectVisibilityOfCompetition(String neededVisibilityOfCompetition) {
        new Select(competitionVisibility).selectByVisibleText(neededVisibilityOfCompetition);
    }

    public void setStartDate(String month, String day, String year, String hour, String minutes, String timePeriod) {
        startDate.sendKeys(month, day, year, hour, minutes, timePeriod);
    }

    public void setEndDate(String month, String day, String year, String hour, String minutes, String timePeriod) {
        endDate.sendKeys(month, day, year, hour, minutes, timePeriod);
    }

    public void clickButtonAddCategory() {
        buttonAddCategory.click();
    }

    public void setCategoryTitle(String title) {
        categoryTitle.sendKeys(title);
    }

    public void selectCategoryType(String typeOfCategory) {
        WebElement type = categoryTypes.stream().filter(a -> a.getText().equalsIgnoreCase(typeOfCategory))
                .findFirst().get();
        type.click();
    }

    public void setCategoryPhotoLimit(String numberOfPhotos) {
        categoryPhotoLimit.sendKeys(numberOfPhotos);
    }

    public void clickButtonSaveCompetition() {
        buttonSaveCompetition.click();
    }

    public void clickPopupButtonYes(){
        buttonYesPopup.click();
    }

    public WebElement getPopupMessage() {
        return popupMessage;
    }
}
