package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class FrontEnd_02_Register_DynamicLocator extends AbstractTest {

	private WebDriver driver;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private String firstName, lastName, email, companyName, password, confirmPassword;

	@Parameters({"browser", "url"})
	@BeforeTest
	public void beforeTest(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);

		// Data input
		firstName = "Nop";
		lastName = "Commerce";
		email = "NopCommerce" + randomNumber() + "@gmail.com";
		companyName = "Nop commerce Ltd";
		password = "123456";
		confirmPassword = "123456";
	}

	@BeforeMethod
	public void beforeMethod() {
		homePage.clickToHeaderLinkPagesByName(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
	}
	@Test
	public void TC_01_RegisterWithEmptyData() {
		log.info("TC_01_RegisterWithEmptyData - Step 01 : Input empty value in all fields");
		registerPage.inputToNopCommerceTextboxByID(driver, "FirstName", "");
		registerPage.inputToNopCommerceTextboxByID(driver, "LastName", "");
		
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthDay", "Day");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthMonth", "Month");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthYear", "Year");
		
		registerPage.inputToNopCommerceTextboxByID(driver, "Email", "");
		registerPage.inputToNopCommerceTextboxByID(driver, "Company", "");
		registerPage.inputToNopCommerceTextboxByID(driver, "Password", "");
		registerPage.inputToNopCommerceTextboxByID(driver, "ConfirmPassword", "");
		
		log.info("TC_01_RegisterWithEmptyData - Step 02 : Click to 'Register' button");
		registerPage.clickToNopCommerceButtonByValue(driver, "Register");
		
		log.info("TC_01_RegisterWithEmptyData - Step 03 : Verify Validation error message is displayed");
		verifyTrue(registerPage.isNopCommerceValidationMsgDisplayed(driver, "First name is required."));
		verifyTrue(registerPage.isNopCommerceValidationMsgDisplayed(driver, "Last name is required."));
		verifyTrue(registerPage.isNopCommerceValidationMsgDisplayed(driver, "Email is required."));
		verifyTrue(registerPage.isNopCommerceValidationMsgDisplayed(driver, "Password is required."));
		verifyTrue(registerPage.isNopCommerceValidationMsgDisplayed(driver, "Password is required."));

	}

	@Test
	public void TC_02_RegisterWithInvalidEmail() {
		log.info("--------------------------------------CASE 1 ---------------------------------------");
		log.info("TC_02_RegisterWithInvalidEmail - Step 01 : Input valid value in required fields");
		registerPage.inputToNopCommerceTextboxByID(driver, "FirstName", firstName);
		registerPage.inputToNopCommerceTextboxByID(driver, "LastName", lastName);
		
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthDay", "2");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthMonth", "June");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthYear", "1987");
		
		log.info("TC_02_RegisterWithInvalidEmail - Step 02 : Input invalid Email ");
		registerPage.inputToNopCommerceTextboxByID(driver, "Email", "automation@hotcom");
		
		log.info("TC_02_RegisterWithInvalidEmail - Step 03 : Input valid value in other fields");
		registerPage.inputToNopCommerceTextboxByID(driver, "Company", companyName);
		registerPage.inputToNopCommerceTextboxByID(driver, "Password", password);
		registerPage.inputToNopCommerceTextboxByID(driver, "ConfirmPassword", confirmPassword);
		
		log.info("TC_02_RegisterWithInvalidEmail - Step 04 : Click to 'Register' button");
		registerPage.clickToNopCommerceButtonByValue(driver, "Register");
		
		log.info("TC_02_RegisterWithInvalidEmail - Step 05 : Verify Validation error message is displayed");
		verifyTrue(registerPage.isNopCommerceValidationMsgDisplayed(driver, "Wrong email"));
		
		log.info("--------------------------------------CASE 2 ---------------------------------------");
		log.info("TC_02_RegisterWithInvalidEmail - Step 06 : Input valid value in required fields");
		registerPage.inputToNopCommerceTextboxByID(driver, "FirstName", firstName);
		registerPage.inputToNopCommerceTextboxByID(driver, "LastName", lastName);
		
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthDay", "2");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthMonth", "June");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthYear", "1987");
		
		log.info("TC_02_RegisterWithInvalidEmail - Step 07 : Input invalid Email ");
		registerPage.inputToNopCommerceTextboxByID(driver, "Email", "automation123@");
		
		log.info("TC_02_RegisterWithInvalidEmail - Step 08 : Input valid value in other fields");
		registerPage.inputToNopCommerceTextboxByID(driver, "Company", companyName);
		registerPage.inputToNopCommerceTextboxByID(driver, "Password", password);
		registerPage.inputToNopCommerceTextboxByID(driver, "ConfirmPassword", confirmPassword);
		
		log.info("TC_02_RegisterWithInvalidEmail - Step 09 : Click to 'Register' button");
		registerPage.clickToNopCommerceButtonByValue(driver, "Register");
		
		log.info("TC_02_RegisterWithInvalidEmail - Step 10 : Verify Validation error message is displayed");
		verifyTrue(registerPage.isNopCommerceValidationMsgDisplayed(driver, "Wrong email"));
		
		log.info("--------------------------------------CASE 3 ---------------------------------------");
		log.info("TC_02_RegisterWithInvalidEmail - Step 11 : Input valid value in required fields");
		registerPage.inputToNopCommerceTextboxByID(driver, "FirstName", firstName);
		registerPage.inputToNopCommerceTextboxByID(driver, "LastName", lastName);
		
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthDay", "2");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthMonth", "June");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthYear", "1987");
		
		log.info("TC_02_RegisterWithInvalidEmail - Step 12 : Input invalid Email ");
		registerPage.inputToNopCommerceTextboxByID(driver, "Email", "automation123gmail.com");
		
		log.info("TC_02_RegisterWithInvalidEmail - Step 13 : Input valid value in other fields");
		registerPage.inputToNopCommerceTextboxByID(driver, "Company", companyName);
		registerPage.inputToNopCommerceTextboxByID(driver, "Password", password);
		registerPage.inputToNopCommerceTextboxByID(driver, "ConfirmPassword", confirmPassword);
		
		log.info("TC_02_RegisterWithInvalidEmail - Step 14 : Click to 'Register' button");
		registerPage.clickToNopCommerceButtonByValue(driver, "Register");
		
		log.info("TC_02_RegisterWithInvalidEmail - Step 15 : Verify Validation error message is displayed");
		verifyTrue(registerPage.isNopCommerceValidationMsgDisplayed(driver, "Wrong email"));
	}

	@Test
	public void TC_03_RegisterWithEmailExits() {
		log.info("TC_03_RegisterWithEmailExits - Step 01 : Input valid value in required fields");
		registerPage.inputToNopCommerceTextboxByID(driver, "FirstName", firstName);
		registerPage.inputToNopCommerceTextboxByID(driver, "LastName", lastName);
		
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthDay", "2");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthMonth", "June");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthYear", "1987");
		
		log.info("TC_03_RegisterWithEmailExits - Step 02 : Input exits Email ");
		registerPage.inputToNopCommerceTextboxByID(driver, "Email", "tran@gmail.com");
		
		log.info("TC_03_RegisterWithEmailExits - Step 03 : Input valid value in other fields");
		registerPage.inputToNopCommerceTextboxByID(driver, "Company", companyName);
		registerPage.inputToNopCommerceTextboxByID(driver, "Password", password);
		registerPage.inputToNopCommerceTextboxByID(driver, "ConfirmPassword", confirmPassword);
		
		log.info("TC_03_RegisterWithEmailExits - Step 04 : Click to 'Register' button");
		registerPage.clickToNopCommerceButtonByValue(driver, "Register");
		
		log.info("TC_03_RegisterWithEmailExits - Step 05 : Verify Result error message is displayed");
		verifyTrue(registerPage.isNopCommerceResultErrorMsgDisplayed(driver, "The specified email already exists"));
	}

	@Test
	public void TC_04_RegisterWithPasswordLessThan6Characters() {
		log.info("TC_04_RegisterWithPasswordLessThan6Characters - Step 01 : Input valid value in required fields");
		registerPage.inputToNopCommerceTextboxByID(driver, "FirstName", firstName);
		registerPage.inputToNopCommerceTextboxByID(driver, "LastName", lastName);
		
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthDay", "2");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthMonth", "June");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthYear", "1987");
		
		registerPage.inputToNopCommerceTextboxByID(driver, "Email", email);
		registerPage.inputToNopCommerceTextboxByID(driver, "Company", companyName);
		
		log.info("TC_04_RegisterWithPasswordLessThan6Characters - Step 02 : Input Pass less than 6 chars ");
		registerPage.inputToNopCommerceTextboxByID(driver, "Password", "1234");
		
		log.info("TC_04_RegisterWithPasswordLessThan6Characters - Step 03 : Input confirm Pass");
		registerPage.inputToNopCommerceTextboxByID(driver, "ConfirmPassword", "1234");
		
		log.info("TC_04_RegisterWithPasswordLessThan6Characters - Step 04 : Click to 'Register' button");
		registerPage.clickToNopCommerceButtonByValue(driver, "Register");
		
		log.info("TC_04_RegisterWithPasswordLessThan6Characters - Step 05 : Verify Validation error message is displayed");
		verifyTrue(registerPage.isValidationPasswordErrorMsgDisplayed("Password must meet the following rules: "));
		verifyTrue(registerPage.isValidationPasswordErrorMsgDisplayed("must have at least 6 characters"));
	}

	@Test
	public void TC_05_RegisterWithConfirmPassworDifferentPass() {
		
		log.info("TC_05_RegisterWithConfirmPassworDifferentPass - Step 01 : Input valid value in required fields");
		registerPage.inputToNopCommerceTextboxByID(driver, "FirstName", firstName);
		registerPage.inputToNopCommerceTextboxByID(driver, "LastName", lastName);
		
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthDay", "2");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthMonth", "June");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthYear", "1987");
		
		registerPage.inputToNopCommerceTextboxByID(driver, "Email", email);
		registerPage.inputToNopCommerceTextboxByID(driver, "Company", companyName);
		
		log.info("TC_05_RegisterWithConfirmPassworDifferentPass - Step 02 : Input valid password ");
		registerPage.inputToNopCommerceTextboxByID(driver, "Password", password);
		
		log.info("TC_05_RegisterWithConfirmPassworDifferentPass - Step 03 : Input Confirm Pass different Pass ");
		registerPage.inputToNopCommerceTextboxByID(driver, "ConfirmPassword", "654321");
		
		log.info("TC_05_RegisterWithConfirmPassworDifferentPass - Step 04 : Click to 'Register' button");
		registerPage.clickToNopCommerceButtonByValue(driver, "Register");
		
		log.info("TC_05_RegisterWithConfirmPassworDifferentPass - Step 05 : Verify Result error message is displayed");
		verifyTrue(registerPage.isNopCommerceValidationMsgDisplayed(driver, "The password and confirmation password do not match."));
	}

	@Test
	public void TC_06_RegisterWithCorrectData() {
		
		log.info("TC_06_RegisterWithCorrectData - Step 01 : Input valid value in required fields");
		registerPage.inputToNopCommerceTextboxByID(driver, "FirstName", firstName);
		registerPage.inputToNopCommerceTextboxByID(driver, "LastName", lastName);
		
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthDay", "2");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthMonth", "June");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthYear", "1987");
		
		registerPage.inputToNopCommerceTextboxByID(driver, "Email", email);
		registerPage.inputToNopCommerceTextboxByID(driver, "Company", companyName);
		registerPage.inputToNopCommerceTextboxByID(driver, "Password", password);
		registerPage.inputToNopCommerceTextboxByID(driver, "ConfirmPassword", confirmPassword);
		
		log.info("TC_06_RegisterWithCorrectData - Step 02 : Click to 'Register' button");
		registerPage.clickToNopCommerceButtonByValue(driver, "Register");
		
		log.info("TC_06_RegisterWithCorrectData - Step 03 : Verify Result error message is displayed");
		verifyTrue(registerPage.isRegisterSuccessMsgDisplayed("Your registration completed"));
		registerPage.clickToHeaderLinkPagesByName(driver, "Log out");
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
