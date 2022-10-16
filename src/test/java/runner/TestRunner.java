package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"./src/test/java/features"},
glue = "step_def",
tags = "@Assignment",
monochrome = true,
plugin = { "pretty", "html:target/cucumber-reports" })

public class TestRunner {
	
	@BeforeClass
	public static void  setup() throws Throwable {
		//Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		System.out.println(System.getProperty("os.name"));
		System.out.println("Java Version"+System.getProperty("java.version"));
		core.BaseClass.readProperty();
		core.BaseClass.reportDirectory();
	}
	
	@AfterClass
	public static void tearDown() {
		
		//BaseClass.driver.quit();
	}

}
