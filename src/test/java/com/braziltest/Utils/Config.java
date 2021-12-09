package com.braziltest.Utils;

import com.braziltest.utils.ManipularJson;

public class Config {

    public static final String PLATFORMNAME = "WEB";

    public static final String BROWSERTESTING = "FIREFOX"; // FIREFOX / CHROME //GRID

    //FIREFOX
    public static final String DRIVERPATHFOX = "/Users/braziltest/sources/repos/Drivers/geckodriver";

    //CHROME
    public static final String DRIVERPATH = "C:\\Drivers\\browsers\\chrome\\95.0.4638.54\\chromedriver.exe";

    //For Mac Users
    //public static final String PATHEVIDENCE = "/Users/braziltest/evidencias/Run_"+ getSaltStringCelular() + "/";

    //For Windows Users
    public static final String PATHEVIDENCE = "C:\\Evidencias\\Braziltest\\Run_"+ ManipularJson.getSaltStringCelular() + "\\";


    public static final int TIMEOUTAUTOMATION = 100;
    public static final String PLATFORMTYPE = PLATFORMNAME;

    public static final String email = "admin";
    public static final String passw = "Agt125243";


    public static final String dataAtual = ManipularJson.dataAtual();
    public static String ScenarioName = "";
    public static String ScenarioId = "";
    public static String FeatureName = "";


    public static final String xpath = "xpath";
    public static final String cssSelector = "cssSelector";
    public static final String className = "className";
    public static final String id = "id";
    public static final String tagname = "tagname";
}
