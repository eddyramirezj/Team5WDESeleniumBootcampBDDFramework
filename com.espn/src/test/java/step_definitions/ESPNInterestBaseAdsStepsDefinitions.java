package step_definitions;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pom.Homepage;
import pom.InterestBaseAdsPage;
import pom.TermsOfUse;

public class ESPNInterestBaseAdsStepsDefinitions extends BaseClass {

        SharedStepsUI sharedStepsUI;
        Homepage homepage;
        InterestBaseAdsPage interestBaseAdsPage;


    public ESPNInterestBaseAdsStepsDefinitions() {
            sharedStepsUI = new SharedStepsUI();
            homepage = new Homepage();
            interestBaseAdsPage = new InterestBaseAdsPage();
        }

    @And("user navigates to interest base ads page")
    public void navigateToInterestBaseAdsPage() {
        homepage.navigateToInterestBaseAdsPage();

    }


    @When("user clicks on the select all available opt-outs")
    public void clickOnSelectAllAvailableOptOuts() {
        interestBaseAdsPage.clickOnSelectAllCheckbox();

    }

    @Then("all available opt-out choices should be selected")
    public void verifyAllOptOutsSelections() {
        Assert.assertTrue(isElementPresent(driver.findElement(By.cssSelector("input[type='checkbox'][checked]"))));

    }


}
