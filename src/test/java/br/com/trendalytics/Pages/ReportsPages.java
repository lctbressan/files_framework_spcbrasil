package br.com.trendalytics.Pages;

import br.com.trendalytics.Runners.BaseTest;
import br.com.trendalytics.Utils.Constants;
import br.com.trendalytics.Utils.Instrumentation;

import java.io.IOException;

public class ReportsPages extends BaseTest {


    public static void clickModule(String arg0) throws Exception {
        switch (arg0) {
            case "Report":
                Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 1, "Cick on Report");
                Thread.sleep(3000);
                Instrumentation.clickByfindElements(Webdriver, "sidebar-navigation-menu-item", 1, "Cick on Report");
                break;
            case "Dashboard":
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
        switch (arg0)
        {
            case "My Comparison":
                msg = "menu-item-name";
                break;
            case "My dashboard":
                msg = "menu-item-name";
                break;
            case "Assort Comparition Report":
                msg = "item-name";
                break;
            case "My DSB":
                msg = "item-name";
                break;
            case "LEVKOFF at Multiple Retail Sites":
                msg = "report-header__title-block";
            default:
                throw new Exception("Invalid option");
        }
        Instrumentation.clickByfindElements(Webdriver,msg,0,""+ arg0 +"");

    }
}
