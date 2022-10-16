package step_def;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import core.BaseClass;

public class Hook  {
	public Scenario scenario;
	ExtentTest logger;


	@Before
	public void beforScenario(Scenario scenario)
	{
		this.scenario = scenario;
		System.out.println("Current Scenario:"+scenario.getName());
	}

	@After
	public void afterScenario(Scenario scenario) throws Exception
	{
		System.out.println("Current Scenario Status:"+scenario.getStatus());
		this.scenario = scenario;
		if (scenario.isFailed())
		{
			BaseClass.takeSnapShot();
			final byte[] screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Screenshot");
		}
		BaseClass.driver.quit();
	}
}

