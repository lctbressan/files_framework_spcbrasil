package br.com.trendalytics.Pages;

import br.com.trendalytics.Runners.BaseTest;
import br.com.trendalytics.Utils.Constants;
import br.com.trendalytics.Utils.Instrumentation;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;

public class ReportsPages extends BaseTest {


    public static void clickModule(String arg0) throws Exception {
        switch (arg0) {
            case "Report":
                Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 1, "Cick on Report");
                Thread.sleep(2000);
                Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 1, "Cick on Report");
                break;
            case "Dashboard":
                Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 0, "Cick on Dashboard");
                Thread.sleep(2000);
                Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 0, "Cick on Dashboard");
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

    }

    public static void clickConfirm() throws IOException {
        Instrumentation.clickOnElementNotInteractWithContainsText(Webdriver, "Confirm",  "Confirm Button");
    }
}
