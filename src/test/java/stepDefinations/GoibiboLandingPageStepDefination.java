package stepDefinations;

import io.cucumber.java.en.Given;
import pageObjects.GoibiboLandingpage;
import utils.TestContextSetup;

public class GoibiboLandingPageStepDefination {
	TestContextSetup testContextSetup;
	GoibiboLandingpage goibiboLandingpage;

	public GoibiboLandingPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.goibiboLandingpage = testContextSetup.pageObjectManager.goibiboLandingpage;
	}

	@Given("^I want to use the (.+)$")
	public void i_want_to_use_browser(String url) throws Throwable {
		goibiboLandingpage.getURL(url);

	}

}
