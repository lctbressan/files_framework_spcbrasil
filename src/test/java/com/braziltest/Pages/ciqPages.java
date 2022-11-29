package com.braziltest.Pages;

import com.braziltest.Steps.Hook.BaseStep;
import com.braziltest.Utils.Config;
import com.braziltest.Utils.Instrumentation;
import org.openqa.selenium.By;

import java.io.IOException;


public class ciqPages extends BaseStep {


    public static void fillEmail(String arg0) throws IOException {
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath, "//input[@name='email']",arg0, "Confirm");
    }

    public static void fillPassword(String Env, String arg0) throws IOException {

        if(Env.equals("ciq")){
            Instrumentation.sendKeysWeb(Webdriver, Config.xpath, "//html/body/div[1]/div[5]/div[2]/div[6]/div/div/input",arg0, "Confirm");
        }
        if(Env.equals("smc")){
            Instrumentation.sendKeysWeb(Webdriver, Config.xpath, "//input[@name='password']",arg0, "Confirm");

        }

    }

    public static void cickLogin() throws IOException, InterruptedException {
        Thread.sleep(2000);
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'Login')]","");
        waitingfor("EXPERIÊNCIA BOA");
    }

    public static void clickcaptcha() throws IOException {
        Webdriver.switchTo().frame(0);
        Webdriver.findElement(By.cssSelector("div.rc-anchor-content")).click();
        Webdriver.switchTo().defaultContent();

        }


    public static void waitingfor(String SomeItemScreen) throws IOException, InterruptedException
    {
        System.out.println("Waiting For screen element ..." + SomeItemScreen );
            for (int i = 0; i < 500; i++) {
                String ResultScreen = Instrumentation.waitngFor(Webdriver, SomeItemScreen);
                if (ResultScreen == "YES") {
                    break;
                }
            }}

}
