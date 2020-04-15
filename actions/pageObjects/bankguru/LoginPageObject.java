package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.bankguru.LoginPageUI;

public class LoginPageObject extends AbstractPages{
	WebDriver driver;
	
	public LoginPageObject(WebDriver _driver){
		driver = _driver;
	}

	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}

	public RegisterPageObject clickToHereLink() {
		waitForElementClickable(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public void inputUserIDTextbox(String userIDValue) {
		waitForElementVisible(driver, LoginPageUI.USERID_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERID_TEXTBOX, userIDValue);
		
	}

	public void inputPasswordTextbox(String passwordValue) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordValue);
		
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	
}
