package com.br.spcbrasil.Pages;

import com.br.spcbrasil.Steps.Hook.BaseStep;
import com.br.spcbrasil.Utils.Config;
import com.br.spcbrasil.Utils.Instrumentation;

import java.io.IOException;

public class HomePage extends BaseStep {


    public static void thatTheUserIsOnTheHomeScreen() throws Exception {
       // DriverFactory.getDriver();
    }

    public static void sendCredencialsAnd(String arg0, String arg1,String Env) throws IOException, InterruptedException {

        //Instrumentation.clickWeb(Webdriver,Env, Config.className,"ant-btn","Confirm");
    }

    public static void GetMessageHome(String arg1,String Env) throws Exception {


        switch (arg1) {
            case "Press":
                Thread.sleep(1000);

                break;
            case "The closest thing to a crystal ball":
                Thread.sleep(1000);

                break;
            case "The leadership team":
                Thread.sleep(1000);

                break;
            case "Join the team":
            case "Your personal data scientist":
                Thread.sleep(1000);

                break;

            default:
                throw new Exception("Invalid option");
        }

}


    public static void confirmActionHome(String Env) throws IOException {

    }

    public static void clickOnProductLink(String arg0,String Env) throws Exception {

        switch (arg0) {
            case "Product":
                Thread.sleep(1000);

                break;
            case "Press":
                Thread.sleep(1000);

                break;
            case "THOUGHT LEADERSHIP":
                Thread.sleep(1000);

                break;
            case "ABOUT":
                Thread.sleep(1000);

                break;
            case "LEADERSHIP":
                Thread.sleep(1000);

                break;
            case "CAREERS":
                Thread.sleep(1000);

                break;


            default:
                throw new Exception("Invalid option");
        }



    }



    public static void acceptCookies(String Env) throws IOException {


    }


    public static void clickInConsulta(String arg0) throws IOException, InterruptedException {
        if(arg0.equals("Consultas")) {
            Instrumentation.clickByResourceId_Android(driver, "android.widget.ImageButton", "spcempresas.org.br:id/btnQuery", "Click Sair");
        }
        }
}
