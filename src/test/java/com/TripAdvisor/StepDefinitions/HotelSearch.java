package com.TripAdvisor.StepDefinitions;

import com.TripAdvisor.pageObjects.Locators;
import com.TripAdvisor.utils.Helper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelSearch {

	static Locators loc;
	String file = System.getProperty("user.dir") + "/src/test/resources/Trip.xlsx"; // storing the file path

	@Given("user opens the browser with the specified url")
	public void user_opens_the_browser_with_the_specified_url() {
		loc = new Locators(Helper.getDriver());		
	}

	@Given("The user moves their cursor over the navigation bar and clicks on the Hotels tab in goibibo website")
	public void the_user_moves_their_cursor_over_the_navigation_bar_and_clicks_on_the_hotels_tab_in_goibibo_website() {
		loc.clickOnHotels();
		System.out.println("-----Clicked on Hotels-----");		
	}

	@Given("The user has selected one of the radio buttons on the Goibibo website.")
	public void the_user_has_selected_one_of_the_radio_buttons_on_the_goibibo_website() {
		loc.clickRadioBtn();
		System.out.println("-----Selected Radio Button-----");
	}

	@Given("user has to enter the location in the goibibo website")
	public void user_has_to_enter_the_location_in_the_goibibo_website() {
		loc.hotelName();
		System.out.println("-----Entered location-----");
	}

	@Given("user enter checkin date in the goibibo website")
	public void user_enter_checkin_date_in_the_goibibo_website() {
		loc.checkIn();
		System.out.println("-----CheckIn Done-----");		
	}

	@Given("user enter checkout date in the goibibo webiste")
	public void user_enter_checkout_date_in_the_goibibo_webiste() {
		loc.checkOut();
		System.out.println("-----Checkout Done");		
	}

	@Given("user clicks on the guests&rooms icon and enters the no.of adults in the goibibo website")
	public void user_clicks_on_the_guests_rooms_icon_and_enters_the_no_of_adults_in_the_goibibo_website() {
		loc.numberOfAdults();
		System.out.println("-----Adutls Entered-----");		
	}
		
	@Then("user clicks on the done button in the goibibo website")
	public void user_clicks_on_the_done_button_in_the_goibibo_website() {
		loc.doneBtn();
		System.out.println("-----Clicked On Done-----");
	}

	@Then("user clicks on search button")
	public void user_clicks_on_search_button() {
		loc.clickOnSearch();
		System.out.println("-----Clicked On Search Button-----");
	}
	
	@Given("user clicks on the sort by options in the goibibo website")
	public void user_clicks_on_the_sort_by_options_in_the_goibibo_website() {
	    
	    
	}

	@Given("user clicks on the customer ratings in the goibibo website")
	public void user_clicks_on_the_customer_ratings_in_the_goibibo_website() {
	    
	    
	}

	@Given("user clicks on amenities in the goibibo website")
	public void user_clicks_on_amenities_in_the_goibibo_website() {
	    
	    
	}

	@Then("capture the data after applying the sorts and filters")
	public void capture_the_data_after_applying_the_sorts_and_filters() {
	    
	    
	}
}
