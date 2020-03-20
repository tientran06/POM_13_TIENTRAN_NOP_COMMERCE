package driverFactoryPattern;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadlessDriverManager extends DriverManager{

	@Override
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", ".\\libraries\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("headless");
		options.addArguments("window-size=1920x1080");
		driver = new ChromeDriver(options);
		
	}

}
