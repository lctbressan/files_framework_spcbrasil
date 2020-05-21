package br.com.trendalytics.Runners;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber", "json:target/cucumber.json" },
        monochrome = true,
        dryRun = false,
        glue = {"br.com.trendalytics.Steps"},
        features = {"src/test/java/resources/features/Reports.feature"},
        plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"},
        tags={"@CheckEmailAlertPDF"},
        snippets = SnippetType.CAMELCASE)
public abstract class ReportRunner extends BaseTest {
}
