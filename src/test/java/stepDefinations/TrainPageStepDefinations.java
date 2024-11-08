package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.TrainListPage;
import pageObjects.TrainSearchPage;
import utils.TestContextSetup;

public class TrainSearchPageStepDefinations {
	public WebDriver driver;
	public TrainSearchPage trainSearchPage;
	TestContextSetup testContextSetup;
	public TrainListPage trainListPage;

	public TrainPageStepDefinations(TestContextSetup testContextSetup) {
		
		this.testContextSetup = testContextSetup;
		this.trainSearchPage = testContextSetup.pageObjectManager.gettrainSearchPage();
		this.trainListPage = testContextSetup.pageObjectManager.gettrTrainListPage();

	}

	@Given("the user is on the Goibibo train booking homepage")
	public void the_user_is_on_the_goibibo_train_booking_homepage() {
		trainSearchPage.getTrainpage();

	}

	@When("^the user enters (.+) in the From field$")
	public void the_user_enters_in_the_field(String from) throws Throwable {
		trainSearchPage.fromStation(from);
	}

	@When("^the user enters (.+) in the To field$")
	public void the_user_enters_in_the_to_field(String to) throws Throwable {
		trainSearchPage.toStation(to);
	}

	@When("^the user selects travel (.+) and (.+) and clicks on the Search Trains button$")
	public void the_user_selects_as_the_travel_date(String date, String monthyear) throws Throwable {
		//WebElement travellingDate = trainSearchPage.selectdate(date, monthyear);
		//testContextSetup.genericUtils.clickElement(travellingDate);
		trainSearchPage.selectdate(date, monthyear);
		trainSearchPage.searchTrain();

	}

	@Then("^the user should see a list of available trains from (.+) to (.+)$")
	public void the_user_should_see_a_list_of_available_trains(String from, String to) {
		Assert.assertTrue(trainListPage.fromplace().contains(from));
		Assert.assertTrue(trainListPage.toplace().contains(to));

	}

	@Then("^the user should see the travel date (.+) and (.+)$")
	public void the_user_should_see_the_travel_date_as(String date, String monthyear) {
		trainListPage.travellingDate();
		Assert.assertTrue(trainListPage.getDate().contains(date));
		Assert.assertTrue(trainListPage.getMonthYear().contains(monthyear));
		testContextSetup.genericUtils.randomsideClick();

	}

	@Then("the user should see a {string} button for each train option")
	public void the_user_should_see_a_button_for_each_train_option(String string) {
		WebElement book = trainListPage.bookNow();
		testContextSetup.genericUtils.clickElement(book);
		Assert.assertTrue(trainListPage.validateBookNowbtn().contains(string));

	}

}
