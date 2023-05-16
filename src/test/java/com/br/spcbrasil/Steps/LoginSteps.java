package com.br.spcbrasil.Steps;

import com.br.spcbrasil.Pages.HomePage;
import com.br.spcbrasil.Pages.LoginPage;
import com.br.spcbrasil.Pages.MessagesPage;
import com.br.spcbrasil.Pages.ProdutosPages;
import com.br.spcbrasil.Steps.Hook.BaseStep;
import com.br.spcbrasil.Utils.Config;
import com.br.spcbrasil.Utils.Instrumentation;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import org.ietf.jgss.MessageProp;
import org.openqa.selenium.Dimension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static com.br.spcbrasil.Utils.Config.*;


public class LoginSteps extends BaseStep {
    Config cons = new Config();



    @Given("^that test new inspection on environment \"([^\"]*)\" \"([^\"]*)\"$")
    public void thatTestNewInspectionOnEnvironment(String Env,String Url) throws Throwable {

        if(Env.equalsIgnoreCase("PRD")) {
            LoginPage.thatTheUserInTheMainPage(Url);

            HomePage.sendCredencialsAnd(email, passw,Env);
        }
    }





    @Then("^I get the message Home \"([^\"]*)\"$")
    public void IgetthemessageHome(String arg1,String Env) throws Throwable {
        HomePage.GetMessageHome(arg1,Env);
    }

    @And("confirm action Home")
    public void confirmActionHome(String Env) throws IOException {
        HomePage.confirmActionHome(Env);
    }


    @When("^click on menu \"([^\"]*)\" link")
    public void clickOnProductLink(String arg0,String Env) throws Exception {
        HomePage.clickOnProductLink(arg0,Env);

    }

    @And("accept cookies")
    public void acceptCookies(String Env) throws IOException {
        HomePage.acceptCookies(Env);
    }



    @And("click in total")
    public void clickInTotal(String Env) throws IOException, InterruptedException {

    }

    @And("click in cash ")
    public void clickInCash(String Env) throws IOException, InterruptedException {

    }



    @And("select a specific product \"([^\"]*)\"$")
    public void selectASpecificProduct(String arg0,String Env) throws Exception {

    }

    @And("select a product \"([^\"]*)\" \"([^\"]*)\"$")
    public void selectAProduct(String arg0,String Env) throws Exception {

        Thread.sleep(TIMEOUTAUTOMATION);
    }



    @And("Select a type \"([^\"]*)\"$")
    public void selectADrink(String arg0,String Env) throws Exception {
        //LoginPage.selectAProduct("[Sm Drink]");
        //LoginPage.selectAProduct("Coke");

    }





    @And("select a sales type \"([^\"]*)\"$")
    public void selectASalesType(String arg0,String Env) throws IOException, InterruptedException {
        Thread.sleep(TIMEOUTAUTOMATION);


    }

    @And("check billing \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void checkBilling(String produto, String opc1, String opc2,String Env) throws IOException {


    }


        @And("send crendencials boh \"([^\"]*)\" \"([^\"]*)\"$")
        public void sendCrendencialsBoh(String User, String Pass) throws IOException, InterruptedException {

        }




    @Then("check all Items data values from bohQE on BohSystem")
    public void checkAllItemsDataValuesFromBohQEOnBohSystem(String Env) throws Exception {

    }

    @And("click confirm value")
    public void clickConfirmValue() throws IOException {

    }

    @Then("check all Assemby data values from bohQE on BohSystem")
    public void checkAllAssembyDataValuesFromBohQEOnBohSystem(String Env) throws Exception {

    }

    @And("Close Open POS \"([^\"]*)\"")
    public void closeOpenPos(String Env) throws IOException {

    }



    @And("Change layout \"([^\"]*)\" \"([^\"]*)\"$")
    public void changeLayout(String Env,String arg0) throws IOException, InterruptedException {
        Thread.sleep(TIMEOUTAUTOMATION);

    }




    @And("check POSTYPE \"([^\"]*)\"$")
    public void checkPOSTYPE(String arg0) throws IOException {

    }




