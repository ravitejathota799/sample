package com.TripAdvisor.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Base64;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Helper{

	static WebDriver driver; //creating an webdriver instance 
	static Properties p;	//creating an instance to access properties from config.properties file 
	static Logger logger;	//creating an instance to logger 

	@SuppressWarnings("deprecation")
	//Method for initializing browser with two environments remote and local
	public static WebDriver initilizeBrowser() throws IOException {
		if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			// os
			if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			} else {
				System.out.println("No matching OS..");
			}
			// capturing browser name from config file
			switch (getProperties().getProperty("browser").toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				capabilities.setBrowserName("FireFox");
			default:
				System.out.println("No matching browser");
			}

			driver = new RemoteWebDriver(new URL(getProperties().getProperty("appURL")), capabilities);	//creating an instance for the remote webdriver

		} else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (getProperties().getProperty("browser").toLowerCase()) {
			// switch(browser.toLowerCase()){
			case "chrome":
				driver = new ChromeDriver();	//creating an instance for the chrome driver
				break;
			case "edge":
				driver = new EdgeDriver();		//creating an instance for the edge driver
				break;
			case "firefox":
				driver = new FirefoxDriver();	//creating an instance for the firefox driver
				break;

			default:
				System.out.println("#####No matching browser");		//printing if browser doesnt matches with any of the mentioned browsers in config file
				driver = null;
			}
		}
		driver.manage().deleteAllCookies();		//deleting all the cookies 
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		return driver;		//returning the webdriver

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static Properties getProperties() throws IOException {
		FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties"); //config file path

		p = new Properties(); 	//creating an object for the properties
		p.load(file);			//loading properties file	
		return p;				//returning the properties object
	}

	public static Logger getLogger() {
		logger = LogManager.getLogger(); // Log4j
		return logger;
	}

	public static String decode(String s) {
		byte[] actualByte = Base64.getDecoder().decode(s);	//decoding the encoded string
		String actualString = new String(actualByte);
		return actualString;		//returning the actual string  after decoding
	}
}
