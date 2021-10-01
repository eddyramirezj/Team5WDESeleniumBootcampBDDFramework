package pom;

import base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static base.BaseClass.driver;

public class Homepage extends BaseClass {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "div._1sfnwgq>svg")
    public WebElement dropDownMenuLoginButton;

    @FindBy (css = "_1xq16jy")
    public WebElement locationTextField;

    @FindBy (css = "div._gor68n>div._wtz1co")
    public WebElement locationTextFieldButton;







}
