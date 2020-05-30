package com.trendalytics.Pages;
import com.trendalytics.Runners.BaseTest;
import com.trendalytics.Utils.Instrumentation;
import com.trendalytics.Utils.Constants;
import com.trendalytics.interfaces.DriverFactory;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BaseTest {


    public static void thatTheUserIsOnTheHomeScreen() throws Exception {
        DriverFactory.getDriver();
    }

    public static void sendCredencialsAnd(String arg0, String arg1) throws IOException, InterruptedException {
        Instrumentation.sendKeysWeb(Webdriver, Constants.xpath,"//input[@name='user']",arg0,"Type User");
        Instrumentation.sendKeysWeb(Webdriver, Constants.xpath,"//input[@name='pass']",arg1,"Type Pass");
        Instrumentation.clickWeb(Webdriver, Constants.xpath,"//input[@name='commit']","Confirm");
    }

    public static void GetMessage(String arg1) throws Exception {
        Instrumentation.clickWeb(Webdriver, Constants.xpath,"//*[contains(text(),'"+ arg1 +"')]","");
}


    public static void confirmAction() throws IOException {
        Instrumentation.clickWeb(Webdriver, Constants.xpath,"//input[@name='submit']","Confirm");
    }
}
