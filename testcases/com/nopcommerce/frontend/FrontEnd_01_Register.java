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
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class FrontEnd_01_Register extends AbstractTest {

	private WebDriver driver;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private String firstName, lastName, email, companyName, password, confirmPassword;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
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
		registerPage = homePage.clickToRegisterLink();
	}
	@Test
	public void TC_01_RegisterWithEmptyData() {
		registerPage.inputToFirstName("");
		registerPage.inputToLastName("");

		registerPage.selectDayDropDown("Day");
		registerPage.selectMonthDropDown("Month");
		registerPage.selectYearDropDown("Year");

		registerPage.inputToEmailTextbox("");
		registerPage.inputToCompanyTextbox("");
		registerPage.inputToPasswordTextbox("");
		registerPage.inputToConfirmPasswordTextbox("");

		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isValidationErrorMsgDisplayed("First name is required."));
		Assert.assertTrue(registerPage.isValidationErrorMsgDisplayed("Last name is required."));
		Assert.assertTrue(registerPage.isValidationErrorMsgDisplayed("Email is required."));
		Assert.assertTrue(registerPage.isValidationPasswordErrorMsgDisplayed("Password is required."));
		Assert.assertTrue(registerPage.isValidationConfirmPasswordErrorMsgDisplayed("Password is required."));

	}

	@Test
	public void TC_02_RegisterWithInvalidEmail() {
		registerPage.clickToMale();
		registerPage.inputToFirstName(firstName);
		registerPage.inputToLastName(lastName);

		registerPage.selectDayDropDown("2");
		registerPage.selectMonthDropDown("June");
		registerPage.selectYearDropDown("1922");

		registerPage.inputToEmailTextbox("automation@hotcom");
		registerPage.inputToCompanyTextbox(companyName);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);

		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isEmailErrorMsgDisplayed("Wrong email"));
	}

	@Test
	public void TC_03_RegisterWithEmailExits() {
		registerPage.clickToMale();
		registerPage.inputToFirstName(firstName);
		registerPage.inputToLastName(lastName);

		registerPage.selectDayDropDown("2");
		registerPage.selectMonthDropDown("June");
		registerPage.selectYearDropDown("1922");

		registerPage.inputToEmailTextbox("tran@gmail.com");
		registerPage.inputToCompanyTextbox(companyName);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);

		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isResultMsgDisplayed("The specified email already exists"));
	}

	@Test
	public void TC_04_RegisterWithPasswordLessThan6Characters() {
		registerPage.clickToMale();
		registerPage.inputToFirstName(firstName);
		registerPage.inputToLastName(lastName);

		registerPage.selectDayDropDown("2");
		registerPage.selectMonthDropDown("June");
		registerPage.selectYearDropDown("1922");

		registerPage.inputToEmailTextbox(email);
		registerPage.inputToCompanyTextbox(companyName);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");

		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isValidationPasswordErrorMsgDisplayed("Password must meet the following rules: "));
		Assert.assertTrue(registerPage.isValidationPasswordErrorMsgDisplayed("must have at least 6 characters"));

	}

	@Test
	public void TC_05_RegisterWithConfirmPassworDifferentPass() {
		registerPage.clickToMale();
		registerPage.inputToFirstName(firstName);
		registerPage.inputToLastName(lastName);

		registerPage.selectDayDropDown("2");
		registerPage.selectMonthDropDown("June");
		registerPage.selectYearDropDown("1922");

		registerPage.inputToEmailTextbox(email);
		registerPage.inputToCompanyTextbox(companyName);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("123");

		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isValidationConfirmPasswordErrorMsgDisplayed("The password and confirmation password do not match."));
	}

	@Test
	public void TC_06_RegisterWithCorrectData() {
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
		homePage = registerPage.clickToLogoutLink();
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
