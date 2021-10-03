package step_definitions;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pom.BusinessPage;
import pom.Homepage;

import java.util.List;


public class VerizonBusinessStepsDefinitions extends BaseClass {

    SharedStepsUI sharedStepsUI;
    Homepage homepage;
    BusinessPage businessPage;

    public VerizonBusinessStepsDefinitions() {
        sharedStepsUI = new SharedStepsUI();
        homepage = new Homepage();
        businessPage = new BusinessPage();

    }

    // STEPS DEFINITIONS GO IN HERE (i.e. A METHOD FOR EACH STEP OF THE SCENARIO)

    @When("user navigates to the business page")
    public void userNavigatesToTheBusinessPage() {
        homepage.navigateToBusinessPage();
    }

    @And("clicks on maximizing the chat-with-us dialog box")
    public void clicksOnMaximizingTheChatWithUsDialogBox(){
        businessPage.openChatWithUsDialogBox();
    }

    @And("clicks and holds on the chat-with-us dialog box")
    public void clicksAndHoldsOnTheChatWithUsDialogBox() {

    }

    @Then("user should be able to drag and drop to {int} and {int} the chat-with-us dialog box")
    public void userShouldBeAbleToDragAndDropTheChatWithUsDialogBox(int xOffset, int yOffset) {

        dragAndDrop(businessPage.chatWithUsDialogWindowForGrab, xOffset, yOffset);

        List<WebElement> defaultDialogBoxConfig = driver.findElements(By.cssSelector("div[style='left: auto; right: 0px; bottom: 0px; display: block; border-radius: 5px 5px 0px 0px; border: none; box-shadow: rgba(0, 0, 0, 0.2) 0px 0px 16px 3px;']"));

        Assert.assertEquals(defaultDialogBoxConfig.size(), 0);


    }
}
