package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reporting.ExtentManager;
import reporting.ExtentTestManager;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.*;

public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static ExtentReports extent;

    public static DataReader dataReader;
    public MySQLConnection database;

    private Properties properties;
    public final String ABSOLUTE_PATH = System.getProperty("user.dir");
    public final String PROPERTIES_RELATIVE_PATH = "/src/main/resources/secret.properties";
    private final String PROP_FILE_PATH = ABSOLUTE_PATH + PROPERTIES_RELATIVE_PATH;

    public void setUp(String browserName) {
        driver = getLocalDriver(browserName);
        webDriverWait = new WebDriverWait(driver, 20);
        dataReader = new DataReader();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }


    public WebDriver getLocalDriver(String browserName) {

        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();


        } else if (browserName.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else if (browserName.equalsIgnoreCase("chrome-options")) {
            ChromeOptions options = new ChromeOptions();

            Map<String, Object> prefs = new HashMap<String, Object>();

            prefs.put("download.prompt_for_download", false);
            prefs.put("profile.default_content_settings.popups", 0);
            prefs.put("download.default_directory", "C:" + File.separator + "Users" + File.separator + "Eddy" + File.separator +"SeleniumDownloads");
            prefs.put("plugins.always_open_pdf_externally", true);

            options.setExperimentalOption("prefs", prefs);

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }

        return driver;
    }

    /*
    Selenium Helper Methods
     */

    public WebElement safeFindElement(By by) {
        return driver.findElement(by);
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void confirmAlert() {
        driver.switchTo().alert().accept();
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    public void sendKeysToInput(WebElement element, String keys) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));

        element.sendKeys(keys);
    }

    public void dropdownSelectByVisibleText(WebElement element, String visibleText) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));

        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public void clickOnElement(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (StaleElementReferenceException e1) {
            e1.printStackTrace();
        }

        try {
            element.click();
        } catch (Exception e1) {
            clickJScript(element);
        }
    }

    public void clickJScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void createJSAlert(String alertText) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("alert('" + alertText + "');");
    }

    public void scrollJS(int numOfPixelsToScroll) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0," + numOfPixelsToScroll + ")");
    }

    public void hoverOverElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();

    }


    /*
    SYNC Methods
     */
    public void waitForElementToBeVisible(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForElementToContainText(WebElement element, String text) {
        try {
            webDriverWait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForElementToBeClickable(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForElementToBeSelected(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeSelected(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void waitForTitleOfPageToContain(String title) {
        try {
            webDriverWait.until(ExpectedConditions.titleContains(title));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(WebElement element) {
        boolean flag = false;

        try {
            if (element.isDisplayed()){
                flag = true;
            }
        } catch (ElementNotVisibleException e) {
            System.out.println("UNABLE TO LOCATE ELEMENT");
        }

        return flag;
    }

}