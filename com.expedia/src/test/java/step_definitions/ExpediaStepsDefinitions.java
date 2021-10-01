package step_definitions;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pom.Homepage;


public class ExpediaStepsDefinitions extends BaseClass {

    SharedStepsUI sharedStepsUI;
    Homepage homepage;

    public ExpediaStepsDefinitions() {
        sharedStepsUI = new SharedStepsUI();
        homepage = new Homepage();

    }

    // STEPS DEFINITIONS GO IN HERE (i.e. A METHOD FOR EACH STEP OF THE SCENARIO)

    @Given("user is at homepage")
    public void userIsAtHomepage() {
        sharedStepsUI.openExpediaApplication();
    }

//    @When("user enters the url")
//    public void userEntersTheUrl() {
//        System.out.println("Entering URL");
//    }

    @Then("user navigates to the Homepage")
    public void userNavigatesToTheHomepage() throws InterruptedException {

        homepage.navigateToHomepageWithExpediaTopButton().selectADestinationOnGoingToBox("New York");
        Thread.sleep(3000);

    }

}
