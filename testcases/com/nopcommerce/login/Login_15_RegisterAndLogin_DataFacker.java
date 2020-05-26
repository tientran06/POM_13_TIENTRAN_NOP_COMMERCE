package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.DataHelperFacker;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Login_15_RegisterAndLogin_DataFacker extends AbstractTest {

	private WebDriver driver;
	private String firstName, lastName, email, companyName, password, confirmPassword;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private DataHelperFacker data;
	@Parameters({ "browser", "url" })
	@BeforeTest()
	public void beforeTest(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		// >> Home page
		homePage = PageGeneratorManager.getHomePage(driver);
		data = DataHelperFacker.getData();

		// Data input
		firstName = data.getFirstName();
		lastName = data.getLastName();
		email = data.getEmail();
		companyName = data.getCompanyName();
		password = data.getPassword();
		confirmPassword = "123456";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		// Click to Register >> Register page
		homePage.clickToHeaderLinkPagesByName(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		// Register page >> input First name / Last name
		registerPage.clickToNopCommerceRadioButtonByID(driver, "gender-female");
		registerPage.inputToNopCommerceTextboxByID(driver, "FirstName", firstName);
		registerPage.inputToNopCommerceTextboxByID(driver, "LastName", lastName);

		// Select Date of Birth
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthDay", "2");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthMonth", "June");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthYear", "1987");

		// Input Email / company / pass
		registerPage.inputToNopCommerceTextboxByID(driver, "Email", email);
		registerPage.inputToNopCommerceTextboxByID(driver, "Company", companyName);
		registerPage.inputToNopCommerceTextboxByID(driver, "Password", password);
		registerPage.inputToNopCommerceTextboxByID(driver, "ConfirmPassword", password);
		log.info("Password is------------------------------ " +password);

		registerPage.clickToNopCommerceButtonByValue(driver, "Register");
		verifyTrue(registerPage.isRegisterSuccessMsgDisplayed("Your registration completed"));

		// Click Log out link >> HomePage
		registerPage.clickToHeaderLinkPagesByName(driver, "Log out");
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_02_LoginToSystem() {
		// click to log in >> Login Page
		homePage.clickToHeaderLinkPagesByName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.inputToNopCommerceTextboxByID(driver, "Email", email);
		loginPage.inputToNopCommerceTextboxByID(driver, "Password", password);

		// Click to Login button >> Home Page
		loginPage.clickToNopCommerceButtonByValue(driver, "Log in");
		homePage = PageGeneratorManager.getHomePage(driver);

		// Verify log in successfully
		verifyTrue(homePage.isMyAccountLinkDisplayed());

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

}
