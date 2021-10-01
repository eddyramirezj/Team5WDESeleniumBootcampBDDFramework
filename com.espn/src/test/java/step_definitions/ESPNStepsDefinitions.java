package step_definitions;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pom.HomeWatch;
import pom.Homepage;


public class ESPNStepsDefinitions extends BaseClass {

    SharedStepsUI sharedStepsUI;
    Homepage homepage;
    HomeWatch homeWatch;


    public ESPNStepsDefinitions() {
        sharedStepsUI = new SharedStepsUI();
        homepage = new Homepage();
        homeWatch = new HomeWatch();
    }

    // STEPS DEFINITIONS GO IN HERE (i.e. A METHOD FOR EACH STEP OF THE SCENARIO)

    @Given("user is at homepage")
    public void userIsAtHomepage() {
    }

    @When("user navigates to the watch page")
    public void userNavigatesToTheWatchPage() {
        homepage.navigateToHomeWatch();
    }

    @And("user navigates to the trailers section")
    public void userNavigatesToTheTrailersSection() {
        homeWatch.navigateToTrailers();
    }

    @And("user selects a trailer slot")
    public void userSelectsATrailerSlot() {
        homeWatch.selectATrailerFromSlot(1);

    }

    @Then("user should be taken to the selected trailer embedded media player")
    public void userShouldBeTakenToTheSelectedTrailerEmbeddedMediaPlayer() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        homeWatch.clickOnStopVideoPlayerButton();
        Thread.sleep(4000);
        softAssert.assertTrue(isElementPresent(homeWatch.playVideoPlayerButton));
        homeWatch.clickOnPlayVideoPlayerButton();
        Thread.sleep(4000);
        softAssert.assertTrue(isElementPresent(homeWatch.stopVideoPlayerButton));
        homeWatch.clickOnStopVideoPlayerButton();
        Thread.sleep(4000);

        softAssert.assertAll();

    }


}
