package com.braziltest.Steps;

import com.braziltest.Pages.ciqPages;
import com.braziltest.Steps.Hook.BaseStep;
import cucumber.api.java.en.And;

import java.io.IOException;

public class ciqSteps  extends BaseStep {


    @And("click on ciq menu \"([^\"]*)\"$")
    public void clickInMenu(String arg0) throws IOException {
        ciqPages.clickInMenu(arg0);
    }
}
