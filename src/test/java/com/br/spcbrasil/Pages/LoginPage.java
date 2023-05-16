package com.br.spcbrasil.Pages;

import com.br.spcbrasil.dto.thusDbLocal;
import com.br.spcbrasil.pmixJsonDto.PmixJson;
import com.br.spcbrasil.utils.ManipularJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.br.spcbrasil.Steps.Hook.BaseStep;
import com.br.spcbrasil.Steps.LoginSteps;
import com.br.spcbrasil.Utils.Config;
import com.br.spcbrasil.Utils.Instrumentation;
import com.br.spcbrasil.dao.thusLocalDao;
import com.br.spcbrasil.interfaces.DriverFactory;
import com.vimalselvam.cucumber.listener.Reporter;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
    public class LoginPage extends BaseStep {


    private static String JsonPmix;
    public Logger log = LoggerFactory.getLogger(LoginSteps.class);
    static ManipularJson mj = new ManipularJson();
    public static void thatTheUserInTheMainPage(String arg0) throws Exception {

        DriverFactory.getDriverWeb(arg0);

    }










    public static void navigateTo(WebDriver driver, String arg0) {
        driver.navigate().to(arg0);
    }






    public static void testDataFromLocalDataBaseVersusEnv(String arg0, String arg1, String Server) throws Exception {
        Integer count = 0;
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        thusLocalDao thusLocaldao = (thusLocalDao) ac.getBean("thusLocalDao");

        //SEARCH FROM LOCAL
        Collection<thusDbLocal> retthusLocaldao = thusLocaldao.findLocalData(arg0, Server);
        if (retthusLocaldao.isEmpty()) {
            assertTrue(false);
        }
        for (thusDbLocal tdl : retthusLocaldao) {
            count = count + 1;
            System.out.println(count + " >>>> RESULTSET : " + tdl.getProduto().trim() + " - " + tdl.getPreco() +" - "+ tdl.getTPN());

        }
    }




    public static void checkRestaurantID(String arg0) throws IOException {
        Reporter.addStepLog("Check Restaurant ID");
        ObjectMapper mapper = new ObjectMapper();
        PmixJson root = mapper.readValue(JsonPmix, PmixJson.class);
        assertEquals("Checking Restaurant ID", arg0, root.getParams().getRestaurant_id());
    }


    public static void product(String arg0) throws IOException {
        Reporter.addStepLog("Check Product Name");
        ObjectMapper mapper = new ObjectMapper();
        PmixJson root = mapper.readValue(JsonPmix, PmixJson.class);
        assertEquals("Checking Product Name ", arg0, root.getParams().getTlogs().get(0).getValuemeals().get(0).getValuemeal_name());
    }







    public static void openSpcBrasilEmpresas(String Type,String target) throws Exception {
        DriverFactory.getDriverMobile(Type,target);

    }

    public static void logonDeviceANDOID(String login, String senha) throws IOException, InterruptedException {


        Instrumentation.sendKeyByClassName_Android(driver,"android.widget.EditText","Usuário",login,"Informe usuario");

        Instrumentation.sendKeyByClassName_Android(driver,"android.widget.EditText","Senha",senha,"Informe a senha");

        //Instrumentation.clickByText_Android1(driver,"android.widget.TextView","Entrar","Click botao entrar");
    }


    public static void startInspection(String arg0,String foto,Integer qtdy,String permitir) throws IOException, InterruptedException {
        TouchAction action = new TouchAction(driver);
            Integer count =0;



            //Inicia a inspeção
           Instrumentation.clickByXpath_IOS(driver,"XCUIElementTypeOther","cardInactiveInspectionCardToClick","Inicia a inspecao");


            //Seleciona Barragem
            Instrumentation.clickByXpath_IOS(driver, "XCUIElementTypeOther", arg0, "Seleciona a Barragem");


            //Click permitir
           // if(permitir.equals("S")) {
                Instrumentation.clickByXpath_IOS(driver,"XCUIElementTypeButton","Allow While Using App","");

           // }
            //Iniciar Inpeção clica no PLAY
            //Thread.sleep(2000);
            //action.tap(380, 1170).perform();

        //play Inspection
        Thread.sleep(3000);
        Instrumentation.clickByID_IOS(driver,  "playInspection", "Play Inspection");
        //action.tap(380, 900).perform();


        for (int i = 0; i < qtdy; i++) {

            //click sandwich
            Instrumentation.clickByButtonContentDesc_Android(driver, "android.view.ViewGroup", "hamburguerInspectionAction", "Click Inspecionar item");
            Thread.sleep(1000);


            //Inspecionar item
            Instrumentation.clickByText_Android(driver, "android.widget.TextView", "Inspecionar item", "Click Inspecionar item");



            //Ficha barragem concreto
            Instrumentation.clickByText_Android(driver, "android.widget.TextView", "Ficha barragem concreto", "Click Ficha barragem concreto");



            //Estrutura 1
            Instrumentation.clickByText_Android(driver, "android.widget.TextView", "Estrutura 1", "Click Estrutura 1");



            //Outras anomalias
            Instrumentation.clickByText_Android(driver, "android.widget.TextView", "Outras anomalias", "Click Outras anomalias");



            if (foto.equalsIgnoreCase("S")) {
                //Inserir fotos
                Instrumentation.clickByText_Android(driver, "android.widget.TextView", "Inserir fotos", "Click Inserir fotos");

                if(count == 0) {
                    if (permitir.equals("S")) {
                        if (Config.PlatformDeviceName.equals("RQ8N109W2ZE")) {
                            Instrumentation.clickByText_Android(driver, "android.widget.Button", "Permitir", "Click permitir");
                        }

                        //Click permitir
                        if (Config.PlatformDeviceName.equals("42004d4300c6a403")) {
                            Instrumentation.clickByText_Android(driver, "android.widget.Button", "PERMITIR", "Click permitir");
                        }
                    }
                }

                //Instrumentation.listOption(driver);

                //FOTO3

                Instrumentation.clickByText_Android(driver, "android.widget.TextView", "F", "Click Inserir fotos 1");
                Thread.sleep(2000);
                Instrumentation.clickByText_Android(driver, "android.widget.TextView", "F", "Click Inserir fotos 2 ");
                Thread.sleep(1000);
                Instrumentation.clickByText_Android(driver, "android.widget.TextView", "F", "Click Inserir fotos 3");

                /*
                Thread.sleep(4000);
                action.tap(380, 1170).perform();

                Thread.sleep(4000);
                action.tap(380, 1170).perform();

                Thread.sleep(4000);
                action.tap(380, 1170).perform();
                */

            }
            Thread.sleep(1000);

            //CONFIRMAR POS FOTO
            //Instrumentation.clickByText_Android(driver, "android.widget.TextView", "Confirmar", "Click Confirmar");
            Instrumentation.clickByButtonContentDesc_Android(driver, "android.view.ViewGroup", "inspectionFormConfirmButton", "Click Inspecionar item");



            //OBSERVAÇÃO
            Instrumentation.clickByText_Android(driver, "android.widget.EditText", "Observação do item inspecionado", "Click Inserir fotos 3");
            Instrumentation.sendKeyByClassName_Android(driver, "android.widget.EditText", "Observação do item inspecionado", "Test Automation number : ( " + count + " )", "Informe obsercação");
            Thread.sleep(2000);


            //CONFIRMAR OBSERVAÇÃO
            Instrumentation.clickByText_Android(driver, "android.widget.TextView", "Confirmar", "Click Confirmar");
            //Instrumentation.clickByButtonContentDesc_Android(driver, "android.view.ViewGroup", "ObsModalConfirm", "Click Inspecionar item");


            //CONFIRMAR POS OBSERVAÇÃO
            //Instrumentation.clickByText_Android(driver, "android.widget.TextView", "Confirmar", "Click Confirmar");
            Instrumentation.clickByButtonContentDesc_Android(driver, "android.view.ViewGroup", "inspectionFormConfirmButton", "Click Inspecionar item");
            Thread.sleep(2000);
            //CONFIRMAR POPUP
            Instrumentation.clickByText_Android(driver, "android.widget.Button", "CONFIRMAR", "Click Confirmar");


            count = count+1;
        }
            //finalizar
            //click sandwich
            //Thread.sleep(1000);
            //action.tap(380, 1170).perform();
            Instrumentation.clickByButtonContentDesc_Android(driver, "android.view.ViewGroup", "hamburguerInspectionAction", "Click Inspecionar item");


            Instrumentation.clickByText_Android(driver, "android.widget.TextView", "Finalizar", "Click finalizar");


            Instrumentation.clickByText_Android(driver, "android.widget.Button", "FINALIZAR", "Click Confirmar");


    }

    public static void Sincronizar() throws IOException {
        driver.swipe(0,20,500,1000,100);
        Instrumentation.clickByText_Android(driver, "android.widget.TextView", "SINCRONIZAR TODOS", "Click Sincronizar");
    }

    public static void logonDeviceIOS(String email, String passw) throws IOException {

        Instrumentation.SendKeyByXPATH_IOS(driver,"XCUIElementTypeTextField","Usuário",email,"");

        Instrumentation.SendKeyByXPATH_IOS(driver,"XCUIElementTypeSecureTextField","Senha",passw,"");

        Instrumentation.clickByXpath_IOS(driver,"XCUIElementTypeOther","Entrar",passw);

    }

    public static void logonWithCredentials(String operador, String pass, String passPrase) throws IOException, InterruptedException {

        Instrumentation.clickByClassText_Android(driver,"android.widget.EditText","Código do operador","Select Operador");
        Instrumentation.sendKeyByResourceId_Android(driver,"android.widget.EditText","spcempresas.org.br:id/edt_cod_operador",operador,"Click operador");
        driver.hideKeyboard();

        Instrumentation.clickByClassText_Android(driver,"android.widget.EditText","Senha","Select Senha");
        Instrumentation.sendKeyByResourceId_Android(driver,"android.widget.EditText","spcempresas.org.br:id/edt_senha_operador",pass,"Click Senha");
        driver.hideKeyboard();

        Instrumentation.clickByClassText_Android(driver,"android.widget.Button","ACESSAR","Click Acessar");
        Instrumentation.clickByClassText_Android(driver,"android.widget.EditText","Digite aqui…","Click Acessar");
        Instrumentation.sendKeyByResourceId_Android(driver,"android.widget.EditText","spcempresas.org.br:id/edt_secret_keyword",passPrase,"Click Acessar");


        driver.hideKeyboard();
        Instrumentation.clickByClassText_Android(driver,"android.widget.Button","Confirmar","Click Confirnar");
    }



    public static void clickExit() throws IOException {
        Instrumentation.clickByResourceId_Android(driver,"android.widget.Button","spcempresas.org.br:id/btnExit","Click Sair");
    }











    public static void swipeDown() {
        Instrumentation.scrollDown(driver);
    }

    public static void goingto(String arg0) throws IOException {
        Instrumentation.clickByResourceId_Android(driver,"android.widget.EditText","com.android.chrome:id/url_bar","Click Sair");
        Instrumentation.sendKeyByResourceId_Android(driver,"android.widget.EditText","com.android.chrome:id/url_bar",arg0,"");
        Instrumentation.HitEnter_Adroid(driver);


    }

    public static void clickComecar() throws IOException {
        Instrumentation.clickByResourceId_Android(driver,"android.widget.Button","spcempresas.org.br:id/btnAvancar","Click Sair");


    }

    public static void moreinfo() throws IOException, InterruptedException {
       Thread.sleep(4000);
        Instrumentation.clickByResourceId_Android(driver,"android.widget.Button","spcempresas.org.br:id/btnSummaryInformation","Click Sair");
    }

        public static void clickPular() throws IOException {
            Instrumentation.clickByResourceId_Android(driver,"android.widget.Button","spcempresas.org.br:id/btnPular","Click Pular");
        }
    }
