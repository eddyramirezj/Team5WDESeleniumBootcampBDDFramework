package pom;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomeWatch extends BaseClass {

    public HomeWatch() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css="a[href='http://www.espn.com/watch/originals']")
    public WebElement originalsDropMenu;

    @FindBy (xpath="//span[text()='Trailers']/parent::a[@class='AnchorLink AnchorLink--dark Nav__Dropdown__Menu__Link flex items-center ns7 pa3 Nav__Dropdown__Menu__Link--dark']")
    public WebElement trailersOriginalsDropMenu;

    @FindBy (xpath="//a[@data-track-linkid='trailers:row0:Trailers:slot1']")
    public WebElement trailerSlot1;

    @FindBy (css="iframe[allow='autoplay;trust-token-redemption;attribution-reporting;']")
    public WebElement trailerIFrame;

    @FindBy (css="button.vjs-play-control.vjs-control.vjs-button.vjs-paused")
    public WebElement playVideoPlayerButton;

    @FindBy (css="button.vjs-play-control.vjs-control.vjs-button.vjs-playing[tabindex='0']")
    public WebElement stopVideoPlayerButton;

    public HomeWatch navigateToTrailers() {
        waitForElementToBeVisible(originalsDropMenu);
        hoverOverElement(originalsDropMenu);
        waitForElementToBeClickable(trailersOriginalsDropMenu);
        clickOnElement(trailersOriginalsDropMenu);
        return new HomeWatch();
    }

    public HomeWatch selectATrailerFromSlot(int slot) {
        try {
            WebElement trailerSlot = driver.findElement(By.xpath("//a[@data-track-linkid='trailers:row0:Trailers:slot" + slot + "']"));
            waitForElementToBeVisible(trailerSlot);
            clickOnElement(trailerSlot);
        }
        catch (NoSuchElementException e) {
            System.out.println("THE SELECTED TRAILER SLOT DOES NOT EXIST");
        }
        return new HomeWatch();
    }

    public HomeWatch clickOnPlayVideoPlayerButton() {
        waitForElementToBeClickable(playVideoPlayerButton);
        clickOnElement(playVideoPlayerButton);
        return new HomeWatch();
    }

    public HomeWatch clickOnStopVideoPlayerButton() {
        waitForElementToBeClickable(stopVideoPlayerButton);
        clickOnElement(stopVideoPlayerButton);
        return new HomeWatch();
    }
}
