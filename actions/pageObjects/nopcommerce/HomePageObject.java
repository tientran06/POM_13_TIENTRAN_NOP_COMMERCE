package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.nopcommerce.HomePageUI;

public class HomePageObject extends AbstractPages{
	private WebDriver driver;
	
	public HomePageObject(WebDriver _driver){
		driver = _driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MYACCOUNT_LINK);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_LINK);
		
	}

	
}
