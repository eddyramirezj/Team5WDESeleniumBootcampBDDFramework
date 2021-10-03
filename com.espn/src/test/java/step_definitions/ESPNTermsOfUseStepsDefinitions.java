package step_definitions;

import base.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pom.Homepage;
import pom.TermsOfUse;

import java.io.File;
import java.util.List;

public class ESPNTermsOfUseStepsDefinitions extends BaseClass {

    SharedStepsUI sharedStepsUI;
    Homepage homepage;
    TermsOfUse termsOfUse;


    public ESPNTermsOfUseStepsDefinitions() {
        sharedStepsUI = new SharedStepsUI();
        homepage = new Homepage();
        termsOfUse = new TermsOfUse();
    }

    @And("user navigates to terms of use page")
    public void navigateToTermsOfUse() {
        homepage.navigateToTermsOfUsePage();
        }


    @When("user clicks on the download PDF button")
    public void clickOnDownloadPDF() throws InterruptedException {
        termsOfUse.clickOnDownloadPDFButton();


    }

    @Then("a PDF file of the terms of use will be downloaded")
    public void downloadPDF() {
        Assert.assertTrue(isFileDownloaded("Disney US English Terms of Use"));

    }
}
