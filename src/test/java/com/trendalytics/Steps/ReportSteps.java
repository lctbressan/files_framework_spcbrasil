package com.trendalytics.Steps;

import com.trendalytics.Pages.LoginPage;
import com.trendalytics.Pages.ReportsPages;
import com.trendalytics.Runners.BaseTest;
import com.trendalytics.Utils.Config;
import com.trendalytics.Utils.Instrumentation;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;

import java.awt.*;
import java.io.IOException;

public class ReportSteps extends BaseTest {
Config cons = new Config();


    @Given("^that the user is logged \"([^\"]*)\"$")
    public void thatTheUserIsLogged(String arg0) throws Throwable {
        LoginPage.thatTheUserIsOnTheHomeScreen(arg0);
        Instrumentation.takeScreenshot(Webdriver,"Screen Home");
        LoginPage.sendCredencialsAnd( cons.email,cons.passw);
        LoginPage.confirmAction();
    }



    @After
    public void tearDownSteps(){
        Webdriver.close();
    }

    @And("^click to create a report")
    public void clickToCreateAReport() throws IOException {
        ReportsPages.clickToCreateAReport();
    }

    @And("^click on the option \"([^\"]*)\"$")
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

    @And("click Brand")
    public void clickBrand() throws Exception {
        ReportsPages.clickBrand();
    }

    @And("click Retail")
    public void clickRetail() throws Exception {
        ReportsPages.clickRetail();
    }

    @And("click Category")
    public void clickCategory() throws IOException {
        ReportsPages.clickCategory();
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
        String ReportName = arg0 +"-"+ cons.dataAtual;
        ReportsPages.setReportName(ReportName);
    }

    @And("^Select Trends")
    public void selectTrends() throws IOException {
        ReportsPages.selectTrends();
    }

    @And("^Fill name of report \"([^\"]*)\"$")
    public void fillNameOfReport(String arg0) throws Exception {
        String ReportName = arg0 +"-"+ cons.dataAtual;
        ReportsPages.fillNameOfReport(ReportName);
         LoginPage.GetMessage(arg0);
    }

    @And("click on the tab \"([^\"]*)\" and the tab \"([^\"]*)\"$")
    public void clickOnTheTabAndTheTab(String arg0, String arg1) throws Exception {

        LoginPage.GetMessage(arg0);

        LoginPage.GetMessage(arg1);
    }

    @And("click on the tab \"([^\"]*)\"$")
    public void clickOnTheTab(String arg0) throws Exception {

        LoginPage.GetMessage(arg0);


    }
    @And("Click on email alerts")
    public void clickOnEmailAlerts() throws IOException {
        ReportsPages.clickOnEmailAlerts();
    }

    @And("^search for user email \"([^\"]*)\"$")
    public void searchForUserEmail(String arg0) throws IOException, InterruptedException {
        String ReportName = arg0 +"-"+ cons.dataAtual;
        ReportsPages.searchForUserEmail(ReportName);
        Thread.sleep(2000);
    }

    @When("click module \"([^\"]*)\"$")
    public void clickModule(String arg0) throws Exception {
        ReportsPages.clickModule(arg0);
    }

    @And("Download Excel Current \"([^\"]*)\"$")
    public void downloadExcelCurrent(String arg0) throws IOException, InterruptedException {
        String ReportName = arg0 +"-"+ cons.dataAtual;
        ReportsPages.downloadExcelCurrent(ReportName);

    }

    @And("^Download Excel History \"([^\"]*)\"$")
    public void downloadExcelHistory(String arg0) throws IOException, InterruptedException {
        String ReportName = arg0 +"-"+ cons.dataAtual;
        ReportsPages.downloadExcelHistory(ReportName);
    }

    @Then("Check created Report")
    public void checkCreatedReport() throws IOException {
        ReportsPages.checkCreatedReport();
    }

    @And("click Save")
    public void clickSave() throws AWTException, IOException {
        ReportsPages.clickSave();
    }
}