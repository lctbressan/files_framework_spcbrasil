package com.br.spcbrasil.interfaces;

import com.br.spcbrasil.Steps.Hook.BaseStep;
import com.br.spcbrasil.Utils.Config;
import com.br.spcbrasil.Utils.Instrumentation;
import com.br.spcbrasil.utils.ManipularJson;
import com.vimalselvam.cucumber.listener.Reporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unchecked")
public class DriverFactory extends BaseStep {


    private static String path = "";
    private static String url = "";
    private static WebElement element = null;
    private static int id = 0;
    public static String browser;
    public static String scenarioName;
    public static String executionFolder;
    static ManipularJson mj = new ManipularJson();
    private int linha = 0;
    private String ExecutionFolder = LocalDateTime.now().toString().replaceAll(":", "").replace("-", "").replace(".", "");

    public static WebDriver getDriverWeb(String arg0) throws Exception {

        if (Config.PLATFORMTYPE.toUpperCase().equals("WEB")) {

            if (Config.BROWSERTESTING.equals("CHROME")) {
                //OpenBrowserChrome(URLTESTING);
                OpenBrowserChrome(arg0);

            }

            if (Config.BROWSERTESTING.equals("FIREFOX")) {
                OpenBrowserFirefox(arg0);
            }
        }

        //System.out.println("INSTANCIA DO DIVER >>" + Webdriver);
        return Webdriver;
    }


    /*************************************************************
     * INSTANTIATE A NEW DRIVER WEB
     ****************************************************************/
    public static WebDriver OpenBrowserChrome(String p0) throws Exception {
        System.setProperty("webdriver.chrome.driver", Config.DRIVERPATH);
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
        Thread.sleep(3000);
        return Webdriver;
    }


    public static WebDriver OpenBrowserFirefox(String p0) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", Config.DRIVERPATH);
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to(p0);
        driver.manage().timeouts().implicitlyWait(Config.TIMEOUTAUTOMATION, TimeUnit.SECONDS);
        Webdriver = driver;
        //return Webdriver;

        //FirefoxBinary firefoxBinary = new FirefoxBinary();
        //firefoxBinary.addCommandLineOptions("--headless");
        //firefoxBinary.addCommandLineOptions("--no-sandbox");
        //System.setProperty("webdriver.gecko.driver", DRIVERPATH);
        //FirefoxOptions firefoxOptions = new FirefoxOptions();
        //firefoxOptions.setBinary(firefoxBinary);
        //FirefoxDriver Webdriver = new FirefoxDriver(firefoxOptions);
        //Webdriver.get(p0);
        return Webdriver;
    }

    public static AppiumDriver<MobileElement> getDriverMobile(String Type,String target) throws Exception {

        if (driver == null) {
            if (Type.equals("ANDROID")) {
                createDriverAndroid(target);
            } else {
                creatDriverIOS();
            }
        }

        return driver;
    }

    private static void createDriverAndroid(String target) throws Exception {
        try {


        DesiredCapabilities caps = new DesiredCapabilities();

        //caps.setCapability("deviceId", PlatformDeviceIP);
        caps.setCapability("automationName", Config.AutomationName);
       caps.setCapability("platformName", Config.PlatformDeviceName);
        caps.setCapability("noReset", true);
        caps.setCapability("FullReset", true);

       if(Instrumentation.getDevices(target).equals("YES")) {

            caps.setCapability("udid", Config.UDID);

            System.out.println(InetAddress.getLocalHost().getHostName());
            System.out.println(InetAddress.getLocalHost().getHostAddress());


            if (target.equals("EMPRESAS")) {
                caps.setCapability("appPackage", "spcempresas.org.br");
                caps.setCapability("appActivity", ".ui.activities.SplashActivity");
                caps.setCapability("deviceName", "Android");
            }

            if (target.equals("CONSUMIDOR")) {
                caps.setCapability("appPackage", "br.com.spc.consumidor");
                caps.setCapability("appActivity", ".view.SplashActivity");
                caps.setCapability("deviceName", "Android");
            }

        }
        //caps.setCapability("skipDeviceInitialization", true);
        //caps.setCapability("skipServerInstallation", true);
        //caps.setCapability("ignoreUnimportantViews", true);
        //caps.setCapability("unicodeKeyboard", "true");
        //caps.setCapability("resetKeyboard", "true");


            driver = new AndroidDriver<>(new URL("http://"+Config.PlatformServer+":"+ Config.PlatformPort+"/wd/hub"), caps);
            //driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
            //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            Thread.sleep(5000);
        } catch (MalformedURLException  e) {
            e.printStackTrace();
            Assert.fail(String.valueOf(e));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    /*************************************************************
     * DRIVER IOS
     ****************************************************************/
    private static void creatDriverIOS() throws Exception {
        DesiredCapabilities dc = new DesiredCapabilities();
        //dc.setCapability("noReset", true);
        //dc.setCapability("FullReset", false);
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, Config.PlatformVersion);
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Config.PlatformName);
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, Config.AutomationName);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, Config.DeviceName);
        dc.setCapability(MobileCapabilityType.UDID, Config.UDID);
        //dc.setCapability("appPackage", PlatformAppPackage);
        //dc.setCapability("appActivity", PlatformAppActivity);
        dc.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir") + "/src/test/resources/app/SysdamApp.app");
        //dc.setCapability(MobileCapabilityType.APP,"/Users/braziltest/Library/Developer/Xcode/DerivedData/SysdamApp-bsugcygoekqcfmcehwilhuowzjap/Build/Products/Debug-iphonesimulator/SysdamApp.app");
         try {
            driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Metodo mata o driver e retorna valor null nele
     */
    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }

    /*************************************************************
     * EVIDENCIAS SCREENSHOTS
     ****************************************************************/
    public static void Evidencia(WebDriver driver, String Env,String Feature,String Scenario,String StepName,String Details ,String Status) throws IOException {
    if(Config.evidenceGen.equals("S")) {
        //evidence picture report
        id = id + 1;
        String pathCucumber = "";
        if (System.getProperty("os.name").contains("Windows")) {
            pathCucumber = Config.PATHEVIDENCEWIN;
        }

        if (System.getProperty("os.name").contains("Linux")) {
            pathCucumber = Config.PATHEVIDENCELINUX;
        }
        if (System.getProperty("os.name").contains("Mac OS")) {
            pathCucumber = Config.PATHEVIDENCEMAC;
        }

        File folder = new File(pathCucumber);
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                path = pathCucumber;
                id = 1;
            } else {
                System.out.println("Falha ao criar diretório!");
            }
        }
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(pathCucumber + id + ".jpg");
        String imageDest = pathCucumber + id + ".jpg";
        FileUtils.copyFile(scrFile, dest);
        Reporter.addScreenCaptureFromPath(imageDest);
        //System.out.println(scrFile + " - " + dest);


        //evidence text report
        //Instrumentation.evidenceText(Config.RunnerNbr,Env,Feature,Scenario,StepName,String.valueOf(id) ,mj.dataAtual(),"2",Status);
    }
    }
}
