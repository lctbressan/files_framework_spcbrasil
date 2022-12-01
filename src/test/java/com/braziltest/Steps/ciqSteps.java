package com.braziltest.Steps;

import com.braziltest.Pages.HomePage;
import com.braziltest.Pages.ciqPages;
import com.braziltest.Steps.Hook.BaseStep;
import com.braziltest.Utils.Config;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.junit.Before;

import java.io.IOException;

public class ciqSteps extends BaseStep {


    Config cons = new Config();

@Before
public static void before(){

}
    @And("fill email \"([^\"]*)\"$")
    public void fillEmail(String arg0) throws IOException {
        ciqPages.fillEmail(arg0);
    }

    @And("fill password \"([^\"]*)\" \"([^\"]*)\"$")
    public void fillPassword(String Env, String arg0) throws IOException {
        ciqPages.fillPassword(Env, arg0);
    }

    @And("cick Login")
    public void cickLogin() throws IOException, InterruptedException {
        ciqPages.cickLogin();
    }

    @And("click captcha")
    public void clickCaptcha() throws IOException {
        ciqPages.clickcaptcha();
    }

    @And("Send credentials \"([^\"]*)\"$")
    public void sendCredentials(String Env) throws IOException {
        ciqPages.fillEmail("controle.ativos@automatos.com");
        ciqPages.fillPassword(Env, "Automatos@123");
    }

    @And("check for information on logon \"([^\"]*)\" \"([^\"]*)\"$")
    public void checkForInformation(String Env, String arg0) throws IOException {
        HomePage.checkForInformationOnLogonPage(Env, arg0);
    }

    @And("click in total de ativos")
    public void clickInTotalDeAtivos() throws IOException {
        ciqPages.clickInTotalDeAtivos();
    }

    @And("Click in \"([^\"]*)\" and get total")
    public void clickInNotebooks(String arg0) throws IOException, InterruptedException {
        ciqPages.clickInNotebooks(arg0);
    }



    @And("get total from the list \"([^\"]*)\"$")
    public void checkFromTheListTotalMatch(String arg0) throws IOException, InterruptedException {
        ciqPages.checkFromTheListTotalMatch(arg0);
    }

    @Then("check both totals match")
    public void checkBothTotalsMatch() {
        ciqPages.checkTotalMatch();
    }
}

