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
        Instrumentation.clickWeb(Webdriver,xpath,"//*[contains(text(),'"+ arg1 +"')]","");
}


    public static void confirmAction() throws IOException {
        Instrumentation.clickWeb(Webdriver,xpath,"//input[@name='submit']","Confirm");
    }
}
