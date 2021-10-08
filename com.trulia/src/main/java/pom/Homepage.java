package pom;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BaseClass {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css="button[data-testid='tab-button-buy']")
    public WebElement buyBtn;

    @FindBy (css="button[data-testid='tab-button-rent']")
    public WebElement rentBtn;

    @FindBy (css="button[data-testid='tab-button-sold']")
    public WebElement soldBtn;

    @FindBy (css="input#banner-search")
    public WebElement searchBarComboBox;

    @FindBy (css="li[id='react-autowhatever-home-banner-section-0-item-0']>div")
    public WebElement comboBoxResults;

    @FindBy (xpath="//input[@id='banner-search']//parent::div/div[@aria-label='submit search']")
    public WebElement searchBtn;

    public Homepage clearSearchBar() {
        waitForElementToBeClickable(searchBarComboBox);
        clickOnElement(searchBarComboBox);
        searchBarComboBox.sendKeys(Keys.BACK_SPACE);
        return new Homepage();
    }

    public Homepage clickOnBuyTab() {
        waitForElementToBeClickable(buyBtn);
        clickOnElement(buyBtn);
        waitForElementToBeClickable(searchBarComboBox);
        return new Homepage();
    }

    public Homepage clickOnRentTab() {
        waitForElementToBeClickable(rentBtn);
        clickOnElement(rentBtn);
        waitForElementToBeClickable(searchBarComboBox);
        return new Homepage();
    }

    public Homepage clickOnSoldTab() {
        waitForElementToBeClickable(soldBtn);
        clickOnElement(soldBtn);
        waitForElementToBeClickable(searchBarComboBox);
        return new Homepage();
    }

    public Homepage sendKeysToSearchBarComboBox(String keys) {
        waitForElementToBeClickable(searchBarComboBox);
        sendKeysToInput(searchBarComboBox, keys);
        waitForElementToBeVisible(comboBoxResults);
        return new Homepage();
    }

    public ResultsPage selectResultFromComboBox(int index) {
        waitForElementToBeClickable(driver.findElement(By.cssSelector("li[id='react-autowhatever-home-banner-section-0-item-" + index + "']>div")));
        clickOnElement(driver.findElement(By.cssSelector("li[id='react-autowhatever-home-banner-section-0-item-" + index + "']>div")));
        waitForElementToBeVisible(driver.findElement(By.cssSelector("div#resultsColumn")));
        return new ResultsPage();
    }


}
