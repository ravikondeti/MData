package Cucumber.Cucumber_TestNG;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features ="Feature",
				 glue = {"stepdefinition"},
				 dryRun =false,
				 plugin = {"json:target/cucumber.json",
						   "usage:target/usagecucumber.json"}
				 
				 )
public class TestRunner extends AbstractTestNGCucumberTests {
  @Test
  public void f() {
  }
}
