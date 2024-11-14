package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoibiboLandingpage {
	WebDriver driver;

	private By signinpopup = By.xpath("//span[@class=\"logSprite icClose\"]");
	private By framepopup = By.xpath("//button[.=\"I'll do this later\"]");
	private By adpopup = By.xpath("//p[@class=\"sc-jlwm9r-1 ewETUe\"]");
	private int frameNum = 2;
	
	public GoibiboLandingpage(WebDriver driver) {
		this.driver = driver;
	}
	public void getURL(String url) throws Throwable   {
		Thread.sleep(2000);
		System.out.println(url);
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(signinpopup).click();
		driver.switchTo().frame(frameNum);
		
		driver.findElement(framepopup).click();
		driver.switchTo().defaultContent();
		driver.findElement(adpopup).click();
	}
}
