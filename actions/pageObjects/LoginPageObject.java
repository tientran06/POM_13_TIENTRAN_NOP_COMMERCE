package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.LoginPageUI;

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
		return new HomePageObject(driver);
	}

	

	
}
