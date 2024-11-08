package stepDefinations;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelPageStepDefinations {
	public WebDriver driver;

	@Given("user is on the Goibibo hotel search page")
	public void user_is_on_the_goibibo_hotel_search_page() throws Throwable {
		driver = new ChromeDriver();
		driver.get("https://www.goibibo.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@class=\"logSprite icClose\"]")).click();
		Thread.sleep(2000);
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("//button[@id=\"deny\"]")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//p[@class=\"sc-jlwm9r-1 ewETUe\"]")).click();
		driver.findElement(By.xpath("//a[@href=\"/hotels/\"]")).click();

	}

	@When("user click on India")
	public void user_click_on_india() {
		driver.findElement(By.xpath("//div[@data-testid='search-radio-button-wrap']//input[@name='CountryType']"))
				.click();
	}

	@When("user enter the location {string}")
	public void user_enter_the_location(String from) {
		driver.findElement(By.xpath("//input[@id='downshift-1-input']")).sendKeys(from);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> list = driver.findElements(By.xpath("//li[contains(@id,'downshift-1-item-')]"));

		for (WebElement a : list) {

			if (a.getText().contains("Majestic")) {
				a.click();
				break;
			}

		}

	}

	@When("user select the check-in date as {string} {string} and check-out date as {string} {string}")
	public void user_select_the_check_in_date(String cidate, String cimonth, String codate, String comonth)
			throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@data-testid=\"openCheckinCalendar\"]")).click();
		Thread.sleep(3000);
		WebElement ele = driver
				.findElement(By.xpath("//span[.=\"" + cimonth + "\"]/../..//span[text()=\"" + cidate + "\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		act.click(ele).perform();
		WebElement ele1 = driver
				.findElement(By.xpath("//span[.=\"" + comonth + "\"]/../..//span[text()=\"" + codate + "\"]"));
		act.moveToElement(ele1).perform();
		act.click(ele1).perform();

	}

	@When("user select the number of Guests as {string} Child as {string} and childAge as {string} and Rooms {string}")
	public void user_select_the_number_of_guests_as_child_as_and_child_age_as_and_rooms(String adults, String child,
			String childAge, String rooms) throws Throwable {
		int a = Integer.parseInt(adults);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-testid=\"pax-text-wrapper\"]")).click();
		Thread.sleep(2000);
		for (int i = 2; i < a; i++) {
			driver.findElement(By.xpath("//span[@data-testid=\"button-adult-add\"]")).click();
		}
		int b = Integer.parseInt(child);
		int c = Integer.parseInt(childAge);
		if (b >= 1 && c >= 1) {
			for (int j = 0; j < b; j++) {
				driver.findElement(By.xpath("//span[@data-testid=\"button-child-add\"]")).click();
				driver.findElement(By.xpath("//h4[.='Select']")).click();

				driver.findElement(
						By.xpath("//ul[@class=\"PaxWidgetstyles__ChildDropdownWrap-sc-gv3w6r-9 jSAoUB\"]/li[text()=\""
								+ childAge + "\"]"))
						.click();

			}
		}

		driver.findElement(By.xpath("//button[@data-testid=\"button-pax-homeunif-dweb\"]")).click();
	}

	@When("user click on the search button")
	public void user_click_on_the_search_button() {
		driver.findElement(By.xpath("//button[@data-testid=\"searchHotelBtn\"]")).click();

	}

	@Then("user should see a list of hotels in {string}")
	public void user_should_see_a_list_of_hotels_in(String string) throws Throwable {
		Thread.sleep(5000);
		WebElement ele11 = driver.findElement(By.xpath("//input[@placeholder=\"LOCATION NAME\"]"));
		String atrbtValue = ele11.getAttribute("value");
		Assert.assertTrue(atrbtValue.contains(string));
		if (atrbtValue.equalsIgnoreCase(string)) {
			System.out.println("Hotels located at "+string+" location");
		} else
			System.out.println("No Hotels located in your location");

		//driver.quit();

	}


}
