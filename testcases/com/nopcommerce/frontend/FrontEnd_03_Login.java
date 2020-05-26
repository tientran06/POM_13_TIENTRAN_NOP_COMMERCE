package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class FrontEnd_03_Login extends AbstractTest {

	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private String email, password;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		loginPage = homePage.clickToLoginLink();

		// Data input
		email = "automation_FC@gmail.com";
		password = "123456";
	}

	@BeforeMethod
	public void beforeMethod() {
		//loginPage = homePage.clickToLoginLink();
	}

	@Test
	public void TC_01_LoginWithEmptyValue() {
		loginPage.inputToEmailTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isEmailErrorMsgDisplayed("Please enter your email"));

	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {
		loginPage.inputToEmailTextbox("abcdkđfd@hotmailcom");
		loginPage.inputToPasswordTextbox("123654");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isEmailErrorMsgDisplayed("Wrong email"));
	}

	@Test
	public void TC_03_LoginWithIncorrectEmail() {
		loginPage.inputToEmailTextbox("automation_FC123@gmail.com");
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isResultErrorMsgDisplayed("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isResultErrorMsgDisplayed("No customer account found"));

	}

	@Test
	public void TC_04_LoginWithCorrectEmailAndEmptyPassword() {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isResultErrorMsgDisplayed("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isResultErrorMsgDisplayed("The credentials provided are incorrect"));
	}

	@Test
	public void TC_05_LoginwithCorrectEmailAndIncorrectPassword() {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox("123789@");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isResultErrorMsgDisplayed("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isResultErrorMsgDisplayed("The credentials provided are incorrect"));
	}

	@Test
	public void TC_06_LoginWithCorrectEmailAndPassword() {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
