package com.TripAdvisor.StepDefinitions;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.TripAdvisor.utils.Helper;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {

	static WebDriver driver;
	static Properties p;

	//method for setting up the browser
	@BeforeAll
	public static void setup() throws Throwable {
		driver = Helper.initilizeBrowser();	//calling the initializeBrowser method
		p = Helper.getProperties();			//calling the properties method
		driver.manage().window().maximize();	//maximizing the windows
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));	//waiting the for the page loading 
		driver.get(p.getProperty("appURL"));	//opening the browser with given appURL

	}

	//method for closing the browser
	@AfterAll
	public static void tearDown() {
		driver.quit();	//closing the browser
	}

	//method for attaching screenshot
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		// this is for cucumber junit report
		if (!scenario.isFailed()) {		//if scenario is passed
			TakesScreenshot ts = (TakesScreenshot) driver;		//taking screenshot using takingScreenshot interfacess
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);	
			scenario.attach(screenshot, "image/png", scenario.getName());	//attaching the screen shot 
		}
	}
}
