package com.br.spcbrasil.Utils;

import com.br.spcbrasil.dao.devicefarmDao;
import com.br.spcbrasil.dto.devicefarm;
import com.br.spcbrasil.utils.ManipularJson;
import com.br.spcbrasil.interfaces.DriverFactory;
import com.google.common.collect.ImmutableMap;
import com.vimalselvam.cucumber.listener.Reporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.openqa.selenium.*;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.constraints.Null;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class Instrumentation {

    protected WebDriverWait wait;

    static ManipularJson mj = new ManipularJson();



    public static void  dealocatetDevices() throws Exception {
        String dateDevice = null;
        Date d1 = null;
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        devicefarmDao devicefarmdao = (devicefarmDao) ac.getBean("devicefarmDao");

        Collection<devicefarm> df = devicefarmdao.getDevices();
        for(devicefarm DF : df){
            System.out.println(DF.getDeviceName() +" "+ DF.getPlatFormPort() +" "+ DF.getPlatFormServer()+" "+ DF.getSTATUS()+" "+ DF.getUDID() +" "+ DF.getCreation_date());
            Config.PlatformPort =DF.getPlatFormPort();
            Config.PlatformServer = DF.getPlatFormServer();
            Config.PlatformDeviceName = DF.getDeviceName();
            Config.UDID = DF.getUDID();
           //if( calcDiffTime(DF.getCreation_date()).equals("YES")){
               Instrumentation.setDeviceReady(DF.getDeviceName() );
           //}

        }

    }

    public static String calcDiffTime(String d1) throws ParseException {
        String Ret = "";
        Date date1=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(d1);

        Date date2 = new Date();
        // d1, d2 are dates

        long diff = date2.getTime() - date1.getTime();

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);

        System.out.print(diffDays + " days, ");
        System.out.print(diffHours + " hours, ");
        System.out.print(diffMinutes + " minutes, ");
        System.out.print(diffSeconds + " seconds.");
        if (diffMinutes > 5){
            Ret = "YES";
        }
        return Ret;
    }

    public static String  getDevices(String target) throws Exception {
        String Ret = "";
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        devicefarmDao devicefarmdao = (devicefarmDao) ac.getBean("devicefarmDao");

        Collection<devicefarm> df = devicefarmdao.getDevices();
        for(devicefarm DF : df){
            System.out.println(DF.getDeviceName() +" "+ DF.getPlatFormPort() +" "+ DF.getPlatFormServer()+" "+ DF.getSTATUS()+" "+ DF.getUDID());
            Config.PlatformPort =DF.getPlatFormPort();
            Config.PlatformServer = DF.getPlatFormServer();
            Config.PlatformDeviceName = DF.getDeviceName();
            Config.UDID = DF.getUDID();
            if(DF.getSTATUS().equals("READY")){
                Ret = "YES";
                devicefarmdao.setDeviceRunner(DF.getDeviceName(),target);
                break;
            }

        }
    return Ret;
    }

    public static void setDeviceReady(String DeviceName) throws Exception {

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        devicefarmDao devicefarmdao = (devicefarmDao) ac.getBean("devicefarmDao");
        devicefarmdao.setDeviceReady(DeviceName);
    }

        //=========================================================================================================================
    //all classes
    //=========================================================================================================================
    public static void adbShellEvents(int value){
        Runtime run = Runtime.getRuntime();
        try{
            String exec = "adb shell input keyevent " + value;
            final Process process = run.exec(exec);
            process.waitFor();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void getInformationFromView( AppiumDriver<MobileElement> driver, String className, String text, String StepLog) throws IOException, InterruptedException {
        Thread.sleep(8000);
        List<MobileElement> rows = driver. findElementsByXPath("//*");
        for(int i=0;i<rows.size();i++) {
        String elementText = rows.get(i).getText();
        System.out.println("RESULT >> " + elementText);
            Instrumentation.resultText(Config.RunnerNbr,elementText);
        }


    }
    public static void scrollDown(AppiumDriver<MobileElement> driver)
    {

        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth() / 2;
        int starty = (int) (size.getHeight() * 0.80);
        int endy = (int) (size.getHeight() * 0.10);
        driver.swipe(x, starty, x, endy, 800);

    }

    public static void scrollUp(AppiumDriver<MobileElement> driver)
    {
        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth() / 2;
        int starty = (int) (size.getHeight() * 0.10);
        int endy = (int) (size.getHeight() * 0.90);
        driver.swipe(x, starty, x, endy, 800);
    }

    public static void lftRightSwipe(AppiumDriver<MobileElement> driver){
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.100);
        int endx = (int) (size.width * 0.10);
        int starty = size.height / 2;
        System.out.println("Start swipe operation");
        driver.swipe(startx, starty, endx, starty, 500);
    }
    public static void takeScreenshot (WebDriver driver, String StepLog,String Env) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            DriverFactory.Evidencia(driver,Env,"takeScreenshot","takeScreenshot","takeScreenshot","takeScreenshot","PASSED");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }

