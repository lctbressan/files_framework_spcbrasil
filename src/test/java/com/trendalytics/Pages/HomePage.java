package com.trendalytics.Pages;
import com.trendalytics.Runners.BaseTest;
import com.trendalytics.Utils.Instrumentation;
import com.trendalytics.Utils.Config;
import com.trendalytics.interfaces.DriverFactory;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class HomePage extends BaseTest {


    public static void thatTheUserIsOnTheHomeScreen() throws Exception {
       // DriverFactory.getDriver();
    }

    public static void sendCredencialsAnd(String arg0, String arg1) throws IOException, InterruptedException {
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath,"//input[@name='user']",arg0,"Type User");
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath,"//input[@name='pass']",arg1,"Type Pass");
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//input[@name='commit']","Confirm");
    }

    public static void GetMessageHome(String arg1) throws Exception {


        switch (arg1) {
            case "Press":
                Thread.sleep(1000);
                Instrumentation.clickWeb(Webdriver, Config.xpath,"/html/body/div[2]/section[1]/div/div/div/div/div/div[1]/div/h1","Check "+ arg1 );
                break;
            case "The closest thing to a crystal ball":
                Thread.sleep(1000);
                Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'"+ arg1 +"')]","");
                break;
            case "The leadership team":
                Thread.sleep(1000);
                Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[@id='menu-item-7336']/a","");
                break;
            case "Join the team":
            case "Your personal data scientist":
                Thread.sleep(1000);
                Instrumentation.clickWeb(Webdriver, Config.xpath,"/html/body/div[2]/section[1]/div/div/div/div/div/div/div/h1","");
                break;

            default:
                throw new Exception("Invalid option");
        }

}


    public static void confirmActionHome() throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//input[@name='submit']","Confirm");
    }

    public static void clickOnProductLink(String arg0) throws Exception {

        switch (arg0) {
            case "Product":
                Thread.sleep(1000);
                Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[@id='menu-item-7305']/a","Click " + arg0);
                break;
            case "Press":
                Thread.sleep(1000);
                Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[@id='menu-item-7319']/a","Click " + arg0);
                break;
            case "THOUGHT LEADERSHIP":
                Thread.sleep(1000);
                Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[@id='menu-item-7310']/a","Click " + arg0);
                break;
            case "ABOUT":
                Thread.sleep(1000);
                Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[@id='menu-item-7326']","Click " + arg0);
                break;
            case "LEADERSHIP":
                Thread.sleep(1000);
                Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[@id='menu-item-7329']/a","Click " + arg0);
                break;
            case "CAREERS":
                Thread.sleep(1000);
                Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[@id='menu-item-7336']/a","Click " + arg0);
                break;


            default:
                throw new Exception("Invalid option");
        }



    }



    public static void acceptCookies() throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[@id='cookie_action_close_header']","Click Cookies");

    }
}
