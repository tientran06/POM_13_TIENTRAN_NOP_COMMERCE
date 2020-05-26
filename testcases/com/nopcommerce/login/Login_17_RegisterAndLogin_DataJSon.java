package com.nopcommerce.login;

import org.testng.annotations.Test;

import com.data.json.NewCustomerData;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import commons.AbstractTest;
import commons.GlobalConstants;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Login_17_RegisterAndLogin_DataJSon extends AbstractTest {

	private WebDriver driver;
	// private String firstName, lastName, email, companyName, password, confirmPassword;
	private HomePageObject homePage;
	// private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	NewCustomerData data;

	@Parameters({ "browser", "url" })
	@BeforeTest()
	public void beforeTest(String browserName, String url) throws JsonParseException, JsonMappingException, IOException {
		driver = getBrowserDriver(browserName, url);

		// >> Home page
		homePage = PageGeneratorManager.getHomePage(driver);
		data = NewCustomerData.getNewCustomer(GlobalConstants.PROJECT_PATH + "\\testdata\\com\\data\\json\\NewCustomer.json");
		// email = "automationFC" + randomNumber() + "@gmail.com";
	}

	@BeforeMethod()
	public void beforeMethod() {
		// Click to Register >> Register page
		homePage.clickToHeaderLinkPagesByName(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
	}

	@Test()
	public void TC_01_RegisterToSystem() {

		// Register page >> input First name / Last name
		registerPage.clickToNopCommerceRadioButtonByID(driver, "gender-female");
		registerPage.inputToNopCommerceTextboxByID(driver, "FirstName", data.getFirstname());
		registerPage.inputToNopCommerceTextboxByID(driver, "LastName", data.getLastname());

		// Select Date of Birth
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthDay", data.getDay());
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthMonth", data.getMonth());
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthYear", data.getYear());

		// Input Email / company / pass
		registerPage.inputToNopCommerceTextboxByID(driver, "Email", data.getEmail());
		registerPage.inputToNopCommerceTextboxByID(driver, "Company", data.getCompany());
		registerPage.inputToNopCommerceTextboxByID(driver, "Password", data.getPassword());
		registerPage.inputToNopCommerceTextboxByID(driver, "ConfirmPassword", data.getPassword());
		log.info("Password is------------------------------ " + data.getPassword());

		registerPage.clickToNopCommerceButtonByValue(driver, "Register");
		verifyTrue(registerPage.isRegisterSuccessMsgDisplayed("Your registration completed"));

		// Click Log out link >> HomePage
		registerPage.clickToHeaderLinkPagesByName(driver, "Log out");
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

}
