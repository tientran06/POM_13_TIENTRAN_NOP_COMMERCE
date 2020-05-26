package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_RegisterUser;

import commons.AbstractTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class FrontEnd_04_Login_DynamicLocator extends AbstractTest {

	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private String email, password;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);

		// Data input
		email = Common_01_RegisterUser.email;
		password = Common_01_RegisterUser.password;
	}

	@BeforeMethod
	public void beforeMethod() {
		homePage.clickToHeaderLinkPagesByName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_LoginWithEmptyValue() {
		log.info("TC_01_LoginWithEmptyValue - Step 01 : Input Empty value in Email and Password");
		loginPage.inputToNopCommerceTextboxByID(driver, "Email", "");
		loginPage.inputToNopCommerceTextboxByID(driver, "Password", "");

		log.info("TC_01_LoginWithEmptyValue - Step 02 : Click to 'Login' button");
		loginPage.clickToNopCommerceButtonByValue(driver, "Log in");

		log.info("TC_01_LoginWithEmptyValue - Step 03 : Verify Validation Error Message is displayed");
		verifyTrue(loginPage.isNopCommerceValidationMsgDisplayed(driver, "Please enter your email"));
	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {
		log.info("------------------------------------------------ CASE 1 ---------------------------------------------");
		log.info("TC_02_LoginWithInvalidEmail - Step 01 : Input Invalid Email value");
		loginPage.inputToNopCommerceTextboxByID(driver, "Email", "automation@gmailcom");

		log.info("TC_02_LoginWithInvalidEmail - Step 02 : Input Password");
		loginPage.inputToNopCommerceTextboxByID(driver, "Password", password);

		log.info("TC_02_LoginWithInvalidEmail - Step 03 : Click to 'Login' button");
		loginPage.clickToNopCommerceButtonByValue(driver, "Log in");

		log.info("TC_02_LoginWithInvalidEmail - Step 04 : Verify Validation Error Message is displayed");
		verifyTrue(loginPage.isNopCommerceValidationMsgDisplayed(driver, "Wrong email"));

		log.info("------------------------------------------------ CASE 2 ---------------------------------------------");
		log.info("TC_02_LoginWithInvalidEmail - Step 05 : Input Invalid Email value");
		loginPage.inputToNopCommerceTextboxByID(driver, "Email", "automationgmailcom");

		log.info("TC_02_LoginWithInvalidEmail - Step 06 : Input Password");
		loginPage.inputToNopCommerceTextboxByID(driver, "Password", password);

		log.info("TC_02_LoginWithInvalidEmail - Step 07 : Click to 'Login' button");
		loginPage.clickToNopCommerceButtonByValue(driver, "Log in");

		log.info("TC_02_LoginWithInvalidEmail - Step 08 : Verify Validation Error Message is displayed");
		verifyTrue(loginPage.isNopCommerceValidationMsgDisplayed(driver, "Wrong email"));

		log.info("------------------------------------------------ CASE 3 ---------------------------------------------");
		log.info("TC_02_LoginWithInvalidEmail - Step 09 : Input Invalid Email value");
		loginPage.inputToNopCommerceTextboxByID(driver, "Email", "automation@");

		log.info("TC_02_LoginWithInvalidEmail - Step 10 : Input Password");
		loginPage.inputToNopCommerceTextboxByID(driver, "Password", password);

		log.info("TC_02_LoginWithInvalidEmail - Step 11 : Click to 'Login' button");
		loginPage.clickToNopCommerceButtonByValue(driver, "Log in");

		log.info("TC_02_LoginWithInvalidEmail - Step 12 : Verify Validation Error Message is displayed");
		verifyTrue(loginPage.isNopCommerceValidationMsgDisplayed(driver, "Wrong email"));
	}

	@Test
	public void TC_03_LoginWithIncorrectEmail() {
		log.info("TC_03_LoginWithIncorrectEmail - Step 01 : Input Incorrect Email");
		loginPage.inputToNopCommerceTextboxByID(driver, "Email", "automation_FC@gmail.com");

		log.info("TC_03_LoginWithIncorrectEmail - Step 02 : Input Password");
		loginPage.inputToNopCommerceTextboxByID(driver, "Password", password);

		log.info("TC_03_LoginWithIncorrectEmail - Step 03 : Click to 'Login' button");
		loginPage.clickToNopCommerceButtonByValue(driver, "Log in");

		log.info("TC_03_LoginWithIncorrectEmail - Step 04 : Verify Result Error Message is displayed");
		verifyTrue(loginPage.isResultErrorMsgDisplayed("Login was unsuccessful. Please correct the errors and try again."));
		verifyTrue(loginPage.isResultErrorMsgDisplayed("No customer account found"));
	}

	@Test
	public void TC_04_LoginWithCorrectEmailAndEmptyPassword() {
		log.info("TC_04_LoginWithCorrectEmailAndEmptyPassword - Step 01 : Input correct Email");
		loginPage.inputToNopCommerceTextboxByID(driver, "Email", email);

		log.info("TC_04_LoginWithCorrectEmailAndEmptyPassword - Step 02 : Input Empty Password");
		loginPage.inputToNopCommerceTextboxByID(driver, "Password", "");

		log.info("TC_04_LoginWithCorrectEmailAndEmptyPassword - Step 03 : Click to 'Login' button");
		loginPage.clickToNopCommerceButtonByValue(driver, "Log in");

		log.info("TC_04_LoginWithCorrectEmailAndEmptyPassword - Step 04 : Verify Validation Error Message is displayed");
		verifyTrue(loginPage.isResultErrorMsgDisplayed("Login was unsuccessful. Please correct the errors and try again."));
		verifyTrue(loginPage.isResultErrorMsgDisplayed("The credentials provided are incorrect"));
	}

	@Test
	public void TC_05_LoginwithCorrectEmailAndIncorrectPassword() {
		log.info("TC_05_LoginwithCorrectEmailAndIncorrectPassword - Step 01 : Input correct Email");
		loginPage.inputToNopCommerceTextboxByID(driver, "Email", email);

		log.info("TC_05_LoginwithCorrectEmailAndIncorrectPassword - Step 02 : Input Incorrect Password");
		loginPage.inputToNopCommerceTextboxByID(driver, "Password", "555555");

		log.info("TC_05_LoginwithCorrectEmailAndIncorrectPassword - Step 03 : Click to 'Login' button");
		loginPage.clickToNopCommerceButtonByValue(driver, "Log in");

		log.info("TC_05_LoginwithCorrectEmailAndIncorrectPassword - Step 04 : Verify Validation Error Message is displayed");
		verifyTrue(loginPage.isResultErrorMsgDisplayed("Login was unsuccessful. Please correct the errors and try again."));
		verifyTrue(loginPage.isResultErrorMsgDisplayed("The credentials provided are incorrect"));
	}

	@Test
	public void TC_06_LoginWithCorrectEmailAndPassword() {
		log.info("TC_06_LoginWithCorrectEmailAndPassword - Step 01 : Input correct Email and Password");
		loginPage.inputToNopCommerceTextboxByID(driver, "Email", email);
		loginPage.inputToNopCommerceTextboxByID(driver, "Password", password);

		log.info("TC_06_LoginWithCorrectEmailAndPassword - Step 02 : Click to 'Login' button");
		loginPage.clickToNopCommerceButtonByValue(driver, "Log in");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("TC_06_LoginWithCorrectEmailAndPassword - Step 03 : Verify Log in successfully");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		homePage.clickToHeaderLinkPagesByName(driver, "Log out");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
