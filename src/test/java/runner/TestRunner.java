package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = ".\\src\\test\\resources\\Feature",glue= {"stepDef"})
public class TestRunner extends AbstractTestNGCucumberTests {
	
	

}
