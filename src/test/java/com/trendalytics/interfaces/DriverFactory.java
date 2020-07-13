package com.trendalytics.interfaces;

import com.trendalytics.Runners.BaseTest;
import com.vimalselvam.cucumber.listener.Reporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import static com.trendalytics.Utils.Config.*;

@SuppressWarnings("unchecked")
public class DriverFactory extends BaseTest {


    private static String path = "";
    private static String url = "";
    private static WebElement element = null;
    private static int id = 0;
    public static String browser;
    public static String scenarioName;
    public static String executionFolder;

    private int linha = 0;
    private String ExecutionFolder = LocalDateTime.now().toString().replaceAll(":", "").replace("-", "").replace(".",
            "");

        public static WebDriver getDriver() throws Exception {

                if (PLATFORMTYPE.toUpperCase().equals("WEB")) {

                    if (BROWSERTESTING.equals("CHROME")) {
                        OpenBrowserChrome(URLTESTING);

                    }

                    if (BROWSERTESTING.equals("FIREFOX")) {
                        OpenBrowserFirefox(URLTESTING);
                    }
                }

                //System.out.println("INSTANCIA DO DIVER >>" + Webdriver);
                return Webdriver;
            }


    /*************************************************************
     * INSTANTIATE A NEW DRIVER WEB
     ****************************************************************/
    public static WebDriver OpenBrowserChrome(String p0) throws Exception {
        System.setProperty("webdriver.chrome.driver", DRIVERPATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        Webdriver = new ChromeDriver(options);
        Webdriver.get(p0);
        Webdriver.manage().window().maximize();
        Thread.sleep(2000);
      return Webdriver;
    }


    public static WebDriver OpenBrowserFirefox(String p0) throws InterruptedException {
       System.setProperty("webdriver.gecko.driver",DRIVERPATH);
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to(p0);
        driver.manage().timeouts().implicitlyWait(TIMEOUTAUTOMATION, TimeUnit.SECONDS);
        Webdriver = driver;
        return Webdriver;
    }

    /*************************************************************
     * EVIDENCIAS SCREENSHOTS
     ****************************************************************/
    public static void Evidencia(WebDriver driver, String ct) throws IOException {

        id = id + 1;
        String pathCucumber = PATHEVIDENCE ;
        File folder = new File(pathCucumber +  ct);
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                path = pathCucumber +  ct;
                id = 1;
            } else {
                System.out.println("Falha ao criar diretório!");
            }
        }
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(pathCucumber +  id + ".jpg");
        String imageDest = pathCucumber  + id + ".jpg";
        FileUtils.copyFile(scrFile, dest);
        Reporter.addScreenCaptureFromPath(imageDest);
        //System.out.println(scrFile + " - " + dest);

    }
}
