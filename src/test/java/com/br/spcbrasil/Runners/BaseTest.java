package com.br.spcbrasil.Runners;

import com.br.spcbrasil.Steps.Hook.BaseStep;
import com.br.spcbrasil.Utils.Config;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.File;

public abstract class BaseTest extends BaseStep {



   @BeforeClass
    public static void inicializaAutomacao() throws Exception {
        System.out.println("#####################################################################################}");
        System.out.println("                  {STARTING AUTOMATION WAIT }");
        System.out.println("#####################################################################################}");
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;


       if(System.getProperty("os.name").contains("Windows")) {
           extentProperties.setReportPath(Config.PATHEVIDENCEWIN+"/report.html");
       }
       if(System.getProperty("os.name").contains("Linux")){
           extentProperties.setReportPath(Config.PATHEVIDENCELINUX+"/report.html");
       }

    }

    @AfterClass
    public static void finalizaAutomacao() {

            Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
            Reporter.setSystemInfo("user", System.getProperty("user.name"));
            Reporter.setSystemInfo("os", "Win/Mac OSX");
            Reporter.setTestRunnerOutput("Sample test runner output message");
            Reporter.assignAuthor("Braziltest");

            System.out.println("Finalizando Testes");
            System.out.println("#####################################################################################}");
            System.out.println("                  { CLOSING AUTOMATION ..}");
            System.out.println("#####################################################################################}");




    }

}
