package com.braziltest.Utils;

import com.braziltest.interfaces.DriverFactory;
import com.vimalselvam.cucumber.listener.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.WiniumDriver;

import java.io.IOException;

import static com.braziltest.Utils.Config.TIMEOUTAUTOMATION;
import static org.junit.Assert.assertFalse;

public class InstrumentationDesktop {

    public static void clickElement(WiniumDriver driver, String prmType, String prmTag, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            System.out.println("Clique  " + prmType +" "+ prmTag);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            if (prmType.equals("xpath")) {
                driver.findElement(By.xpath(prmTag)).click();
            }

            if (prmType.equals("className")) {
                driver.findElement(By.className(prmTag)).click();
            }

            if (prmType.equals("cssSelector")) {
                driver.findElement(By.cssSelector(prmTag)).click();
            }

            if (prmType.equals("id")) {
                driver.findElement(By.id(prmTag)).click();
            }

            if (prmType.equals("name")) {
                driver.findElement(By.name(prmTag)).click();
            }
            DriverFactory.Evidencia(driver, "");
        } catch (
                NoSuchElementException exception) {



            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }
}
