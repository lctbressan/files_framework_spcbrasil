package br.com.trendalytics.Utils;

import br.com.trendalytics.interfaces.DriverFactory;
import com.vimalselvam.cucumber.listener.Reporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
            waitCad.until(ExpectedConditions.elementToBeClickable(By.xpath(prmXpath))).click();
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

    public static void clickByfindElement (WebDriver driver, String prmCSS ,int index, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.className(prmCSS))).click();
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }


    public static void clickOnElementNotInteractWithContainsText (WebDriver driver, String prmText ,  String StepLog) throws IOException {
        int prmIndex = 0;
        try {
            Reporter.addStepLog(StepLog);
            List<WebElement> listElement = driver.findElements(By.xpath("//*[contains(text(),'"+ prmText +"')]"));
            for(int i =0;i<listElement.size();i++) {
                String elementText = listElement.get(i).getText();
                     if (elementText.trim().equals(prmText)) {
                        prmIndex = i;
                      }
            }
            WebElement element = listElement.get(prmIndex);
            element.click();
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }


    public static void clickByClassNameIndex (WebDriver driver, String prmClassName,Integer prmIndex , String StepLog) throws IOException {

        try {
            Reporter.addStepLog(StepLog);
            List<WebElement> listElement = driver.findElements(By.className(prmClassName));
            WebElement element = listElement.get(prmIndex);
           element.click();
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }

    public static void verticesAreVisible(WebDriver driver, String xpath) {
        List<WebElement> rows = driver.findElements(By.className(".sidebar-navigation-menu-item"));
        WebElement button = rows.get(1);
        button.click();
    }
    public static void clickButtonByIndex(WebDriver driver, Integer prmIndex){
        try {
            List<WebElement> listElement = driver.findElements(By.tagName("button"));
            WebElement element = listElement.get(prmIndex);
            element.click();
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException | IOException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }

    public static void listWebElement (WebDriver driver) throws IOException {

        try {
            //List<WebElement> listElement = driver.findElements(By.xpath("//input[@class='tl-report-wizard-footer__btn']"));
            //List<WebElement> listElement = driver.findElements(By.tagName("button"));
            List<WebElement> listElement = driver.findElements(By.className("tl-card"));
            for(int i =0;i<listElement.size();i++) {
                String elementText = listElement.get(i).getText();
                System.out.println("INDEX :" + i + " - " + elementText);
            }
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }

    public static void ClickOut(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.tagName("body")), 0, 0);
        actions.moveByOffset(500, 100).click().build().perform();
    }




    public static void sendKeysByClassXpathWeb (WebDriver driver, String prmXpath,String prmText,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(prmXpath))).sendKeys(prmText);
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }

    //--->





}
