package com.nopcommerce.login;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Login_01_Register_01_StepByStep {
	WebDriver driver;
	WebDriverWait waitExplicit;
	Select select;
	String firstName = "Automation";
	String lastName = "Testing";
	String email = "automationFC" + randomNumber() + "@gmail.com";
	String companyName = "Automation FC Ltd";
	String password = "123456";
	String confirmPassword = "123456";
	String diffConfirmPassword = "123123";

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
		driver = new FirefoxDriver();
		waitExplicit = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://demo.nopcommerce.com/");
		// Click Register button
		driver.findElement(By.cssSelector(".ico-register")).click();

	}

	@Test
	public void TC_01_RegisterWithEmptyData() {
		// Do not input any fields and Click Register
		driver.findElement(By.cssSelector("#register-button")).click();

		// Verify mandantory fields
		Assert.assertTrue(driver.findElement(By.xpath("//span[text() ='First name is required.']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[text() ='Last name is required.']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[text() ='Email is required.']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id = 'Password-error' and text() ='Password is required.']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id = 'ConfirmPassword-error' and text() ='Password is required.']")).isDisplayed());

	}

	@Test
	public void TC_02_RegisterWithInvalidEmail() {

		// Click Gender selection
		driver.findElement(By.cssSelector("#gender-male")).click();

		// Input information
		driver.findElement(By.cssSelector("#FirstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("#LastName")).sendKeys(lastName);

		// Select Date of Birth
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthDay']")));
		select.selectByVisibleText("2");
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthMonth']")));
		select.selectByVisibleText("May");
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthYear']")));
		select.selectByVisibleText("1980");
		// input invalid email
		driver.findElement(By.cssSelector("#Email")).sendKeys("abc@com");

		driver.findElement(By.cssSelector("#Company")).sendKeys(companyName);
		driver.findElement(By.cssSelector("#Password")).sendKeys(password);
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(confirmPassword);

		// Click Register
		driver.findElement(By.cssSelector("#register-button")).click();

		// Verify result after register - error message xuất hiện
		WebElement emailError = driver.findElement(By.xpath("//span[text() ='Wrong email']"));
		Assert.assertTrue(emailError.isDisplayed());
	}

	@Test
	public void TC_03_RegisterWithEmailExist() {

		// Click Gender selection
		driver.findElement(By.cssSelector("#gender-male")).click();

		// Input information
		driver.findElement(By.cssSelector("#FirstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("#LastName")).sendKeys(lastName);

		// Select Date of Birth
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthDay']")));
		select.selectByVisibleText("2");
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthMonth']")));
		select.selectByVisibleText("May");
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthYear']")));
		select.selectByVisibleText("1980");

		// input email which already exist in system
		driver.findElement(By.cssSelector("#Email")).sendKeys("automationFC@gmail.com");
		driver.findElement(By.cssSelector("#Company")).sendKeys(companyName);
		driver.findElement(By.cssSelector("#Password")).sendKeys(password);
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(confirmPassword);

		// Click Register
		driver.findElement(By.cssSelector("#register-button")).click();
		// Verify email already exists
		Assert.assertTrue(driver.findElement(By.xpath("//li[text() ='The specified email already exists']")).isDisplayed());

	}

	@Test(description = "Password less than 6 characters")
	public void TC_04_RegisterWithInvalidPass() {

		// Click Gender selection
		driver.findElement(By.cssSelector("#gender-male")).click();

		// Input information
		driver.findElement(By.cssSelector("#FirstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("#LastName")).sendKeys(lastName);

		// Select Date of Birth
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthDay']")));
		select.selectByVisibleText("2");
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthMonth']")));
		select.selectByVisibleText("May");
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthYear']")));
		select.selectByVisibleText("1980");

		// input email which already exist in system
		driver.findElement(By.cssSelector("#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("#Company")).sendKeys(companyName);
		driver.findElement(By.cssSelector("#Password")).sendKeys("123");
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123");

		// Click Register
		driver.findElement(By.cssSelector("#register-button")).click();
		// Verify Password less than 6 characters
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() ='Password must meet the following rules: ']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[text() ='must have at least 6 characters']")).isDisplayed());

	}

	@Test(description = "Confirm Password is different with Password")
	public void TC_05_RegisterWithInvalidConfirmPassword() {

		// Click Gender selection
		driver.findElement(By.cssSelector("#gender-male")).click();

		// Input information
		driver.findElement(By.cssSelector("#FirstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("#LastName")).sendKeys(lastName);

		// Select Date of Birth
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthDay']")));
		select.selectByVisibleText("2");
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthMonth']")));
		select.selectByVisibleText("May");
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthYear']")));
		select.selectByVisibleText("1980");

		// input email which already exist in system
		driver.findElement(By.cssSelector("#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("#Company")).sendKeys(companyName);
		driver.findElement(By.cssSelector("#Password")).sendKeys(password);
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(diffConfirmPassword);

		// Click Register
		driver.findElement(By.cssSelector("#register-button")).click();
		// Verify Password less than 6 characters
		Assert.assertTrue(driver.findElement(By.xpath("//span[text() = 'The password and confirmation password do not match.']")).isDisplayed());

	}

	@Test
	public void TC_06_RegisterToSystem() {

		// Click Gender selection
		driver.findElement(By.cssSelector("#gender-male")).click();

		// Input information
		driver.findElement(By.cssSelector("#FirstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("#LastName")).sendKeys(lastName);

		// Select Date of Birth
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthDay']")));
		select.selectByVisibleText("2");
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthMonth']")));
		select.selectByVisibleText("May");
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthYear']")));
		select.selectByVisibleText("1980");

		driver.findElement(By.cssSelector("#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("#Company")).sendKeys(companyName);
		driver.findElement(By.cssSelector("#Password")).sendKeys(password);
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(confirmPassword);

		// Click Register
		driver.findElement(By.cssSelector("#register-button")).click();
		// Verify result after register

		Assert.assertEquals(driver.findElement(By.cssSelector(".result")).getText(), "Your registration completed");
		driver.findElement(By.cssSelector(".ico-logout")).click();

	}

	public int randomNumber() {
		Random ran = new Random();
		return ran.nextInt(5000);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
