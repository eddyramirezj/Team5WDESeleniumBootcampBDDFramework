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

    @FindBy (css="a[href='http://www.espn.com/watch/']")
    public WebElement watchDropMenuButton;

    @FindBy (css="a[name='&lpos=sitenavdefault+watch+index']")
    public WebElement homeWatchDropMenuButton;

    @FindBy (css = "a#global-user-trigger")
    public WebElement dropDownMenuLoginButton;

    @FindBy (css = "//ul[@class='tools focused']//a[@tref='/members/v3_1/login']")
    public WebElement loginButton;

    public HomeWatch navigateToHomeWatch() {
        waitForElementToBeClickable(watchDropMenuButton);
        clickOnElement(watchDropMenuButton);
        waitForElementToBeVisible(homeWatchDropMenuButton);
        clickOnElement(homeWatchDropMenuButton);
        return new HomeWatch();
    }



}
