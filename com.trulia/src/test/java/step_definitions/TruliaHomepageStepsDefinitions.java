package step_definitions;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pom.Homepage;
import pom.ResultsPage;


public class TruliaHomepageStepsDefinitions extends BaseClass {

    SharedStepsUI sharedStepsUI;
    Homepage homepage;
    ResultsPage resultsPage;


    public TruliaHomepageStepsDefinitions() {
        sharedStepsUI = new SharedStepsUI();
        homepage = new Homepage();
        resultsPage = new ResultsPage();
    }


    @When("user enters {string} city in the search bar")
    public void userEntersACityInTheSearchBar(String city) {
        homepage.clearSearchBar().sendKeysToSearchBarComboBox(city);

    }

    @And("user selects a city from the list of populated cities")
    public void userSelectsACity() throws InterruptedException {

        homepage.selectResultFromComboBox(0);

    }

   @When("user clicks on rent tab for houses to rent")
    public void userClicksOnRentTabForHousesToRent() {
        homepage.clickOnRentTab();
    }

    @When("user clicks on sold tab for houses sold")
    public void userClicksOnSoldTabForHousesSold() {
        homepage.clickOnSoldTab();
    }

    @Then("user should be taken to the list of {string} houses for the specified city")
    public void userShouldBeTakenToTheListOfHousesForSaleForTheSpecifiedCity(String numOfHouses) {
        String actualResults = resultsPage.housesForSaleResultCount.getText();
        String expectedResults = numOfHouses + " homes available on Trulia";

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Then("user should be taken to the list of {string} dwellings for Rent for the specified city")
    public void userShouldBeTakenToTheListOfDwellingsForRentForTheSpecifiedCity(String numOfHouses) {
        String actualResults = resultsPage.dwellingsForRentCount.getText();
        String expectedResults = numOfHouses + "  rentals available on Trulia";

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Then("user should be taken to the list of {string} sold houses for the specified city")
    public void userShouldBeTakenToTheListOfSoldHousesForTheSpecifiedCity(String numOfHouses) {
        String actualResults = resultsPage.housesSoldCount.getText();
        String expectedResults = numOfHouses + " sold homes on Trulia";

        Assert.assertEquals(actualResults, expectedResults);

    }

}
