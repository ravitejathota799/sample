package com.TripAdvisor.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	 protected WebDriver driver;
	    
	   public BasePage(WebDriver driver)
	     {
		     this.driver=driver;
		     PageFactory.initElements(driver,this);  //creating page factory to initialize elements
	     }
	   	   
}





