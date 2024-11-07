package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrainListPage {

	private By fromtxt = By.xpath("(//span[@class=\"padL5\"])[1]");
	private By totxt = By.xpath("(//span[@class=\"padL5\"])[2]");
	private By trvlDat = By.xpath(
			"//input[@class=\"Search_headerCmp__inpEl__ZtAD0 Search_headerCmp__dateBox__ggdSl font16 rubikMedium whiteText\"]");
	private By selectedMonthYear = By.xpath("//p[@class=\"font22 rubikSemiBold blackText2 textCenter\"]");
	private By selectedDate = By
			.xpath("//p[@class=\"styles_dayCmp__calDate__heiRT styles_dayCmp__selDateColor__wZuhg\"]");
	private By chkAvailability = By.xpath("(//div[@style=\"display: flex;\"])[1]");
	private By BkNowbtn = By.xpath("//a[@class=\"TrainCard_trnCrd__avlLstItmLnk___0KdS rubikMedium\"]");

	public WebDriver driver;

	public TrainListPage(WebDriver driver) {
		this.driver = driver;
	}

	public String fromplace() {
		return driver.findElement(fromtxt).getText();
	}

	public String toplace() {
		return driver.findElement(totxt).getText();
	}

	public void travellingDate() {
		driver.findElement(trvlDat).click();
	}

	public String getMonthYear() {
		return driver.findElement(selectedMonthYear).getText();
	}

	public String getDate() {
		return driver.findElement(selectedDate).getText();
	}

	public WebElement checkAvailability() {
		return driver.findElement(chkAvailability);
	}
	public boolean bookNow() {
		
		return driver.findElement(BkNowbtn).isDisplayed();
	}

}
