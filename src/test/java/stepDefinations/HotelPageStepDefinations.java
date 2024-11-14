package stepDefinations;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HotelSearchPage;
import utils.TestContextSetup;

public class HotelPageStepDefinations {
	public WebDriver driver;
	public HotelSearchPage hotelSearchPage;
	TestContextSetup testContextSetup;

	public HotelPageStepDefinations(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.hotelSearchPage = testContextSetup.pageObjectManager.getHotelSearchPage();
	}

	@Given("user is on the Goibibo hotel search page")
	public void user_is_on_the_goibibo_hotel_search_page() throws Throwable {
		hotelSearchPage.getHotels();

	}

	/*@When("user click on India")
	public void user_click_on_india() {
		hotelSearchPage.selectindia();
	}*/

	@When("user enter the location {string}")
	public void user_enter_the_location(String from) {
		hotelSearchPage.enterLocation(from);
	}

	@When("user select the check-in date as {string} {string} and check-out date as {string} {string}")
	public void user_select_the_check_in_date(String cidate, String cimonth, String codate, String comonth)
			throws Throwable {
		hotelSearchPage.checkin(cidate, cimonth, codate, comonth);

	}

	@When("user select the number of Guests as {string} Child as {string} and childAge as {string} and Rooms {string}")
	public void user_select_the_number_of_guests_as_child_as_and_child_age_as_and_rooms(String adults, String child,
			String childAge, String rooms) throws Throwable {
		hotelSearchPage.guestandRooms(adults, child, childAge, rooms);
	}

	@When("user click on the search button")
	public void user_click_on_the_search_button() {
		hotelSearchPage.searchhotel();

	}

	@Then("user should see a list of hotels in {string}")
	public void user_should_see_a_list_of_hotels_in(String string) throws Throwable {
		hotelSearchPage.hotelinbang(string);

		// driver.quit();

	}

}
