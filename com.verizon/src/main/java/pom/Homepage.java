package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BaseClass {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css="a#gnav20-eyebrow-link-Business")
    public WebElement businessPageLink;

    @FindBy (css="button#gnav20-sign-id")
    public WebElement logInDropDownMenuButton;

    @FindBy (css="a#gnav20-sign-id-list-item-1")
    public WebElement signInToMyAccountButton;

    @FindBy (css="button.gnav20-promo-icon")
    public WebElement tradeInPromoButton;

    @FindBy (css="button#gnav20-close-icon")
    public WebElement closeTradeInInformationModalWindowButton;

    @FindBy (xpath="//a[@data-label='Español']")
    public WebElement changeLanguageToSpanishHeaderBtn;

    @FindBy (xpath = "//a[@data-label='English']")
    public WebElement changeLanguageToEnglishHeaderBtn;

    @FindBy (css="img[alt='Feedback']")
    public WebElement feedbackTab;

    @FindBy (css="iframe#kampyleForm1098")
    public WebElement feedbackTabIFrame;

    @FindBy (css="label.rating-label")
    public WebElement feedbackTabRating;

    @FindBy (css="div.neb-website-select.neb-content.neb-wcag.neb-relative.native-arrow>select")
    public WebElement purposeOfVisitDropDownMenu;

    @FindBy (css="button[data-aut='button_Submit']")
    public WebElement submitRatingButton;

    @FindBy (xpath = "//p[text()='Thank You For Providing Feedback']")
    public WebElement thankYouForFeedbackMessage;

    public BusinessPage navigateToBusinessPage() {
        waitForElementToBeClickable(businessPageLink);
        clickOnElement(businessPageLink);
        return new BusinessPage();
    }

    public SignInPage navigateToSignInPage() {
        waitForElementToBeClickable(logInDropDownMenuButton);
        clickOnElement(logInDropDownMenuButton);
        waitForElementToBeClickable(signInToMyAccountButton);
        clickOnElement(signInToMyAccountButton);
        return new SignInPage();
    }

    public void changeLanguageToSpanish() {
        waitForElementToBeClickable(changeLanguageToSpanishHeaderBtn);
        clickOnElement(changeLanguageToSpanishHeaderBtn);
        waitForElementToBeVisible(changeLanguageToEnglishHeaderBtn);

    }

    public void changeLanguageToEnglish() {
        waitForElementToBeClickable(changeLanguageToEnglishHeaderBtn);
        clickOnElement(changeLanguageToEnglishHeaderBtn);
        waitForElementToBeVisible(changeLanguageToSpanishHeaderBtn);

    }

}
