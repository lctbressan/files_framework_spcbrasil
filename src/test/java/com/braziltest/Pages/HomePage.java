package com.braziltest.Pages;
import com.braziltest.Steps.Hook.BaseStep;
import com.braziltest.Steps.Hook.Hook;
import com.braziltest.Utils.Instrumentation;
import com.braziltest.Utils.Config;
import com.braziltest.interfaces.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class HomePage extends BaseStep {

   public static int x = 0;
    public static void thatTheUserIsOnTheHomeScreen(String arg0) throws Exception {
        DriverFactory.getDriver(arg0);
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

    public static void abreaconexaoNaoparticular() throws IOException {
        //Instrumentation.clickWeb(Webdriver, Config.id, "details-button",  "Clique em Avançado");
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'Avançado')]","");
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'Ir para 192.168.15.1 (não seguro)')]","");

    }

    public static void irPara(String arg0, String arg1) throws IOException {
        Webdriver.switchTo().frame("menufrm");
        Instrumentation.clickWeb(Webdriver, Config.xpath, "/html/body/div/div/div/ul/li[3]/a", "");
        Instrumentation.clickWeb(Webdriver, Config.xpath, "/html/body/div/div/div/ul/li[3]/ul/li[3]/a", "");
    }

    public static void sendLoginandPass(String arg0, String arg1) throws IOException, InterruptedException {
        Thread.sleep(1000);


        Webdriver.switchTo().parentFrame();

        Webdriver.switchTo().frame("basefrm");


        //Webdriver.switchTo().frame("passWarning");
        //Webdriver.switchTo().frame(0);
        //Webdriver.switchTo().frame(Webdriver.findElement(By.id("basefrm")));


        WebElement el = Webdriver.findElement(By.id("Loginuser"));
        el.click();
        Webdriver.findElement(By.id("Loginuser")).sendKeys(arg0);

        Thread.sleep(2000);
        WebElement el1 = Webdriver.findElement(By.id("LoginPassword"));
        el1.click();
        Webdriver.findElement(By.id("LoginPassword")).sendKeys(arg1);


        Instrumentation.clickWeb(Webdriver,Config.xpath,"/html/body/div/div/div[1]/form/div/table/tbody/tr[6]/td/input[2]","");

       //Instrumentation.sendKeysWeb(Webdriver,Config.xpath,"/html/body/div/div/div[1]/form/div/table/tbody/tr[2]/td[2]/input",arg0,"");
        //Instrumentation.sendKeysWeb(Webdriver,Config.id,"Loginuser",arg0,"");
        //Instrumentation.sendKeysWeb(Webdriver,Config.id,"LoginPassword",arg1,"");
        //Instrumentation.clickWeb(Webdriver,Config.xpath,"//*[contains(text(),'LOGIN')]","");
        //Instrumentation.clickOnElementNotInteractWithContainsText(Webdriver,Config.className,"","setupWifiTable","");

    }

    public static void reiniciaoteador() throws Exception {
        Thread.sleep(2000);
        Webdriver.switchTo().parentFrame();

        Webdriver.switchTo().frame("basefrm");


        //Instrumentation.clickWeb(Webdriver,Config.id,"btn-clicktocall","");
        //click reboot
        Instrumentation.clickWeb(Webdriver,Config.xpath,"/html/body/form/div/div/div[1]/table/tbody/tr[1]/td[1]/a","");



        // click n0 cancel
        //Webdriver.navigate().to("http://192.168.15.1/cgi-bin/popup-reboot.cgi#");


        Webdriver.switchTo().defaultContent();
        //Webdriver.switchTo().frame("basefrm");
       // Webdriver.switchTo().frame(Webdriver.findElement(By.className("fancybox-iframe")));




        //Webdriver.switchTo().frame(1);
        Thread.sleep(2000);
        //Instrumentation.clickWeb(Webdriver,Config.xpath,"/html/body/div/table/tbody/tr[4]/td/a[2]/span","");*/
        /*String xpath = "/html/body/div/table/tbody/tr[4]/td/a[2]/span";
        Robot robot = new Robot();
        //Pass in the X and Y Coordinates of the Element (Integer)
        robot.mouseMove(Webdriver.findElement(By.xpath(xpath)).getLocation().getX(),Webdriver.findElement(By.xpath(xpath)).getLocation().getY());
        robot.mousePress(InputEvent.BUTTON1_MASK);
        Thread.sleep(50);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);*/
        //Actions actions = new Actions(Webdriver);
        //actions.moveToElement(Webdriver.findElement(By.tagName("body")), 500, 500);
        //actions.moveByOffset(30, 80).click().build().perform();
        //Instrumentation.clickWeb(Webdriver,Config.xpath,"/html/body/div/table/tbody/tr[4]/td/a[2]","");
       // Instrumentation.clickOnElementNotInteractWithContainsText(Webdriver,  Config.xpath, "Yes, Reboot", "No, Cancel  ");

        //Instrumentation.clickWeb(Webdriver,Config.id,"btnReset","");
       /* Webdriver.switchTo().frame(0);
        Instrumentation.clickWeb(Webdriver,Config.id,"btnCancel","");*/
        runnerIframe(Webdriver);

    }
    public static void runnerIframe(WebDriver driver) {

        for (int i = 0; i < 6; i++) {
            try {
                driver.switchTo().frame(x);
                driver.findElement(By.xpath("/html/body/div/table/tbody/tr[4]/td/a[2]")).click();
            } catch (Exception ex) {
                System.out.println("Not an iframe");
                x = x+1;
                runnerIframe(Webdriver);

            }



        }
    }

}
