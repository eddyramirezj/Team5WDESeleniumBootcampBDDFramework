package step_definitions;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pom.Homepage;
import pom.SignInPage;

import java.util.List;

public class VerizonHomepageStepsDefinitions extends BaseClass {

    SharedStepsUI sharedStepsUI;
    Homepage homepage;


    public VerizonHomepageStepsDefinitions() {
        sharedStepsUI = new SharedStepsUI();
        homepage = new Homepage();

    }

    @When("clicks on tradeIn information button")
    public void clickOnTradeInInformationButton() {
        waitForElementToBeClickable(homepage.tradeInPromoButton);
        homepage.tradeInPromoButton.click();
    }


    @Then("a modal window should appear at the top of the page with the necessary information")
    public void dismissModalWindowForTradeInInformation() throws InterruptedException {

        waitForElementToBeClickable(homepage.closeTradeInInformationModalWindowButton);

        homepage.closeTradeInInformationModalWindowButton.click();

        List<WebElement> modalWindow = driver.findElements(By.cssSelector("div.gnav20-modal[style='display: block;']"));

        Assert.assertEquals(modalWindow.size(), 0);

    }


    @When("clicks on change to Spanish language button")
    public void clicksOnChangeToSpanishLanguageButton() {
        homepage.changeLanguageToSpanish();
    }

    @Then("homepage language should change to Spanish")
    public void homepageLanguageShouldChangeToSpanish() {
        Assert.assertTrue(isElementPresent(homepage.changeLanguageToEnglishHeaderBtn));
    }

    @When("clicks on change to English language button")
    public void clicksOnChangeToEnglishLanguageButton() {
        homepage.changeLanguageToEnglish();
    }

    @Then("homepage language should change to English")
    public void homepageLanguageShouldChangeToEnglish() {
        Assert.assertTrue(isElementPresent(homepage.changeLanguageToSpanishHeaderBtn));
    }

    @When("User clicks on feedback tab")
    public void userClicksOnFeedbackTab() {
        waitForElementToBeClickable(homepage.feedbackTab);
        clickOnElement(homepage.feedbackTab);
        waitForElementToBeVisible(homepage.feedbackTabIFrame);
        driver.switchTo().frame(homepage.feedbackTabIFrame);
    }

    @And("User selects {string} rating number")
    public void userSelectsARatingNumber(String rating) {
        waitForElementToBeVisible(homepage.feedbackTabRating);
        driver.findElement(By.cssSelector("label.rating-label." + rating)).click();

    }

    @And("User selects a purpose of visit option from the menu")
    public void userSelectsAPurposeOfVisitOptionFromTheMenu() {
        waitForElementToBeVisible(homepage.purposeOfVisitDropDownMenu);
        homepage.purposeOfVisitDropDownMenu.click();
        selectDropMenuOptionsByIndex(homepage.purposeOfVisitDropDownMenu, 1);
    }

    @And("User clicks on Submit button")
    public void userClicksOnSubmitButton() {
        waitForElementToBeClickable(homepage.submitRatingButton);
        clickOnElement(homepage.submitRatingButton);

    }

    @Then("message {string} should appear")
    public void messageShouldAppear(String expectedMessage) {
        waitForElementToBeVisible(homepage.thankYouForFeedbackMessage);
        String actualMessage = homepage.thankYouForFeedbackMessage.getText();

        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
