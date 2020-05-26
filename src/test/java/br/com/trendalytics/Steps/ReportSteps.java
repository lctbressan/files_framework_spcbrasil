package br.com.trendalytics.Steps;

import br.com.trendalytics.Pages.LoginPage;
import br.com.trendalytics.Pages.ReportsPages;
import br.com.trendalytics.Runners.BaseTest;
import br.com.trendalytics.Utils.Constants;
import br.com.trendalytics.Utils.Instrumentation;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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
        //LoginPage.confirmAction();
    }



    @After
    public void tearDownSteps(){
        Webdriver.close();
    }

    @And("^click to create a report")
    public void clickToCreateAReport() throws IOException {
        ReportsPages.clickToCreateAReport();
    }

    @And("^click on the tab \"([^\"]*)\"$")
    public void clickOn(String arg0) throws Exception {
        LoginPage.GetMessage(arg0);
    }

    @And("^download a PDF Report")
    public void downloadAPDFReport() throws IOException, InterruptedException {
        ReportsPages.downloadPdfReport();
    }

    @And("^Click verify on subscription event")
    public void clickVerifyOnSubscriptionEvent() throws Exception {
        ReportsPages.clickVerifyOnSubscriptionEvent();
    }

    @And("^verify the email alert \"([^\"]*)\"$")
    public void verifyTheEmailAlert(String arg0) throws IOException {
        ReportsPages.verifyTheEmailAlert(arg0);
    }

    @Then("^I get the status \"([^\"]*)\"$")
    public void IgettheStatus(String arg1) throws Throwable {
        ReportsPages.GetStatus(arg1);
    }

    @And("click Create a Report")
    public void clickCreateAReport() throws IOException {
        ReportsPages.clickCreateAReport();
    }


    @And("^create a Report Type \"([^\"]*)\"$")
    public void createAReporttype(String arg0) throws Exception {
        ReportsPages.chooseAReport(arg0);
     }

    @And("^click Type \"([^\"]*)\"$")
    public void clickType(String arg0) throws Exception {
        ReportsPages.chooseTypeReport(arg0);
    }

    @And("^click Brand \"([^\"]*)\"$")
    public void clickBrand(String arg0) throws Exception {
        ReportsPages.clickBrand(arg0);
    }

    @And("^click Retail \"([^\"]*)\"$")
    public void clickRetail(String arg0) throws Exception {
        ReportsPages.clickRetail(arg0);
    }

    @And("^click Category \"([^\"]*)\"$")
    public void clickCategory(String arg0) throws IOException {
        ReportsPages.clickCategory(arg0);
    }

    @Then("^click submit")
    public void clickSubmit() throws IOException, InterruptedException {
        Thread.sleep(3000);
        ReportsPages.clickSubmit();
        Thread.sleep(3000);
    }


    @When("click module Admin")
    public void clickModuleAdmin() throws Exception {
        ReportsPages.clickModule("Admin");
    }

    @When("^click module Report")
    public void clickModuleReport() throws Exception {
        ReportsPages.clickModule("Report");
    }

    @And("^type Name \"([^\"]*)\"$")
    public void typeName(String arg0) throws IOException {
        ReportsPages.setReportName(arg0);
    }

    @And("^Select Trends")
    public void selectTrends() throws IOException {
        ReportsPages.selectTrends();
    }

    @And("^Fill name of report \"([^\"]*)\"$")
    public void fillNameOfReport(String arg0) throws Exception {
        ReportsPages.fillNameOfReport(arg0);
         LoginPage.GetMessage(arg0);
    }
}
