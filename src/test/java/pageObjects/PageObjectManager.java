package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public TrainSearchPage trainSearchPage;
	public TrainListPage trainListPage;

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

}
