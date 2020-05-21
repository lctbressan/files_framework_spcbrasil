package br.com.trendalytics.Steps;

import br.com.trendalytics.Pages.DashboardPages;
import cucumber.api.java.en.And;

public class DashboardSteps {


    @And("Click out")
    public void clickOut() {
        DashboardPages.clickOut();


    }
}