    @When("click on my ip number")
    public void clickOnMyIpNumber(String Env) throws IOException {

    }

    @Given("^Test data from local database \"([^\"]*)\" versus environment database \"([^\"]*)\" \"([^\"]*)\"$")
    public void testDataFromLocalDatabaseVersusEnvironmentDatabase(String arg0, String arg1,String Server) throws Exception {
        LoginPage.testDataFromLocalDataBaseVersusEnv(arg0,arg1,Server);
    }







    @And("Check Pmix restaurant ID \"([^\"]*)\"$")
    public void checkRestaurantID(String arg0) throws IOException {
        LoginPage.checkRestaurantID(arg0);
    }


    @And("Check Pmix Product \"([^\"]*)\"$")
    public void product(String arg0) throws IOException {
        LoginPage.product(arg0);
    }


    @And("logon device$")
    public void logonDevice() throws IOException, InterruptedException {
        LoginPage.logonDeviceIOS(email, passw);

    }

    @And("^start a inspection \"([^\"]*)\" \"([^\"]*)\" quantity \"([^\"]*)\" and permitir \"([^\"]*)\"$")
    public void startAInpection(String barragem,String foto,Integer Qtdy,String permitir) throws IOException, InterruptedException {

        LoginPage.startInspection(barragem,foto,Qtdy,permitir);
    }

    @And("Sincronizar")
    public void sincronizar() throws IOException {
        LoginPage.Sincronizar();


    }

    @Given("open SPC BRASIL EMPRESAS \"([^\"]*)\"$")
    public void openSPCBRASILEMPRESAS(String Type) throws Exception {
        TestWeb = "MOBILE";
        LoginPage.openSpcBrasilEmpresas(Type,"EMPRESAS");
        Thread.sleep(4000);
    }

    @When("logon with credentials \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void logonWithCredentialsAndAnd(String Operador, String Pass, String PassPrase) throws IOException, InterruptedException {
        LoginPage.logonWithCredentials(Operador,  Pass,  PassPrase);
    }



    @And("swipe left")
    public void swipeLeft() {
        //driver.swipe(0,0,1000,500,100);
        Instrumentation.lftRightSwipe(driver);

    }



    @Given("run automation type \"([^\"]*)\"$")
    public void runAutomationType(String arg0) {
        PlatformName = arg0;
    }


    @And("click exit")
    public void clickExit() throws IOException {
        LoginPage.clickExit();
    }

    @And("click in Consulta \"([^\"]*)\"$")
    public void clickInConsulta(String arg0) throws IOException, InterruptedException {
        HomePage.clickInConsulta(arg0);
    }











    @And("get all results")
    public void checkAllResults() throws IOException, InterruptedException {
        ProdutosPages.checkCCFResults();
    }

    @When("swipe down")
    public void swipeDown() {
        LoginPage.swipeDown();
    }

    @And("go to \"([^\"]*)\"$")
    public void goTo(String arg0) throws IOException {
        LoginPage.goingto(arg0);

    }

    @And("click in mais informacoes")
    public void clickInMaisInformacoes() throws IOException, InterruptedException {
        LoginPage.moreinfo();
    }


    @Given("verify devices allocated and dealocate")
    public void verifyDevicesAllocatedAndDealocate() throws Exception {
         Instrumentation.dealocatetDevices();

    }

    @Given("reboot devices \"([^\"]*)\"$")
    public void rebootDevices(String arg0) throws IOException {
        String s;
        Process p;
        String path="";
       if(arg0.equals("MotoG4")){
           path = "/home/bressan/devices/./motog4.sh";
        }
        if(arg0.equals("J5Prime")){
            path = "/home/bressan/devices/./j5prime.sh";
        }
        if(arg0.equals("GalaxyA7")){
            path = "/home/bressan/devices/./galaxya7.sh";
        }



        try {
            p = Runtime.getRuntime().exec(path);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line: " + s);
            p.waitFor();
            System.out.println ("exit: " + p.exitValue());
            p.destroy();
        } catch (Exception e) {}



    }
}
