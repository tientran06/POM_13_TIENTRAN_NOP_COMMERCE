package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.bankguru.RegisterPageUI;

public class RegisterPageObject extends AbstractPages{
	WebDriver driver;
	
	public RegisterPageObject(WebDriver _driver){
		driver = _driver;
	}

	public void inputToEmailTextbox(String emailValue) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailValue);
		
	}

	public void clickToSubmitButton() {
		waitForElementClickable(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getUserIDValue() {
		waitForElementVisible(driver, RegisterPageUI.USERID_TEXTBOX);
		return getTextElement(driver, RegisterPageUI.USERID_TEXTBOX);
	}

	public String getPasswordValue() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		return getTextElement(driver, RegisterPageUI.PASSWORD_TEXTBOX);
	}

	public LoginPageObject openLoginPage(String loginPageUrl) {
		driver.get(loginPageUrl);
		return PageGeneratorManager.getLoginPage(driver);
	}

	
}
