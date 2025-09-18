package bdddemo;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("bdddemo")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/reports/firefox/report.html, " +
        "json:target/reports/firefox/report.json")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "bdddemo")
public class RunCucumberFireFoxTest {
}
