package br.com.trendalytics.Pages;
import br.com.trendalytics.Runners.BaseTest;
import br.com.trendalytics.Utils.Instrumentation;
import br.com.trendalytics.Utils.Constants;
import br.com.trendalytics.interfaces.DriverFactory;
import static br.com.trendalytics.Utils.Constants.xpath;
import static br.com.trendalytics.Utils.Constants.className;
import static br.com.trendalytics.Utils.Constants.cssSelector;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BaseTest{


    public static void thatTheUserIsOnTheHomeScreen() throws Exception {
        DriverFactory.getDriver();
    }

    public static void sendCredencialsAnd(String arg0, String arg1) throws IOException, InterruptedException {
        Instrumentation.sendKeysWeb(Webdriver,xpath,"//input[@name='user']",arg0,"Type User");
        Instrumentation.sendKeysWeb(Webdriver,xpath,"//input[@name='pass']",arg1,"Type Pass");
        Instrumentation.clickWeb(Webdriver,xpath,"//input[@name='commit']","Confirm");
    }

    public static void GetMessage(String arg1) throws Exception {
        String msg ="";
        Constants plat = new Constants();
        Thread.sleep(1500);
        switch (arg1)
        {
            case "My Comparison":
                msg = "My Comparison";
                break;
            case "Assortment Comparison":
                msg = "Assortment Comparison Report";
                break;
            case "Logged":
                msg = "Trend Discovery";
                break;
            case "NotLogged":
                msg = "Wrong Username/Email and password combination.";
                break;
            case "LEVKOFF at Multiple Retail Sites":
                msg = "Assortment Comparison Report - #LEVKOFF at Multiple Retail Sites";
                break;
            case "2019.02 FEBRUARY TOP WOMENS TRENDS":
                msg = "2019.02 FEBRUARY TOP WOMENS TRENDS";
                break;
            case "Shared with me":
                msg = "Shared with me";
                break;
            case "Q1 2019":
                msg="Q1 2019: Ingredients Dashboard";
                break;
            case "2Modern":
                msg="2Modern - SEO Opportunities For Accessories - Bag Charms & Straps - 05-19-20";
                break;
            case "SEO Opportunity Report":
                msg="SEO Opportunity Report";
                break;

            default:
                throw new Exception("Invalid option");
        }
        Instrumentation.clickWeb(Webdriver,xpath,"//*[contains(text(),'"+ msg +"')]","");
}


    public static void confirmAction() throws IOException {
        Instrumentation.clickWeb(Webdriver,xpath,"//input[@name='submit']","Confirm");
    }
}
