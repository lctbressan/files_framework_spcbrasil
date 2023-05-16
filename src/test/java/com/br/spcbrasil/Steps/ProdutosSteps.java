package com.br.spcbrasil.Steps;

import com.br.spcbrasil.Pages.ProdutosPages;
import com.br.spcbrasil.Steps.Hook.BaseStep;
import com.br.spcbrasil.Utils.Config;
import com.br.spcbrasil.Utils.Instrumentation;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;

import java.io.IOException;

public class ProdutosSteps extends BaseStep {



    @And("click in Produtos Disponiveis")
    public void clickInProdutosDisponiveis() throws IOException, InterruptedException {
        ProdutosPages.clickProdutosDisponiveis();
    }
    @And("Click in type \"([^\"]*)\"$")
    public void clickInType(String arg0) throws IOException, InterruptedException {
        ProdutosPages.clickType(arg0);
        }
    @And("Inform all datas \"([^\"]*)\"$")
    public void informAllDatas(String arg0) throws IOException {
        ProdutosPages.informAllDatas(arg0);
    }
    @And("Select o produto \"([^\"]*)\"$")
    public void selectProduct(String arg0) throws IOException, InterruptedException {
        driver.hideKeyboard();
        ProdutosPages.selectProduct(arg0);
    }

}
