package com.trendalytics.Runners;

import static com.trendalytics.Utils.Config.PATHEVIDENCE;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public abstract class BaseTest {

    public static WebDriver  Webdriver;
    public static WebDriverWait wait;

   @BeforeClass
    public static void inicializaAutomacao() throws Exception {
        System.out.println("#####################################################################################}");
        System.out.println("                  {STARTING AUTOMATION WAIT PLS}");
        System.out.println("#####################################################################################}");
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath(PATHEVIDENCE+"/report.html");
    }

    @AfterClass
    public static void finalizaAutomacao() {
        try {
            Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
            Reporter.setSystemInfo("user", System.getProperty("user.name"));
            Reporter.setSystemInfo("os", "Win/Mac OSX");
            Reporter.setTestRunnerOutput("Sample test runner output message");
            Reporter.assignAuthor("JoyJet");

            System.out.println("Finalizando Testes");
            System.out.println("#####################################################################################}");
            System.out.println("                  {CLOSING AUTOMATION ..}");
            System.out.println("#####################################################################################}");
            Webdriver.quit();

        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }


    }

}
