package pom;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;

public class ResultsPage extends BaseClass {

    public ResultsPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy (xpath="//h2[contains(text(), 'homes available on Trulia')]")
    public WebElement housesForSaleResultCount;

    @FindBy (xpath="//h2[contains(text(), ' rentals available on Trulia')]")
    public WebElement dwellingsForRentCount;

    @FindBy (xpath="//h2[contains(text(), 'sold homes on Trulia')]")
    public WebElement housesSoldCount;

    @FindBy (css="button[data-testid='srp-xxl-bedrooms-filter-button'][aria-expanded='false']")
    public WebElement numOfBedRoomsDropMenu;

    @FindBy (css="button[data-testid='srp-xxl-bedrooms-filter-button'][aria-expanded='true']")
    public WebElement numOfBedRoomsDropMenuExpanded;

    @FindBy (xpath="//div[@aria-label='number of bedrooms']/button[text()='Studio+']")
    public WebElement selectStudioFilter;

    @FindBy (xpath="//div[@aria-label='number of bedrooms']/button[text()='1+']")
    public WebElement select1BedsFilter;

    @FindBy (xpath="//div[@aria-label='number of bedrooms']/button[text()='2+']")
    public WebElement select2BedsFilter;

    @FindBy (xpath="//div[@aria-label='number of bedrooms']/button[text()='3+']")
    public WebElement select3BedsFilter;

    @FindBy (xpath="//div[@aria-label='number of bedrooms']/button[text()='4+']")
    public WebElement select4BedsFilter;

    @FindBy (xpath="//div[@aria-label='number of bedrooms']/button[text()='Studio+'][@aria-pressed='true']")
    public WebElement filterStudioBedsSelected;

    @FindBy (xpath="//div[@aria-label='number of bedrooms']/button[text()='1+'][@aria-pressed='true']")
    public WebElement filter1BedsSelected;

    @FindBy (xpath="//div[@aria-label='number of bedrooms']/button[text()='2+'][@aria-pressed='true']")
    public WebElement filter2BedsSelected;

    @FindBy (xpath="//div[@aria-label='number of bedrooms']/button[text()='3+'][@aria-pressed='true']")
    public WebElement filter3BedsSelected;

    @FindBy (xpath="//div[@aria-label='number of bedrooms']/button[text()='4+'][@aria-pressed='true']")
    public WebElement filter4BedsSelected;

    public ResultsPage selectNumOfBedrooms(int numOfBeds) throws InterruptedException, AWTException {
        Robot robot = new Robot();
        waitForElementToBeClickable(numOfBedRoomsDropMenu);
        clickOnElement(numOfBedRoomsDropMenu);
        waitForElementToBeVisible(numOfBedRoomsDropMenuExpanded);
        WebElement filter = selectNumOfBeds(numOfBeds);
        waitForElementToBeClickable(filter);
        clickOnElement(filter);
        WebElement selected = selectNumOfBeds(numOfBeds);
        waitForElementToBeVisible(selected);
        robot.delay(1500);
        waitForElementToBeVisible(housesForSaleResultCount);
        return new ResultsPage();
    }

    private WebElement selectNumOfBeds(int number) {
        WebElement filter;
        switch (number) {
            case 0 : filter = selectStudioFilter;
                break;

            case 1 : filter = select1BedsFilter;
                break;

            case 2 : filter = select2BedsFilter;
                break;

            case 3 : filter = select3BedsFilter;
                break;

            case 4 : filter = select4BedsFilter;
                break;

            default : filter = selectStudioFilter;
        }
        return filter;

    }

    private WebElement selectedNumOfBeds(int number) {
        WebElement filter;
        switch (number) {
            case 0 : filter = filterStudioBedsSelected;
                break;

            case 1 : filter = filter1BedsSelected;
                break;

            case 2 : filter = filter2BedsSelected;
                break;

            case 3 : filter = filter3BedsSelected;
                break;

            case 4 : filter = filter4BedsSelected;
                break;

            default : filter = filterStudioBedsSelected;
        }
        return filter;

    }

}
