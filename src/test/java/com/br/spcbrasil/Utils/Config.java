package com.br.spcbrasil.Utils;

import com.br.spcbrasil.utils.ManipularJson;

public class Config {

    public static final String PLATFORMNAME = "WEB";

    public static final String BROWSERTESTING = "CHROME"; // FIREFOX / CHROME

    public static  String PlatformName = "Android";
    public static String PlatformDeviceName ="";
    public static String PlatformServer = "";
    public static String PlatformPort =  "";
    public static final String PlatformVersion = "13.5";
    public static final String AutomationName = "UiAutomator2";//"UiAutomator2";//"XCUITest";//"UiAutomator2";//" XCUITest";

    //public static final String DeviceName = "iPhone SE (2nd generation)";
    //public static final String UDID = "3BA75E85-C547-4FA0-9565-200ADD631ABF";

    public static final String DeviceName = "android";//"iPhone 11";
    public static String UDID = "";
    //public static final String UDID = "B4103965-53E8-46C1-A7B5-C206545A55C3";
    public static final String PlatformType = PlatformName;

    //UBUNTU
    //FIREFOX
    //public static final String DRIVERPATH = "/home/mediaworks/Drivers/browsers/firefox/geckodriver-v0.27.0-linux64/geckodriver";
    //CHROME
   // public static final String DRIVERPATH = "/home/mediaworks/Drivers/browsers/chrome/chromedriver.exe";

    //For Mac Users
    //public static final String PATHEVIDENCE = "/home/mediaworks/evidencias/Run_"+ getSaltStringCelular() + "/";

    //FIREFOX
   //public static final String DRIVERPATH = "C:\\Drivers\\browsers\\firefox\\geckodriver-v0.26.0-win64\\geckodriver.exe";

    //WINDOWS
    //CHROME
    public static final String DRIVERPATH = "C:\\Drivers\\browsers\\chrome\\89.0.4389.23\\chromedriver_win32\\chromedriver.exe";
    //For Windows Users
    public static final String RunnerNbr = "Run_"+ ManipularJson.getSaltStringCelular();
    public static final String PATHEVIDENCEWIN = "C:\\Evidencias\\SPCBR\\"+ RunnerNbr + "\\";
    public static final String PATHEVIDENCELINUX = "/home/bressan/evidencias/SPCBR/"+ RunnerNbr + "/";

    public static final String PATHEVIDENCEMAC = "/Users/braziltest/evidencias/SPCBR/"+ RunnerNbr + "/";


    public static final int TIMEOUTAUTOMATION = 1000;
    public static final int TIMEOUTAUTOMATIONSTEPS = 500;
    public static final String PLATFORMTYPE = PLATFORMNAME;

    public static final String email = "lctbressan@gmail.com";
    public static final String passw = "brt125243";

    public static final String xpath = "xpath";
    public static final String cssSelector = "cssSelector";
    public static final String className = "className";
    public static final String id = "id";
    public static String TestWeb = "";

    public static final String dataAtual = ManipularJson.dataAtual();
    public static final int timeOutInSeconds =15;
    public static final String evidenceGen = "S";


}
