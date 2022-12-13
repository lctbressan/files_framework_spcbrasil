package com.braziltest.Pages;

import com.braziltest.Steps.Hook.BaseStep;
import com.braziltest.Utils.Config;
import com.braziltest.Utils.Instrumentation;

import java.io.IOException;

public class ciqPages extends BaseStep {


    public static void clickInMenu(String arg0) throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'"+ arg0 +"')]","click " + arg0);
    }
}
