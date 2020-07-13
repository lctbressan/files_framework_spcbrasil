package com.trendalytics.Steps;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;
import com.trendalytics.Pages.MarketPulsePages;
import com.trendalytics.Pages.ReportsPages;
import com.trendalytics.Runners.BaseTest;
import com.trendalytics.Utils.Instrumentation;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MarketPulseSteps extends BaseTest {
    private RequestSpecification request;
    private Response responsePRD;
    private final Logger log = LoggerFactory.getLogger(MarketPulseSteps.class);
    private String JsonPRD;


    @When("^click module MarketPulse")
    public void clickModuleMarketPulse() throws Exception {
        ReportsPages.clickModule("MarketPulse");
    }

    @And("^select filter Category \"([^\"]*)\" and IndexColumnItem \"([^\"]*)\"$")
    public void selectFilterCategoryAndIndecColumn(String arg0,Integer arg1) throws IOException, InterruptedException {

        String str =arg0;
        String[] arrOfStr = str.split(";");
        System.out.println("Number of substrings: "+arrOfStr.length);
        Integer total = arrOfStr.length;
        for(int i=0; i< arrOfStr.length; i++)
        {
            System.out.println("str["+i+"] : "+arrOfStr[i]);
            MarketPulsePages.selectFilterCategory(arrOfStr[i]);
        }

        MarketPulsePages.selelectCategory(total,arg1);
 
    }

    @And("click in Set filter")
    public void clickInSetFilter() throws IOException {
        MarketPulsePages.SetFilter();
    }

    @And("Click Retailes Shop Cart")
    public void clickRetailesShopCart() throws IOException, InterruptedException {

        MarketPulsePages.selectFilterCategory("retailers");
    }

    @And("Collect all retails")
    public void collectAllRetails() throws IOException {
        Instrumentation.collectByClassNameIndex(Webdriver,"ng-scope","","");
    }


}
