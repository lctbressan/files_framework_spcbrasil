package com.spcbrasil.Steps.Hook;

import static com.spcbrasil.Utils.Config.*;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.NoSuchElementException;

public abstract class Hook extends BaseStep {


    @BeforeClass
    public static void inicializaAutomacao() throws Exception {
        System.out.println("#####################################################################################}");
        System.out.println("                  {STARTING AUTOMATION WAIT PLS - }");
        System.out.println("                        RUNNER "+ RunnerNbr +" ");
        System.out.println("#####################################################################################}");
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;

        String pathCucumber = "" ;
        if (System.getProperty("os.name").contains("Windows")) {
            extentProperties.setReportPath(PATHEVIDENCEWIN + "/report.html");
        }

        if (System.getProperty("os.name").contains("Linux")) {
            extentProperties.setReportPath(PATHEVIDENCELIN + "/report.html");
        }

        if ( System.getProperty("os.name").contains("Mac OS X")) {
                extentProperties.setReportPath(PATHEVIDENCEMAC + "/report.html");

        }

    }

    @AfterClass
    public static void finalizaAutomacao() {
        try {
            //Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
            Reporter.setSystemInfo("user", System.getProperty("user.name"));
            Reporter.setSystemInfo("os", "Win/Mac OSX");
            Reporter.setTestRunnerOutput("Sample test runner output message");
            Reporter.assignAuthor("BRAZILTEST");

            System.out.println("Finalizando Testes");
            System.out.println("#####################################################################################}");
            System.out.println("                  {CLOSING AUTOMATION ..}");
            System.out.println("#####################################################################################}");
            //Webdriver.quit();

        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }

    private String getFeatureFileNameFromScenarioId(Scenario scenario) {
        String featureName = "Feature ";
        String rawFeatureName = scenario.getId().split(";")[0].replace("-", " ");
        featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);

        return featureName;
    }


    @Before
    public void before(Scenario scenario) {
        ScenarioName = scenario.getName();
        ScenarioId = scenario.getId();
        FeatureName = getFeatureFileNameFromScenarioId(scenario);
    }

     @After
    public void after() {
        Webdriver.quit();
    }

}


