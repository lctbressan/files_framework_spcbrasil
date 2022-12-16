package com.braziltest.Pages;

import com.braziltest.Steps.Hook.BaseStep;
import com.braziltest.Utils.Config;
import com.braziltest.Utils.Instrumentation;

import java.io.IOException;

public class ciqPages extends BaseStep {


    public static void clickInMenu(String arg0) throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'"+ arg0 +"')]","click " + arg0);
    }

    public static void clickOnCiqFilter(String arg0) throws IOException {
        Instrumentation.clickWeb(Webdriver,Config.xpath,"/html/body/div/div[9]/div[2]/div/div/div[3]/div/div/div[1]/div[1]/div/div","");
    }

    public static void clickOnRegion(String arg0) throws IOException {
        Instrumentation.clickWeb(Webdriver,Config.xpath,"/html/body/div/div[9]/div[2]/div/div/div[3]/div/div/div[1]/div[1]/div/div[2]/div[4]/div[1]/div[3]/div","");
    }

    public static void cickConfirmar() throws IOException {
        Instrumentation.clickWeb(Webdriver,Config.xpath,"/html/body/div/div[9]/div[2]/div/div/div[3]/div/div/div[1]/div[1]/div/div[2]/div[5]/div[2]/p","");
    }
}
