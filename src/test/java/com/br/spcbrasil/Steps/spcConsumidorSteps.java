package com.br.spcbrasil.Steps;

import com.br.spcbrasil.Pages.LoginPage;
import com.br.spcbrasil.Pages.consumidorPages;
import com.br.spcbrasil.Runners.BaseTest;
import com.br.spcbrasil.Utils.Instrumentation;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

import static com.br.spcbrasil.Utils.Config.TestWeb;

public class spcConsumidorSteps extends BaseTest {


        @Given("^open SPC Consumidor \"([^\"]*)\"$")
        public void openSpcConsumidor(String Type) throws Exception {

            TestWeb = "MOBILE";
            LoginPage.openSpcBrasilEmpresas(Type,"CONSUMIDOR");


    }

    @When("access the consumidor app")
    public void accessTheConsumidorApp() throws IOException, InterruptedException {
        consumidorPages.accessTheConsumidorApp();
    }

    @And("send a cpf and password \"([^\"]*)\" \"([^\"]*)\"$")
    public void sendACpf(String arg0,String arg1) throws IOException, InterruptedException {
        consumidorPages.sendACpf(arg0,"142536@!A");
    }

    @And("click in sair da Consulta")
    public void clickInSairDaConsulta() throws IOException {
            consumidorPages.clickSairdaConta();
    }

    @And("click in consulta de terceiros")
    public void clickInConsultaDeTerceiros() throws IOException {
            //swipe
        Instrumentation.scrollDown(driver);
        Instrumentation.scrollDown(driver);
        consumidorPages.clickInConsultaDeTerceiros();
    }

    @And("click Consultar CPF")
    public void clickInConsultarCPF() throws IOException, InterruptedException {
        consumidorPages.clickInConsultaCPF();
    }
    @And("click Consultar CNPJ")
    public void clickInConsultarCNPJ() throws IOException, InterruptedException {
        consumidorPages.clickInConsultaCNPJ();
    }

    @And("inform a cpf number \"([^\"]*)\"$")
    public void informAValidCpfNumber(String arg0) throws IOException, InterruptedException {
            if(arg0.equals("i")) {
                consumidorPages.informAInValidCpfNumber();
            }
            if(arg0.equals("v")) {
                consumidorPages.informAValidCpfNumber();
            }
        if(arg0.equals("n")) {
            consumidorPages.informAValidCpfCadastro();
        }
    }
    @And("inform a cnpj number \"([^\"]*)\"$")
    public void informAValidCnpjNumber(String arg0) throws IOException, InterruptedException {
        if(arg0.equals("i")) {
            consumidorPages.informAInValidCnpjNumber();
        }
        if(arg0.equals("v")) {
            consumidorPages.informAValidCnpjNumber();
        }

    }
    @And("click in termo de compromisso")
    public void clickInTermoDeCompromisso() throws IOException, InterruptedException {
        Instrumentation.scrollDown(driver);
        consumidorPages.clickInTermoDeCompromisso();
    }

    @And("check for message \"([^\"]*)\"$")
    public void checkForMessage(String arg0) throws IOException {
            consumidorPages.CheckForMessages(arg0);
    }

    @And("close session")
    public void closeSession() throws IOException {
        consumidorPages.closeSession();
        consumidorPages.clickSairdaConta();
    }
    @And("click contratar agora")
    public void clickContratarAgora() throws IOException {
        consumidorPages.clickContratarAgora();
    }

    @And("fill confirme seus dados")
    public void fillConfirmeSeusDados() throws IOException, InterruptedException {
        consumidorPages.fillConfirmeSeusDados();
    }

    @And("click in faca seu cadastro")
    public void clickInFacaSeuCadastro() throws IOException {
        consumidorPages.clickInFacaSeuCadastro();
    }

    @And("send a name \"([^\"]*)\"$")
    public void sendAName(String arg0) throws IOException {
        consumidorPages.sendAName(arg0);
    }

    @And("send Data de nascimento")
    public void sendDataDeNascimento() throws IOException {
            consumidorPages.sendDataNascimento();
    }
    @And("send email")
    public void sendEmail() throws IOException {
        consumidorPages.sendEmail();
    }
    @And("send Celular")
    public void sendCelular() throws IOException {
        consumidorPages.sendCelular();
    }
    @And("send Password")
    public void sendPassword() throws IOException {
        consumidorPages.sendPassword();
    }

    @And("agree terms")
    public void agreeTerms() throws IOException {
            consumidorPages.AgreeTerms();
    }
    @And("Confirm by email")
    public void confirmByEmail() throws IOException {
        consumidorPages.CofirmByEmail();
    }


}
