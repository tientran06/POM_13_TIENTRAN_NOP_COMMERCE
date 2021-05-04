package testing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.AbstractTest;

public class testing extends AbstractTest {
	WebDriver driver;
	WebDriverWait waitExplicit;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
		driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", ".\\libraries\\chromedriver.exe");
//		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		waitExplicit = new WebDriverWait(driver, 15);
	}

	@BeforeMethod
	public void beforeMethod() {

	}

	@Test
	public void TC02_Dropdown() throws InterruptedException {
		String month = getCurrentMonth1();
		System.out.println("MONTH IS =================================================" + month);

	}

	@Test
	public void TC04_QuitDriver() {
		Assert.assertTrue(false);
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

	protected String getCurrentMonth() {
		LocalDate currentdate = LocalDate.now();
		Month currentMonth = currentdate.getMonth();
		String month = currentMonth.toString().toLowerCase();
		return month;
	}
	protected String getCurrentMonth1() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		int month = now.getMonthOfYear();
		DateFormat dateFormat = new SimpleDateFormat("MMMM");
		return dateFormat.format(month);
	}
}