public static String checkOnScreen(AppiumDriver<MobileElement> driver, String value) throws InterruptedException {
    String prmmRet = "";
    //Thread.sleep(200);
    List<MobileElement> rows = driver.findElementsByXPath("//*");
    if(rows.size() != 0) {
        for (int i = 0; i < rows.size(); i++) {
            String elementText = rows.get(i).getText();
            System.out.println("RESULT >> " + elementText);
            if (elementText.contains(value)) {
                prmmRet = "YES";
            }
        }
    }
    return prmmRet;
}


    public static String  waitingforTextScreen(AppiumDriver<MobileElement> driver,String SomeItemScreen) throws IOException, InterruptedException {
        String Ret = "";
        System.out.println("Waiting For screen element ..." + SomeItemScreen);
        for (int i = 0; i < 50000; i++) {
            System.out.println(SomeItemScreen);
            String ResultScreen = Instrumentation.checkOnScreen(driver,SomeItemScreen);
            if (ResultScreen == "YES") {
                Ret = "YES";
                break;
            }
        }
        return Ret;
    }
    public static String waitngFor(AppiumDriver<MobileElement> driver, String prmText) throws IOException {
        String Ret = "";
        try {
            List<MobileElement> listElement = driver.findElements(By.xpath("//*[contains(text(),'" + prmText + "')]"));
            for (int i = 0; i < listElement.size(); i++) {
                String elementText = listElement.get(i).getText();
                if (elementText != null) {
                    Ret = "YES";
                }
            }
        } catch (Exception e) {
            waitngFor(driver, prmText);
        }
        return Ret;
    }

