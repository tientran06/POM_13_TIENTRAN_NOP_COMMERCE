package com.nopcommerce.login;

import org.testng.annotations.Test;

import driverFactoryPattern.DriverManager;
import driverFactoryPattern.DriverManagerFactory;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_08_RegisterAndLogin_Factory_Pattern {

	private WebDriver driver;
	private DriverManager driverManager;
	private String firstName, lastName, email, companyName, password, confirmPassword;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driverManager = DriverManagerFactory.getManager(browserName);
		driver = driverManager.getDriver();
		
		// >> Home page
		homePage = PageGeneratorManager.getHomePage(driver);

		// Data input
		firstName = "Automation";
		lastName = "Testing";
		email = "automationFC" + randomNumber() + "@gmail.com";
		companyName = "Automation FC Ltd";
		password = "123456";
		confirmPassword = "123456";
	}

	@Test
	public void TC_01_RegisterToSystem() throws InterruptedException {
		// Click to Register >> Register page
		registerPage = homePage.clickToRegisterLink();
		// Register page >> input data
		registerPage.clickToMale();
		registerPage.inputToFirstName(firstName);
		registerPage.inputToLastName(lastName);

		registerPage.selectDayDropDown("2");
		registerPage.selectMonthDropDown("June");
		registerPage.selectYearDropDown("1922");

		registerPage.inputToEmailTextbox(email);
		registerPage.inputToCompanyTextbox(companyName);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);

		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isRegisterSuccessMsgDisplayed("Your registration completed"));
		// Click Log out link >> HomePage
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void TC_02_LoginToSystem() {
		// click to log in >> Login Page
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);

		// Click to Login button >> Home Page
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

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
