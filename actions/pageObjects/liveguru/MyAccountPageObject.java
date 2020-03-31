package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.liveguru.MyAccountPageUI;

public class MyAccountPageObject extends AbstractPages {

	WebDriver driver;

	public MyAccountPageObject(WebDriver _driver) {
		driver = _driver;
	}

	public boolean isWellcomeMsgDisplayed(String expectedText) {
		waitForElementVisible(driver, String.format(MyAccountPageUI.ACCOUNT_WELLCOME_TEXT, expectedText));
		return isElementDisplayed(driver, String.format(MyAccountPageUI.ACCOUNT_WELLCOME_TEXT, expectedText));
	}

	public boolean isAccountEmailDisplayed(String expectedEmail) {
		waitForElementVisible(driver, String.format(MyAccountPageUI.ACCOUNT_EMAIL_TEXT, expectedEmail));
		return isElementDisplayed(driver, String.format(MyAccountPageUI.ACCOUNT_EMAIL_TEXT, expectedEmail));
	}

	public boolean isAccountNameDisplayed(String expectedText) {
		waitForElementVisible(driver, String.format(MyAccountPageUI.ACCOUNT_NAME_TEXT, expectedText));
		return isElementDisplayed(driver, String.format(MyAccountPageUI.ACCOUNT_NAME_TEXT, expectedText));
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, MyAccountPageUI.ACCOUNT_LINK);
		clickToElement(driver, MyAccountPageUI.ACCOUNT_LINK);
		waitForElementClickable(driver, MyAccountPageUI.LOGOUT_LINK);
		clickToElement(driver, MyAccountPageUI.LOGOUT_LINK);
		return new HomePageObject(driver);
	}

	public boolean isRegisterSuccessMsgDisplayed(String expectedText) {
		waitForElementVisible(driver, String.format(MyAccountPageUI.ACCOUNT_REGISTER_SUCCESS_MSG, expectedText));
		return isElementDisplayed(driver, String.format(MyAccountPageUI.ACCOUNT_REGISTER_SUCCESS_MSG, expectedText));
	}

	

}
