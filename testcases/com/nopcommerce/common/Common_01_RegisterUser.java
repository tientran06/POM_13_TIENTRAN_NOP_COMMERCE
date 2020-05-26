package com.nopcommerce.common;


import commons.AbstractTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;

public class Common_01_RegisterUser extends AbstractTest {
	private WebDriver driver;
	public static String email, password;
	private String firstName, lastName, companyName, confirmPassword;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	@Parameters({ "browser", "url" })
	@BeforeSuite
	public void createUser(@Optional("chrome") String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		// >> Home page
		homePage = PageGeneratorManager.getHomePage(driver);

		// Data input
		firstName = "Automation";
		lastName = "Testing";
		email = "automationFC" + randomNumber() + "@gmail.com";
		companyName = "Automation FC Ltd";
		password = "123456";
		confirmPassword = "123456";

		registerPage = homePage.clickToRegisterLink();
		
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
		verifyTrue(registerPage.isRegisterSuccessMsgDisplayed("Your registration completed"));
		
		homePage = registerPage.clickToLogoutLink();
		driver.quit();
	}

}
