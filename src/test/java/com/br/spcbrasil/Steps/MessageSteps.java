package com.br.spcbrasil.Steps;

import com.br.spcbrasil.Pages.LoginPage;
import com.br.spcbrasil.Pages.MessagesPage;
import com.br.spcbrasil.Pages.empresasPages;
import com.br.spcbrasil.Steps.Hook.BaseStep;
import com.br.spcbrasil.Utils.Config;
import com.br.spcbrasil.Utils.Instrumentation;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.io.IOException;

public class MessageSteps extends BaseStep {




    @Then("check message \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void checkMessage(String arg0,String arg1,String arg2) throws IOException, InterruptedException {

        Thread.sleep(10000);
        String Ret = Instrumentation.checkOnScreen(driver,"Pular");
        if(Ret.equals("YES")) {

            LoginPage.clickPular();
            /*MessagesPage.checkMessage(arg0);
            Instrumentation.lftRightSwipe(driver);
            MessagesPage.checkMessage(arg1);
            Instrumentation.lftRightSwipe(driver);
            MessagesPage.checkMessage(arg2);
            LoginPage.clickComecar();*/
        }
    }


    @And("check results \"([^\"]*)\"$")
    public void checkResults(String arg0) throws IOException {
        for (String line : arg0.split(";")) {
            System.out.println(line);
            if(!line.equals(";") ){
                empresasPages.checkResult(line);
            }
        }
    }
}
