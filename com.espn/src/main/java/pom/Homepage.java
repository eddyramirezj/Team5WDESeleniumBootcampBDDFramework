package pom;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy (xpath="//div[@class='scores-carousel']//div[@class='cscore_channels icon-font-before icon-play-arrow-solid-before']/span")
    public WebElement channelsOnScoreboard;

    @FindBy (xpath="//div[@class='scores-carousel']")
    public WebElement scoreboardCarousel;

    @FindBy (css="div.PageFooter__Footer a[href='https://disneytermsofuse.com/english/']")
    public WebElement footerTermsOfServiceLink;

    public HomeWatch navigateToHomeWatch() {
        waitForElementToBeClickable(watchDropMenuButton);
        clickOnElement(watchDropMenuButton);
        waitForElementToBeVisible(homeWatchDropMenuButton);
        clickOnElement(homeWatchDropMenuButton);
        return new HomeWatch();
    }

    public void channelsShownOnScoreboard() {
        List<WebElement> channelsShown = channelsOnScoreboard.findElements(By.xpath(getByLocatorChannelsOnScoreboard()));
        System.out.println("The amount of channels shown on the scoreboard is: " + channelsShown.size());
        System.out.println("The following channels are available: ");

        for (int i = 0; i < channelsShown.size(); i++) {
            System.out.println(channelsShown.get(i).getText());

        }

    }

    public boolean checkIfChannelIsShownOnScoreboard(String channel) {
        boolean flag = false;

        List<WebElement> channelsShown = channelsOnScoreboard.findElements(By.xpath(getByLocatorChannelsOnScoreboard()));

        for (int i = 0; i < channelsShown.size(); i++) {
            if (channel.equalsIgnoreCase(channelsShown.get(i).getText())){
                flag = true;
            };

        }
        return flag;

        }

    public TermsOfUse navigateToTermsOfUsePage() {
        waitForElementToBeClickable(footerTermsOfServiceLink);
        clickOnElement(footerTermsOfServiceLink);
        return new TermsOfUse();
    }

    private String getByLocatorChannelsOnScoreboard() {
        return "//div[@class='scores-carousel']//div[@class='cscore_channels icon-font-before icon-play-arrow-solid-before']/span";
    }

}
