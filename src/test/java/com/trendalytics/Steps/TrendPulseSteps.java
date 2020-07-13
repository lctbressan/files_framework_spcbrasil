package com.trendalytics.Steps;

import com.trendalytics.Pages.ReportsPages;
import com.trendalytics.Pages.TrendPulsePages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;

public class TrendPulseSteps {



    @When("^click module TrendPulse")
    public void clickModuleTrendPulse() throws Exception {
        ReportsPages.clickModule("TrendPulse");
    }

    @And("select Trend Discovery")
    public void selectTrendDiscovery() throws IOException {
        TrendPulsePages.selectTrendDiscovery();
    }

    @And("select Default Main Filter")
    public void selectDefaultMainFilter() throws IOException {
        TrendPulsePages.SelectDefaultMailFilter();
    }


    @And("switch to table view")
    public void switchToTableView() throws IOException {
        TrendPulsePages.switchToTableView();
    }

    @And("^select month \"([^\"]*)\"$")
    public void selectMonth(String arg0) throws Exception {
        TrendPulsePages.selectMonth(arg0);
    }

    @And("^Search Table \"([^\"]*)\"$")
    public void searchTable(String arg0) throws Exception {
        TrendPulsePages.searchTable(arg0);
    }

    @Then("^check Avg Weekly Searches \"([^\"]*)\"$")
    public void checkAvgWeeklySearches(String arg0) throws Exception {
        TrendPulsePages.checkAvgWeeklySearches(arg0);
    }

    @And("^check TY/LY Growth \"([^\"]*)\"$")
    public void checkTYLYGrowth(String arg0) throws IOException {
        TrendPulsePages.checkTYLYGrowth(arg0);
    }

}
