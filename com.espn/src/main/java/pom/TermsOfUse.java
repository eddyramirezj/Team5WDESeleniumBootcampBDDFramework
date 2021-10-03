package pom;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TermsOfUse extends BaseClass {

    public TermsOfUse() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[text()='Download PDF']/parent::a[@href='https://disneytermsofuse.com/app/uploads/2020/10/Disney-US-English-Terms-of-Use-060920a-1.pdf']")
    public WebElement downloadPDFButton;


    public void clickOnDownloadPDFButton() throws InterruptedException {
        waitForElementToBeClickable(downloadPDFButton);
        clickOnElement(downloadPDFButton);
        Thread.sleep(2000);

    }
}
