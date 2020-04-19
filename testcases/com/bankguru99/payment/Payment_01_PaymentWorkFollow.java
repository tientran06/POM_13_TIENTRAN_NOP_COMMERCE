package com.bankguru99.payment;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.bankguru.BalanceEnquiryPageObject;
import pageObjects.bankguru.DeleteAccountPageObject;
import pageObjects.bankguru.DeleteCustomerPageObject;
import pageObjects.bankguru.DepositPageObject;
import pageObjects.bankguru.EditAccountPageObject;
import pageObjects.bankguru.EditCustomerPageObject;
import pageObjects.bankguru.FundTransferPageObject;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.NewAccountPageObject;
import pageObjects.bankguru.NewCustomerPageObject;
import pageObjects.bankguru.PageGeneratorManager;
import pageObjects.bankguru.RegisterPageObject;
import pageObjects.bankguru.WithdrawalPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Payment_01_PaymentWorkFollow extends AbstractTest {

	private WebDriver driver;
	private String email, customerName, dateOfBirth, address, city, state, pin, mobileNumber, password, gender;
	private int initDeposit1, initDeposit2, depositAmount, withdrawalAmount, transferAmount, currentAmount;
	private String editAddress, editcity, editstate, editpin, editmobileNumber, editemail;
	private String wellComeMsg, customerID, account1ID, account2ID;

	@Parameters({ "browser", "url" })
	@BeforeTest
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

		initDeposit1 = 50000;
		initDeposit2 = 100000;
		depositAmount = 2000;
		withdrawalAmount = 20000;
		transferAmount = 5000;

		// Edit data

		editAddress = "5432 New Dehi";
		editcity = "Ho Chi Minh";
		editstate = "HCM";
		editpin = "400255";
		editmobileNumber = "9007787965";
		editemail = "selenium" + randomNumber() + "@gmail.com";

		// Pre-condition

		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailTextbox(email);
		registerPage.clickToSubmitButton();

		String userID = registerPage.getUserIDValue();
		password = registerPage.getPasswordValue();
		log.info("User ID is ------------" + userID);
		log.info("Password is ------------" + password);

		loginPage = registerPage.openLoginPage(loginPageUrl);

		loginPage.inputUserIDTextbox(userID);
		loginPage.inputPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();

		// Verify login successfully
		wellComeMsg = homePage.getWellcomeMsg();
		log.info("Wellcome message: -------------" + wellComeMsg);
		verifyEquals(wellComeMsg, "Welcome To Manager's Page of Guru99 Bank");
		verifyTrue(homePage.isUserIDDisplayed(userID));
	}

	@Test(description = "Create New Customer and verify customer registered successfully")
	public void TC_01_CreateNewCustomer() {
		
		log.info("TC_01_CreateNewCustomer - Step 01: Click to 'New Customer' link");
		homePage.clickToBankGuruMenuLinkByName(driver, "New Customer");
		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);

		log.info("TC_01_CreateNewCustomer - Step 02: input value in all fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", customerName);
		newCustomerPage.clickToBankGuruRadioButtonByValue(driver, "m");

		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", dateOfBirth);
		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", address);

		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", city);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", state);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", pin);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", mobileNumber);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", email);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", password);

		log.info("TC_01_CreateNewCustomer - Step 03: Click to 'Submit' button");
		newCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_01_CreateNewCustomer - Step 04: Verify Register successfully!!!");
		verifyEquals(newCustomerPage.getBankGuruHeaderText(driver), "Customer Registered Successfully!!!");
		
		log.info("TC_01_CreateNewCustomer - Step 05: Verify all information is displayed correctly");
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Customer Name"), customerName);
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Gender"), gender);
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Birthdate"), dateOfBirth);
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Address"), address);
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "City"), city);
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "State"), state);
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Pin"), pin);
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Mobile No."), mobileNumber);
		verifyEquals(newCustomerPage.getBankGuruTextByRowName(driver, "Email"), email);
		
		log.info("TC_01_CreateNewCustomer - Step 06: Get 'Customer ID'");
		customerID = newCustomerPage.getBankGuruTextByRowName(driver, "Customer ID");
		log.info("Customer ID is : ------------------" + customerID);

	}

	@Test(description = "Edit Customer and verify edited successfully", dependsOnMethods = "TC_01_CreateNewCustomer")
	public void TC_02_EditCustomer() {
		log.info("TC_02_EditCustomer - Step 01 : Click to 'Edit Customer' link");
		newCustomerPage.clickToBankGuruMenuLinkByName(driver, "Edit Customer");
		editCustomerPage = PageGeneratorManager.getEditCustomerPage(driver);

		log.info("TC_02_EditCustomer - Step 02 : Input 'Customer ID'");
		editCustomerPage.inputToBankGuruTextboxByName(driver, "cusid", customerID);
		
		log.info("TC_02_EditCustomer - Step 03 : Click to 'Submit' button");
		editCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_02_EditCustomer - Step 04 : Verify information can not edit - Disable");
		verifyFalse(editCustomerPage.isBankGuruTextboxEnabledByName(driver, "name"));
		verifyFalse(editCustomerPage.isBankGuruTextboxEnabledByName(driver, "gender"));
		verifyFalse(editCustomerPage.isBankGuruTextboxEnabledByName(driver, "dob"));

		log.info("TC_02_EditCustomer - Step 05 : Verify information can edit - Enable");
		verifyTrue(editCustomerPage.isBankGuruTextboxEnabledByName(driver, "city"));
		verifyTrue(editCustomerPage.isBankGuruTextboxEnabledByName(driver, "state"));

		log.info("TC_02_EditCustomer - Step 06 : Input information in Edit's enable fields");
		editCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", editAddress);
		editCustomerPage.inputToBankGuruTextboxByName(driver, "city", editcity);
		editCustomerPage.inputToBankGuruTextboxByName(driver, "state", editstate);
		editCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", editpin);
		editCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", editmobileNumber);
		editCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", editemail);

		log.info("TC_02_EditCustomer - Step 07 : Click to 'Submit' button");
		editCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_02_EditCustomer - Step 08 : Verify Customer detail updated successfully");
		verifyEquals(editCustomerPage.getBankGuruHeaderText(driver), "Customer details updated Successfully!!!");
		
		log.info("TC_02_EditCustomer - Step 09 : Verify all information is displayed correctly after editing");
		verifyEquals(editCustomerPage.getBankGuruTextByRowName(driver, "Customer ID"), customerID);
		verifyEquals(editCustomerPage.getBankGuruTextByRowName(driver, "Customer Name"), customerName);
		verifyEquals(editCustomerPage.getBankGuruTextByRowName(driver, "Gender"), gender);
		verifyEquals(editCustomerPage.getBankGuruTextByRowName(driver, "Birthdate"), dateOfBirth);
		verifyEquals(editCustomerPage.getBankGuruTextByRowName(driver, "Address"), editAddress);
		verifyEquals(editCustomerPage.getBankGuruTextByRowName(driver, "City"), editcity);
		verifyEquals(editCustomerPage.getBankGuruTextByRowName(driver, "State"), editstate);
		verifyEquals(editCustomerPage.getBankGuruTextByRowName(driver, "Pin"), editpin);
		verifyEquals(editCustomerPage.getBankGuruTextByRowName(driver, "Mobile No."), editmobileNumber);
		verifyEquals(editCustomerPage.getBankGuruTextByRowName(driver, "Email"), editemail);
	}

	@Test(description = "Create a new Accound and verify created successfully", dependsOnMethods = "TC_02_EditCustomer")
	public void TC_03_CreateNewAccount() {

		log.info("Create Account 1");
		log.info("TC_03_CreateNewAccount - Step 01 : Click to 'New Account' link");
		editCustomerPage.clickToBankGuruMenuLinkByName(driver, "New Account");
		newAccountPage = PageGeneratorManager.getNewAccountPage(driver);

		log.info("TC_03_CreateNewAccount - Step 02 : Input information in all fields");
		newAccountPage.inputToBankGuruTextboxByName(driver, "cusid", customerID);
		newAccountPage.selectBankGuruDropDownByValue(driver, "selaccount", "Current");
		newAccountPage.inputToBankGuruTextboxByName(driver, "inideposit", initDeposit1);
		
		log.info("TC_03_CreateNewAccount - Step 03 : Click to 'Submit' button");
		newAccountPage.clickToBankGuruButtonByValue(driver, "submit");

		
		log.info("TC_03_CreateNewAccount - Step 04 : Verify Created New account 1 successfully");
		verifyEquals(newAccountPage.getBankGuruHeaderText(driver), "Account Generated Successfully!!!");
		
		log.info("TC_03_CreateNewAccount - Step 05 : Verify all information is displayed correctly");
		verifyEquals(newAccountPage.getBankGuruTextByRowName(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getBankGuruTextByRowName(driver, "Customer Name"), customerName);
		verifyEquals(newAccountPage.getBankGuruTextByRowName(driver, "Email"), editemail);
		verifyEquals(newAccountPage.getBankGuruTextByRowName(driver, "Account Type"), "Current");
		verifyEquals(newAccountPage.getBankGuruTextByRowName(driver, "Date of Opening"), getToday());

		currentAmount = newAccountPage.getBankGuruNumberByRowName(driver, "Current Amount");
		verifyEquals(currentAmount, initDeposit1);
		
		log.info("TC_03_CreateNewAccount - Step 06 : Get 'Account 1 ID'");
		account1ID = newAccountPage.getBankGuruTextByRowName(driver, "Account ID");
		log.info("Account 1 ID is ----------------------------------------" + account1ID);
		log.info("Current Amount is ----------------------------------------" + currentAmount);

		
		log.info("Create Account 2");
		log.info("TC_03_CreateNewAccount - Step 07 : Click to 'New Account' link");
		newAccountPage.clickToBankGuruMenuLinkByName(driver, "New Account");

		log.info("TC_03_CreateNewAccount - Step 08 : Input information in all fields");
		newAccountPage.inputToBankGuruTextboxByName(driver, "cusid", customerID);
		newAccountPage.selectBankGuruDropDownByValue(driver, "selaccount", "Savings");
		newAccountPage.inputToBankGuruTextboxByName(driver, "inideposit", initDeposit2);
		
		log.info("TC_03_CreateNewAccount - Step 09 : Click to 'Submit' button");
		newAccountPage.clickToBankGuruButtonByValue(driver, "submit");

		log.info("TC_03_CreateNewAccount - Step 10 : Verify Created New account 2 successfully");
		verifyEquals(newAccountPage.getBankGuruHeaderText(driver), "Account Generated Successfully!!!");
		
		log.info("TC_03_CreateNewAccount - Step 11 : Verify all information is displayed correctly");
		verifyEquals(newAccountPage.getBankGuruTextByRowName(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getBankGuruTextByRowName(driver, "Customer Name"), customerName);
		verifyEquals(newAccountPage.getBankGuruTextByRowName(driver, "Email"), editemail);
		verifyEquals(newAccountPage.getBankGuruTextByRowName(driver, "Account Type"), "Savings");
		verifyEquals(newAccountPage.getBankGuruTextByRowName(driver, "Date of Opening"), getToday());

		currentAmount = newAccountPage.getBankGuruNumberByRowName(driver, "Current Amount");
		verifyEquals(currentAmount, initDeposit2);
		
		log.info("TC_03_CreateNewAccount - Step 12 : Get 'Account 2 ID'");
		account2ID = newAccountPage.getBankGuruTextByRowName(driver, "Account ID");
		log.info("Account 2 ID is ----------------------------------------" + account2ID);
		log.info("Current Amount is ----------------------------------------" + currentAmount);
	}

	@Test(description = "Edit account and verify edited successfully", dependsOnMethods = "TC_03_CreateNewAccount")
	public void TC_04_EditAccount() {
		
		log.info("TC_04_EditAccount - Step 01: Click to 'Edit Account' link");
		newAccountPage.clickToBankGuruMenuLinkByName(driver, "Edit Account");
		editAccountPage = PageGeneratorManager.getEditAccountPage(driver);

		log.info("TC_04_EditAccount - Step 02: input 'Account ID'");
		editAccountPage.inputToBankGuruTextboxByName(driver, "accountno", account1ID);
		
		log.info("TC_04_EditAccount - Step 03: Click to 'Submit' link");
		editAccountPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_04_EditAccount - Step 04: Verify information can not edit - Disable");
		verifyFalse(editAccountPage.isBankGuruTextboxEnabledByName(driver, "txtcid"));
		verifyFalse(editAccountPage.isBankGuruTextboxEnabledByName(driver, "txtinitdep"));

		log.info("TC_04_EditAccount - Step 05: Edit 'Account Type'");
		editAccountPage.selectBankGuruDropDownByValue(driver, "a_type", "Savings");
		
		log.info("TC_04_EditAccount - Step 06: Click 'Submit' button");
		editAccountPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_04_EditAccount - Step 07: Verify account details updated successfully");
		verifyEquals(editAccountPage.getBankGuruHeaderText(driver), "Account details updated Successfully!!!");
		
		log.info("TC_04_EditAccount - Step 08: Verify all information is displayed correctly");
		verifyEquals(editAccountPage.getBankGuruTextByRowName(driver, "Account ID"), account1ID);
		verifyEquals(editAccountPage.getBankGuruTextByRowName(driver, "Customer ID"), customerID);
		verifyEquals(editAccountPage.getBankGuruTextByRowName(driver, "Customer Name"), customerName);
		verifyEquals(editAccountPage.getBankGuruTextByRowName(driver, "Email"), editemail);
		verifyEquals(editAccountPage.getBankGuruTextByRowName(driver, "Account Type"), "Savings");
		verifyEquals(editAccountPage.getBankGuruTextByRowName(driver, "Date of Opening"), getToday());
		verifyEquals(editAccountPage.getBankGuruNumberByRowName(driver, "Current Amount"), initDeposit1);
	}

	@Test(description = "Deposit to current account and verify successfully", dependsOnMethods = "TC_04_EditAccount")
	public void TC_05_DepositToCurrentAccount() {
		int amountDeposited;
		
		log.info("TC_05_DepositToCurrentAccount - Step 01: Click to 'Deposit' link");
		editAccountPage.clickToBankGuruMenuLinkByName(driver, "Deposit");
		depositPage = PageGeneratorManager.getDepositPage(driver);

		log.info("TC_05_DepositToCurrentAccount - Step 02: input information in required fields");
		depositPage.inputToBankGuruTextboxByName(driver, "accountno", account1ID);
		depositPage.inputToBankGuruTextboxByName(driver, "ammount", depositAmount);
		depositPage.inputToBankGuruTextboxByName(driver, "desc", "DEPOSIT 1");
		
		log.info("TC_05_DepositToCurrentAccount - Step 03: Click to 'Submit' button");
		depositPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_05_DepositToCurrentAccount - Step 04: Verify Deposit successfully");
		verifyEquals(depositPage.getBankGuruHeaderText(driver), "Transaction details of Deposit for Account " + account1ID);
		
		log.info("TC_05_DepositToCurrentAccount - Step 05: Verify all information is displayed successfully");
		verifyEquals(depositPage.getBankGuruTextByRowName(driver, "Account No"), account1ID);
		verifyEquals(depositPage.getBankGuruTextByRowName(driver, "Type of Transaction"), "Deposit");

		amountDeposited = depositPage.getBankGuruNumberByRowName(driver, "Amount Credited");
		log.info("Amount Credited = ---------------------------------------------" + amountDeposited);
		verifyEquals(amountDeposited, depositAmount);

		currentAmount = depositPage.getBankGuruNumberByRowName(driver, "Current Balance");
		log.info("After deposit, amount = ---------------------------------------------" + currentAmount);
		verifyEquals(currentAmount, (initDeposit1 + depositAmount));
	}

	@Test(description = "Withdrawal money from current account", dependsOnMethods = "TC_05_DepositToCurrentAccount")
	public void TC_06_WithdrawalFromCurrentAccount() {
		int amountWithdrawal;
		log.info("TC_06_WithdrawalFromCurrentAccount - Step 01: Click to 'Withdrawal' link");
		depositPage.clickToBankGuruMenuLinkByName(driver, "Withdrawal");
		withdrawalPage = PageGeneratorManager.getWithdrawalPage(driver);

		// Withdrawal money from current account and verify
		log.info("TC_06_WithdrawalFromCurrentAccount - Step 02: input value in required fields");
		withdrawalPage.inputToBankGuruTextboxByName(driver, "accountno", account1ID);
		withdrawalPage.inputToBankGuruTextboxByName(driver, "ammount", withdrawalAmount);
		withdrawalPage.inputToBankGuruTextboxByName(driver, "desc", "Withdrawal");
		
		log.info("TC_06_WithdrawalFromCurrentAccount - Step 03: Click to 'Submit' button");
		withdrawalPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_06_WithdrawalFromCurrentAccount - Step 04: Verify Withdrawal successfully");
		verifyEquals(withdrawalPage.getBankGuruHeaderText(driver), "Transaction details of Withdrawal for Account " + account1ID);
		
		log.info("TC_06_WithdrawalFromCurrentAccount - Step 05: Verify all informaiton displayed correctly");
		verifyEquals(withdrawalPage.getBankGuruTextByRowName(driver, "Account No"), account1ID);
		verifyEquals(withdrawalPage.getBankGuruTextByRowName(driver, "Type of Transaction"), "Withdrawal");

		amountWithdrawal = withdrawalPage.getBankGuruNumberByRowName(driver, "Amount Debited");
		verifyEquals(amountWithdrawal, withdrawalAmount);
		log.info("Amount Debited is ------------------------------------------------" + amountWithdrawal);

		currentAmount = withdrawalPage.getBankGuruNumberByRowName(driver, "Current Balance");
		log.info("Current Balance is ------------------------------------------------" + currentAmount);
		verifyEquals(currentAmount, (initDeposit1 + depositAmount - withdrawalAmount));
	}

	@Test(description = "Transfer to Another Account and verify transfered successfully", dependsOnMethods = "TC_06_WithdrawalFromCurrentAccount")
	public void TC_07_TransferToAnotherAccount() {
		log.info("TC_07_TransferToAnotherAccount - Step 01 : Click 'Fund Transfer' link");
		withdrawalPage.clickToBankGuruMenuLinkByName(driver, "Fund Transfer");
		fundTransferPage = PageGeneratorManager.getFundTransferPage(driver);

		log.info("TC_07_TransferToAnotherAccount - Step 02 : input value in required fields");
		fundTransferPage.inputToBankGuruTextboxByName(driver, "payersaccount", account1ID);
		fundTransferPage.inputToBankGuruTextboxByName(driver, "payeeaccount", account2ID);
		fundTransferPage.inputToBankGuruTextboxByName(driver, "ammount", transferAmount);
		fundTransferPage.inputToBankGuruTextboxByName(driver, "desc", "Transfer");
		
		log.info("TC_07_TransferToAnotherAccount - Step 03 : Click 'Submit' button");
		fundTransferPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_07_TransferToAnotherAccount - Step 04 : Verify transfer successfully");
		verifyEquals(fundTransferPage.getBankGuruHeaderText(driver), "Fund Transfer Details");
		
		log.info("TC_07_TransferToAnotherAccount - Step 05 : Verify all information is displayed correctly");
		verifyEquals(fundTransferPage.getBankGuruTextByRowName(driver, "From Account Number"), account1ID);
		verifyEquals(fundTransferPage.getBankGuruTextByRowName(driver, "To Account Number"), account2ID);
		verifyEquals(fundTransferPage.getBankGuruNumberByRowName(driver, "Amount"), transferAmount);
		verifyEquals(fundTransferPage.getBankGuruTextByRowName(driver, "Description"), "Transfer");
	}

	@Test(description = "Check Account Balance after Deposit / Withdrawal / Transfer", dependsOnMethods = "TC_07_TransferToAnotherAccount")
	public void TC_08_CheckAccountBalance() {
		log.info("Balance inquiry account 1");
		log.info("TC_08_CheckAccountBalance - Step 01 : Click to 'Balance Enquiry' link");
		fundTransferPage.clickToBankGuruMenuLinkByName(driver, "Balance Enquiry");
		balanceEnquiryPage = PageGeneratorManager.getBalanceEnquiryPage(driver);

		log.info("TC_08_CheckAccountBalance - Step 02 : input 'Account ID'");
		balanceEnquiryPage.inputToBankGuruTextboxByName(driver, "accountno", account1ID);
		
		log.info("TC_08_CheckAccountBalance - Step 03 : Click to 'Submit' button");
		balanceEnquiryPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_08_CheckAccountBalance - Step 04 : Verify infomation of account is corrected");
		verifyEquals(balanceEnquiryPage.getBankGuruHeaderText(driver), "Balance Details for Account " + account1ID);
		verifyEquals(balanceEnquiryPage.getBankGuruTextByRowName(driver, "Account No"), account1ID);
		verifyEquals(balanceEnquiryPage.getBankGuruTextByRowName(driver, "Type of Account"), "Savings");
		log.info("Current Amount of Account " + account1ID + " Before Transfer is --------------------------" + currentAmount);

		verifyEquals(balanceEnquiryPage.getBankGuruNumberByRowName(driver, "Balance"), (currentAmount - transferAmount));
		log.info("Current Amount of Account " + account1ID + " After Transfer is --------------------------" + balanceEnquiryPage.getBankGuruNumberByRowName(driver, "Balance"));
		
		log.info("Balance inquiry account 2 ==================== BUG");
		log.info("TC_08_CheckAccountBalance - Step 05 : Click to 'Balance Enquiry' link");
		balanceEnquiryPage.clickToBankGuruMenuLinkByName(driver, "Balance Enquiry");

		log.info("TC_08_CheckAccountBalance - Step 06 : input 'Account ID'");
		balanceEnquiryPage.inputToBankGuruTextboxByName(driver, "accountno", account2ID);
		
		log.info("TC_08_CheckAccountBalance - Step 07 : Click to 'Submit' button");
		balanceEnquiryPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_08_CheckAccountBalance - Step 08 : Verify infomation of account is corrected");
		verifyEquals(balanceEnquiryPage.getBankGuruHeaderText(driver), "Balance Details for Account " + account2ID);
		verifyEquals(balanceEnquiryPage.getBankGuruTextByRowName(driver, "Account No"), account2ID);
		verifyEquals(balanceEnquiryPage.getBankGuruTextByRowName(driver, "Type of Account"), "Savings");

		verifyEquals(balanceEnquiryPage.getBankGuruNumberByRowName(driver, "Balance"), (initDeposit2 + transferAmount));
		log.info("Current Amount of Account " + account2ID + " After is transfered --------------------------" + balanceEnquiryPage.getBankGuruNumberByRowName(driver, "Balance"));
	}

	@Test(description = "Delete all Account", dependsOnMethods = "TC_08_CheckAccountBalance")
	public void TC_09_DeleteAllAccount() {
		log.info("TC_09_DeleteAllAccount - Step 01: Click to 'Delete Account' link");
		balanceEnquiryPage.clickToBankGuruMenuLinkByName(driver, "Delete Account");
		deleteAccountPage = PageGeneratorManager.getDeleteAccountPage(driver);

		log.info("Delete Account 1");
		log.info("TC_09_DeleteAllAccount - Step 02: input 'Account ID'");
		deleteAccountPage.inputToBankGuruTextboxByName(driver, "accountno", account1ID);
		
		log.info("TC_09_DeleteAllAccount - Step 03: Click to 'Submit' button");
		deleteAccountPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_09_DeleteAllAccount - Step 04: Verify Alert's text is displayed and accept it");
		verifyTrue(deleteAccountPage.verifyBankGuruAlertTextandAcceptAlert(driver, "Do you really want to delete this Account?"));

		log.info("TC_09_DeleteAllAccount - Step 05: Verify Alert's text is displayed and accept it");
		verifyTrue(deleteAccountPage.verifyBankGuruAlertTextandAcceptAlert(driver, "Account Deleted Sucessfully"));

		log.info("Verify Delete successfully");
		log.info("TC_09_DeleteAllAccount - Step 06: Click to 'Delete Account' link");
		deleteAccountPage.clickToBankGuruMenuLinkByName(driver, "Delete Account");
		
		log.info("TC_09_DeleteAllAccount - Step 07: input 'Account ID'");
		deleteAccountPage.inputToBankGuruTextboxByName(driver, "accountno", account1ID);
		
		log.info("TC_09_DeleteAllAccount - Step 08: Click to 'Submit' button");
		deleteAccountPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		log.info("TC_09_DeleteAllAccount - Step 09: Verify Alert's text is displayed and accept it");
		verifyTrue(deleteAccountPage.verifyBankGuruAlertTextandAcceptAlert(driver, "Do you really want to delete this Account?"));
		
		log.info("TC_09_DeleteAllAccount - Step 10: Verify Alert's text is displayed and accept it");
		verifyTrue(deleteAccountPage.verifyBankGuruAlertTextandAcceptAlert(driver, "Account does not exist"));

		log.info("Delete Account 2");
		log.info("TC_09_DeleteAllAccount - Step 11: input 'Account ID'");
		deleteAccountPage.inputToBankGuruTextboxByName(driver, "accountno", account2ID);
		
		log.info("TC_09_DeleteAllAccount - Step 12: Click to 'Submit' button");
		deleteAccountPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("TC_09_DeleteAllAccount - Step 13: Verify Alert's text is displayed and accept it");
		verifyTrue(deleteAccountPage.verifyBankGuruAlertTextandAcceptAlert(driver, "Do you really want to delete this Account?"));

		log.info("TC_09_DeleteAllAccount - Step 14: Verify Alert's text is displayed and accept it");
		verifyTrue(deleteAccountPage.verifyBankGuruAlertTextandAcceptAlert(driver, "Account Deleted Sucessfully"));

		log.info("Verify Delete successfully");
		log.info("TC_09_DeleteAllAccount - Step 15: Click to 'Delete Account' link");
		deleteAccountPage.clickToBankGuruMenuLinkByName(driver, "Delete Account");
		
		log.info("TC_09_DeleteAllAccount - Step 16: input 'Account ID'");
		deleteAccountPage.inputToBankGuruTextboxByName(driver, "accountno", account2ID);
		
		log.info("TC_09_DeleteAllAccount - Step 17: Click to 'Submit' button");
		deleteAccountPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		log.info("TC_09_DeleteAllAccount - Step 18: Verify Alert's text is displayed and accept it");
		verifyTrue(deleteAccountPage.verifyBankGuruAlertTextandAcceptAlert(driver, "Do you really want to delete this Account?"));
		
		log.info("TC_09_DeleteAllAccount - Step 19: Verify Alert's text is displayed and accept it");
		verifyTrue(deleteAccountPage.verifyBankGuruAlertTextandAcceptAlert(driver, "Account does not exist"));
	}

	@Test(description = "Delete Customer", dependsOnMethods = "TC_09_DeleteAllAccount")
	public void TC_10_DeleteCustomer() {
		log.info("TC_10_DeleteCustomer - Step 01 : Click to 'Delete Customer' link");
		deleteAccountPage.clickToBankGuruMenuLinkByName(driver, "Delete Customer");
		deleteCustomerPage = PageGeneratorManager.getDeleteCustomerPage(driver);
		
		log.info("TC_10_DeleteCustomer - Step 02 : input 'Customer ID'");
		deleteCustomerPage.inputToBankGuruTextboxByName(driver, "cusid", customerID);
		
		log.info("TC_10_DeleteCustomer - Step 03 : Click to 'Submit' button");
		deleteCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		log.info("TC_10_DeleteCustomer - Step 04 : Verify Alert's text is displayed and accept it");
		verifyTrue(deleteCustomerPage.verifyBankGuruAlertTextandAcceptAlert(driver, "Do you really want to delete this Customer?"));
		
		log.info("TC_10_DeleteCustomer - Step 05 : Verify Alert's text is displayed and accept it");
		verifyTrue(deleteCustomerPage.verifyBankGuruAlertTextandAcceptAlert(driver, "Customer deleted Successfully"));
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Verify Delete successfully");
		log.info("TC_10_DeleteCustomer - Step 06 : Click to 'Delete Customer' link");
		homePage.clickToBankGuruMenuLinkByName(driver, "Delete Customer");
		deleteCustomerPage = PageGeneratorManager.getDeleteCustomerPage(driver);
		
		log.info("TC_10_DeleteCustomer - Step 07 : input 'Customer ID'");
		deleteCustomerPage.inputToBankGuruTextboxByName(driver, "cusid", customerID);
		
		log.info("TC_10_DeleteCustomer - Step 08 : Click to 'Submit' button");
		deleteCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		log.info("TC_10_DeleteCustomer - Step 09 : Verify Alert's text is displayed and accept it");
		verifyTrue(deleteCustomerPage.verifyBankGuruAlertTextandAcceptAlert(driver, "Do you really want to delete this Customer?"));
		
		log.info("TC_10_DeleteCustomer - Step 10 : Verify Alert's text is displayed and accept it");
		verifyTrue(deleteCustomerPage.verifyBankGuruAlertTextandAcceptAlert(driver, "Customer does not exist!!"));
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editCustomerPage;
	private NewAccountPageObject newAccountPage;
	private EditAccountPageObject editAccountPage;
	private DepositPageObject depositPage;
	private WithdrawalPageObject withdrawalPage;
	private FundTransferPageObject fundTransferPage;
	private BalanceEnquiryPageObject balanceEnquiryPage;
	private DeleteAccountPageObject deleteAccountPage;
	private DeleteCustomerPageObject deleteCustomerPage;

}
