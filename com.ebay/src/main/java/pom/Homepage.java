package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static base.BaseClass.driver;

public class Homepage extends BaseClass {


    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "input.gh-tb.ui-autocomplete-input")
    public WebElement searchBar;

    @FindBy (css = "input.btn.btn-prim.gh-spr")
    public WebElement searchButton;

    public void searchOnSearchBar(String value) {
        waitForElementToBeClickable(searchBar);
        sendKeysToInput(searchBar, value);
        waitForElementToBeClickable(searchButton);
        clickOnElement(searchButton);
    }


}
