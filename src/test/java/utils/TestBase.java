package utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public WebDriver driver;
	
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
			
			
		}
		return driver;	
	}
}
