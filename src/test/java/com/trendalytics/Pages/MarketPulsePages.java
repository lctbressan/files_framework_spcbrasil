package com.trendalytics.Pages;

import com.trendalytics.Runners.BaseTest;
import com.trendalytics.Utils.Config;
import com.trendalytics.Utils.Instrumentation;

import java.io.IOException;

public class MarketPulsePages extends BaseTest {
    public static void selectFilterCategory(String arg0) throws IOException, InterruptedException {
        Thread.sleep(1000);
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'"+ arg0 +"')]","");

    }

    public static void selelectCategory(Integer total,Integer Index) throws IOException {
        String prmXpath = null;


        if(total==2) {
            prmXpath = "";
        }

        if(total==3) {
            prmXpath = "//*[@id='page-main']/nav/ul/div/div[2]/treecontrol2/treeitem2/treeitem2/div/div[1]/ul/li["+ Index +"]/div/div/span";
        }

        if(total==4) {
            prmXpath = "//*[@id='page-main']/nav/ul/div/div[2]/treecontrol2/treeitem2/treeitem2/treeitem2/div/div[1]/ul/li[4]/i[1]";
        }

        if(total==5) {
            prmXpath = "";
        }

//*[@id='page-main']/nav/ul/div/div[2]/treecontrol2/treeitem2/treeitem2/treeitem2/div/div[1]/ul/li[4]/div/div
        Instrumentation.clickWeb(Webdriver, Config.xpath,prmXpath,"");

    }

    public static void SetFilter() throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.className,"button-dark","Click on Set Filter");

    }
}
