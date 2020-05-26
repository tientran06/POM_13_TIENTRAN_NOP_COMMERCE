package com.bankguru99.common;


import commons.AbstractTest;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.NewCustomerPageObject;
import pageObjects.bankguru.PageGeneratorManager;
import pageObjects.bankguru.RegisterPageObject;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;

public class Common_01_CreateNewCustomer extends AbstractTest {

	private WebDriver driver;
	public static String userID, password, customerID;
	private String  email, customerName, dateOfBirth, address, city, state, pin, mobileNumber, gender, wellComeMsg;

	@Parameters({ "browser", "url" })
	@BeforeSuite
	public void beforeTest(@Optional("chrome") String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		loginPage = PageGeneratorManager.getLoginPage(driver);
		String loginPageUrl = loginPage.getLoginPageUrl();

		// Data input

		email = "automation" + randomNumber() + "@gmail.com";
		customerName = "Automation Testing";
		gender = "male";
		dateOfBirth = "1987-05-25";
		address = "PO Box 911 Duis Avenue";
		city = "Tampa";
		state = "FL";
		pin = "466250";
		mobileNumber = "4555787965";

		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailTextbox(email);
		registerPage.clickToSubmitButton();

		userID = registerPage.getUserIDValue();
		password = registerPage.getPasswordValue();
		log.info("User ID is ------------" + userID);
		log.info("Password is ------------" + password);

//		loginPage = registerPage.openLoginPage(loginPageUrl);
//
//		loginPage.inputUserIDTextbox(userID);
//		loginPage.inputPasswordTextbox(password);
//		homePage = loginPage.clickToLoginButton();
//
//		wellComeMsg = homePage.getWellcomeMsg();
//		log.info("Wellcome message: -------------" + wellComeMsg);
//		verifyEquals(wellComeMsg, "Welcome To Manager's Page of Guru99 Bank");
//		verifyTrue(homePage.isUserIDDisplayed(userID));
//		
//		homePage.clickToBankGuruMenuLinkByName(driver, "New Customer");
//		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);
//
//		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", customerName);
//		newCustomerPage.clickToBankGuruRadioButtonByValue(driver, "m");
//
//		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", dateOfBirth);
//		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", address);
//
//		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", city);
//		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", state);
//		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", pin);
//		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", mobileNumber);
//		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", email);
//		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", password);
//
//		newCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");
//
//		verifyEquals(newCustomerPage.getBankGuruHeaderText(driver), "Customer Registered Successfully!!!");
//		customerID = newCustomerPage.getBankGuruTextByRowName(driver, "Customer ID");
//		log.info("Register Message is : ------------------------------" + newCustomerPage.getBankGuruHeaderText(driver));
//		log.info("Customer ID is : ------------------" + customerID);
//
//		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Customer Name"), customerName);
//		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Gender"), gender);
//		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Birthdate"), dateOfBirth);
//		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Address"), address);
//		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "City"), city);
//		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "State"), state);
//		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Pin"), pin);
//		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Mobile No."), mobileNumber);
//		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Email"), email);
		driver.quit();
	}

	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	//private HomePageObject homePage;
	//private NewCustomerPageObject newCustomerPage;

}
