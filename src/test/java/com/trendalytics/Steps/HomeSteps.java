package com.trendalytics.Steps;

import com.trendalytics.Pages.HomePage;
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


public class HomeSteps extends BaseTest {
    Config cons = new Config();




    @Then("^I get the message Home \"([^\"]*)\"$")
    public void IgetthemessageHome(String arg1) throws Throwable {
        HomePage.GetMessageHome(arg1);
    }

    @And("confirm action Home")
    public void confirmActionHome() throws IOException {
        HomePage.confirmActionHome();
    }


    @When("^click on menu \"([^\"]*)\" link")
    public void clickOnProductLink(String arg0) throws Exception {
        HomePage.clickOnProductLink(arg0);

    }

    @And("accept cookies")
    public void acceptCookies() throws IOException {
        HomePage.acceptCookies();
    }
}
