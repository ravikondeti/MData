package CucumberTest.Cucumber;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
/*@ExtendedCucumberOptions(jsonReport = "Cucumber_Reports/JSONReport/cucumber.json",
retryCount = 3,
detailedReport = true,
detailedAggregatedReport = true,
overviewReport = true,

jsonUsageReport = "Cucumber_Reports/JSONReport/cucumber_usage.json",
usageReport = true,
toPDF = true,
outputFolder = "target")*/
@CucumberOptions(features = "Feature",
				 glue={"stepdefinition"},
				 monochrome=true,
				 dryRun= false,
				 strict=true,
				 plugin={"pretty","html:Cucumber_Reports/HTMLReport", 
						 "json:target/cucumber.json",
						 "usage:target/usagecucumber.json",
						 "junit:Cucumber_Reports/Junit/cucumber.xml"})

public class TestRunnerTest {

}
 