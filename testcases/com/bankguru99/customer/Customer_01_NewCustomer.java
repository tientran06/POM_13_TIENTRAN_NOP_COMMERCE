package com.bankguru99.customer;

import org.testng.annotations.Test;

import com.bankguru99.common.Common_01_CreateNewCustomer;

import commons.AbstractTest;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.NewCustomerPageObject;
import pageObjects.bankguru.PageGeneratorManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Customer_01_NewCustomer extends AbstractTest {

	private WebDriver driver;
	private String email, email1, customerName, dateOfBirth, address, city, state, pin, mobileNumber, password, gender;
	private String wellComeMsg;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(@Optional("chrome") String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		loginPage = PageGeneratorManager.getLoginPage(driver);

		// Data input

		email = "automation" + randomNumber() + "@gmail.com";
		email1 = "Selenium" + randomNumber() + "@hotmail.com";
		customerName = "Automation Testing";
		gender = "male";
		dateOfBirth = "1987-05-25";

		address = "PO Box 911 Duis Avenue";
		city = "Tampa";
		state = "FL";
		pin = "466250";
		mobileNumber = "4555787965";
		password = "123456";

		// Pre-condition
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.inputUserIDTextbox(Common_01_CreateNewCustomer.userID);
		loginPage.inputPasswordTextbox(Common_01_CreateNewCustomer.password);
		homePage = loginPage.clickToLoginButton();

		wellComeMsg = homePage.getWellcomeMsg();
		log.info("Wellcome message: -------------" + wellComeMsg);
		verifyEquals(wellComeMsg, "Welcome To Manager's Page of Guru99 Bank");
		verifyTrue(homePage.isUserIDDisplayed(Common_01_CreateNewCustomer.userID));
	}

	@BeforeMethod
	public void beforeMethod() {
		homePage.clickToBankGuruMenuLinkByName(driver, "New Customer");
		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);
	}

	@Test(description = "Verify that Name / Address / City / State / Pin / Telephone / Email can not be empty")
	public void TC_01_CreateNewCustomerWithEmptyValue() {
		log.info("TC_01_CreateNewCustomerWithEmptyValue - Step 01 : Input empty value in all fields");

		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", "");

		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", "");
		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", "");

		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", "");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", "");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", "");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", "");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", "");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", "");

		log.info("TC_01_CreateNewCustomerWithEmptyValue - Step 02 : Click 'Submit' button");
		newCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_01_CreateNewCustomerWithEmptyValue - Step 03: Verify Alert's messaged is displayed and accept it");
		verifyTrue(newCustomerPage.verifyBankGuruAlertTextandAcceptAlert(driver, "please fill all fields"));

		log.info("TC_01_CreateNewCustomerWithEmptyValue - Step 04 : Verify validations message is displayed");

		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message"), "Customer name must not be blank");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message24"), "Date Field must not be blank");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message3"), "Address Field must not be blank");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message4"), "City Field must not be blank");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message5"), "State must not be blank");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message6"), "PIN Code must not be blank");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message7"), "Mobile no must not be blank");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message9"), "Email-ID must not be blank");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message18"), "Password must not be blank");
	}

	@Test(description = "Verify that Name / City / State can not be numberic")
	public void TC_02_CreateNewCustomerWithNumbericValue() {
		log.info("Input value with CHARACTER + NUMBERIC --------------------------------------------------------------");

		log.info("TC_02_CreateNewCustomerWithNumbericValue - Step 01 : Input 'character' + 'numberric' value in NAME field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", "automation12345");

		log.info("TC_02_CreateNewCustomerWithNumbericValue - Step 02 : Input valid value in other fieds");
		newCustomerPage.clickToBankGuruRadioButtonByValue(driver, "m");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", dateOfBirth);
		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", address);

		log.info("TC_02_CreateNewCustomerWithNumbericValue - Step 03 : input 'character' + 'numberric' value in CITY field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", "city12345");

		log.info("TC_02_CreateNewCustomerWithNumbericValue - Step 04 : Input 'character' + 'numberric' value in STATE field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", "state12345");

		log.info("TC_02_CreateNewCustomerWithNumbericValue - Step 05 : Input valid value in other fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", pin);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", mobileNumber);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", email);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", password);

		log.info("TC_02_CreateNewCustomerWithNumbericValue - Step 06 : Click to 'Submit' button");
		newCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_02_CreateNewCustomerWithNumbericValue - Step 07 : Verify alert's message is displayed and accept it");
		verifyTrue(newCustomerPage.verifyBankGuruAlertTextandAcceptAlert(driver, "please fill all fields"));

		log.info("TC_02_CreateNewCustomerWithNumbericValue - Step 08 : Verify Validation message displayed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message"), "Numbers are not allowed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message4"), "Numbers are not allowed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message5"), "Numbers are not allowed");

		log.info("Input value with NUMBERIC --------------------------------------------------------------");
		newCustomerPage.refresh(driver);
		log.info("TC_02_CreateNewCustomerWithNumbericValue - Step 09 : Input 'numberric' value in NAME field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", "123456");

		log.info("TC_02_CreateNewCustomerWithNumbericValue - Step 10 : Input valid value in other fieds");
		newCustomerPage.clickToBankGuruRadioButtonByValue(driver, "m");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", dateOfBirth);
		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", address);

		log.info("TC_02_CreateNewCustomerWithNumbericValue - Step 11 : input 'numberric' value in CITY field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", "345672");

		log.info("TC_02_CreateNewCustomerWithNumbericValue - Step 12 : Input 'numberric' value in STATE field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", "111111");

		log.info("TC_02_CreateNewCustomerWithNumbericValue - Step 13 : Input valid value in other fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", pin);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", mobileNumber);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", email);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", password);

		log.info("TC_02_CreateNewCustomerWithNumbericValue - Step 14 : Click to 'Submit' button");
		newCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_02_CreateNewCustomerWithNumbericValue - Step 15 : Verify alert's message is displayed and accept it");
		verifyTrue(newCustomerPage.verifyBankGuruAlertTextandAcceptAlert(driver, "please fill all fields"));

		log.info("TC_02_CreateNewCustomerWithNumbericValue - Step 16 : Verify Validation message displayed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message"), "Numbers are not allowed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message4"), "Numbers are not allowed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message5"), "Numbers are not allowed");
	}

	@Test(description = "Verify that Name / City / State / PIN  can not have special character")
	public void TC_03_CreateNewCustomerWithSpecialCharacterValue() {
		log.info("Input value with CHARACTER + SPECIAL CHARACTER --------------------------------------------------------------");

		log.info("TC_03_CreateNewCustomerWithSpecialCharacterValue - Step 01 : Input Character + Special Character Value in NAME field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", "automation@!#$");

		log.info("TC_03_CreateNewCustomerWithSpecialCharacterValue - Step 02 : Input valid Value in other fields");
		newCustomerPage.clickToBankGuruRadioButtonByValue(driver, "m");

		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", dateOfBirth);
		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", address);

		log.info("TC_03_CreateNewCustomerWithSpecialCharacterValue - Step 03 : Input Character + Special Character Value in CITY | STATE | PIN  field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", "city!@#$%");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", "state!@#$%");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", "1!@#$%");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", mobileNumber);

		log.info("TC_03_CreateNewCustomerWithSpecialCharacterValue - Step 04 : Input valid Value in other fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", email);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", password);

		log.info("TC_03_CreateNewCustomerWithSpecialCharacterValue - Step 05 : Click to 'Submit' button");
		newCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_03_CreateNewCustomerWithSpecialCharacterValue - Step 06 : Verify alert's message is displayed and accept it");
		verifyTrue(newCustomerPage.verifyBankGuruAlertTextandAcceptAlert(driver, "please fill all fields"));

		log.info("TC_03_CreateNewCustomerWithSpecialCharacterValue - Step 07 : Verify Validation message displayed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message"), "Special characters are not allowed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message4"), "Special characters are not allowed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message5"), "Special characters are not allowed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message6"), "Special characters are not allowed");

		log.info("Input value with SPECIAL CHARACTER --------------------------------------------------------------");
		newCustomerPage.refresh(driver);
		log.info("TC_03_CreateNewCustomerWithSpecialCharacterValue - Step 08 : Input Special Character Value in NAME field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", "@!#$$%^&");

		log.info("TC_03_CreateNewCustomerWithSpecialCharacterValue - Step 09 : Input valid Value in other fields");
		newCustomerPage.clickToBankGuruRadioButtonByValue(driver, "m");

		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", dateOfBirth);
		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", address);

		log.info("TC_03_CreateNewCustomerWithSpecialCharacterValue - Step 10 : Special Character Value in CITY | STATE | PIN  field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", "!@#$%");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", "!@#$%");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", "@!@#$%");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", mobileNumber);

		log.info("TC_03_CreateNewCustomerWithSpecialCharacterValue - Step 11 : Input valid Value in other fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", email);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", password);

		log.info("TC_03_CreateNewCustomerWithSpecialCharacterValue - Step 12 : Click to 'Submit' button");
		newCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_03_CreateNewCustomerWithSpecialCharacterValue - Step 13 : Verify alert's message is displayed and accept it");
		verifyTrue(newCustomerPage.verifyBankGuruAlertTextandAcceptAlert(driver, "please fill all fields"));

		log.info("TC_03_CreateNewCustomerWithSpecialCharacterValue - Step 14 : Verify Validation message displayed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message"), "Special characters are not allowed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message4"), "Special characters are not allowed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message5"), "Special characters are not allowed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message6"), "Special characters are not allowed");
	}

	@Test(description = "Verify that Telephone can not have special character")
	public void TC_04_CreateNewCustomerWithSpecialCharacterValueInTelephoneField() {

		log.info("TC_04_CreateNewCustomerWithSpecialCharacterValueInTelephoneField - Step 01 : Input valid Value in other fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", customerName);
		newCustomerPage.clickToBankGuruRadioButtonByValue(driver, "m");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", dateOfBirth);
		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", address);

		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", city);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", state);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", pin);

		log.info("TC_04_CreateNewCustomerWithSpecialCharacterValueInTelephoneField - Step 02 : Input Special Character Value in Phone field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", "!@#45678915");

		log.info("TC_04_CreateNewCustomerWithSpecialCharacterValueInTelephoneField - Step 03 : Input valid Value in other fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", email);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", password);

		log.info("TC_04_CreateNewCustomerWithSpecialCharacterValueInTelephoneField - Step 04 : Verify Validation message displayed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message7"), "Special characters are not allowed");

		log.info("TC_04_CreateNewCustomerWithSpecialCharacterValueInTelephoneField - Step 05 : Input Special Character Value in Phone field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", "12345$#@795");
		log.info("TC_04_CreateNewCustomerWithSpecialCharacterValueInTelephoneField - Step 06 : Verify Validation message displayed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message7"), "Special characters are not allowed");

		log.info("TC_04_CreateNewCustomerWithSpecialCharacterValueInTelephoneField - Step 07 : Input Special Character Value in Phone field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", "1234567*&^%");
		log.info("TC_04_CreateNewCustomerWithSpecialCharacterValueInTelephoneField - Step 08 : Verify Validation message displayed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message7"), "Special characters are not allowed");

		log.info("TC_04_CreateNewCustomerWithSpecialCharacterValueInTelephoneField - Step 09 : Click to 'Submit' button");
		newCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_04_CreateNewCustomerWithSpecialCharacterValueInTelephoneField - Step 10 : Verify alert's message is displayed and accept it");
		verifyTrue(newCustomerPage.verifyBankGuruAlertTextandAcceptAlert(driver, "please fill all fields"));
	}

	@Test(description = "Verify that Name / Address / City / State / PIN / Telephone can not have first character as blank space")
	public void TC_05_CreateNewCustomerWithFirstBlankSpaceValue() {

		log.info("TC_05_CreateNewCustomerWithFirstBlankSpaceValue - Step 01 : Input first character as Blank space in NAME field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", " ");

		log.info("TC_05_CreateNewCustomerWithFirstBlankSpaceValue - Step 02 : Click Gender and select Date of Birth");
		newCustomerPage.clickToBankGuruRadioButtonByValue(driver, "m");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", dateOfBirth);

		log.info("TC_05_CreateNewCustomerWithFirstBlankSpaceValue - Step 03 : Input first character as Blank space in ADDRESS field");
		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", " ");

		log.info("TC_05_CreateNewCustomerWithFirstBlankSpaceValue - Step 04 : Input first character as Blank space in CITY | STATE | PIN | PHONE fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", " ");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", " ");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", " ");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", " ");

		log.info("TC_05_CreateNewCustomerWithFirstBlankSpaceValue - Step 05 : Input valid value in other fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", email);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", password);

		log.info("TC_05_CreateNewCustomerWithFirstBlankSpaceValue - Step 06 : Click 'Submit' button");
		newCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_05_CreateNewCustomerWithFirstBlankSpaceValue - Step 07 : Verify alert's message is displayed and accept it");
		verifyTrue(newCustomerPage.verifyBankGuruAlertTextandAcceptAlert(driver, "please fill all fields"));

		log.info("TC_05_CreateNewCustomerWithFirstBlankSpaceValue - Step 08 : Verify Validation message displayed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message"), "First character can not have space");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message3"), "First character can not have space");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message4"), "First character can not have space");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message5"), "First character can not have space");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message6"), "First character can not have space");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message7"), "First character can not have space");
	}

	@Test(description = "Verify that PIN must be numberic")
	public void TC_06_CreateNewCustomerWithCharacterValue() {

		log.info("TC_06_CreateNewCustomerWithCharacterValue - Step 01 : Input valid value on required fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", customerName);
		newCustomerPage.clickToBankGuruRadioButtonByValue(driver, "m");

		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", dateOfBirth);
		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", address);

		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", city);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", state);

		log.info("TC_06_CreateNewCustomerWithCharacterValue - Step 02 : Input character value on PIN field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", "123PIN");

		log.info("TC_06_CreateNewCustomerWithCharacterValue - Step 03 : Input valid value on the other fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", mobileNumber);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", email);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", password);

		log.info("TC_06_CreateNewCustomerWithCharacterValue - Step 04 : Click to 'Submit button'");
		newCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_06_CreateNewCustomerWithCharacterValue - Step 05 : Verify alert's message is displayed and accept it");
		verifyTrue(newCustomerPage.verifyBankGuruAlertTextandAcceptAlert(driver, "please fill all fields"));

		log.info("TC_06_CreateNewCustomerWithCharacterValue - Step 06 : Verify Validation message displayed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message6"), "Characters are not allowed");

	}

	@Test(description = "Verify that PIN must have 6 digits")
	public void TC_07_CreateNewCustomerWithPinLessThan6Digits() {

		log.info("TC_07_CreateNewCustomerWithPinLessThan6Digits - Step 01 : Input valid value in required fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", customerName);
		newCustomerPage.clickToBankGuruRadioButtonByValue(driver, "m");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", dateOfBirth);
		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", address);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", city);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", state);

		log.info("TC_07_CreateNewCustomerWithPinLessThan6Digits - Step 02 : Input PIN with Less than 6 Digits");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", "1234");

		log.info("TC_07_CreateNewCustomerWithPinLessThan6Digits - Step 03 : Input valid value in other fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", mobileNumber);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", email);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", password);

		log.info("TC_07_CreateNewCustomerWithPinLessThan6Digits - Step 04 : Click to 'Submit' button");
		newCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_07_CreateNewCustomerWithPinLessThan6Digits - Step 05 : Verify alert's message is displayed and accept it");
		verifyTrue(newCustomerPage.verifyBankGuruAlertTextandAcceptAlert(driver, "please fill all fields"));

		log.info("TC_07_CreateNewCustomerWithPinLessThan6Digits - Step 06: Verify Validation mesage is displayed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message6"), "PIN Code must have 6 Digits");
	}

	@Test(description = "Verify that PIN must have 6 digits")
	public void TC_08_CreateNewCustomerWithPinMoreThan6Digits() {

		log.info("TC_08_CreateNewCustomerWithPinMoreThan6Digits - Step 01 : Input valid value in required fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", customerName);
		newCustomerPage.clickToBankGuruRadioButtonByValue(driver, "m");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", dateOfBirth);
		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", address);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", city);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", state);

		log.info("TC_08_CreateNewCustomerWithPinMoreThan6Digits - Step 02 : Input PIN with More than 6 Digits");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", "123454378");

		log.info("TC_08_CreateNewCustomerWithPinMoreThan6Digits - Step 03 : Input valid value in other fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", mobileNumber);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", email);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", password);

		log.info("TC_08_CreateNewCustomerWithPinMoreThan6Digits - Step 04 : Click to 'Submit' button");
		newCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_08_CreateNewCustomerWithPinMoreThan6Digits - Step 05: Verify Register successfully!!!");
		verifyEquals(newCustomerPage.getBankGuruHeaderText(driver), "Customer Registered Successfully!!!");

		log.info("TC_08_CreateNewCustomerWithPinMoreThan6Digits - Step 06: Verify all information is displayed correctly");
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Customer Name"), customerName);
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Gender"), gender);
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Birthdate"), dateOfBirth);
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Address"), address);
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "City"), city);
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "State"), state);
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Mobile No."), mobileNumber);
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Email"), email);

		log.info("TC_08_CreateNewCustomerWithPinMoreThan6Digits - Step 07: Verify that PIN is just recorded 6 Digits");
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Pin"), "123454");
	}

	@Test(description = "Verify that PIN / Telephone can not have Blank space")
	public void TC_09_CreateNewCustomerWithBlankSpaceValue() {

		log.info("TC_09_CreateNewCustomerWithBlankSpaceValue - Step 01 : Input valid value in required fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", customerName);
		newCustomerPage.clickToBankGuruRadioButtonByValue(driver, "m");

		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", dateOfBirth);
		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", address);

		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", city);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", state);

		log.info("TC_09_CreateNewCustomerWithBlankSpaceValue - Step 02 : Input PIN and Phone with blank space");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", "123 45");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", "123456 78910123");

		log.info("TC_09_CreateNewCustomerWithBlankSpaceValue - Step 03 : Input valid value in other fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", email);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", password);

		log.info("TC_09_CreateNewCustomerWithBlankSpaceValue - Step 04 : Click to 'Submit' button");
		newCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_09_CreateNewCustomerWithBlankSpaceValue - Step 05 : Verify alert's message is displayed and accept it");
		verifyTrue(newCustomerPage.verifyBankGuruAlertTextandAcceptAlert(driver, "please fill all fields"));

		log.info("TC_09_CreateNewCustomerWithBlankSpaceValue - Step 06 : Verify Validation message displayed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message6"), "Characters are not allowed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message7"), "Characters are not allowed");
	}

	@Test(description = "Verify that PIN / Telephone can not have Last blank space -------------------------FALSE ----->>>>> BUG")
	public void TC_10_CreateNewCustomerWithLastBlankSpaceValue() {

		log.info("TC_10_CreateNewCustomerWithLastBlankSpaceValue - Step 01 : Input valid value in required fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", customerName);
		newCustomerPage.clickToBankGuruRadioButtonByValue(driver, "m");

		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", dateOfBirth);
		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", address);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", city);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", state);

		log.info("TC_10_CreateNewCustomerWithLastBlankSpaceValue - Step 02 : Input PIN and Phone with last blank space");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", "12345 ");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", "12345678910123 ");

		log.info("TC_10_CreateNewCustomerWithLastBlankSpaceValue - Step 03 : Input valid value in other fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", email1);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", password);

		log.info("-------------------------------------- ******* BUG ******----------------------------------------------");

		log.info("TC_10_CreateNewCustomerWithLastBlankSpaceValue - Step 04 : Verify Validation message displayed");
		verifyFalse(newCustomerPage.isBankGuruValidationMsgUnDisplayed(driver, "message6"));
		verifyFalse(newCustomerPage.isBankGuruValidationMsgUnDisplayed(driver, "message7"));
		
	}

	@Test(description = "Verify that Email must be correct format")
	public void TC_11_CreateNewCustomerWithIncorrectEmail() {

		log.info("TC_11_CreateNewCustomerWithIncorrectEmail - Step 01 : Input valid value in required fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", customerName);
		newCustomerPage.clickToBankGuruRadioButtonByValue(driver, "m");

		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", dateOfBirth);
		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", address);

		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", city);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", state);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", pin);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", mobileNumber);

		log.info("TC_11_CreateNewCustomerWithIncorrectEmail - Step 02 : Input incorrect Email 1 in Email field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", "automation123@gmail");

		log.info("TC_11_CreateNewCustomerWithIncorrectEmail - Step 03 : Verify vadidation message is displayed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message9"), "Email-ID is not valid");

		log.info("TC_11_CreateNewCustomerWithIncorrectEmail - Step 04 : Input incorrect Email 2 in Email field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", "automation123");

		log.info("TC_11_CreateNewCustomerWithIncorrectEmail - Step 05 : Verify vadidation message is displayed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message9"), "Email-ID is not valid");

		log.info("TC_11_CreateNewCustomerWithIncorrectEmail - Step 06 : Input incorrect Email 3 in Email field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", "automation123@");

		log.info("TC_11_CreateNewCustomerWithIncorrectEmail - Step 07 : Verify vadidation message is displayed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message9"), "Email-ID is not valid");

		log.info("TC_11_CreateNewCustomerWithIncorrectEmail - Step 08 : Input incorrect Email 4 in Email field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", "automation123@.");

		log.info("TC_11_CreateNewCustomerWithIncorrectEmail - Step 09 : Verify vadidation message is displayed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message9"), "Email-ID is not valid");

		log.info("TC_11_CreateNewCustomerWithIncorrectEmail - Step 10 : Input incorrect Email 5 in Email field");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", "automation123gmail.com");

		log.info("TC_11_CreateNewCustomerWithIncorrectEmail - Step 11 : Verify vadidation message is displayed");
		verifyEquals(newCustomerPage.getBankGuruValidationMsgByID(driver, "message9"), "Email-ID is not valid");

		log.info("TC_11_CreateNewCustomerWithIncorrectEmail - Step 12 : Input valid password");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", password);

		log.info("TC_11_CreateNewCustomerWithIncorrectEmail - Step 13 : Click to 'Submit' button");
		newCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_11_CreateNewCustomerWithIncorrectEmail - Step 14 : Verify alert's message is displayed and accept it");
		verifyTrue(newCustomerPage.verifyBankGuruAlertTextandAcceptAlert(driver, "please fill all fields"));
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;

}
