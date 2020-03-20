package driverFactoryPattern;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxHeadlessDriverManager extends DriverManager{

	@Override
	public void createDriver() {
		System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1920x1080");
		driver = new FirefoxDriver(options);
		
	}

}
