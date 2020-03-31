package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.liveguru.LoginPageUI;

public class LoginPageObject extends AbstractPages{
	WebDriver driver;
	
	public LoginPageObject (WebDriver _driver) {
		driver = _driver;
	}

	public void inputToEmailTextbox(String emailValue) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailValue);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordValue);
		
	}

	public MyAccountPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return new MyAccountPageObject(driver);
	}

	public boolean isRequiredEmailErrorMsgDisplayed(String errorMessage) {
		waitForElementVisible(driver, String.format(LoginPageUI.EMAIL_REQUIRED_ERROR_MSG, errorMessage));
		return isElementDisplayed(driver, String.format(LoginPageUI.EMAIL_REQUIRED_ERROR_MSG, errorMessage));
	}

	public boolean isRequiredPasswordErrorMsgDisplayed(String errorMessage) {
		waitForElementVisible(driver, String.format(LoginPageUI.PASSWORD_REQUIRED_ERROR_MSG, errorMessage));
		return isElementDisplayed(driver, String.format(LoginPageUI.PASSWORD_REQUIRED_ERROR_MSG, errorMessage));
	}

	public boolean isValidationEmailErrorMsgDisplayed(String errorMessage) {
		waitForElementVisible(driver, String.format(LoginPageUI.EMAIL_VALIDATION_ERROR_MSG, errorMessage));
		return isElementDisplayed(driver, String.format(LoginPageUI.EMAIL_VALIDATION_ERROR_MSG, errorMessage));
	}

	public boolean isErrorMsgDisplayed(String errorMessage) {
		waitForElementVisible(driver, String.format(LoginPageUI.LOGIN_ERROR_MSG, errorMessage));
		return isElementDisplayed(driver, String.format(LoginPageUI.LOGIN_ERROR_MSG, errorMessage));
	}

	public boolean isValidationPasswordErrorMsgDisplayed(String errorMessage) {
		waitForElementVisible(driver, String.format(LoginPageUI.PASSWORD_VALIDATION_ERROR_MSG, errorMessage));
		return isElementDisplayed(driver, String.format(LoginPageUI.PASSWORD_VALIDATION_ERROR_MSG, errorMessage));
	}


}
