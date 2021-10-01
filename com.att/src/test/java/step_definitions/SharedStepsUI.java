package step_definitions;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.support.PageFactory;

public class SharedStepsUI extends BaseClass {

    //SHARED WEB ELEMENTS GO HERE

    public SharedStepsUI() {
        PageFactory.initElements(driver, this);
    }


    @Before
    public void driverSetUp() {
        String browser = "Chrome";
        setUp(browser);
        openAttApplication();
    }

    @After
    public void driverTearDown() {
        driver.close();
        driver.quit();
    }

    public void openAttApplication() {
        String url = "https://att.com";
        driver.get(url);
    }

    // SHARED METHODS GO HERE

}
