package com.trendalytics.Pages;

import com.trendalytics.Runners.BaseTest;
import com.trendalytics.Utils.Instrumentation;
import com.trendalytics.Utils.Config;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class ReportsPages extends BaseTest {



    public static void clickModule(String arg0) throws Exception {
          switch (arg0) {
            case "Report":
                    Thread.sleep(2000);
                    Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 1, "Click on Report");
                    Thread.sleep(2500);
                    Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 1, "Click on Report");
                    break;
            case "Dashboard":
                    Thread.sleep(2000);
                    Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 0, "Click on Dashboard");
                    Thread.sleep(2500);
                    Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 0, "Click on Dashboard");
                    break;
             case "Admin":
                        Thread.sleep(2000);
                    Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 6, "Click on Admin Management");
                    Thread.sleep(2500);
                    break;
              case "TrendPulse":
                  Thread.sleep(1000);
                  Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 3, "Click on TrendPulse");
                  Thread.sleep(1000);
                  break;
              case "MarketPulse":
                  Thread.sleep(2000);
                  Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 4, "Click on Market Pulse");
                  Thread.sleep(2500);
                  break;

              default:
                    throw new Exception("Invalid option");
            }
    }

    public static void clickToCreateAReport() throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.cssSelector,"input[type='button'][value='Create Report']","Click Create Report");
    }

    public static void downloadPdfReport() throws IOException, InterruptedException {
        Instrumentation.clickWeb(Webdriver, Config.className, "el-dropdown",  "Export Pdf");
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'Export as PDF')]","Export PDF");
        Instrumentation.clickOnElementNotInteractWithContainsText(Webdriver, "Confirm",  "Confirm Button");
    }


    public static void clickVerifyOnSubscriptionEvent() throws IOException {

        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'Subscription Events')]","Export PDF");

        Instrumentation.sendKeysWeb(Webdriver, Config.xpath,"v-input v-input-default","Luis","Subscription");

    }

    public static void verifyTheEmailAlert (String arg0) throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'Subscription Events')]","Export PDF");
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath,"v-input v-input-default","Luis","Subscription");
    }

    public static void GetStatus(String arg1) throws Exception {
        String prmString;
        switch (arg1)
        {
            case "Completed":
                prmString = "el-icon-success";
                break;
            default:
                throw new Exception("Invalid option");
        }

        Instrumentation.clickByClassNameIndex(Webdriver,prmString,0,"");
        Thread.sleep(200);

    }

    public static void clickCreateAReport() throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'Create Report')]","");
    }

    public static void chooseAReport(String arg0) throws Exception {
        Integer prmIndex=0;
        switch (arg0)
        {
            case "ASSORTMENT COMPARISON":
                prmIndex=0;
                break;
            case "TREND COMPARISON":
                prmIndex=2;
                break;
            case "SEO OPPORTUNITIES":
                prmIndex=3;
                break;
            case "ATTRIBUTE COMPARISON":
                prmIndex=4;
                break;
            default:
                throw new Exception("Invalid option");
        }

        Instrumentation.clickByClassNameIndex(Webdriver,"tl-card",prmIndex,"");
        Thread.sleep(200);
        Instrumentation.clickButtonByIndex(Webdriver,"Next");
    }

    public static void chooseTypeReport(String arg1) throws Exception {
        Instrumentation.listWebElement(Webdriver);

        Integer prmIndex=0;
        switch (arg1)
        {
            case "ONE BRAND ACROSS MULTIPLE RETAIL SITES":
                prmIndex=0;
                break;
            case "MULTIPLE RETAIL SITES":
                prmIndex=1;
                break;
            case "MULTIPLE BRANDS ACROSS ONE RETAIL SITE":
                prmIndex=2;
                break;
            case "SIDE BY SIDE TREND COMPARISON":
                prmIndex=0;
                break;
            case "MULTIPLE TREND COMPARISON":
                prmIndex=1;
                break;
            default:
                throw new Exception("Invalid option");
        }
        Instrumentation.clickByClassNameIndex(Webdriver,"tl-card",prmIndex,"");
        Instrumentation.clickButtonByIndex(Webdriver,"Next");
    }

    public static void clickBrand() throws Exception {
        String prmText;
        prmText = "mp__0__0";
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//label[@for='"+prmText+"']","");
        Instrumentation.clickButtonByIndex(Webdriver,"Next");
    }

    public static void clickRetail() throws Exception {
        String prmText;
        prmText = "mp__1__0";
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//label[@for='"+prmText+"']","");
        Instrumentation.clickButtonByIndex(Webdriver,"Next");
    }

    public static void clickCategory() throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//label[@id='lb__0__0']","");
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//label[@for='all__1']","");
        Instrumentation.clickButtonByIndex(Webdriver,"Next");
    }


    public static void setReportName(String arg5) throws IOException {
        Instrumentation.cleanInputTextByClass(Webdriver,"tl-report-name__input","Clean Input Text");
        Instrumentation.sendKeysWeb(Webdriver, Config.className,"tl-report-name__input",arg5,"Input Report Name ");
    }

    public static void clickSubmit() throws IOException {
        Instrumentation.clickOnElementNotInteractWithContainsText(Webdriver, "Submit",  "Confirm Button");
    }

    public static void selectTrends() throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'1 light flush mount')]","Selecionou - 1 light flush mount");
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'12 piece comforter set')]","Selecionou - 12 piece comforter set");
        Instrumentation.clickButtonByIndex(Webdriver,"Next");

    }

    public static void fillNameOfReport(String arg0) throws IOException {
        //Instrumentation.clickWeb(Webdriver,xpath,"//input[@placeholder='Search']","Clean Input Text");
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath,"//input[@placeholder='Search']",arg0,"");


    }

    public static void clickOnEmailAlerts() throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'Email Alerts')]","Export PDF");
    }

    public static void searchForUserEmail(String arg0) throws IOException {
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath,"//input[@placeholder='Search for user Email']",arg0,"");
    }

    public static void downloadExcelCurrent(String arg0) throws IOException, InterruptedException  {
        Thread.sleep(3000);
        Instrumentation.clickWeb(Webdriver, Config.className, "el-dropdown",  "Export Pdf");
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'Download to Excel (Current)')]","Download to Excel (Current)");
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath,"//input[@placeholder='File Name (optional)']",arg0,"");
        //Instrumentation.clickOnElementNotInteractWithContainsText(Webdriver, "Confirm",  "Confirm Button");


    }

    public static void downloadExcelHistory(String arg0) throws IOException, InterruptedException  {
        Thread.sleep(3000);
        Instrumentation.clickWeb(Webdriver, Config.className, "el-dropdown",  "Export Pdf");
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[contains(text(),'Download to Excel (History)')]","Download to Excel (History)");
        Instrumentation.clickWeb(Webdriver, Config.xpath,"/html/body/div[8]/div/div[3]/div/button/span[1]","Download ");
        Thread.sleep(2000);
        Instrumentation.clickWeb(Webdriver, Config.xpath,"/html/body/div[8]/div/div[1]/button","Download Download complete");

        //Instrumentation.sendKeysWeb(Webdriver, Config.xpath,"//input[@placeholder='File Name (optional)']",arg0,"");
        //Instrumentation.clickOnElementNotInteractWithContainsText(Webdriver, "Confirm",  "Confirm Button");


    }

    public static void checkCreatedReport() throws IOException {
        Instrumentation.clickWeb(Webdriver, Config.xpath,"//*[@id='page-trend']/ng-include[1]/div/div[1]/div[1]/div[2]/p","Check Report Create Sucessfully");
    }



    public static void clickSave() throws AWTException, IOException {
        Robot robot = new Robot();
//Doing a mouse over for the X and Y coordinates of button/link which opens modal window
        robot.mouseMove(210,350);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(100);
/*//Clicking tab til the cursor is on specific position (textbox/button)
        robot.keyPress(KeyEvent.VK_TAB);
        robot.delay(100);
//Doing a mouse over for the X and Y coordinates of button/link
        robot.mouseMove(300,150);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        //robot.delay(100);*/

Instrumentation.clickOnElementNotInteractWithContainsText(Webdriver, "Confirm",  "Confirm Button");
    }
}
