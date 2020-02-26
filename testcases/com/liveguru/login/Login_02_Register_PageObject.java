package com.liveguru.login;

import org.testng.annotations.Test;

import pageObjects.liveguru.MyAccountPageObject;
import pageObjects.liveguru.RegisterPageObject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_02_Register_PageObject {
	WebDriver driver;
	private String firstName, lastName, email, password, confirmPassword;
	private RegisterPageObject registerPage;
	private MyAccountPageObject myAccountPage;
	

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

		firstName = "John";
		lastName = "Henry";
		email = "automation_FC" + randomNumber() + "@gmail.com";
		password = "123456";
		confirmPassword = "123456";
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("http://live.demoguru99.com/index.php/customer/account/create/");
		registerPage = new RegisterPageObject(driver);

	}

	@Test
	public void TC_01_RegisterWithEmptyData() {

		registerPage.inputToFirstNameTextbox("");
		registerPage.inputToLastNameTextbox("");
		registerPage.inputToEmailTextbox("");
		registerPage.inputToPasswordTextbox("");
		registerPage.inputToConfirmPasswordTextbox("");
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isFirstNameRequiredErrorMsgDisplayed("This is a required field."));
		Assert.assertTrue(registerPage.isLastNameRequiredErrorMsgDisplayed("This is a required field."));
		Assert.assertTrue(registerPage.isEmailRequiredErrorMsgDisplayed("This is a required field."));
		Assert.assertTrue(registerPage.isPasswordRequiredErrorMsgDisplayed("This is a required field."));
		Assert.assertTrue(registerPage.isConfirmRequiredErrorMsgDisplayed("This is a required field."));

	}

	@Test
	public void TC_02_RegisterWithInvalidEmail() {
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("autoFCabc@mailcom");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		registerPage.clickToRegisterButton();

		registerPage.isEmailValidationErrorMsgDisplayed("Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_03_RegisterWithEmailExits() {
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("selenium45678@gmail.com");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		registerPage.clickToRegisterButton();

		Assert.assertTrue(
				registerPage.isRegisterErrorMsgDisplayed("There is already an account with this email address."));

	}

	@Test
	public void TC_04_RegisterWithPasswordLessThan6Characters() {
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isPasswordValidationErrorMsgDisplayed("Please enter 6 or more characters without leading or trailing spaces."));
	}

	@Test
	public void TC_05_RegisterWithConfirmPassworDifferentPass() {
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123789");
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isConfirmPasswordValidationErrorMsgDisplayed("Please make sure your passwords match."));
	}

	@Test
	public void TC_06_RegisterWithCorrectData() {
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);

		myAccountPage = registerPage.clickToRegisterButton();

		Assert.assertTrue(myAccountPage.isRegisterSuccessMsgDisplayed("Thank you for registering with Main Website Store."));
		Assert.assertTrue(myAccountPage.isAccountNameDisplayed(firstName + " " + lastName));
		Assert.assertTrue(myAccountPage.isAccountEmailDisplayed(email));

		myAccountPage.clickToLogoutLink();

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
