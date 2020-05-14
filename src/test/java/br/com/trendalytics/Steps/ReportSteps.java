package br.com.trendalytics.Steps;

import br.com.trendalytics.Pages.LoginPage;
import br.com.trendalytics.Pages.ReportsPages;
import br.com.trendalytics.Runners.BaseTest;
import br.com.trendalytics.Utils.Constants;
import br.com.trendalytics.Utils.Instrumentation;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.After;

import java.io.IOException;

public class ReportSteps extends BaseTest {
Constants cons = new Constants();
    @Before
    public void setup() throws Exception {

    }
    @Given("^that the user is logged$")
    public void thatTheUserIsLogged() throws Throwable {
        Instrumentation.takeScreenshot(Webdriver,"Screen Home");
        LoginPage.sendCredencialsAnd( cons.email,cons.passw);
        LoginPage.confirmAction();
    }

    @When("^click module \"([^\"]*)\"$")
    public void clickModule(String arg1) throws Throwable {
        ReportsPages.clickModule(arg1);
    }

    @After
    public void tearDownSteps(){
        Webdriver.close();
    }

    @And("click to create a report")
    public void clickToCreateAReport() throws IOException {
        ReportsPages.clickToCreateAReport();
    }
}
