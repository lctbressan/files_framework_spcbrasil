package com.braziltest.Pages;

import com.braziltest.Steps.Hook.BaseStep;
import com.braziltest.Utils.Config;
import com.braziltest.Utils.Instrumentation;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import java.io.IOException;


public class smartcenterPages extends BaseStep {



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

    public static void clickInNotebooks(String arg0) throws IOException, InterruptedException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'"+arg0+"')]","");
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
          if(Instrumentation.checkElementIsPresent(Webdriver,"/html/body/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[2]/div/div/div/ul/li[5]/a")){
          Instrumentation.clickWeb(Webdriver, Config.xpath, "/html/body/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[2]/div/div/div/ul/li[5]/a", "");
      }}}}

    public static void checkTotalMatch() {
        Assert.assertEquals("Total match",Config.prmCardCoout,Config.prmListCount);
    }

    public static void clickInMenu() throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"/html/body/div[1]/div/div[2]/header/div/div[1]/div[1]","");
    }

    public static void clickInSubmenu(String arg0) throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'"+arg0+"')]","");
    }

    public static void clickInItem(String arg0) throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'"+arg0+"')]","");
    }

    public static void checkForInformation(String arg0) throws Exception {
        Instrumentation.assertPhaseEqualsText(Webdriver,arg0, "match text " + arg0);

    }

    public static void clickInSair() throws IOException {
        Instrumentation.clickWeb(Webdriver,Config.xpath,"/html/body/div[1]/div/div[2]/header/div/div[2]/a[2]","");
    }

    public static void clickItemPage(String arg0) throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'"+arg0+"')]","");
    }

    public static void checkPupup() throws IOException, InterruptedException {
        Boolean Ret = Instrumentation.checkElementIsPresent(Webdriver,"//*[contains(text(),'Fechar e não mostrar novamente')]");
        if(Ret) {
            Instrumentation.clickWeb(Webdriver,Config.xpath,"//*[contains(text(),'Fechar e não mostrar novamente')]","");
        }
    }

    public static void pesquisarItem(String arg0) throws IOException {
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath,"//input[@name='input-search']",arg0,"Pesquisar item");
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath,"//input[@name='input-search']", String.valueOf(Keys.ENTER),"Enter");

    }

    public static void selecionarOItem(String arg0) throws IOException, InterruptedException {
        Thread.sleep(1000);
        //Instrumentation.collectByClassNameIndex(Webdriver,"show-desktop show-mobile machine",arg0,"Check for : " + arg0);
        Instrumentation.clickWeb(Webdriver,Config.xpath,"//*[contains(text(),'"+arg0+"')]","");
    }

    public static void coleteInformcaoesFichahard() throws IOException {
        String Ret1 = Instrumentation.listWebElementClass(Webdriver,"cardlist-block");
        for (String line : Ret1.split("\n")) {
            System.out.println(line);

        }

    }

    public static void verifiqueSeORecursoDeHardwareApresentaAMensagem(String arg0) throws IOException, InterruptedException {
        Instrumentation.clickWeb(Webdriver,Config.xpath,"/html/body/div[1]/div/div[2]/div[3]/div[2]/div[1]/div/div[6]/div/div[3]/div/div[2]/div/div/a[1]/div/span[1]","");
        Thread.sleep(2000);
        if (Instrumentation.checkElementIsPresent(Webdriver, "//*[contains(text(),'" + arg0 + "')]")) {
                Assert.assertTrue(false);
        }
    }

    public static void verifiqueOsDadosEmTela(String prmData, String prmValue) throws IOException, InterruptedException {

        Instrumentation.collectByClassNameIndex(Webdriver,"-inside-title",prmData,"Check for : " + prmData);
        Instrumentation.collectByClassNameIndex(Webdriver,"-inside-text",prmValue,"Check for : " + prmValue);

       /* String RetX = Instrumentation.listWebElementClass(Webdriver,"cardlist");
        for (String line : RetX.split("\n")) {
            System.out.println(line);

        }


        Boolean Ret = Instrumentation.checkElementIsPresent(Webdriver,"//*[contains(text(),'"+prmData+"')]");
        if(Ret) {
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
        Boolean Ret1 = Instrumentation.checkElementIsPresent(Webdriver,"//*[contains(text(),'"+prmValue+"')]");
        if(Ret1) {
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }*/
    }
}
