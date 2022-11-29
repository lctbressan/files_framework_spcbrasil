package com.braziltest.Steps;

import com.braziltest.Pages.HomePage;
import com.braziltest.Pages.ciqPages;
import com.braziltest.Steps.Hook.BaseStep;
import com.braziltest.Utils.Config;
import cucumber.api.java.en.And;

import java.io.IOException;

public class ciqSteps extends BaseStep {


    Config cons = new Config();


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
}

