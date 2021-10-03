package step_definitions;

import base.BaseClass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pom.HomeWatch;
import pom.Homepage;

import java.util.List;

public class ESPNHomepageStepsDefinitions extends BaseClass {

    SharedStepsUI sharedStepsUI;
    Homepage homepage;
    HomeWatch homeWatch;


    public ESPNHomepageStepsDefinitions() {
        sharedStepsUI = new SharedStepsUI();
        homepage = new Homepage();
        homeWatch = new HomeWatch();
    }

        @When("the scoreboard is available")
        public void checkIfScoreboardIsAvailable() {
            if (isElementPresent(homepage.scoreboardCarousel)) {
                System.out.println("Scoreboard Carousel is available");
            }
        }

        @Then("user should be able to see all channels being shown on the scoreboard")
        public void checkHowManyChannelsAreShownOnScoreboard() {
            homepage.channelsShownOnScoreboard();
            List<WebElement> numOfChannelsShown = homepage.channelsOnScoreboard.findElements(By.xpath("//div[@class='scores-carousel']//div[@class='cscore_channels icon-font-before icon-play-arrow-solid-before']/span"));
            int expectedResults = 39;
            int actualResults = numOfChannelsShown.size();

            Assert.assertEquals(actualResults, expectedResults);

        }


        @Then("user should be able to see if {string} is being shown on the scoreboard")
        public void checkIfSpecificChannelIsShownOnScoreboard(String channel) {
        Assert.assertTrue(homepage.checkIfChannelIsShownOnScoreboard(channel));

    }



}
