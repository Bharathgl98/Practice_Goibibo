package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import io.cucumber.java.After;
import utils.TestContextSetup;

public class Hooks {
	public TestContextSetup testContextSetup;
	
	
	
	public Hooks(TestContextSetup testContextSetup) throws Throwable {
		this.testContextSetup = testContextSetup;
		
	}
	
	
	@After
	public void AfterScenario() throws Throwable {
		
		testContextSetup.testBase.webdriverManager().quit();
		
	}
	

}
