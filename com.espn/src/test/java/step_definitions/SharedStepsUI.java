package step_definitions;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.PageFactory;

public class SharedStepsUI extends BaseClass {

    //SHARED WEB ELEMENTS GO HERE

    public SharedStepsUI() {
        PageFactory.initElements(driver, this);
    }


    @Before
    public void driverSetUp() {
        String browser = "chrome-options";
        setUp(browser);
        openESPNApplication();
    }

    @After
    public void driverTearDown() {
        driver.close();
        driver.quit();
    }

    public void openESPNApplication() {
        String url = "https://espn.com";
        driver.get(url);
    }

    // SHARED METHODS GO HERE

    @Given("user is at homepage")
    public void userIsAtHomepage() {
    }


}

