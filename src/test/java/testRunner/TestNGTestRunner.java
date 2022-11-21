package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Feature", glue = "stepDefinitions", monochrome = true,
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" ,"rerun:target/failed_scenarios.txt"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	/*
	 * @Override
	 * 
	 * @DataProvider(parallel=true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */
}
