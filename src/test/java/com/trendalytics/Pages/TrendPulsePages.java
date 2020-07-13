package com.trendalytics.Pages;

import com.trendalytics.Runners.BaseTest;
import com.trendalytics.Utils.Config;
import com.trendalytics.Utils.Instrumentation;

import java.io.IOException;

public class TrendPulsePages extends BaseTest {

    public static void selectTrendDiscovery() throws IOException {
        Instrumentation.clickWeb(Webdriver,"xpath","/html/body/aside/div[1]/div[1]/div[1]/div[1]/div/div[1]/div/div/div","Clicou em Trend Discovery Menu");
    }

    public static void SelectDefaultMailFilter() throws IOException {
        Instrumentation.clickWeb(Webdriver,"xpath","/html/body/aside/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div","Select Default Main Filter");
    }

    public static void switchToTableView() throws IOException {
        Instrumentation.clickWeb(Webdriver,"xpath","//*[@id='comparison']/div/div/div[1]/div/div[2]/div/button[1]","Clicou swith table view");
    }

    public static void selectMonth(String arg0) throws Exception {


        switch (arg0) {
            case "1m":
                Instrumentation.clickWeb(Webdriver, Config.xpath, "//*[@id='comparison']/div/div/div[3]/div/div[2]/div[2]/div/div[1]/div/label[3]/span", "Clicou 1m");
                break;
            case "3m":
                Instrumentation.clickWeb(Webdriver, Config.xpath, "//*[@id='comparison']/div/div/div[3]/div/div[2]/div[2]/div/div[1]/div/label[2]/span", "Clicou 3m");
                break;
            case "6m":
                Instrumentation.clickWeb(Webdriver, Config.xpath, "//*[@id='comparison']/div/div/div[3]/div/div[2]/div[2]/div/div[1]/div/label[1]/span", "Clicou 6m");
                break;
            default:
                throw new Exception("Invalid option");
        }
    }


    public static void searchTable(String arg0) throws IOException {
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath,"//*[@id='comparison']/div/div/div[5]/div[1]/div[3]/div[2]/div/div[1]/div[2]/div/div/input",arg0,"");
    }

    public static void checkAvgWeeklySearches(String arg0) throws IOException {
        //Instrumentation.collectByClassNameIndex(Webdriver,"formatter-block",arg0,"");
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'" + arg0 + "')]","AVG");
    }

    public static void checkTYLYGrowth(String arg0) throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'" + arg0 + "')]","AVG");
    }
}

