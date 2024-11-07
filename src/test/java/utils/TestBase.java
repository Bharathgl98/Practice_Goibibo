package utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public WebDriver driver;
	private By signinpopup = By.xpath("//span[@class=\"logSprite icClose\"]");
	private By framepopup = By.xpath("//button[.=\"I'll do this later\"]");
	private By adpopup = By.xpath("//p[@class=\"sc-jlwm9r-1 ewETUe\"]");
	private String url = "https://www.goibibo.com/";
	private int frameNum = 2;
	private String browser = "chrome";
	
	public WebDriver webdriverManager() throws  IOException, Throwable {
		if(driver == null) {
			
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}
			if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
			if (browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
			driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
			driver.manage().window().maximize();
			
			driver.get(url);
			Thread.sleep(2000);
			driver.findElement(signinpopup).click();
			driver.switchTo().frame(frameNum);
			
			driver.findElement(framepopup).click();
			driver.switchTo().defaultContent();
			driver.findElement(adpopup).click();
		}
		
		
		
		
		return driver;
		
	}

}
