package com.br.spcbrasil.Steps.Hook;

import com.br.spcbrasil.Pages.LoginPage;
import com.br.spcbrasil.Utils.Config;
import com.br.spcbrasil.Utils.Instrumentation;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.PickleStepTestStep;
import cucumber.api.Scenario;
import cucumber.api.TestCase;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.SkipException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.br.spcbrasil.Utils.Config.TestWeb;

public class Hook extends BaseStep{

    PickleStepTestStep currentStep;
    private int counter = 0;

    @BeforeClass
    public static void inicializaAutomacao() throws Exception {
        System.out.println("#####################################################################################}");
        System.out.println("                  { STARTING AUTOMATION WAIT }");
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
    public static void finalizaAutomacao() throws Exception {

        //Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Win/Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");
        Reporter.assignAuthor("Braziltest");

        System.out.println("Finalizando Testes");
        System.out.println("#####################################################################################}");
        System.out.println("                  { CLOSING AUTOMATION ..}");
        System.out.println("                  { DEALOCATE DEVICE " + Config.PlatformDeviceName + "  }");
        System.out.println("#####################################################################################}");
        Instrumentation.setDeviceReady(Config.PlatformDeviceName);
        if(driver != null) {
            driver.quit();
            driver = null;
            if (Config.TestWeb.equals("")) {
                Webdriver.quit();
            }
        }




    }
    @BeforeStep
    public void getStepName(Scenario scenario) throws Exception {

        Field f = scenario.getClass().getDeclaredField("testCase");
        f.setAccessible(true);
        TestCase r = (TestCase) f.get(scenario);

        List<PickleStepTestStep> stepDefs = r.getTestSteps()
                .stream()
                .filter(x -> x instanceof PickleStepTestStep)
                .map(x -> (PickleStepTestStep) x)
                .collect(Collectors.toList());

        currentStep = stepDefs.get(counter);

        System.out.println(currentStep.getStepText());

    }


 /*   @Before
    public void before(Scenario scenario) throws Exception {
        TestWeb = "MOBILE";
        LoginPage.openSpcBrasilEmpresas("ANDROID");
    }*/
    @AfterStep
    public void afterStep(Scenario scenario) {
        if(driver != null) {
            driver.quit();
            driver = null;
            if (Config.TestWeb.equals("")) {
                Webdriver.quit();
            }
        }
    }
    @After
    public void after() {
        if(driver != null) {
            driver.quit();
            driver = null;
            if (Config.TestWeb.equals("")) {
                Webdriver.quit();
            }
        }
    }

    private void skippedScenario(Scenario scenario) {
        Optional<String> findFirst = scenario.getSourceTagNames().stream().filter(p -> p.equalsIgnoreCase("@bug"))
                .findFirst();

        if (findFirst.isPresent())
            throw new SkipException("O cenario não pode ser executado, pois existe um bug que impede a execução.");
    }
}
