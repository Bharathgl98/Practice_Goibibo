package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public TrainSearchPage trainSearchPage;
	public TrainListPage trainListPage;
<<<<<<< HEAD
	public GoibiboLandingpage goibiboLandingpage;
=======
	public HotelSearchPage hotelSearchPage;
>>>>>>> e63b82967fbd0e78f330ba6321921a755a4ac267

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
	
<<<<<<< HEAD
	public GoibiboLandingpage getGoibiboLandingpage() {
		goibiboLandingpage = new GoibiboLandingpage(driver);
		return goibiboLandingpage;
=======
	public HotelSearchPage getHotelSearchPage() {
		hotelSearchPage = new HotelSearchPage(driver);
		return hotelSearchPage;
>>>>>>> e63b82967fbd0e78f330ba6321921a755a4ac267
	}

}
