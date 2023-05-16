package com.br.spcbrasil.interfaces;

import com.br.spcbrasil.Steps.Hook.Hook;
import com.vimalselvam.cucumber.listener.Reporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import static com.br.spcbrasil.Utils.Config.*;

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
            System.out.println(System.getProperty("os.name"));
            if (PLATFORMTYPE.toUpperCase().equals("WEB")) {

                if (BROWSERTESTING.equals("CHROME")) {

                    if (System.getProperty("os.name").contains("Windows")) {
                        if(BROWSERTESTING.equals("CHROME")) {
                            OpenBrowserChrome(arg0, DRIVERPATHCHROMEWIN);
                        }
                    }

                    if (System.getProperty("os.name").contains("Linux") ) {
                        if(BROWSERTESTING.equals("CHROME")) {
                            OpenBrowserChrome(arg0, DRIVERPATHCHROMELIN);
                        }

                    }

                    if ( System.getProperty("os.name").contains("Mac OS X")) {
                        if(BROWSERTESTING.equals("CHROME")) {
                            OpenBrowserChrome(arg0, DRIVERPATHCHROMEMAC);
                        }

                    }

                }


                if (BROWSERTESTING.equals("FIREFOX") ) {
                    if (System.getProperty("os.name").contains("Windows")) {
                        if(BROWSERTESTING.equals("FIREFOX")) {
                            OpenBrowserFirefox(arg0, DRIVERPATHFFOXLWIN);
                        }
                    }

                    if (System.getProperty("os.name").contains("Linux")|| System.getProperty("os.name").contains("Mac OS X")) {
                        if(BROWSERTESTING.equals("FIREFOX")) {
                            OpenBrowserFirefox(arg0, DRIVERPATHFFOXLIN);
                        }
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
        //Webdriver.manage().window().maximize();
        return Webdriver;
    }


    public static WebDriver OpenBrowserFirefox(String p0,String path) throws InterruptedException {
       System.setProperty("webdriver.gecko.driver",path);
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to(p0);
        driver.manage().timeouts().implicitlyWait(TIMEOUTAUTOMATION, TimeUnit.SECONDS);
        Webdriver = (RemoteWebDriver) driver;
        return Webdriver;
    }


}
