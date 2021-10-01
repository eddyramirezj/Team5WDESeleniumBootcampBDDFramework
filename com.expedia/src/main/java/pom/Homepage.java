package pom;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BaseClass {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css="a[href='https://www.expedia.com/']")
    public WebElement expediaButton;

    @FindBy(css = "input#add-flight-switch")
    public WebElement addAFlightCheckBox;

    @FindBy(css = "input#add-car-switch")
    public WebElement addACarCheckBox;

    @FindBy(css = "button.uitk-faux-input[data-stid='location-field-destination-menu-trigger']")
    public WebElement goingToComboBox;

    @FindBy(css="li[data-index='0']>button[data-stid='location-field-destination-result-item-button']")
    public WebElement locationResultItemButton1;

    public Homepage navigateToHomepageWithExpediaTopButton() {
        clickOnElement(expediaButton);
        return new Homepage();

    }
    public Homepage selectADestinationOnGoingToBox(String destination) {
        waitForElementToBeClickable(goingToComboBox);
        clickOnElement(goingToComboBox);

        for (int i = 0; i <= 7; i++) {
            WebElement selection = driver.findElement(By.cssSelector("li[data-index='" + i + "']>button[data-stid='location-field-destination-result-item-button']"));
            waitForElementToBeVisible(selection);
            if (destination.equalsIgnoreCase(selection.getText())); {
                clickOnElement(selection);
            }

        }
        return new Homepage();
    }
}
