package driverFactoryPattern;

public class DriverManagerFactory {
	public static DriverManager getManager(String browserName) {
		DriverManager driverManager;
		switch (browserName) {
		case "chrome":
			driverManager = new ChromeDriverManager();
			break;
		case "firefox":
			driverManager = new FirefoxDriverManager();
			break;
		case "headless_chrome":
			driverManager = new ChromeHeadlessDriverManager();
			break;
			
		case "headless_firefox":
			driverManager = new FirefoxHeadlessDriverManager();
			break;
		default:
			driverManager = new ChromeDriverManager();
			break;
			
		}
		return driverManager;
		
	}
}
