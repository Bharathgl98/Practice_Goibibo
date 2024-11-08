package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.TestContextSetup;


public class TrainSearchPage {
	
	
	
	private By train = By.xpath("//span[.=\"Trains\"]");
	private By fromTxtfld = By.xpath("//p[.=\"Enter Source Name\"]");
	private By fromTFip = By.xpath("//input[@type=\"text\"]");
	private By toTxtfld = By.xpath("//p[.=\"Enter Destination Name\"]");
	private By toTFip = By.xpath("//input[@type=\"text\"]");
	private By sugg = By.xpath("//li[@class=\"styles_FswAutoCompItem__RE1dP\"]");
	//public By selectDate = By.xpath("//div[.=\""+ monthyear +"\"]/..//p[text()=\""+ date +"\"]");
	private By searchbutton =By.xpath("//span[.=\"SEARCH TRAINS\"]");
	
	public WebDriver driver;
	public TrainSearchPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	public void getTrainpage() {
		driver.findElement(train).click();
	}
	
	public void fromStation(String from) throws Throwable {
		driver.findElement(fromTxtfld).click();
		driver.findElement(fromTFip).sendKeys(from);
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(sugg);

		for (WebElement a : list) {

			if (a.getText().contains(from)) {
				a.click();
				break;
			}

		}

	}
	public void toStation(String to) throws Throwable {
		driver.findElement(toTxtfld).click();
		driver.findElement(toTFip).sendKeys(to);
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(sugg);
		
		for (WebElement a : list) {

			if (a.getText().contains(to)) {
				a.click();
				break;
			}

		}
	}
	public WebElement selectdate(String date, String monthyear) throws Throwable {
		
		
		Thread.sleep(5000);
		
		WebElement selectedDate = driver.findElement(By.xpath("//div[.=\""+monthyear+"\"]/..//p[text()=\""+date+"\"]"));
		//WebElement selectedDate = driver.findElement(selectDate);
		
		System.out.println("#######################################");
		return selectedDate;
		
		
	}
	public void searchTrain(){
		
		driver.findElement(searchbutton).click();
	}
	
	
	
}
