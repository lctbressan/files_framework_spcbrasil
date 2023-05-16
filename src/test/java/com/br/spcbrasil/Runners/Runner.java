package com.br.spcbrasil.Runners;


import com.br.spcbrasil.Steps.Hook.Hook;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        dryRun = false,
        glue = {"classpath:com.br.spcbrasil.Steps"},
        features = {"src/test/resources/features/"},
        plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:", "json:target/cucumber.json", "html:target/cucumber-report", "junit:target/junit.xml"},

        //==================================================================
        //EMPRESAS
        //==================================================================
        //tags={"@dealocatetDevices"},

        tags={"@dealocatetDevices"},


        //==================================================================
        //Consumidor
        //==================================================================
        //tags={"@ConsumidorLogin"},



        strict = true,
        snippets = SnippetType.CAMELCASE)

public class Runner extends Hook {
}


