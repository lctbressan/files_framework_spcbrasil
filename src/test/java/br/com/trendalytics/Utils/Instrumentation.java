package br.com.trendalytics.Utils;

import br.com.trendalytics.interfaces.DriverFactory;
import com.vimalselvam.cucumber.listener.Reporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static br.com.trendalytics.Utils.Constants.TIMEOUTAUTOMATION;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class Instrumentation {
    protected WebDriverWait wait;


    public static void takeScreenshot (WebDriver driver, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }

    public static void sendKeysByXpathWeb (WebDriver driver, String prmXpath,  String arg0, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prmXpath))).sendKeys(arg0);
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }

    public static void clickByXpathWeb (WebDriver driver, String prmXpath, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prmXpath))).click();
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }


    public static void clickBycssSelector (WebDriver driver, String prmXpath, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(prmXpath))).click();
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }


    public static void clickByfindElements (WebDriver driver, String prmCSS ,int index, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            List<WebElement> rows = driver.findElements(By.className(prmCSS));
            WebElement button = rows.get(index);
            button.click();
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }


    public static void verticesAreVisible(WebDriver driver, String xpath) {

        List<WebElement> rows = driver.findElements(By.className("sidebar-navigation-menu-item"));
        WebElement button = rows.get(1);
        button.click();
    }

    //--->

    public static void clickByText_Android (AppiumDriver<MobileElement> driver,String className,String text,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//"+ className +"[@text='"+ text +"']"))).click();
            assertTrue("This will succeed.", true);
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }

public static void clearByText_Android (AppiumDriver<MobileElement> driver,String className,String text,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            Constants plat= new Constants();
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//"+ className +"[@text='"+ text +"']"))).clear();

            assertTrue("This will succeed.", true);
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }


public static void sendKeysByText_Android (AppiumDriver<MobileElement> driver,String className,String text,String arg0,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            Constants plat= new Constants();
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//"+ className +"[@text='"+ text +"']"))).sendKeys(arg0);
            assertTrue("This will succeed.", true);
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }
    public static void sendKeysByIndex_Android (AppiumDriver<MobileElement> driver,String className,String index,String arg0,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            Constants plat= new Constants();
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//"+ className +"[@index='"+ index +"']"))).sendKeys(arg0);
            assertTrue("This will succeed.", true);
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }

    public static void sendKeyByXpath_Android (AppiumDriver<MobileElement> driver,String xpath, String arg1,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            Constants plat= new Constants();
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).sendKeys(arg1);
            assertTrue("This will succeed.", true);
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }


    public static void clickByXpath_Android (AppiumDriver<MobileElement> driver,String xpath, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            Constants plat= new Constants();
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            assertTrue("This will succeed.", true);
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }
    public static void clickByContentDesc_Android (AppiumDriver<MobileElement> driver,String className,String button,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            Constants plat= new Constants();
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//"+ className +"[@content-desc='"+ button +"']"))).click();
            assertTrue("This will succeed.", true);
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }


    public static void clickByResource_id_Android (AppiumDriver<MobileElement> driver,String className,String resource_id,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            Constants plat= new Constants();
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//"+ className +"[@resource-id='"+ resource_id +"']"))).click();
            assertTrue("This will succeed.", true);
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }
    public static void SendKeyByIndex_Android (AppiumDriver<MobileElement> driver,String className,String index,String Arg,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait wait = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            Constants plat= new Constants();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//"+ className +"['"+ index +"']"))).sendKeys(Arg);
            assertTrue("This will succeed.", true);
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }

    public static void SendKeyContentDesc_Android (AppiumDriver<MobileElement> driver,String className,String contentdesc,String Arg,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait wait = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            Constants plat= new Constants();
            wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//"+ className +"[@content-desc='"+ contentdesc +"']")))).sendKeys(Arg);
            assertTrue("This will succeed.", true);
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }


    //######################### >> IOS MAPPERS

    public static void clickByID_IOS (AppiumDriver<MobileElement> driver,String IdText,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            Constants plat= new Constants();
            waitCad.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId(IdText))).click();
            assertTrue("This will succeed.", true);
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }

    public static void SendKeyByID_IOS (AppiumDriver<MobileElement> driver,String IdText, String Arg, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            Constants plat= new Constants();
            waitCad.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId(IdText))).sendKeys(Arg);
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }

    public static void textIsDisplayed_IOS (AppiumDriver<MobileElement> driver,String IdText, String Arg, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            Constants plat = new Constants();
            waitCad.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId(IdText))).getText().equals(Arg);
            DriverFactory.Evidencia(driver, "");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }

    public static void textIsDisplayedByXpath_IOS (AppiumDriver<MobileElement> driver,String type, String text, String Arg, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            Constants plat = new Constants();
            waitCad.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//" + type + "[@label='" + text + "']"))).getText().equals(Arg);
            DriverFactory.Evidencia(driver, "");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }

    public static void clickByXpath_IOS (AppiumDriver<MobileElement> driver,String className, String type, String text, int position, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            Constants plat= new Constants();
            waitCad.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//" + className + "[contains("+type+", '" + text + "')]["+position+"]"))).click();
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }

    public static void elementIsDisplayedByXpath_IOS (AppiumDriver<MobileElement> driver,String className, int position, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            Constants plat = new Constants();
            waitCad.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//" + className+ "['"+position+"']"))).click();
            DriverFactory.Evidencia(driver, "");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }


}
