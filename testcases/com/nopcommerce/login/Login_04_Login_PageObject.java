package com.nopcommerce.login;

import org.testng.annotations.Test;

import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;

import org.testng.annotations.BeforeTest;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Login_04_Login_PageObject {

	private WebDriver driver;
	private String email, password;
	private HomePageObject homePage;
	private LoginPageObject loginPage;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
		driver = new FirefoxDriver();

		email = "tran123@gmail.com";
		password = "123456";
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		loginPage = new LoginPageObject(driver);
	}

	@Test
	public void TC_01_LoginWithEmptyValue() {
		loginPage.inputToEmailTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isEmailErrorMsgDisplayed("Please enter your email"));

	}

	// @Test
	public void TC_02_LoginWithInvalidEmail() {
		loginPage.inputToEmailTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
	}

	@Test
	public void TC_03_LoginWithIncorrectEmail() {
		loginPage.inputToEmailTextbox("automation_FC123@gmail.com");
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage
				.isResultErrorMsgDisplayed("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isResultErrorMsgDisplayed("No customer account found"));

	}

	@Test
	public void TC_04_LoginWithCorrectEmailAndEmptyPassword() {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage
				.isResultErrorMsgDisplayed("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isResultErrorMsgDisplayed("The credentials provided are incorrect"));
	}

	@Test
	public void TC_05_LoginwithCorrectEmailAndIncorrectPassword() {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox("123789@");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage
				.isResultErrorMsgDisplayed("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isResultErrorMsgDisplayed("The credentials provided are incorrect"));
	}

	@Test
	public void TC_06_LoginWithCorrectEmailAndPassword() {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();

		// >> Home Page
		homePage = new HomePageObject(driver);
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
