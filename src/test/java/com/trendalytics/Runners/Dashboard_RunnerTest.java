package com.trendalytics.Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber", "json:target/cucumber.json" },
        monochrome = true,
        dryRun = false,
        glue = {"com.trendalytics.Steps"},
        features = {"src/test/resources/features/Dashboard.feature"},
        plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"},
        snippets = SnippetType.CAMELCASE)
public  class Dashboard_RunnerTest extends BaseTest {

}
