package br.com.trendalytics.Pages;

import br.com.trendalytics.Runners.BaseTest;
import static br.com.trendalytics.Utils.Constants.TIMEOUTAUTOMATION;
import static br.com.trendalytics.Utils.Constants.xpath;
import static br.com.trendalytics.Utils.Constants.className;
import static br.com.trendalytics.Utils.Constants.cssSelector;



import br.com.trendalytics.Utils.Instrumentation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ReportsPages extends BaseTest {



    public static void clickModule(String arg0) throws Exception {
          switch (arg0) {
                case "Report":
                    Thread.sleep(1000);
                    Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 1, "Click on Report");
                    Thread.sleep(1000);
                    Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 1, "Click on Report");
                    break;
                case "Dashboard":
                    Thread.sleep(1000);
                    Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 0, "Click on Dashboard");
                    Thread.sleep(1000);
                    Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 0, "Click on Dashboard");
                    break;
                    case "Admin":
                        Thread.sleep(1000);
                    Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 6, "Click on Admin Management");
                    Thread.sleep(1000);
                    break;
                default:
                    throw new Exception("Invalid option");
            }
    }

    public static void clickToCreateAReport() throws IOException {
        Instrumentation.clickWeb(Webdriver,cssSelector,"input[type='button'][value='Create Report']","Click Create Report");
    }

    public static void downloadPdfReport() throws IOException, InterruptedException {
        Instrumentation.clickWeb(Webdriver,className, "el-dropdown",  "Export Pdf");
        Instrumentation.clickWeb(Webdriver,xpath,"//*[contains(text(),'Export as PDF')]","Export PDF");
        Instrumentation.clickOnElementNotInteractWithContainsText(Webdriver, "Confirm",  "Confirm Button");
    }


    public static void clickVerifyOnSubscriptionEvent() throws IOException {

        Instrumentation.clickWeb(Webdriver,xpath,"//*[contains(text(),'Subscription Events')]","Export PDF");

        Instrumentation.sendKeysWeb(Webdriver,xpath,"v-input v-input-default","Luis","Subscription");

    }

    public static void verifyTheEmailAlert (String arg0) throws IOException {
        Instrumentation.clickWeb(Webdriver,xpath,"//*[contains(text(),'Subscription Events')]","Export PDF");
        Instrumentation.sendKeysWeb(Webdriver,xpath,"v-input v-input-default","Luis","Subscription");
    }

    public static void GetStatus(String arg1) throws Exception {
        Instrumentation.clickWeb(Webdriver,xpath,"//*[contains(text(),'"+ arg1 +"')]","");
    }

    public static void clickCreateAReport() throws IOException {
        Instrumentation.clickWeb(Webdriver,xpath,"//*[contains(text(),'Create Report')]","");
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

    public static void clickBrand(String arg0) throws Exception {
        String prmText;
        switch (arg0)
        {
            case "LEVKOFF":
                prmText = "mp__0__0";
                break;
            case "47 Nba":
                prmText = "mp__0__2";
                break;
            case "CARBON38":
                prmText = "mp__0__0";
                break;
            default:
                throw new Exception("Invalid option");
        }
        Instrumentation.clickWeb(Webdriver,xpath,"//label[@for='"+prmText+"']","");
        Instrumentation.clickButtonByIndex(Webdriver,"Next");
    }

    public static void clickRetail(String arg0) throws Exception {
        String prmText;
        switch (arg0)
        {
            case "Nordstrom":
                prmText = "mp__1__0";
                break;
            case "Nordstrom Rack":
                prmText = "mp__1__1";
                break;
            case "CARBON38":
                prmText = "mp__1__0";
                break;
            default:
                throw new Exception("Invalid option");
        }
        Instrumentation.clickWeb(Webdriver,xpath,"//label[@for='"+prmText+"']","");
        Instrumentation.clickButtonByIndex(Webdriver,"Next");
    }

    public static void clickCategory(String arg0) throws IOException {
        Instrumentation.clickWeb(Webdriver,xpath,"//label[@id='lb__0__0']","");
        Instrumentation.clickWeb(Webdriver,xpath,"//label[@for='all__1']","");
        Instrumentation.clickButtonByIndex(Webdriver,"Next");
    }


    public static void setReportName(String arg5) throws IOException {
        Instrumentation.cleanInputTextByClass(Webdriver,"tl-report-name__input","Clean Input Text");
        Instrumentation.sendKeysWeb(Webdriver,className,"tl-report-name__input",arg5,"Input Report Name ");
    }

    public static void clickSubmit() throws IOException {
        Instrumentation.clickOnElementNotInteractWithContainsText(Webdriver, "Submit",  "Confirm Button");
    }

    public static void selectTrends() throws IOException {
        Instrumentation.clickWeb(Webdriver,xpath,"//*[contains(text(),'1 light flush mount')]","Selecionou - 1 light flush mount");
        Instrumentation.clickWeb(Webdriver,xpath,"//*[contains(text(),'12 piece comforter set')]","Selecionou - 12 piece comforter set");
        Instrumentation.clickButtonByIndex(Webdriver,"Next");

    }

    public static void fillNameOfReport(String arg0) throws IOException {
        //Instrumentation.clickWeb(Webdriver,xpath,"//input[@placeholder='Search']","Clean Input Text");
        Instrumentation.sendKeysWeb(Webdriver,xpath,"//input[@placeholder='Search']",arg0,"");


    }
}
