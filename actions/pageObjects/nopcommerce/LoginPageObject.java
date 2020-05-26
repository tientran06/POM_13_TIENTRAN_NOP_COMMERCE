package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.nopcommerce.LoginPageUI;

public class LoginPageObject extends AbstractPages{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver _driver){
		driver = _driver;
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public HomePageObject clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	public boolean isEmailErrorMsgDisplayed(String errorMessage) {
		waitForElementVisible(driver, String.format(LoginPageUI.EMAIL_ERROR_MSG, errorMessage));
		return isElementDisplayed(driver, String.format(LoginPageUI.EMAIL_ERROR_MSG, errorMessage));
	}

	public boolean isResultErrorMsgDisplayed(String errorMessage) {
		waitForElementVisible(driver, String.format(LoginPageUI.VALIDATION_ERROR_MSG, errorMessage));
		return isElementDisplayed(driver, String.format(LoginPageUI.VALIDATION_ERROR_MSG, errorMessage));
	}

	
}
