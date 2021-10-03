package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BaseClass {

    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css="button.gnav20-promo-icon")
    public WebElement tradeInPromoButton;




}
