package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InterestBaseAdsPage extends BaseClass {

    public InterestBaseAdsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="input[type='checkbox']#gwt-debug-preferencetable_selectall-input")
    public WebElement selectAllCheckbox;

    @FindBy(css="input[type='checkbox'][checked]")
    public WebElement allAvailableCheckboxesSelected;

    public void clickOnSelectAllCheckbox() {
        waitForElementToBeClickable(selectAllCheckbox);
        clickOnElement(selectAllCheckbox);
        webDriverWait.until(ExpectedConditions.visibilityOf(allAvailableCheckboxesSelected));
    }



}
