package driverFactoryPattern;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager{

	@Override
	public void createDriver() {
		System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("-private");
		driver = new FirefoxDriver(options);
	}

}
