package com.braziltest.Utils;

import com.braziltest.interfaces.DriverFactory;
import com.vimalselvam.cucumber.listener.Reporter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.braziltest.Utils.Config.TIMEOUTAUTOMATION;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Instrumentation {


    public static void takeScreenshot (WebDriver driver, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }

    public static void sendKeysWeb (WebDriver driver, String prmType,String prmTag,  String arg0, String StepLog) throws IOException {
        try {

            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            if(prmType.equals("xpath")){
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prmTag))).sendKeys(arg0);}

            if(prmType.equals("className")){
                waitCad.until(ExpectedConditions.presenceOfElementLocated(By.className(prmTag))).sendKeys(arg0);}

            if(prmType.equals("cssSelector")){
                waitCad.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(prmTag))).sendKeys(arg0);}

            if(prmType.equals("id")){
                waitCad.until(ExpectedConditions.presenceOfElementLocated(new By.ByName(prmTag))).sendKeys(arg0);}

            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }


    public static void clickWeb(WebDriver driver, String prmType, String prmTag, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            System.out.println("Clique  " + prmType +" "+ prmTag);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            if (prmType.equals("xpath")) {
                waitCad.until(ExpectedConditions.elementToBeClickable(By.xpath(prmTag))).click();
            }

            if (prmType.equals("className")) {
                waitCad.until(ExpectedConditions.elementToBeClickable(By.className(prmTag))).click();
            }

            if (prmType.equals("cssSelector")) {
                waitCad.until(ExpectedConditions.elementToBeClickable(By.cssSelector(prmTag))).click();
            }

            if (prmType.equals("id")) {
                waitCad.until(ExpectedConditions.visibilityOfElementLocated(By.id(prmTag))).click();
            }

            DriverFactory.Evidencia(driver, "");
        } catch (
                NoSuchElementException exception) {



            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }

    public static String waitngFor(WebDriver driver, String prmText) throws IOException {
        String Ret = "";
        try {
            List<WebElement> listElement = driver.findElements(By.xpath("//*[contains(text(),'" + prmText + "')]"));
            for (int i = 0; i < listElement.size(); i++) {
                String elementText = listElement.get(i).getText();
                if (elementText != null) {
                    Ret = "YES";
                }            }
        }catch(Exception e){
            waitngFor(driver,prmText);
        }
        return Ret;
    }

    public static void clickByfindElements (WebDriver driver, String prmCSS ,int index, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            List<WebElement> rows = driver.findElements(By.className(prmCSS));
            WebDriverWait listWait = new WebDriverWait(driver,TIMEOUTAUTOMATION);
            listWait.until(ExpectedConditions.visibilityOfAllElements(rows));
            WebElement button = rows.get(index);
            button.click();
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }

    public static void clickOnElementNotInteractWithContainsText (WebDriver driver, String prmText , String StepLog) throws Exception {
        Thread.sleep(TIMEOUTAUTOMATION);
        int prmIndex = 0;
        try {
            Reporter.addStepLog(StepLog);
            List<WebElement> listElement = null;

                listElement = driver.findElements(By.xpath("//*[contains(text(),'" + prmText + "')]"));



            for(int i =0;i<listElement.size();i++) {
                String elementText = listElement.get(i).getText();
                if (elementText.toUpperCase().trim().equals(prmText.toUpperCase())) {
                    prmIndex = i;
                }
            }

            WebElement element = listElement.get(prmIndex);
            element.click();
            //Thread.sleep(TIMEOUTAUTOMATION);

        } catch (
                NoSuchElementException  exception) {



        }
    }
    public static void clickOnElementNotInteractWithContainsText (WebDriver driver, String Type,String prmText  ,  String StepLog) throws IOException {
        int prmIndex = 0;
        try {
            Reporter.addStepLog(StepLog);
            List<WebElement> listElement = null;

            if(Type.equals("xpath")) {
                listElement = driver.findElements(By.xpath("//*[contains(text(),'" + prmText + "')]"));
            }

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

    public static void collectByClassNameIndex (WebDriver driver, String prmClassName,String prmText, String StepLog) throws IOException {
        Integer prmIndex = 0;
        try {
            Reporter.addStepLog(StepLog);
            List<WebElement> listElement = driver.findElements(By.className(prmClassName));
            for(int i =0;i<listElement.size();i++) {
                String elementText = listElement.get(i).getText();
                if(elementText.contains(prmText)) {
                    prmIndex = i;
                }
                System.out.println(elementText);
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
    public static void verticesAreVisible(WebDriver driver, String xpath) {
        List<WebElement> rows = driver.findElements(By.className(".sidebar-navigation-menu-item"));
        WebElement button = rows.get(1);
        button.click();
    }
    public static void clickButtonByIndex(WebDriver driver, String prmString){
       Integer prmIndex = 0;
        try {
            List<WebElement> listElement = driver.findElements(By.tagName("button"));
            for(int i =0;i<listElement.size();i++) {
                String elementText = listElement.get(i).getText();
                if (elementText.trim().equals(prmString)) {
                    prmIndex = i;
                }
            }
            WebElement element = listElement.get(prmIndex);
            element.click();
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException | IOException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }


    public static void cleanInputTextByClass (WebDriver driver, String prmCSS , String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.className(prmCSS))).clear();
            DriverFactory.Evidencia(driver,"");
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }

    public static void listWebElement (WebDriver driver) throws IOException {

        try {
            //List<WebElement> listElement = driver.findElements(By.xpath("//label[@for='mp__0__0']"));
            //List<WebElement> listElement = driver.findElements(By.tagName("label"));
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




    public static String findAllFilesInFolder(File folder) {
        String fineName ="";
        for (File file : folder.listFiles()) {
            if (!file.isDirectory()) {
                //System.out.println(file.getName());
                fineName = file.getName() + ";" + fineName;
            } else {
                findAllFilesInFolder(file);
            }

        }
        return fineName;
    }

    //--->





}
