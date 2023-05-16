package com.br.spcbrasil.Utils;

import com.br.spcbrasil.interfaces.DriverFactory;
import com.vimalselvam.cucumber.listener.Reporter;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.br.spcbrasil.Utils.Config.TIMEOUTAUTOMATION;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Instrumentation {






    public static String listWebElementClass (WebDriver driver,String classname) throws IOException {
    String Ret = "";
        try {
            List<WebElement> listElement = driver.findElements(By.className(classname));
            for(int i =0;i<listElement.size();i++) {
                String elementText = listElement.get(i).getText();
                //System.out.println("INDEX :" + i + " - " + elementText);
                Ret = elementText +";"+Ret;
            }

        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
        return Ret;
    }

    public static void ClickOut(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.tagName("body")), 0, 0);
        actions.moveByOffset(500, 100).click().build().perform();
    }


    public static Boolean checkElementIsPresent(WebDriver driver, String xpath) throws IOException, InterruptedException {
        Thread.sleep(TIMEOUTAUTOMATION);
        Boolean Res = false;
        try {

            Boolean Display = driver.findElement(By.xpath(xpath)).isDisplayed();
            System.out.println("Element displayed is :" + Display);
            Boolean Enable = driver.findElement(By.xpath(xpath)).isEnabled();
            System.out.println("Element displayed is :" + Enable);
            if (Display) {
                Res = true;
            }
        } catch (NoSuchElementException exception) {
            System.out.println("Não Achou elemento em tela");
        }

        return Res;
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
