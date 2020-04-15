package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.bankguru.HomePageUI;

public class HomePageObject extends AbstractPages{
	WebDriver driver;
	
	public HomePageObject(WebDriver _driver){
		driver = _driver;
	}
	public boolean isUserIDDisplayed(String userID) {
		waitForElementVisible(driver, HomePageUI.MANAGER_ID, userID);
		return isElementDisplayed(driver, HomePageUI.MANAGER_ID, userID);
	}
	public String getWellcomeMsg() {
		waitForElementVisible(driver, HomePageUI.WELLCOME_MSG);
		return getTextElement(driver,  HomePageUI.WELLCOME_MSG);
	}
}
