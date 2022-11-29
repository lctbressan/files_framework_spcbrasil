package com.braziltest.Steps.Hook;

import com.braziltest.Pages.HomePage;
import com.braziltest.Utils.Instrumentation;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.*;

import static org.junit.Assert.assertTrue;

public class testQaSteps extends BaseStep {

    int RetCode=0;
    String process;

    @Given("^process file on repository" )
    public void processFileOnRepository(String arg1) throws Throwable {

    }

    @Given("^Check folder file \"([^\"]*)\" and FileControl \"([^\"]*)\" in path \"([^\"]*)\" is not empty$")
    public void checkFolderFileAndFileControlIsNotEmpty(String arg1, String arg2,String path) throws Throwable {
        String fileABCxml="",fileABCok="";
        File folder = new File(System.getProperty("user.dir") + path);
        String Arq = Instrumentation.findAllFilesInFolder(folder);
        for (String item : Arq.split(";")) {
            Reporter.addStepLog("Files find : " + item );
                if(item.equals(arg1)){
                    fileABCxml= "OK";
                }

                if(item.equals(arg2)){
                    fileABCok= "OK";
                }

        }
        if(fileABCok.equals("OK")&&fileABCxml.equals("OK")) {
            assertTrue(true);
            RetCode=200;
        }else{
            assertTrue(false);
            RetCode=501;
        }
    }

    @Given("^get return code for check \"([^\"]*)\"$")
    public void getReturnCodeForCheck(String arg1) throws Throwable {

        if(RetCode == 200) {
            assertTrue(true);
        }else{
            assertTrue(false);
        }

    }

    @Given("^confirm system date \"([^\"]*)\"$")
    public void confirmSystemDate(String arg1) throws Throwable {
        String SDOK = "";
        String SDNOK  = "";
        String SystemDate = "2021-11-05";
        Reporter.addStepLog("Check System Date : " + SystemDate );

        if(arg1.equals(SystemDate)){
            SDOK = "200";
        }else{
            SDNOK = "403";
        }

        if(SDOK.equals(arg1)){
            assertTrue(true);
        }
        if(SDNOK.equals(arg1)){
            assertTrue(true);
        }
    }

    @When("^check \"([^\"]*)\" is empty in path \"([^\"]*)\"$")
    public void serviceCheckIsEmpty(String arg1,String path) throws Throwable {
        String finalLine = "";
        File folder = new File(System.getProperty("user.dir") + path);
        String Arq = Instrumentation.findAllFilesInFolder(folder);
        for (String item : Arq.split(";")) {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream( "arquivos//" + item);
            String data = readFromInputStream(inputStream);
            System.out.println("VERIFICANDO ARQUIVO  " + item ) ;
            for (String line : data.split("\n")) {
                finalLine = finalLine + line;
            }
        }
        if(finalLine.equals("")){
            assertTrue(true);
        }else{
            assertTrue(false);
        }
    }

    @Then("^Process file \"([^\"]*)\" and get result from \"([^\"]*)\"$")
    public void processFileAndGetResultFrom(String arg1, String arg2) throws Throwable {
        try{

            String cmd = "cmd.exe /c dir %s";
            Runtime run = Runtime.getRuntime();
            Process pr = run.exec(cmd);
            pr.waitFor();
            BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line = "";
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
            }
            process = "OK";
        }catch(Exception e){
            System.out.println("And error "+ e);
            assertTrue(false);
        }
    }

    @Then("^The return code should be \"([^\"]*)\"$")
    public void theReturnCodeShouldBe(String arg1) throws Throwable {
        if(process.equals("OK")){
            assertTrue(true);
        }else{
            assertTrue(false);
        }
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br  = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    @And("wait show up \"([^\"]*)\"$")
    public void waitShowUp(String arg0) {
    }

    @And("click in buscar cep")
    public void clickInBuscarCep() throws Exception {
        HomePage.buscarCep();
    }

    @And("fill Buscar no site \"([^\"]*)\"$")
    public void fillBuscarNoSite(String arg0) throws IOException {
        HomePage.fillBuscarNoSite(arg0);
    }



    @And("cick Buscar")
    public void cickBuscar() throws IOException {
        HomePage.cickBuscar();
    }
     @After
    public void after() {
         Webdriver.quit();
    }
}