//========================================================================================================================================================
// MOBILE ANDROID
//========================================================================================================================================================

    public static void clickByClassText_Android (AppiumDriver<MobileElement> driver, String className, String text, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);


            WebDriverWait waitCad = new WebDriverWait(driver, Config.timeOutInSeconds);
            waitCad.until(ExpectedConditions.and(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//" + className + "[@text='" + text + "']"))));
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//" + className + "[@text='" + text + "']"))).click();

            System.out.println("clickByText_Android >>> " +  className + "  " +  text+ "  " + StepLog);

            DriverFactory.Evidencia(driver,"","","","","","");


        } catch (
                NoSuchElementException exception) {
            Assert.fail(String.valueOf(exception));
            System.out.println("FAILURE" + exception);
        }
    }

    public static void sendKeysByClassText_Android (AppiumDriver<MobileElement> driver, String className, String text, String arg0,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            //DriverFactory.Evidencia(driver,"","","","","","");

            WebDriverWait waitCad = new WebDriverWait(driver, Config.timeOutInSeconds);
            waitCad.until(ExpectedConditions.and(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//" + className + "[@text='" + text + "']"))));
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//" + className + "[@text='" + text + "']"))).sendKeys(arg0);

            System.out.println("clickByText_Android >>> " +  className + "  " +  text+ "  " + StepLog);

            //MobileElement elem = driver.findElement(By.xpath("//" + className + "[@text='" + text + "']"));
            //elem.click();


        } catch (
                NoSuchElementException exception) {
            Assert.fail(String.valueOf(exception));
            System.out.println("FAILURE" + exception);
        }
    }

    public static void clickByText_Android (AppiumDriver<MobileElement> driver, String className, String text, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            //

            WebDriverWait waitCad = new WebDriverWait(driver, Config.timeOutInSeconds);
            waitCad.until(ExpectedConditions.and(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//" + className + "[@text='" + text + "']"))));
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//" + className + "[@text='" + text + "']"))).click();
            DriverFactory.Evidencia(driver,"","","","","","");
            System.out.println("clickByText_Android >>> " +  className + "  " +  text+ "  " + StepLog);

            //MobileElement elem = driver.findElement(By.xpath("//" + className + "[@text='" + text + "']"));
            //elem.click();


        } catch (
                NoSuchElementException exception) {
            Assert.fail(String.valueOf(exception));
            System.out.println("FAILURE" + exception);
        }
    }
    public static void clickByXpath_Android(AppiumDriver<MobileElement> driver, String xpath, String StepLog) {
        try {
            Reporter.addStepLog(StepLog);

            WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            DriverFactory.Evidencia(driver,"","","","","","");

        } catch (
                NoSuchElementException | IOException exception) {
            System.out.println("FAILURE" + exception);
            Assert.fail(String.valueOf(exception));

        }
    }
    public static void clickByResourceId_Android (AppiumDriver<MobileElement> driver,String className,String ResourceId,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);

            WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//"+ className +"[@resource-id='"+ ResourceId +"']"))).click();
            DriverFactory.Evidencia(driver,"","","","","","");

        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
            Assert.fail(String.valueOf(exception));

        }
    }
    public static void clickById_Android (AppiumDriver<MobileElement> driver,String className,String Id,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);

            WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("//"+ className +"[@id='"+ Id +"']"))).click();
            DriverFactory.Evidencia(driver,"","","","","","");

        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
            Assert.fail(String.valueOf(exception));

        }
    }
    public static void sendKeyByClassName_Android (AppiumDriver<MobileElement> driver,String className,String text,String prmText,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            //

            WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//"+ className +"[@text='"+ text +"']")))).sendKeys(prmText);
            DriverFactory.Evidencia(driver,"","","","","","");

            //WebDriverWait wait = new WebDriverWait(driver, 20);
            //wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//"+ className +"[@text='"+ text +"']")))).sendKeys(prmText);


        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
            Assert.fail(String.valueOf(exception));

        }
    }
    public static void sendKeyByResourceId_Android(AppiumDriver<MobileElement> driver, String className, String ResourceId, String prmText, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
                WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);

            wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//"+ className +"[@resource-id='"+ ResourceId +"']")))).sendKeys(prmText);
            DriverFactory.Evidencia(driver,"","","","","","");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
            Assert.fail(String.valueOf(exception));

        }
    }
    public static void clearByResourceId_Android(AppiumDriver<MobileElement> driver, String className, String ResourceId, String prmText, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);

            wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//"+ className +"[@resource-id='"+ ResourceId +"']")))).clear();
            DriverFactory.Evidencia(driver,"","","","","","");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
            Assert.fail(String.valueOf(exception));

        }
    }
    public static void SendKeyByResourceId_AndroidDirect (AppiumDriver<MobileElement> driver,String className,String ResourceId,String prmText,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            //WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
            MobileElement melem = driver.findElement(By.xpath("//"+ className +"[@resource-id='"+ ResourceId +"']"));
            melem.click();
            melem.sendKeys("1");
            //wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//"+ className +"[@resource-id='"+ ResourceId +"']")))).sendKeys(prmText);
            DriverFactory.Evidencia(driver,"","","","","","");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
            Assert.fail(String.valueOf(exception));

        }
    }

    public static void clickByButtonContentDesc_Android (AppiumDriver<MobileElement> driver,String className,String button,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, Config.timeOutInSeconds);
            waitCad.until(ExpectedConditions.and(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//"+ className +"[@content-desc='"+ button +"']"))));
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//"+ className +"[@content-desc='"+ button +"']"))).click();
            DriverFactory.Evidencia(driver,"","","","","","");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }
    public static void SendKeyContentDesc_Android (AppiumDriver<MobileElement> driver,String className,String contentdesc,String Arg,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait wait = new WebDriverWait(driver, 10);

            wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//"+ className +"[@content-desc='"+ contentdesc +"']")))).sendKeys(Arg);
            DriverFactory.Evidencia(driver,"","","","","","");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }

    public static String checkTextOnView(AppiumDriver<MobileElement> driver,String className,String text,String StepLog){
        String Ret = "";
         String items = checkTextOnViewRet(driver,className,text,StepLog);
         for(String item : items.split("\n") ){
             if(item.contains(text)){
                 Ret = "YES";
             }
         }
         return Ret;
    }

    public static String checkTextOnViewRet(AppiumDriver<MobileElement> driver,String className,String text,String StepLog) {
        String Ret = "";
        try {
            List<MobileElement> listEment = driver.findElements(By.xpath("//" + className));
            for (WebElement element : listEment) {
                //while (listEment.size()>0) {
                    System.out.println(element.getText());
                Ret = element.getText() +"\n"+Ret;
                   /* if (element.getText().contains(text)) {
                        Ret = "YES";
                    }
                    System.out.println(element.getText());
                    if (element.getText().contains(text)) {
                        Ret = "YES";
                    }*/
                //}
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return Ret;
    }

   //=========================================================================================================================

    public static void clickByID_IOS (AppiumDriver<MobileElement> driver,String IdText,String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, Config.timeOutInSeconds);

            waitCad.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId(IdText))).click();
            DriverFactory.Evidencia(driver,"","","","","","PASSED");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }
    public static void SendKeyByID_IOS (AppiumDriver<MobileElement> driver,String IdText, String Arg, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, Config.timeOutInSeconds);
            waitCad.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId(IdText))).sendKeys(Arg);
            DriverFactory.Evidencia(driver,"","","","","","PASSED");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }
    public static void SendKeyByXPATH_IOS (AppiumDriver<MobileElement> driver,String type, String value, String Arg, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, Config.timeOutInSeconds);
            //waitCad.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath(prmXpath))).sendKeys(Arg);
            waitCad.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//" + type + "[@value='" + value + "']"))).sendKeys(Arg);

            DriverFactory.Evidencia(driver,"","","","","","PASSED");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }

    public static void textIsDisplayed_IOS (AppiumDriver<MobileElement> driver,String IdText, String Arg, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, Config.timeOutInSeconds);
            waitCad.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId(IdText))).getText().equals(Arg);
            DriverFactory.Evidencia(driver,"","","","","","PASSED");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }
    public static void textIsDisplayedByXpath_IOS (AppiumDriver<MobileElement> driver,String type, String text, String Arg, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, Config.timeOutInSeconds);
            waitCad.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//" + type + "[@label='" + text + "']"))).getText().equals(Arg);
            DriverFactory.Evidencia(driver,"","","","","","PASSED");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }
    public static void clickByXpath_IOS (AppiumDriver<MobileElement> driver,String type, String value, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, Config.timeOutInSeconds);

            //waitCad.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//" + className + "[contains("+type+", '" + text + "')]["+position+"]"))).click();
            waitCad.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//" + type + "[@label='" + value + "']"))).click();

            DriverFactory.Evidencia(driver,"","","","","","PASSED");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }
    public static void elementIsDisplayedByXpath_IOS (AppiumDriver<MobileElement> driver,String className, int position, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, Config.timeOutInSeconds);
            waitCad.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//" + className+ "['"+position+"']"))).click();
            DriverFactory.Evidencia(driver,"","","","","","PASSED");
        } catch (
                NoSuchElementException exception) {
            System.out.println("FAILURE" + exception);
        }
    }


    public static void resultText(String Runner,String data) throws IOException {

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

        File dir = new File(pathCucumber);
        //String Arqname = Scenario.trim().replace(" ","_")+".txt";
        String Arqname = Runner +".txt";
        File arq = new File(dir, Arqname);

        try {
            arq.createNewFile();
            FileWriter fileWriter = new FileWriter(arq, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(data);
            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void HitEnter_Adroid(AppiumDriver<MobileElement> driver) {
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
    }

    public static String geraCPF() {
        String iniciais = "";
        Integer numero;
        for (int i = 0; i < 9; i++) {
            numero = new Integer((int) (Math.random() * 10));
            iniciais += numero.toString();
        }
        return iniciais + calcDigVerif(iniciais);
    }

    private static String calcDigVerif(String num) {
        Integer primDig, segDig;
        int soma = 0, peso = 10;
        for (int i = 0; i < num.length(); i++)
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;

        if (soma % 11 == 0 | soma % 11 == 1)
            primDig = new Integer(0);
        else
            primDig = new Integer(11 - (soma % 11));

        soma = 0;
        peso = 11;
        for (int i = 0; i < num.length(); i++)
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;

        soma += primDig.intValue() * 2;
        if (soma % 11 == 0 | soma % 11 == 1)
            segDig = new Integer(0);
        else
            segDig = new Integer(11 - (soma % 11));

        return primDig.toString() + segDig.toString();
    }




    //--->
}
