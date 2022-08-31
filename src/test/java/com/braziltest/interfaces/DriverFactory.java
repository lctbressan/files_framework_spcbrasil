package com.braziltest.interfaces;

import com.braziltest.Steps.Hook.Hook;
import com.vimalselvam.cucumber.listener.Reporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import static com.braziltest.Utils.Config.*;

@SuppressWarnings("unchecked")
public class DriverFactory extends Hook {


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

        public static WebDriver getDriver(String arg0) throws Exception {

            if (PLATFORMTYPE.toUpperCase().equals("WEB")) {
                if (BROWSERTESTING.equals("CHROME")) {
                    if (System.getProperty("os.name").contains("Windows")) {
                        System.out.println(System.getProperty("os.name"));
                        OpenBrowserChrome(arg0, DRIVERPATHCHROMEWIN);
                        //openGridServerChrome(arg0, DRIVERPATHCHROMEWIN);
                    }

                    if (System.getProperty("os.name").contains("Linux")) {
                        System.out.println(System.getProperty("os.name"));
                        // openGridServerFFox(arg0, DRIVERPATHCHROMELIN);
                        OpenBrowserChrome(arg0, DRIVERPATHCHROMELIN);

                    }
                }
            }
            return Webdriver;
        }


    /*************************************************************
     * INSTANTIATE A NEW DRIVER WEB
     ****************************************************************/
    public static WebDriver OpenBrowserChrome(String p0,String Path) throws Exception {
        System.setProperty("webdriver.chrome.driver", Path);
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
        return Webdriver;
    }


    public static WebDriver OpenBrowserFirefox(String p0) throws InterruptedException {
       System.setProperty("webdriver.gecko.driver",DRIVERPATHFFOX);
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to(p0);
        driver.manage().timeouts().implicitlyWait(TIMEOUTAUTOMATION, TimeUnit.SECONDS);
        Webdriver = (RemoteWebDriver) driver;
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


    public static WebDriver OpenBrowserChromeSG(String p0) throws Exception {
        /*DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "77.0");
        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any available one
        capabilities.setCapability("build", "LambdaTestSampleApp");
        capabilities.setCapability("name", "LambdaTestJavaSample");
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs

        capabilities.setCapability("selenium_version","4.0.0-alpha-2");
        capabilities.setCapability("timezone","UTC+05:30");
        capabilities.setCapability("geoLocation","IN");
        capabilities.setCapability("chrome.driver","78.0");
        RemoteWebDriver  driver;
          driver = new RemoteWebDriver(new URL("http://10.10.0.13:4444/wd/hub"), capabilities);
          driver.navigate().to(p0);
            //Webdriver = (RemoteWebDriver) driver;
            //Webdriver.get(p0);
            //return Webdriver;*/

       DesiredCapabilities cap = new DesiredCapabilities().firefox();
       cap.setPlatform(Platform.WIN10);
       cap.setBrowserName("firefox");
        //WebDriver driver = new RemoteWebDriver(new URL("http://10.10.0.5:5557/wd/hub"), cap);
        WebDriver driver = new RemoteWebDriver(new URL("http://10.10.0.5:5557/wd/hub"), cap);
        driver.get(p0);

        Webdriver = (RemoteWebDriver) driver;
        return Webdriver;

    }
}
