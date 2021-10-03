package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusinessPage extends BaseClass {

    public BusinessPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css="div.LPMcontainer.LPMoverlay[role='dialog']")
    public WebElement chatWithUsDialog;

    @FindBy (css="div.lp_header.lpc_maximized-header.lpc_desktop div.lp_header-content-wrapper")
    public WebElement chatWithUsDialogBoxForGrab;

    @FindBy (css=" div.lp_header.lpc_maximized-header.lpc_desktop")
    public WebElement chatWithUsDialogWindowForGrab;

    @FindBy (css="div.lp_maximized.lpmx.lpc_window.lpc_window_maximized.lpc_desktop.lp_floating")
    public WebElement chatWithUsDialogMaximizedWindow;

    @FindBy (css="div.chips-row>button:nth-of-type(1)")
    public WebElement chatWithUsDialogOption1;

    public BusinessPage openChatWithUsDialogBox() {
        waitForElementToBeClickable(chatWithUsDialog);
        clickOnElement(chatWithUsDialog);
        waitForElementToBeVisible(chatWithUsDialogOption1);

        return new BusinessPage();
    }

}
