package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.nopcommerce.RegisterPageUI;

public class RegisterPageObject extends AbstractPages{
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver _driver){
		driver = _driver;
	}

	public void clickToMale() {
		waitForElementVisible(driver, RegisterPageUI.GENDER_MALE_RADIO);
		//waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
		
	}

	public void inputToFirstName(String firstNameValue) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstNameValue);
		
	}

	public void inputToLastName(String lastNameValue) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastNameValue);
		
	}

	public void selectDayDropDown(String expectedDay) {
		waitForElementPresence(driver, RegisterPageUI.DAY_DROPDOWN);
		selectDefaultDropdownList(driver, RegisterPageUI.DAY_DROPDOWN, expectedDay);
	}

	public void selectMonthDropDown(String expectedMonth) {
		waitForElementPresence(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectDefaultDropdownList(driver, RegisterPageUI.MONTH_DROPDOWN, expectedMonth);
		
	}

	public void selectYearDropDown(String expectedYear) {
		waitForElementPresence(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectDefaultDropdownList(driver, RegisterPageUI.YEAR_DROPDOWN, expectedYear);
		
	}

	public void inputToEmailTextbox(String emailValue) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailValue);
		
	}

	public void inputToCompanyTextbox(String companyName) {
		waitForElementVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, companyName);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMPASS_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRMPASS_TEXTBOX, confirmPassword);
		
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		
	}


	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	public boolean isValidationErrorMsgDisplayed(String errorMessage) {
		waitForElementVisible(driver, String.format(RegisterPageUI.REGISTER_VALIDATION_ERROR_MSG, errorMessage));
		return isElementDisplayed(driver, String.format(RegisterPageUI.REGISTER_VALIDATION_ERROR_MSG, errorMessage));
	}

	public boolean isValidationPasswordErrorMsgDisplayed(String errorMessage) {
		waitForElementVisible(driver, String.format(RegisterPageUI.VALIDATION_PASSWORD_ERROR_MSG, errorMessage));
		return isElementDisplayed(driver, String.format(RegisterPageUI.VALIDATION_PASSWORD_ERROR_MSG, errorMessage));
	}

	public boolean isValidationConfirmPasswordErrorMsgDisplayed(String errorMessage) {
		waitForElementVisible(driver, String.format(RegisterPageUI.VALIDATION_CONFIRM_PASSWORD_ERROR_MSG, errorMessage));
		return isElementDisplayed(driver, String.format(RegisterPageUI.VALIDATION_CONFIRM_PASSWORD_ERROR_MSG, errorMessage));
	}

	public boolean isEmailErrorMsgDisplayed(String errorMessage) {
		waitForElementVisible(driver, String.format(RegisterPageUI.EMAIL_ERROR_MSG, errorMessage));
		return isElementDisplayed(driver, String.format(RegisterPageUI.EMAIL_ERROR_MSG, errorMessage));
	}

	public boolean isResultMsgDisplayed(String errorMessage) {
		waitForElementVisible(driver, String.format(RegisterPageUI.REGISTER_ERROR_MSG, errorMessage));
		return isElementDisplayed(driver, String.format(RegisterPageUI.REGISTER_ERROR_MSG, errorMessage));
	}

	public boolean isRegisterSuccessMsgDisplayed(String expectedMessage) {
		waitForElementVisible(driver, String.format(RegisterPageUI.REGISTER_SUCCESS_MSG, expectedMessage));
		return isElementDisplayed(driver, String.format(RegisterPageUI.REGISTER_SUCCESS_MSG, expectedMessage));
	}

	public boolean isFirstNameDisplayed() {
		String locator = "//input[@id = 'FirstName']";
		waitForElementVisible(driver, locator);
		return isElementDisplayed(driver, locator);
	}

	public boolean isRequestVerificationUndisplayed() {
		String locator = "//input[@name = '__RequestVerificationToken']";
		waitForElementInvisible(driver, locator);
		return isElementUnDisplayed(driver, locator);
	}

	public boolean isButtonRegisterDisplayed() {
		String locator = "//input[@class = 'button-1 register-button']";
		waitForElementInvisible(driver, locator);
		return isElementDisplayed(driver, locator);
	}

	public boolean isButtonRegisterUnDisplayed() {
		String locator = "//input[@class = 'button-1 register-button']";
		waitForElementInvisible(driver, locator);
		return isElementUnDisplayed(driver, locator);
	}


}
