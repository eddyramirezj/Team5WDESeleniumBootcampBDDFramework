package step_definitions;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pom.Homepage;
import pom.ResultsPage;

import java.awt.*;

public class TruliaResultsPageStepsDefinitions extends BaseClass {

    SharedStepsUI sharedStepsUI;
    Homepage homepage;
    ResultsPage resultsPage;


    public TruliaResultsPageStepsDefinitions() {
        sharedStepsUI = new SharedStepsUI();
        homepage = new Homepage();
        resultsPage = new ResultsPage();
    }


    @Given("user is at results page for {string}")
    public void userNavigatesToResultsPage(String city) {
        homepage.clearSearchBar().sendKeysToSearchBarComboBox(city).selectResultFromComboBox(0);

    }

    @When("user selects {int} number of minimum bedrooms")
    public void userSelectsNumOfBedroomsFilter(int numOfBedrooms) throws InterruptedException, AWTException {
        resultsPage.selectNumOfBedrooms(numOfBedrooms);

    }

    @Then("number of results should change to {string} to reflect the selected number of minimum bedrooms")
    public void getResultsBasedOnNumOfMinimumBedrooms(String numOfHouses) {
        String actualResults = resultsPage.housesForSaleResultCount.getText();
        String expectedResults = numOfHouses + " homes available on Trulia";

        Assert.assertEquals(actualResults, expectedResults);

    }
}
