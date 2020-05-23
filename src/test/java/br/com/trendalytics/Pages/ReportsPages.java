package br.com.trendalytics.Pages;

import br.com.trendalytics.Runners.BaseTest;
import br.com.trendalytics.Utils.Constants;
import br.com.trendalytics.Utils.Instrumentation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ReportsPages extends BaseTest {


    public static void clickModule(String arg0) throws Exception {
          switch (arg0) {
                case "Report":
                    Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 1, "Click on Report");
                    Thread.sleep(1000);
                    Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 1, "Click on Report");
                    break;
                case "Dashboard":
                    Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 0, "Click on Dashboard");
                    Thread.sleep(1000);
                    Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 0, "Click on Dashboard");
                    break;
                    case "Admin":
                    Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 6, "Click on Admin Management");
                    Thread.sleep(1000);
                    break;
                default:
                    throw new Exception("Invalid option");
            }
    }

    public static void clickToCreateAReport() throws IOException {
        Instrumentation.clickBycssSelector(Webdriver,"input[type='button'][value='Create Report']","Click Create Report");
    }

    public static void clickOn(String arg0) throws Exception {
        String msg ="";
        int prmIndex =  0;
        switch (arg0)
        {


            case "Shared with me":
                msg = "menu-item menu-item--active";
                prmIndex=0;
                break;
            case "Assort Comparition Report":
                msg = "item-name";
                break;
            case "My DSB":
                msg = "item-name";
                break;
            case "LEVKOFF at Multiple Retail Sites":
                msg = "report-header__title-block";
                break;
            case "Q1 2019":
                msg="Q1 2019: INGREDIENTS DASHBOARD";
                break;
            default:
                throw new Exception("Invalid option");
        }
        Instrumentation.clickByfindElements(Webdriver,msg,prmIndex,""+ arg0 +"");

    }

    public static void downloadPdfReport() throws IOException, InterruptedException {

        Instrumentation.clickByfindElement(Webdriver, "el-dropdown", 0, "Export Pdf");

        Instrumentation.clickByXpathWeb(Webdriver,"//*[contains(text(),'Export as PDF')]","Export PDF");

        Instrumentation.clickOnElementNotInteractWithContainsText(Webdriver, "Confirm",  "Confirm Button");

    }


    public static void clickVerifyOnSubscriptionEvent() throws IOException {

        Instrumentation.clickByXpathWeb(Webdriver,"//*[contains(text(),'Subscription Events')]","Export PDF");

        Instrumentation.sendKeysByClassXpathWeb(Webdriver,"v-input v-input-default","Luis","Subscription");

    }

    public static void verifyTheEmailAlert (String arg0) throws IOException {

        Instrumentation.clickByXpathWeb(Webdriver,"//*[contains(text(),'Subscription Events')]","Export PDF");

        Instrumentation.sendKeysByClassXpathWeb(Webdriver,"v-input v-input-default","Luis","Subscription");
    }

    public static void GetStatus(String arg1) throws Exception {
        Instrumentation.clickByXpathWeb(Webdriver,"//*[contains(text(),'"+ arg1 +"')]","");

    }

    public static void clickCreateAReport() throws IOException {
        Instrumentation.clickByXpathWeb(Webdriver,"//*[contains(text(),'Create Report')]","");
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
        Instrumentation.clickButtonByIndex(Webdriver,21);


    }

    public static void chooseTypeReport(String arg1) throws Exception {
        Integer prmIndex=0;
        switch (arg1)
        {
            case "ONE BRAND":
                prmIndex=0;
                break;
            default:
                throw new Exception("Invalid option");
        }
        Instrumentation.clickByClassNameIndex(Webdriver,"tl-card",prmIndex,"");
        //Click Next
        Thread.sleep(2000);
        Instrumentation.clickButtonByIndex(Webdriver,21);
        Instrumentation.listWebElement(Webdriver);
    }
}
