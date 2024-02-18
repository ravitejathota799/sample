package com.TripAdvisor.pageObjects;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators extends BasePage {

	public Locators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	static By clickOnHotels = By.xpath("//span[normalize-space()='Hotels']");
	static By indiaRadioBtn = By.xpath("//h4[normalize-space()='India']");
	static By internationalRadioBtn = By.xpath("//h4[normalize-space()='International']");
	static By hotelName = By.xpath("//input[@id='downshift-1-input']");
	static By checkInIcon = By.xpath("//div[@data-testid='openCheckinCalendar']");
	static By checkOutIcon = By.xpath("//div[@data-testid='openCheckoutCalendar']");
	static By adultsIcon = By.xpath("//span[normalize-space()='Guests & Rooms']");
	static By searchBtn = By.xpath("//button[normalize-space()='Search']");
	static By coupleTp = By.xpath("//li[normalize-space()='Couples']");
	static By goStaysTp = By.xpath("//li[normalize-space()='goStays']");
	
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public void clickOnHotels() {
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/span/span")).click();
		WebElement ele = driver.findElement(clickOnHotels);
		js.executeScript("arguments[0].click()", ele);
	}

	public void clickRadioBtn() {
		Random random = new Random();
		// Define the two values
		String value1 = "India";
		String value2 = "International";
		// Generate a random integer either 0 or 1
		int randomNumber = random.nextInt(2); // Generates a random integer between 0 (inclusive) and 2 (exclusive)
		// Select a random value based on the generated random number
		String selectedValue = (randomNumber == 0) ? value1 : value2;
		// Print the selected random value
		System.out.println("Selected random value: " + selectedValue);
		if (selectedValue.equals("Inida")) {
			driver.findElement(indiaRadioBtn).click();
		} else {
			driver.findElement(internationalRadioBtn).click();
		}
	}

	public void hotelName() {
		driver.findElement(hotelName).sendKeys("Chennai");
		driver.findElement(hotelName).sendKeys(Keys.END);
	}

	public void checkIn() {
		WebElement eleCheckInIcon = driver.findElement(checkInIcon);
		js.executeScript("arguments[0].click()", eleCheckInIcon);
		// Create a Date object for 17th February 2024
		Date date = new Date(); // Note: Year is offset by 1900, so 2024 becomes 124
		// Create a SimpleDateFormat object with the desired format
		SimpleDateFormat sdf = new SimpleDateFormat("d", Locale.ENGLISH);
		// Format the date using the SimpleDateFormat object
		String formattedDate = sdf.format(date);
		// Print the formatted date
		System.out.println(formattedDate); // Output: 17 February 2024
		WebElement ele = driver.findElement(By.xpath(
				"//div[@class='dcalendar-newstyles__DayAndDateLeftWrapper-sc-1i003by-14 flDYDD']//span[contains(text(),'"
						+ formattedDate + "')]"));
		js.executeScript("arguments[0].click()", ele);
	}

	public void checkOut() {
		WebElement eleCheckOutIcon = driver.findElement(checkOutIcon);
		js.executeScript("arguments[0].click()", eleCheckOutIcon);
		LocalDate presentDate = LocalDate.now();
		// Add 5 days to the present date
		LocalDate futureDate = presentDate.plusDays(5);
		// Create a formatter for the desired format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");
		// Format the future date using the formatter
		String formattedDate = futureDate.format(formatter);
		// Print the formatted date
		System.out.println("5th date after 5 days from present date: " + formattedDate);
		WebElement ele = driver.findElement(By.xpath(
				"//div[@class='dcalendar-newstyles__DayAndDateLeftWrapper-sc-1i003by-14 flDYDD']//span[contains(text(),'"
						+ formattedDate + "')]"));
		js.executeScript("arguments[0].click()", ele);
	}
	
	public void numberOfAdults() {
		WebElement adults=driver.findElement(adultsIcon);
		js.executeScript("arguments[0].click()", adults);
		WebElement guest = driver.findElement(By.xpath("//h4[@data-testid='adult-count']"));
		int num=Integer.parseInt(guest.getText().toString());
		WebElement increment = driver.findElement(By.xpath("//span[@data-testid='button-adult-add']"));
		if(num==2) {
			js.executeScript("arguments[0].click()", increment);
			js.executeScript("arguments[0].click()", increment);
			js.executeScript("arguments[0].click()", increment);
		}		
	}
	
	public void doneBtn() {
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//button[normalize-space()='Done']")));
	}
	
	/*public void travellerPreference() {
		Random random = new Random();
		String value1="Couples";
		String value2="goStays";
		int randomNumber = random.nextInt(2);
		String selectedValue = (randomNumber == 0) ? value1 : value2;
		System.out.println("Selected random value: " + selectedValue);
		if (selectedValue.equals(value1)) {
			driver.findElement(coupleTp).click();
		} else {
			driver.findElement(goStaysTp).click();
		}
	}*/
	
	public void clickOnSearch() {
		driver.findElement(searchBtn).click();
	}

}
