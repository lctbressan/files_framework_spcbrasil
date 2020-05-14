package br.com.trendalytics.Pages;

import br.com.trendalytics.Runners.BaseTest;
import br.com.trendalytics.Utils.Instrumentation;

import java.io.IOException;

public class ReportsPages extends BaseTest {


    public static void clickModule(String arg0) throws IOException {
        Instrumentation.clickByXpathWeb(Webdriver,"//div[@id='Reports-200']//svg","Click on report");
    }

    public static void clickToCreateAReport() throws IOException {
        Instrumentation.clickBycssSelector(Webdriver,"input[type='button'][value='Create Report']","Click Create Report");
    }
}
