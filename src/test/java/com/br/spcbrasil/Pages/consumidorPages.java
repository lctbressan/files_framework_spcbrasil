package com.br.spcbrasil.Pages;

import com.br.spcbrasil.Steps.Hook.BaseStep;
import com.br.spcbrasil.Utils.Instrumentation;
import com.google.common.collect.ImmutableMap;

import java.io.IOException;

public class consumidorPages extends BaseStep {


    public static void accessTheConsumidorApp() throws IOException, InterruptedException {
        Thread.sleep(2000);

        String Ret = Instrumentation.checkTextOnView(driver, "android.widget.TextView", "Oba! Você não tem nenhuma dívida no SPC", "");
        if (!Ret.equals("YES")) {
            Instrumentation.clickByResourceId_Android(driver, "android.widget.ImageButton", "br.com.spc.consumidor:id/b_forward", "Click next");
            Instrumentation.clickByResourceId_Android(driver, "android.widget.ImageButton", "br.com.spc.consumidor:id/b_forward", "Click next");

            Instrumentation.clickByResourceId_Android(driver, "android.widget.Button", "br.com.spc.consumidor:id/b_login", "Click Ja Tenho uma Conta");
        } else {
            consumidorPages.clickSairdaConta();
        }


        /*String Ret0= Instrumentation.checkTextOnView(driver,"android.widget.TextView","Veja seu score","No Account check");
        if(!Ret0.equals("YES")) {

        }*/
    }

    public static void sendACpf(String arg0,String arg1) throws IOException, InterruptedException {
        Thread.sleep(1000);


        Instrumentation.sendKeysByClassText_Android(driver,"android.widget.EditText","CPF",arg0,"Send CPF");

        Instrumentation.sendKeysByClassText_Android(driver,"android.widget.EditText","Senha",arg1,"Send CPF");

        Instrumentation.clickByResourceId_Android(driver,"android.widget.Button","br.com.spc.consumidor:id/b_login","Click next");
        Thread.sleep(4000);
    }

    public static void clickSairdaConta() throws IOException {

        Instrumentation.clickByResourceId_Android(driver,"android.widget.ImageView","br.com.spc.consumidor:id/civ_userPhoto","Click Avatar");

        Instrumentation.clickByClassText_Android(driver,"android.widget.Button","Sair da conta","Send CPF");


    }

    public static void clickInConsultaDeTerceiros() throws IOException {
        Instrumentation.clickByClassText_Android(driver,"android.widget.TextView","Consulta de Terceiros","Click Consulta de Terceiros");

    }

    public static void clickInConsultaCPF() throws IOException, InterruptedException {
        Thread.sleep(1000);
        Instrumentation.clickByClassText_Android(driver,"android.view.View","Consulte CPF","Click Consulte CPF");

    }

    public static void informAInValidCpfNumber() throws IOException, InterruptedException {
        Thread.sleep(1000);
        //Instrumentation.geraCPF()
        Instrumentation.sendKeysByClassText_Android(driver,"android.widget.EditText","000.000.000–00","12325878900","Send CPF Number");

    }
    public static void informAValidCpfNumber() throws IOException, InterruptedException {
        Thread.sleep(1000);
        //Instrumentation.geraCPF()
        Instrumentation.sendKeysByClassText_Android(driver,"android.widget.EditText","000.000.000–00","125.243.478-26","Send CPF Number");

    }
    public static void informAValidCpfCadastro() throws IOException, InterruptedException {
        Thread.sleep(1000);
        //Instrumentation.geraCPF()
        Instrumentation.sendKeysByClassText_Android(driver,"android.widget.EditText","CPF","125.243.478-26","Send CPF Number");
        Instrumentation.clickByClassText_Android(driver,"android.widget.Button","Continuar","Click Continuar");
    }
    public static void informAInValidCnpjNumber() throws IOException, InterruptedException {
        Thread.sleep(1000);
        //Instrumentation.geraCPF()
        Instrumentation.sendKeyByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtDocument","34173682000368","Send Invalid cnpj Number");

    }
    public static void informAValidCnpjNumber() throws IOException, InterruptedException {
        Thread.sleep(1000);
        //Instrumentation.geraCPF()
        Instrumentation.sendKeysByClassText_Android(driver,"android.widget.EditText","00.000.000/000–00","34173682000318","Send CPF Number");

    }
    public static void clickInTermoDeCompromisso() throws IOException, InterruptedException {
        Thread.sleep(1000);
        Instrumentation.clickByResourceId_Android(driver,"android.widget.CheckBox","br.com.spc.consumidor:id/checkTerms","Click aceite os termos");

    }

    public static void CheckForMessages(String arg0) throws IOException {
        Instrumentation.clickByClassText_Android(driver,"android.widget.TextView",arg0,"Check Message "  + arg0);
        Instrumentation.clickByClassText_Android(driver,"android.widget.Button","Ok, entendi!","Click Ok, entendi!");
    }

    public static void closeSession() throws IOException {

        Instrumentation.clickByXpath_Android(driver,"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton","Clik exit");
        Instrumentation.clickByXpath_Android(driver,"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton","Clik exit");

    }

