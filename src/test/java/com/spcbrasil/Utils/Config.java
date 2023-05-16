package com.spcbrasil.Utils;

import com.spcbrasil.utils.ManipularJson;

public class Config {

    public static final String PLATFORMNAME = "WEB";

    public static final String BROWSERTESTING = "CHROME"; // FIREFOX / CHROME   z //GRID

    public static final String DRIVERPATHCHROMELIN = "/home/bressan/drivers/chromedriver_linux64/chromedriver";
    public static final String DRIVERPATHCHROMEMAC = "/Users/bressan/drivers/chromedriver_linux64/chromedriver";
    public static final String DRIVERPATHFFOXLIN = "/home/bressan/drivers/firefox/geckodriver-v0.30.0-linux64/geckodriver";
    public static final String DRIVERPATHCHROMEWIN = "C:\\Drivers\\browsers\\chrome\\107\\chromedriver.exe";
    public static final String DRIVERPATHFFOXLWIN = "/home/bressan/drivers/chromedriver_linux64/chromedriver";
    //For Windows Users
    public static final String PATHEVIDENCEWIN = "C:\\Evidencias\\Braziltest\\Run_"+ ManipularJson.getSaltStringCelular() + "\\";
    public static final String PATHEVIDENCELIN = "/home/bressan/evidencias/teste/Run_"+ ManipularJson.getSaltStringCelular() + "/";
    public static final String PathEvidenceCentral = "\\\\10.10.0.10\\f\\evidencias\\CentralEnvidence";
    public static final String RunnerNbr = ManipularJson.getSaltStringCelular();
    public static final String PATHEVIDENCEMAC = "/users/bressan/evidencias/almadin/Run_"+ RunnerNbr + "/";
    public static final int TIMEOUTAUTOMATION = 100;
    public static final String PLATFORMTYPE = PLATFORMNAME;
    public static final String email = "admin";
    public static final String passw = "admin";
    public static final String dataAtual = ManipularJson.dataAtual();
    public static String ScenarioName = "";
    public static String ScenarioId = "";
    public static String FeatureName = "";


    public static final String xpath = "xpath";
    public static final String cssSelector = "cssSelector";
    public static final String className = "className";
    public static final String id = "id";
    public static final String tagname = "tagname";
    public static final String name = "name";


    public static String PathOrigin = "";
    public static String pSit = "";


    public static String Application = "C:\\WINDOWS\\system32\\notepad.exe";
    public static String WiniHost = "http://localhost:9999";
    public static int prmCardCoout = 0;
    public static int prmListCount = 0;



    public static int prmPagination = 0;



    public static String xsdACPO111 = "C:\\spcbrasil\\xsd\\ACPO111.xsd";

}
