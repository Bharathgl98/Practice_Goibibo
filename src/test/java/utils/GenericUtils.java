package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GenericUtils {
	public WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void randomsideClick() {
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
	}
	
	public void clickElement(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		act.click().perform();
	}

}
