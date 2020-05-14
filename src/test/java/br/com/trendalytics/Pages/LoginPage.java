package br.com.trendalytics.Pages;
import br.com.trendalytics.Runners.BaseTest;
import br.com.trendalytics.Utils.Instrumentation;
import br.com.trendalytics.Utils.Constants;
import br.com.trendalytics.interfaces.DriverFactory;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BaseTest{


    public static void thatTheUserIsOnTheHomeScreen() throws Exception {
        DriverFactory.getDriver();
    }

    public static void sendCredencialsAnd(String arg0, String arg1) throws IOException, InterruptedException {

        Instrumentation.sendKeysByXpathWeb(Webdriver,"//input[@name='user']",arg0,"Type User");

        Instrumentation.sendKeysByXpathWeb(Webdriver,"//input[@name='pass']",arg1,"Type Pass");

        Instrumentation.clickByXpathWeb(Webdriver,"//input[@name='commit']","Confirm");

    }

    public static void Message(String arg1) throws Exception {
        String msg ="";
        Constants plat = new Constants();
        switch (arg1)
        {
            case "Logged":
                msg = "Trend Discovery";
                break;
            case "NotLogged":
                msg = "Wrong Username/Email and password combination.";
                break;
            default:
                throw new Exception("Invalid option");
        }

        Instrumentation.clickByXpathWeb(Webdriver,"//*[contains(text(),'"+ msg +"')]","");

    }

    public static void confirmAction() throws IOException {
        Instrumentation.clickByXpathWeb(Webdriver,"//input[@name='submit']","Confirm");
    }
}
