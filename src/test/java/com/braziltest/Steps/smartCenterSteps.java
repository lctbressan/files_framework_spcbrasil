package com.braziltest.Steps;

import com.braziltest.Pages.HomePage;
import com.braziltest.Pages.smartcenterPages;
import com.braziltest.Steps.Hook.BaseStep;
import com.braziltest.Utils.Config;
import com.braziltest.Utils.Instrumentation;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Before;

import java.io.IOException;
import java.util.Map;

public class smartCenterSteps extends BaseStep {


    Config cons = new Config();

    @Before
    public static void before() {

    }

    @And("fill email \"([^\"]*)\"$")
    public void fillEmail(String arg0) throws IOException {
        smartcenterPages.fillEmail(arg0);
    }

    @And("fill password \"([^\"]*)\" \"([^\"]*)\"$")
    public void fillPassword(String Env, String arg0) throws IOException {
        smartcenterPages.fillPassword(Env, arg0);
    }

    @And("cick Login")
    public void cickLogin() throws IOException, InterruptedException {
        smartcenterPages.cickLogin();
        smartcenterPages.checkPupup();
    }

    @And("click captcha")
    public void clickCaptcha() throws IOException {
        smartcenterPages.clickcaptcha();
    }

    @And("Send credentials \"([^\"]*)\"$")
    public void sendCredentials(String Env) throws IOException {
        smartcenterPages.fillEmail("controle.ativos@automatos.com");
        smartcenterPages.fillPassword(Env, "Automatos@123");
    }

    @And("check for information on logon \"([^\"]*)\" \"([^\"]*)\"$")
    public void checkForInformation(String Env, String arg0) throws IOException {
        HomePage.checkForInformationOnLogonPage(Env, arg0);
    }

    @And("click in total de ativos")
    public void clickInTotalDeAtivos() throws IOException {
        smartcenterPages.clickInTotalDeAtivos();
    }

    @And("Click in \"([^\"]*)\" and get total")
    public void clickInNotebooks(String arg0) throws IOException, InterruptedException {
        smartcenterPages.clickInNotebooks(arg0);
    }


    @And("get total from the list \"([^\"]*)\"$")
    public void checkFromTheListTotalMatch(String arg0) throws IOException, InterruptedException {
        smartcenterPages.checkFromTheListTotalMatch(arg0);
    }

    @Then("check both totals match")
    public void checkBothTotalsMatch() {
        smartcenterPages.checkTotalMatch();
    }

    @And("click in menu")
    public void clickInMenu() throws IOException {
        smartcenterPages.clickInMenu();
    }

    @And("Click in submenu \"([^\"]*)\"$")
    public void clickInSubmenu(String arg0) throws IOException {
        smartcenterPages.clickInSubmenu(arg0);
    }

    @And("Click in item \"([^\"]*)\"$")
    public void clickInItem(String arg0) throws IOException {
        smartcenterPages.clickInItem(arg0);
    }

    @And("Check for information \"([^\"]*)\"$")
    public void checkForInformation(String arg0) throws Exception {
        Thread.sleep(2000);
        smartcenterPages.checkForInformation(arg0);
    }

    @Then("Click in Sair")
    public void clickInSair() throws IOException {
        smartcenterPages.clickInSair();
    }

    @And("click item page \"([^\"]*)\"$")
    public void clickItemPage(String arg0) throws IOException {
        if (!arg0.equals("")) {
            smartcenterPages.clickItemPage(arg0);
        }
    }

    @And("pesquisar um item \"([^\"]*)\"$")
    public void pesquisarUmItem(String arg0) throws IOException {
        smartcenterPages.pesquisarItem(arg0);
    }

    @And("selecionar o item \"([^\"]*)\"$")
    public void selecionarOItem(String arg0) throws IOException, InterruptedException {
        smartcenterPages.selecionarOItem(arg0);

    }

    @And("colete todas as informacoes da ficha de hardware")
    public void coleteTodasAsInformacoesDaFichaDeHardware() throws IOException {
        smartcenterPages.coleteInformcaoesFichahard();
    }

    @And("verifique se o recurso de hardware apresenta a mensagem \"([^\"]*)\" se sim falhe o teste")
    public void verifiqueSeORecursoDeHardwareApresentaAMensagem(String arg0) throws IOException, InterruptedException {

        smartcenterPages.verifiqueSeORecursoDeHardwareApresentaAMensagem(arg0);
    }

    @And("verifique os dados em tela")
    public void verifiqueOsDadosEmTela(Map<String, String> responseFields) throws InterruptedException, IOException {
        String prmData="",prmValue;
        try {
            for (Map.Entry<String, String> field : responseFields.entrySet()) {
                Thread.sleep(1000);
                prmData = field.getKey();
                prmValue = field.getValue();

                System.out.println(prmData +" "+ prmValue);
                smartcenterPages.verifiqueOsDadosEmTela(prmData,prmValue);
            }
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());}

    }

    @And("Click in item by a list \"([^\"]*)\"$")
    public void clickInItemByAList(String arg0) throws IOException, InterruptedException {
        Thread.sleep(1500);
        if(!arg0.equals("")) {
            smartcenterPages.clickInItemByAList(arg0);
        }
    }


    @And("define parimetro inicial \"([^\"]*)\"$")
    public void defineParimetroInicial(String arg0) throws IOException {
        smartcenterPages.definePerimetro(arg0);
    }

    @And("verifica no mapa de iteracoes se retornou endereco \"([^\"]*)\"$")
    public void verificaNoMapaDeIteracoesSeRetornouEndereco(String arg0) throws IOException, InterruptedException {
        smartcenterPages.verificaRetornoEndereco(arg0);
    }
}


