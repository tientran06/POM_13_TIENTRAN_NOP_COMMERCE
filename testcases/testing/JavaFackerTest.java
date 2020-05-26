package testing;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class JavaFackerTest {
	private Locale locale = new Locale("en");
	private Faker faker = new Faker(locale);

	@BeforeTest
	public void beforeTest() {

	}

	@Test
	public void TC01_DataFaker() {
		System.out.println("" + getFullName());
		System.out.println("" + getFirstName());
		System.out.println("" + getLastName());
		System.out.println("" + getAddress());
		System.out.println("" + getPhone());
		System.out.println("" + getCity());
		System.out.println("" + getEmail());
		System.out.println("" + getPassword());
		
	}

	public String getFullName() {
		return faker.name().fullName();
	}

	public String getFirstName() {
		return faker.name().firstName();
	}

	public String getLastName() {
		return faker.name().lastName();
	}

	public String getAddress() {
		return faker.address().fullAddress();
	}

	public String getPhone() {
		return faker.phoneNumber().phoneNumber();
	}

	public String getCity() {
		return faker.address().cityName();
	}

	public String getEmail() {
		return faker.internet().emailAddress();
	}

	public String getPassword() {
		return faker.internet().password(6, 8);
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
	}
}
