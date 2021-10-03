package step_definitions;

import base.BaseClass;
import pom.BusinessPage;
import pom.Homepage;
import pom.SignInPage;

public class VerizonSignInPageStepsDefinitions extends BaseClass {

    SharedStepsUI sharedStepsUI;
    Homepage homepage;
    SignInPage signInPage;

    public VerizonSignInPageStepsDefinitions() {
        sharedStepsUI = new SharedStepsUI();
        homepage = new Homepage();
        signInPage = new SignInPage();

    }




}
