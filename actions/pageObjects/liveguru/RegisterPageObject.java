package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.liveguru.RegisterPageUI;

public class RegisterPageObject extends AbstractPages{
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver _driver) {
		driver = _driver;
	}

	public void inputToFirstNameTextbox(String firstNameValue) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstNameValue);
	}

	public void inputToLastNameTextbox(String lastNameValue) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastNameValue);
		
	}

	public void inputToEmailTextbox(String emailValue) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailValue);
		
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, passwordValue);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassValue) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_TEXTBOX, confirmPassValue);
	}

	public boolean isFirstNameRequiredErrorMsgDisplayed(String errorMsg) {
		waitForElementVisible(driver, String.format(RegisterPageUI.REQUIRED_FIRSTNAME_ERROR_MSG, errorMsg));
		return isElementDisplayed(driver, String.format(RegisterPageUI.REQUIRED_FIRSTNAME_ERROR_MSG, errorMsg));
	}

	public boolean isLastNameRequiredErrorMsgDisplayed(String errorMsg) {
		waitForElementVisible(driver, String.format(RegisterPageUI.REQUIRED_LASTNAME_ERROR_MSG, errorMsg));
		return isElementDisplayed(driver, String.format(RegisterPageUI.REQUIRED_LASTNAME_ERROR_MSG, errorMsg));
	}

	public boolean isEmailRequiredErrorMsgDisplayed(String errorMsg) {
		waitForElementVisible(driver, String.format(RegisterPageUI.REQUIRED_EMAILNAME_ERROR_MSG, errorMsg));
		return isElementDisplayed(driver, String.format(RegisterPageUI.REQUIRED_EMAILNAME_ERROR_MSG, errorMsg));
	}

	public boolean isPasswordRequiredErrorMsgDisplayed(String errorMsg) {
		waitForElementVisible(driver, String.format(RegisterPageUI.REQUIRED_PASSWORD_ERROR_MSG, errorMsg));
		return isElementDisplayed(driver, String.format(RegisterPageUI.REQUIRED_PASSWORD_ERROR_MSG, errorMsg));
	}

	public boolean isConfirmRequiredErrorMsgDisplayed(String errorMsg) {
		waitForElementVisible(driver, String.format(RegisterPageUI.REQUIRED_CONFIRM_PASSWORD_ERROR_MSG, errorMsg));
		return isElementDisplayed(driver, String.format(RegisterPageUI.REQUIRED_CONFIRM_PASSWORD_ERROR_MSG, errorMsg));
	}

	public boolean isEmailValidationErrorMsgDisplayed(String errorMsg) {
		waitForElementVisible(driver, String.format(RegisterPageUI.VALIDATION_EMAIL_ERROR_MSG, errorMsg));
		return isElementDisplayed(driver, String.format(RegisterPageUI.VALIDATION_EMAIL_ERROR_MSG, errorMsg));
		
	}

	public boolean isRegisterErrorMsgDisplayed(String errorMsg) {
		waitForElementVisible(driver, String.format(RegisterPageUI.REGISTER_ERROR_MSG, errorMsg));
		return isElementDisplayed(driver, String.format(RegisterPageUI.REGISTER_ERROR_MSG, errorMsg));
	}

	public boolean isPasswordValidationErrorMsgDisplayed(String errorMsg) {
		waitForElementVisible(driver, String.format(RegisterPageUI.VALIDATION_PASSWORD_ERROR_MSG, errorMsg));
		return isElementDisplayed(driver, String.format(RegisterPageUI.VALIDATION_PASSWORD_ERROR_MSG, errorMsg));
	}

	public boolean isConfirmPasswordValidationErrorMsgDisplayed(String errorMsg) {
		waitForElementVisible(driver, String.format(RegisterPageUI.VALIDATION_CONFIRM_PASSWORD_ERROR_MSG, errorMsg));
		return isElementDisplayed(driver, String.format(RegisterPageUI.VALIDATION_CONFIRM_PASSWORD_ERROR_MSG, errorMsg));
	}

	public MyAccountPageObject clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return new MyAccountPageObject(driver);
	}

}
