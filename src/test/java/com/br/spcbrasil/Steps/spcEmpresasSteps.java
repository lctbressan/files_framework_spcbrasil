package com.br.spcbrasil.Steps;

import com.br.spcbrasil.Pages.consumidorPages;
import com.br.spcbrasil.Runners.BaseTest;
import cucumber.api.java.en.And;

import java.io.IOException;

public class spcEmpresasSteps extends BaseTest {
    @And("click in Consultar")
    public void clickInConsultar() throws IOException {
        consumidorPages.clickInConsultar();
    }
}
