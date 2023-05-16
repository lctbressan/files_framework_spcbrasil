package com.br.spcbrasil.Pages;

import com.br.spcbrasil.Steps.Hook.BaseStep;
import com.br.spcbrasil.Utils.Instrumentation;

import java.io.IOException;

public class ProdutosPages extends BaseStep {
    public static void clickProdutosDisponiveis() throws IOException, InterruptedException {
        Instrumentation.clickByResourceId_Android(driver, "android.widget.Button" , "spcempresas.org.br:id/btnQuery","Click On 12 SPC");
    }
    public static void clickType(String arg0) throws IOException, InterruptedException {
        Thread.sleep(25000);
        Instrumentation.sendKeysByClassText_Android(driver,"android.widget.EditText","pesquise por código ou nome de produto",arg0,"pesquise por código ou nome de produto");
        Instrumentation.HitEnter_Adroid(driver);

         //          for(int i=1;i<time;i++){
          //              Instrumentation.scrollDown(driver);
          //          }

        Instrumentation.clickByClassText_Android(driver,"android.widget.TextView",arg0,arg0);

    }

    public static void informAllDatas(String arg0) throws IOException {
        if(arg0.equals("CPF")) {
            Instrumentation.sendKeyByResourceId_Android(driver, "android.widget.EditText", "spcempresas.org.br:id/edt_cpf_or_cnpj", "12524347826", "CPF");
            driver.hideKeyboard();
            Instrumentation.sendKeyByResourceId_Android(driver, "android.widget.EditText", "spcempresas.org.br:id/edt_dia", "11", "DIA");

            Instrumentation.sendKeyByResourceId_Android(driver, "android.widget.EditText", "spcempresas.org.br:id/edt_mes", "11", "MES");

            Instrumentation.sendKeyByResourceId_Android(driver, "android.widget.EditText", "spcempresas.org.br:id/edt_ano", "1972", "ANO");

            Instrumentation.sendKeyByResourceId_Android(driver, "android.widget.EditText", "spcempresas.org.br:id/edt_ddd", "11", "DDD");

            Instrumentation.sendKeyByResourceId_Android(driver, "android.widget.EditText", "spcempresas.org.br:id/edt_tel", "25484705", "Telefone");

            Instrumentation.sendKeyByResourceId_Android(driver, "android.widget.EditText", "spcempresas.org.br:id/edt_cep", "05632105", "CEP");

            Instrumentation.scrollDown(driver);

            Instrumentation.clickByClassText_Android(driver, "android.widget.Button", "Avançar >", "Click Avancar");

        }
        if(arg0.equals("CNPJ")) {
            Instrumentation.sendKeyByResourceId_Android(driver, "android.widget.EditText", "spcempresas.org.br:id/edt_cpf_or_cnpj", "33064378000108", "CNPJ");
            driver.hideKeyboard();

            Instrumentation.sendKeyByResourceId_Android(driver, "android.widget.EditText", "spcempresas.org.br:id/edt_ddd", "11", "DDD");

            Instrumentation.sendKeyByResourceId_Android(driver, "android.widget.EditText", "spcempresas.org.br:id/edt_tel", "25484705", "Telefone");

            Instrumentation.sendKeyByResourceId_Android(driver, "android.widget.EditText", "spcempresas.org.br:id/edt_cep", "05632105", "CEP");

            Instrumentation.scrollDown(driver);

            Instrumentation.clickByClassText_Android(driver, "android.widget.Button", "Avançar >", "Click Avancar");

        }
    }


    public static void selectProduct(String arg0) throws IOException, InterruptedException {
        Thread.sleep(5000);
                //Instrumentation.sendKeysByClassText_Android(driver,"android.widget.EditText","pesquise por nome de insumo",arg0,"pesquise por nome do insumo");

        //Instrumentation.sendKeyByResourceId_Android(driver, "android.widget.EditText", "spcempresas.org.br:id/edtInsumosSearch", arg0, "Cheques");
        //Instrumentation.HitEnter_Adroid(driver);
        //Instrumentation.clickByClassText_Android(driver,"android.widget.TextView",arg0,arg0);
        Instrumentation.clickByClassText_Android(driver,"android.widget.TextView",arg0,arg0);
        ClickConsultar();
        Thread.sleep(10000);

    }

    public static void ClickConsultar() throws IOException {
        Instrumentation.clickByClassText_Android(driver,"android.widget.Button","Consultar","Click Consultar");
    }

    public static void checkCCFResults() throws IOException, InterruptedException {
        Thread.sleep(4000);
        Instrumentation.getInformationFromView(driver,"android.widget.TextView","","");

    }
}
