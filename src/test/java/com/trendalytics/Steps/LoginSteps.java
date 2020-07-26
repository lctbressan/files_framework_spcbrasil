package com.trendalytics.Steps;

import com.trendalytics.Pages.LoginPage;
import com.trendalytics.Runners.BaseTest;
import com.trendalytics.Utils.Config;
import com.trendalytics.Utils.Instrumentation;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;


public class LoginSteps extends BaseTest {
    Config cons = new Config();
    @Before
    public void setup() throws Exception {
//      LoginPage.thatTheUserIsOnTheHomeScreen();
    }
    @Given("^that the user is on the home screen \"([^\"]*)\"$")
    public void thatTheUserIsOnTheHomeScreen(String arg0) throws Exception {
        LoginPage.thatTheUserIsOnTheHomeScreen(arg0);
        Instrumentation.takeScreenshot(Webdriver,"Screen Home");
    }
    @When("^send credencials")
    public void sendCredencialsAnd() throws IOException, InterruptedException {
    LoginPage.sendCredencialsAnd( cons.email,cons.passw);

    }
    @When("^send wrong credencials")
    public void sendWrongCredencialsAnd() throws IOException, InterruptedException {
        LoginPage.sendCredencialsAnd( cons.email,"123456");
    }
    @Then("^I get the message \"([^\"]*)\"$")
    public void Igetthemessage(String arg1) throws Throwable {
        LoginPage.GetMessage(arg1);
    }

    @And("confirm action \"([^\"]*)\"$")
    public void confirmAction(String arg0) throws IOException {
        if(arg0.equals("yes")) {
            LoginPage.confirmAction();
        }
    }
    @After
    public void tearDownSteps(){
        Webdriver.close();
    }

}
