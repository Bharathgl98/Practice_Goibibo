package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public TrainSearchPage trainSearchPage;
	public TrainListPage trainListPage;
	public HotelSearchPage hotelSearchPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public TrainSearchPage gettrainSearchPage() {
		trainSearchPage = new TrainSearchPage(driver);
		return trainSearchPage;
	}

	public TrainListPage gettrTrainListPage() {
		trainListPage = new TrainListPage(driver);
		return trainListPage;
	}
	
	public HotelSearchPage getHotelSearchPage() {
		hotelSearchPage = new HotelSearchPage(driver);
		return hotelSearchPage;
	}

}