    public static void clickContratarAgora() throws IOException {
        Instrumentation.clickByClassText_Android(driver,"android.widget.Button","Contrate agora!","Click Contrate agora!");

    }

    public static void fillConfirmeSeusDados() throws IOException, InterruptedException {

        Instrumentation.clearByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtCep","","clean CEP");
        //Instrumentation.clearByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtStreet","","clan Street");
        //Instrumentation.clearByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtNumber","","clean CEP");
        //Instrumentation.clearByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtComplement","","clean Complement");
        //Instrumentation.clearByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtNeighborhood","","clean Neighbor");
        //Instrumentation.clearByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtState","","clean State");
        //Instrumentation.scrollDown(driver);
        //Instrumentation.clearByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtCity","","clean City");
        //Instrumentation.scrollUp(driver);
        Instrumentation.sendKeyByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtCep","11441400","Send CEP");
        Instrumentation.clickByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtCep","");
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
        //Instrumentation.sendKeyByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtStreet","RUA DR JULIO PESTES DE ALBUQUERQUE ","clan Street");
        //Instrumentation.sendKeyByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtNumber","335","clean CEP");
        //Instrumentation.sendKeyByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtComplement","APTO 32","Send Complement");
        //Instrumentation.sendKeyByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtNeighborhood","VILA ATLANTICA","Send Neighbor");
        //Instrumentation.sendKeyByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtNeighborhood","SP","clean Neighbor");
        //Instrumentation.scrollDown(driver);
        //Instrumentation.sendKeyByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtCity","SAO PAULO","clean City");
        Thread.sleep(3000);
        driver.hideKeyboard();
        Instrumentation.scrollDown(driver);
        Instrumentation.sendKeyByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtNumber","335","clean CEP");
        Instrumentation.sendKeyByResourceId_Android(driver,"android.widget.EditText","br.com.spc.consumidor:id/edtComplement","APTO 32","Send Complement");
        Thread.sleep(1000);
        Instrumentation.clickByClassText_Android(driver,"android.widget.Button","Continuar","Click Continuar");
        //Thread.sleep(1000);
        //Instrumentation.clickByXpath_Android(driver,"//android.widget.ImageView[@content-desc='Fechar']","Click fechar");
        //Instrumentation.clickByXpath_Android(driver,"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[4]/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button","Click Ok");
        //Instrumentation.clickByResourceId_Android(driver,"android.widget.Button","br.com.spc.consumidor:id/btnOk","Click Ok, entendi!");



    }

    public static void clickInFacaSeuCadastro() throws IOException {
        Instrumentation.clickByClassText_Android(driver,"android.widget.Button","Faça seu cadastro","Click Faça seu cadastro");
    }

    public static void sendAName(String arg0) throws IOException {
        Instrumentation.sendKeysByClassText_Android(driver,"android.widget.EditText","Nome",arg0,"Send Nome");
        Instrumentation.clickByClassText_Android(driver,"android.widget.Button","Continuar","Click Continuar");

    }

    public static void sendDataNascimento() throws IOException {
        Instrumentation.sendKeysByClassText_Android(driver,"android.widget.EditText","Data de nascimento","11111972","Send Data de Nascimento");
        Instrumentation.clickByClassText_Android(driver,"android.widget.Button","Continuar","Click Continuar");
    }
    public static void sendEmail() throws IOException {
        Instrumentation.sendKeysByClassText_Android(driver,"android.widget.EditText","Digite seu e-mail","lctbressan@gail.com","Send Data de Nascimento");
        Instrumentation.clickByClassText_Android(driver,"android.widget.Button","Continuar","Click Continuar");
    }
    public static void sendCelular() throws IOException {
        Instrumentation.sendKeysByClassText_Android(driver,"android.widget.EditText","Digite seu celular","11994963213","Send Digite seu celular");
        Instrumentation.clickByClassText_Android(driver,"android.widget.Button","Continuar","Click Continuar");
    }
    public static void sendPassword() throws IOException {
        Instrumentation.sendKeysByClassText_Android(driver,"android.widget.EditText","Senha","142536@!A","Send Digite seu celular");
        Instrumentation.clickByClassText_Android(driver,"android.widget.Button","Continuar","Click Continuar");
    }

    public static void AgreeTerms() throws IOException {
        Instrumentation.clickByResourceId_Android(driver,"android.widget.CheckBox","br.com.spc.consumidor:id/cTerms","Click aceite os termos");
        Instrumentation.clickByClassText_Android(driver,"android.widget.Button","Continuar","Click Continuar");
    }
    public static void CofirmByEmail() throws IOException {
        Instrumentation.clickByClassText_Android(driver,"android.widget.Button","Confirmar via e-mail","Click Continuar");
    }

    public static void clickInConsultaCNPJ() throws InterruptedException, IOException {
        Thread.sleep(1000);
        Instrumentation.clickByClassText_Android(driver,"android.view.View","Consulte CNPJ","Click Consulte CNPJ");

    }

    public static void clickInConsultar() throws IOException {
        Instrumentation.clickByClassText_Android(driver,"android.widget.Button","Consultar","Click Consultar");
    }
}
