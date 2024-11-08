package utils;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;
import stepDefinations.TrainSearchPageStepDefinations;

public class TestContextSetup {
	
	public WebDriver driver;
	public TestBase testBase;
	public GenericUtils genericUtils;
	public PageObjectManager pageObjectManager;
	
	
	

	public TestContextSetup() throws Throwable {
		
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.webdriverManager());
		genericUtils = new GenericUtils(testBase.webdriverManager());
		
		
	}
	
	

}
