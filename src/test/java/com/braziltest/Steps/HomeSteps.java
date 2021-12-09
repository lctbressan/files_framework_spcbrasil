package com.braziltest.Steps;

import com.braziltest.Pages.HomePage;
import com.braziltest.Steps.Hook.BaseStep;
import com.braziltest.Steps.Hook.Hook;
import com.braziltest.Utils.Config;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;


public class HomeSteps extends BaseStep {
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

    @Given("^that the user is on the home screen \"([^\"]*)\"$")
    public void thatTheUserIsOnTheHomeScreen(String arg0) throws Exception {
        HomePage.thatTheUserIsOnTheHomeScreen(arg0);
    }

    @And("Click Login")
    public void clickLogin() {
    }

    @And("Enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enterAnd(String arg0, String arg1) {
    }

    @And("Select Project Trendalitycs")
    public void selectProjectTrendalitycs() {
    }

    @And("Click StopStart")
    public void clickStopStart() {
    }

    @And("abre a conexao nao particular")
    public void abreAConexaoNaoParticular() throws IOException {
        HomePage.abreaconexaoNaoparticular();
    }

    @And("ir para \"([^\"]*)\" e \"([^\"]*)\"$")
    public void irParaE(String arg0, String arg1) throws IOException {
        HomePage.irPara(arg0,arg1);
    }

    @And("Send login \"([^\"]*)\" and \"([^\"]*)\"$")
    public void sendLoginAnd(String arg0, String arg1) throws IOException, InterruptedException {
        HomePage.sendLoginandPass(arg0,arg1);
    }

    @And("Reinicia o roteador")
    public void reiniciaORoteador() throws IOException, InterruptedException {
        HomePage.reiniciaoteador();
    }
}
