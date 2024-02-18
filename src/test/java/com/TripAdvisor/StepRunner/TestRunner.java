package com.TripAdvisor.StepRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = { "src/test/resources/Features",}, glue = "com.TripAdvisor.StepDefinitions", tags=("@smoke"),plugin = {"pretty", "rerun:target/rerun.txt","html:Cucumber-reports/report.html",
				 }, dryRun = false, monochrome = true)


public class TestRunner {

	public TestRunner() {
		// TODO Auto-generated constructor stub
	}

}
