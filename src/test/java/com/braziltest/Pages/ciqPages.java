package com.braziltest.Pages;

import com.braziltest.Steps.Hook.BaseStep;
import com.braziltest.Utils.Config;
import com.braziltest.Utils.Instrumentation;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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

    public static void clickInTotalDeAtivos() throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'Total de Ativos')]","");

    }

    public static void clickInNotebooks() throws IOException, InterruptedException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'Notebook')]","");
        Thread.sleep(2000);
        String Ret = Instrumentation.listWebElementClass(Webdriver,"smp-tooltiptext");
        for (String line : Ret.split(";")) {
            System.out.println(line);
            if(!line.equals("")){
                System.out.println(line);
                Config.prmCardCoout = Integer.valueOf(line.replace(";",""));
                break;
            };
        }
    }

    public static void checkFromTheListTotalMatch(String arg0) throws IOException, InterruptedException {

        String Ret = Instrumentation.listWebElementClass(Webdriver,"pagination");
        for (String line : Ret.split("\n")) {

            if(!line.equals("⟩") &&  !line.contains(";")) {
                Config.prmPagination = Config.prmPagination +1;
            }

        }
  for(int i=0;i<Config.prmPagination;i++){
      Thread.sleep(2000);
      String Ret1 = Instrumentation.listWebElementClass(Webdriver,"undefined");
      for (String line : Ret1.split("MB")) {
          System.out.println(line);
          if(!line.equals(";") ){
              Config.prmListCount = Config.prmListCount + 1;
          }
      }
      Thread.sleep(1000);
      if(i+1 < Config.prmPagination ) {
          Instrumentation.clickWeb(Webdriver, Config.xpath, "/html/body/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[2]/div/div/div/ul/li[5]/a", "");
      }}}

    public static void checkTotalMatch() {
        Assert.assertEquals("Total match",Config.prmCardCoout,Config.prmListCount);
    }
}
