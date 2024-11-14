package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HotelSearchPage {

	private By hotel = By.xpath("//a[@href=\"/hotels/\"]");
	//private By india = By.xpath("//div[@data-testid='search-radio-button-wrap']//input[@name='CountryType']");
	private By area = By.xpath("//input[@id='downshift-1-input']");
	private By location = By.xpath("//li[contains(@id,'downshift-1-item-')]");
	private By checkin = By.xpath("//div[@data-testid=\"openCheckinCalendar\"]");
	private By guest = By.xpath("//div[@data-testid=\"pax-text-wrapper\"]");
	private By noguest = By.xpath("//span[@data-testid=\"button-adult-add\"]");
	private By addchild = By.xpath("//span[@data-testid=\"button-child-add\"]");
	private By selectage = By.xpath("//h4[.='Select']");
	private By addbutton = By.xpath("//button[@data-testid=\"button-pax-homeunif-dweb\"]");
	private By selecthotel = By.xpath("//button[@data-testid=\"searchHotelBtn\"]");
	private By hotelbang = By.xpath("//input[@placeholder=\"LOCATION NAME\"]");

	WebDriver driver;

	public HotelSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void getHotels() {
		driver.findElement(hotel).click();

	}

	/*public void selectindia() {
		driver.findElement(india).click();
	}*/

	public void enterLocation(String from) {
		driver.findElement(area).sendKeys(from);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> list = driver.findElements(location);

		for (WebElement a : list) {

			if (a.getText().contains("Majestic")) {
				a.click();
				break;
			}

		}

	}

	public WebElement checkin(String cidate, String cimonth, String codate, String comonth) throws Throwable {
		Thread.sleep(3000);
		driver.findElement(checkin).click();
		Thread.sleep(3000);
		WebElement ele;
		ele = driver.findElement(By.xpath("//span[.=\"" + cimonth + "\"]/../..//span[text()=\"" + cidate + "\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		act.click(ele).perform();
		ele = driver.findElement(By.xpath("//span[.=\"" + comonth + "\"]/../..//span[text()=\"" + codate + "\"]"));
		act.moveToElement(ele).perform();
		act.click(ele).perform();
		return ele;
	}

	public void guestandRooms(String adults, String child, String childAge, String rooms) throws Throwable {
		int a = Integer.parseInt(adults);
		Thread.sleep(2000);
		driver.findElement(guest).click();
		Thread.sleep(2000);
		for (int i = 2; i < a; i++) {
			driver.findElement(noguest).click();
		}
		int b = Integer.parseInt(child);
		int c = Integer.parseInt(childAge);
		if (b >= 1 && c >= 1) {
			for (int j = 0; j < b; j++) {
				driver.findElement(addchild).click();
				driver.findElement(selectage).click();

				driver.findElement(
						By.xpath("//ul[@class=\"PaxWidgetstyles__ChildDropdownWrap-sc-gv3w6r-9 jSAoUB\"]/li[text()=\""
								+ childAge + "\"]"))
						.click();

			}
		}

		driver.findElement(addbutton).click();
	}

	public void searchhotel() {
		driver.findElement(selecthotel).click();
	}

	public void hotelinbang(String string) throws Throwable {
		Thread.sleep(5000);
		WebElement ele11 = driver.findElement(hotelbang);
		String atrbtValue = ele11.getAttribute("value");
		Assert.assertTrue(atrbtValue.contains(string));
		if (atrbtValue.equalsIgnoreCase(string)) {
			System.out.println("Hotels located at " + string + " location");
		} else
			System.out.println("No Hotels located in your location");
	}
}
