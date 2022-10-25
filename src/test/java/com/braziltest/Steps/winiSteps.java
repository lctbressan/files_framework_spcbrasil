package com.braziltest.Steps;

import com.braziltest.Steps.Hook.BaseStep;
import com.braziltest.Utils.Config;
import com.braziltest.Utils.Instrumentation;
import com.braziltest.Utils.InstrumentationDesktop;
import com.braziltest.interfaces.DriverFactory;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.braziltest.Utils.Config.WiniHost;

public class winiSteps extends BaseStep {

    @Given("open a client server system \"([^\"]*)\"$")
    public void openAClientServerSystemCheckFolderFileAndFileControlInPathIsNotEmpty(String arg0) throws IOException, InterruptedException {
        DriverFactory.winniumDriverOpen(arg0,WiniHost);
        Thread.sleep(2000);
        InstrumentationDesktop.clickElement(winiumDriver, Config.name,"Um","Click");
        InstrumentationDesktop.clickElement(winiumDriver, Config.name,"Dois","Click");
        InstrumentationDesktop.clickElement(winiumDriver, Config.name,"Mais","Click");
        InstrumentationDesktop.clickElement(winiumDriver, Config.name,"Três","Click");
        InstrumentationDesktop.clickElement(winiumDriver, Config.name,"Igual a","Click");
        Assert.assertEquals(true, winiumDriver.findElement(By.name("A exibição é 15")).isDisplayed());
        InstrumentationDesktop.clickElement(winiumDriver, Config.name,"Limpar","Limpar");




    }
}
