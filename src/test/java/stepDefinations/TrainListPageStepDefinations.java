package stepDefinations;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.TrainListPage;
import utils.TestContextSetup;

public class TrainListPageStepDefinations {

	TestContextSetup testContextSetup;
	public TrainListPage trainListPage;

	public TrainListPageStepDefinations(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.trainListPage = testContextSetup.pageObjectManager.gettrTrainListPage();

	}

	@Then("^the user should see a list of available trains from (.+) to (.+)$")
	public void the_user_should_see_a_list_of_available_trains(String from, String to) {
		Assert.assertTrue(trainListPage.fromplace().contains(from));
		Assert.assertTrue(trainListPage.toplace().contains(to));

	}

	@Then("^the user should see the travel date (.+) and (.+)$")
	public void the_user_should_see_the_travel_date_as(String date, String month) {
		trainListPage.travellingDate();
		Assert.assertTrue(trainListPage.getDate().contains(date));
		Assert.assertTrue(trainListPage.getMonthYear().contains(month));
		testContextSetup.genericUtils.randomsideClick();

	}

	@Then("the user should see a Book Now button for each train option")
	public void the_user_should_see_a_button_for_each_train_option() {
		testContextSetup.genericUtils.clickElement(trainListPage.checkAvailability());
		Assert.assertTrue(trainListPage.bookNow());
	}
}
