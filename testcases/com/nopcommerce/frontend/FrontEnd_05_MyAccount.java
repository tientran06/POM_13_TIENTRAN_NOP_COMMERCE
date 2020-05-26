package com.nopcommerce.frontend;

import com.nopcommerce.common.Common_01_RegisterUser;

import commons.AbstractTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.MyAccountPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class FrontEnd_05_MyAccount extends AbstractTest {

	private WebDriver driver;
	private String email, password, newPassword, editFirstName, editLastName, editDate, editMonth, editYear, editCompany, editEmail;
	private String country, state, city, address1, address2, zipCode, phoneNumber, faxNumber;
	// private String editEmail;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);

		email = Common_01_RegisterUser.email; 
		password = Common_01_RegisterUser.password;
		newPassword = "123678";
		// Edit data
		editFirstName = "Anna";
		editLastName = "Julies";
		editDate = "2";
		editMonth = "June";
		editYear = "1990";
		editEmail = "automation_FC" + randomNumber() + "@gmail.com";
		editCompany = "Selenium Testing Company";

		// Address data
		country = "United States";
		state = "Alabama";
		city = "NEW YORK";
		address1 = "1307 NEW YORK A";
		address2 = "4550 WASHINTON";
		zipCode = "456764";
		phoneNumber = "0983456732";
		faxNumber = "0281113333";

		// Pre - condition
		homePage.clickToHeaderLinkPagesByName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.inputToNopCommerceTextboxByID(driver, "Email", email);
		loginPage.inputToNopCommerceTextboxByID(driver, "Password", password);
		loginPage.clickToNopCommerceButtonByValue(driver, "Log in");

		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.clickToHeaderLinkPagesByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
	}

	@Test()
	public void TC_01_UpdateCustomerInformation() {
		log.info("TC_01_UpdateCustomerInformation - Step 01 : Click to Listbox Menu 'Customer Infor'");
		myAccountPage.clickToNopCommerceListBoxMenuByClass(driver, "customer-info");

		log.info("TC_01_UpdateCustomerInformation - Step 02 : Click Radio button");
		myAccountPage.clickToNopCommerceRadioButtonByID(driver, "gender-female");

		log.info("TC_01_UpdateCustomerInformation - Step 03 : Input new value in FirstName and LastName");
		myAccountPage.inputToNopCommerceTextboxByID(driver, "FirstName", editFirstName);
		myAccountPage.inputToNopCommerceTextboxByID(driver, "LastName", editLastName);

		log.info("TC_01_UpdateCustomerInformation - Step 04 : Select Date of Birth");
		myAccountPage.selectNopCommerceDropdownByName(driver, "DateOfBirthDay", editDate);
		myAccountPage.selectNopCommerceDropdownByName(driver, "DateOfBirthMonth", editMonth);
		myAccountPage.selectNopCommerceDropdownByName(driver, "DateOfBirthYear", editYear);

		log.info("TC_01_UpdateCustomerInformation - Step 05 : Input new value in Email and Company");
		myAccountPage.inputToNopCommerceTextboxByID(driver, "Email", editEmail);
		myAccountPage.inputToNopCommerceTextboxByID(driver, "Company", editCompany);

		log.info("TC_01_UpdateCustomerInformation - Step 06 : Click 'Save' button");
		myAccountPage.clickToNopCommerceButtonByValue(driver, "Save");

		log.info("TC_01_UpdateCustomerInformation - Step 07 : Verify information is correct after updating information");
		verifyEquals(myAccountPage.getNopCommerceAttributeValueByID(driver, "FirstName"), editFirstName);
		verifyEquals(myAccountPage.getNopCommerceAttributeValueByID(driver, "LastName"), editLastName);
		verifyEquals(myAccountPage.getNopCommerceAttributeValueByID(driver, "Email"), editEmail);
		verifyEquals(myAccountPage.getNopCommerceAttributeValueByID(driver, "Company"), editCompany);

		verifyTrue(myAccountPage.isDropdownSelectedByText(driver, "DateOfBirthDay", editDate));
		verifyTrue(myAccountPage.isDropdownSelectedByText(driver, "DateOfBirthMonth", editMonth));
		verifyTrue(myAccountPage.isDropdownSelectedByText(driver, "DateOfBirthYear", editYear));
		verifyTrue(myAccountPage.isRadioButtonCheckedByID(driver, "gender-female"));
	}

	@Test(dependsOnMethods = "TC_01_UpdateCustomerInformation")
	public void TC_02_AddingNewAdddress() {
		log.info("TC_02_AddingNewAdddress - Step 01: Click to 'Addresses' link");
		myAccountPage.clickToNopCommerceListBoxMenuByClass(driver, "customer-addresses");

		log.info("TC_02_AddingNewAdddress - Step 02: Click to 'Add new' button");
		myAccountPage.clickToNopCommerceButtonByValue(driver, "Add new");

		log.info("TC_02_AddingNewAdddress - Step 03: input value in FirstName | LastName | Email | Company");
		myAccountPage.inputToNopCommerceTextboxByID(driver, "Address_FirstName", editFirstName);
		myAccountPage.inputToNopCommerceTextboxByID(driver, "Address_LastName", editLastName);
		myAccountPage.inputToNopCommerceTextboxByID(driver, "Address_Email", editEmail);
		myAccountPage.inputToNopCommerceTextboxByID(driver, "Address_Company", editCompany);

		log.info("TC_02_AddingNewAdddress - Step 04: Select 'Country' and 'State'");
		myAccountPage.selectNopCommerceDropdownByName(driver, "Address.CountryId", country);
		myAccountPage.selectNopCommerceDropdownByName(driver, "Address.StateProvinceId", state);

		log.info("TC_02_AddingNewAdddress - Step 05: input value in City | Address 1 | Address 2 | Zipcode | Phone | Fax");
		myAccountPage.inputToNopCommerceTextboxByID(driver, "Address_City", city);
		myAccountPage.inputToNopCommerceTextboxByID(driver, "Address_Address1", address1);
		myAccountPage.inputToNopCommerceTextboxByID(driver, "Address_Address2", address2);
		myAccountPage.inputToNopCommerceTextboxByID(driver, "Address_ZipPostalCode", zipCode);
		myAccountPage.inputToNopCommerceTextboxByID(driver, "Address_PhoneNumber", phoneNumber);
		myAccountPage.inputToNopCommerceTextboxByID(driver, "Address_FaxNumber", faxNumber);

		log.info("TC_02_AddingNewAdddress - Step 06: Click to 'Save' button");
		myAccountPage.clickToNopCommerceButtonByValue(driver, "Save");

		log.info("TC_02_AddingNewAdddress - Step 07: Verify adding new address successfully");
		verifyTrue(myAccountPage.isAddressAccountNameDisplayed(driver, editFirstName + " " + editLastName));

		verifyTrue(myAccountPage.isAddressInforDisplayedByClass(driver, "email", editEmail));
		verifyTrue(myAccountPage.isAddressInforDisplayedByClass(driver, "phone", phoneNumber));
		verifyTrue(myAccountPage.isAddressInforDisplayedByClass(driver, "fax", faxNumber));

		verifyEquals(myAccountPage.getAddressAccountInforByClass(driver, "company"), editCompany);
		verifyEquals(myAccountPage.getAddressAccountInforByClass(driver, "address1"), address1);
		verifyEquals(myAccountPage.getAddressAccountInforByClass(driver, "address2"), address2);
		verifyEquals(myAccountPage.getAddressAccountInforByClass(driver, "country"), country);

		verifyTrue(myAccountPage.getAddressAccountInforByClass(driver, "city-state-zip").contains(city));
		verifyTrue(myAccountPage.getAddressAccountInforByClass(driver, "city-state-zip").contains(state));
		verifyTrue(myAccountPage.getAddressAccountInforByClass(driver, "city-state-zip").contains(zipCode));
	}

	@Test(dependsOnMethods = "TC_02_AddingNewAdddress")
	public void TC_03_ChangePassword() {
		log.info("TC_03_ChangePassword - Step 01 : Click to 'Change Password' link");
		myAccountPage.clickToNopCommerceListBoxMenuByClass(driver, "change-password");
		
		log.info("TC_03_ChangePassword - Step 02 : Input 'Old Password' | 'New password' | Confirm new password");
		myAccountPage.inputToNopCommerceTextboxByID(driver, "OldPassword", password);
		myAccountPage.inputToNopCommerceTextboxByID(driver, "NewPassword", newPassword);
		myAccountPage.inputToNopCommerceTextboxByID(driver, "ConfirmNewPassword", newPassword);
		
		log.info("TC_03_ChangePassword - Step 03 : Click to 'Change Password' button");
		myAccountPage.clickToNopCommerceButtonByValue(driver, "Change password");
		
		log.info("TC_03_ChangePassword - Step 04 : Verify result message successfully is displayed");
		verifyTrue(myAccountPage.isResultMsgSuccessDisplayed(driver, "Password was changed"));
		
		log.info("TC_03_ChangePassword - Step 05 : Click to 'Log out' link");
		myAccountPage.clickToHeaderLinkPagesByName(driver, "Log out");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("TC_03_ChangePassword - Step 06 : Click to 'Log in' link");
		homePage.clickToHeaderLinkPagesByName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("TC_03_ChangePassword - Step 07 : Input email and old password");
		loginPage.inputToNopCommerceTextboxByID(driver, "Email", editEmail);
		loginPage.inputToNopCommerceTextboxByID(driver, "Password", password);
		
		log.info("TC_03_ChangePassword - Step 08 : Click to 'Log in' button");
		loginPage.clickToNopCommerceButtonByValue(driver, "Log in");
		
		log.info("TC_03_ChangePassword - Step 09 : Verify Result message unsuccessfully is displayed");
		verifyTrue(loginPage.isResultErrorMsgDisplayed("Login was unsuccessful. Please correct the errors and try again."));
		verifyTrue(loginPage.isResultErrorMsgDisplayed("The credentials provided are incorrect"));
		
		log.info("TC_03_ChangePassword - Step 10 : Click to 'Log in' link");
		loginPage.clickToHeaderLinkPagesByName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("TC_03_ChangePassword - Step 11 : Input email and new password");
		loginPage.inputToNopCommerceTextboxByID(driver, "Email", editEmail);
		loginPage.inputToNopCommerceTextboxByID(driver, "Password", newPassword);
		
		log.info("TC_03_ChangePassword - Step 11 : Click to 'Log in' button");
		loginPage.clickToNopCommerceButtonByValue(driver, "Log in");
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.sleepInSecond(driver,5);
		
		log.info("TC_03_ChangePassword - Step 12 : Verify log in successfully!");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private MyAccountPageObject myAccountPage;
}
