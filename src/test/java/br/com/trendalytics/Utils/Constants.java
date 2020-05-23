package br.com.trendalytics.Utils;

import static br.com.trendalytics.utils.ManipularJson.getSaltStringCelular;


public class Constants {

    public static final String PLATFORMNAME = "WEB";

    public static final String BROWSERTESTING = "FIREFOX"; // FIREFOX / CHROME

    //FIREFOX
    public static final String DRIVERPATH = "/Users/braziltest/sources/repos/Drivers/geckodriver";

    //CHROME
    //public static final String DRIVERPATH = "C:\\Drivers\\browsers\\chrome\\ChromeDriver 81.0.4044.138\\chromedriver.exe";

    //For Mac Users
    public static final String PATHEVIDENCE = "/Users/braziltest/evidencias/Run_"+ getSaltStringCelular() + "/";

    //For Windows Users
    //public static final String PATHEVIDENCE = "C:\\Evidencias\\Run_"+ getSaltStringCelular() + "\\";


    public static final int TIMEOUTAUTOMATION = 10;

    public static final String URLTESTING = "https://tp3app.trendalytics.co/signin";

    public static final String PLATFORMTYPE = PLATFORMNAME;

    public static final String email = "luis.bressan@joyjet.com";
    public static final String passw = "brt125243";
}
