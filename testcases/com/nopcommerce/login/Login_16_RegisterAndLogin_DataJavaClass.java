package com.nopcommerce.login;

import org.testng.annotations.Test;

import com.nopcommerce.CustomerData;

import commons.AbstractTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Login_16_RegisterAndLogin_DataJavaClass extends AbstractTest {

	private WebDriver driver;
	//private String firstName, lastName, email, companyName, password, confirmPassword;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	@Parameters({ "browser", "url" })
	@BeforeTest()
	public void beforeTest(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		// >> Home page
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_RegisterToSystem() {
		// Click to Register >> Register page
		homePage.clickToHeaderLinkPagesByName(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		// Register page >> input First name / Last name
		registerPage.clickToNopCommerceRadioButtonByID(driver, "gender-female");
		registerPage.inputToNopCommerceTextboxByID(driver, "FirstName", CustomerData.NewCustomer.FIRSTNAME);
		registerPage.inputToNopCommerceTextboxByID(driver, "LastName", CustomerData.NewCustomer.LASTNAME);

		// Select Date of Birth
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthDay", "2");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthMonth", "June");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthYear", "1987");

		// Input Email / company / pass
		registerPage.inputToNopCommerceTextboxByID(driver, "Email", CustomerData.NewCustomer.EMAIL);
		registerPage.inputToNopCommerceTextboxByID(driver, "Company", CustomerData.NewCustomer.COMPANYNAME);
		registerPage.inputToNopCommerceTextboxByID(driver, "Password", CustomerData.NewCustomer.PASSWORD);
		registerPage.inputToNopCommerceTextboxByID(driver, "ConfirmPassword", CustomerData.NewCustomer.PASSWORD);
		log.info("Password is------------------------------ " +CustomerData.NewCustomer.PASSWORD);

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

		loginPage.inputToNopCommerceTextboxByID(driver, "Email", CustomerData.NewCustomer.EMAIL);
		loginPage.inputToNopCommerceTextboxByID(driver, "Password", CustomerData.NewCustomer.PASSWORD);

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
