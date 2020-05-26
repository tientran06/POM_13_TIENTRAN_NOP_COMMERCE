package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.nopcommerce.MyAccountUI;

public class MyAccountPageObject extends AbstractPages{
	private WebDriver driver;
	
	public MyAccountPageObject(WebDriver _driver){
		driver = _driver;
	}

	public void clickToFemaleRadio() {
		waitForElementClickable(driver, MyAccountUI.GENDER_FEMALE_RADIO);
		clickToElement(driver, MyAccountUI.GENDER_FEMALE_RADIO);
		
	}

	public void inputToFirstName(String firstName) {
		waitForElementVisible(driver, MyAccountUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastName(String lastName) {
		waitForElementVisible(driver, MyAccountUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void selectDayDropDown(String expectedDay) {
		waitForElementVisible(driver, MyAccountUI.DAY_DROPDOWN);
		selectDefaultDropdownList(driver, MyAccountUI.DAY_DROPDOWN, expectedDay);
	}

	public void selectMonthDropDown(String expectedMonth) {
		waitForElementVisible(driver, MyAccountUI.MONTH_DROPDOWN);
		selectDefaultDropdownList(driver, MyAccountUI.MONTH_DROPDOWN, expectedMonth);
	}

	public void selectYearDropDown(String expectedYear) {
		waitForElementVisible(driver, MyAccountUI.YEAR_DROPDOWN);
		selectDefaultDropdownList(driver, MyAccountUI.YEAR_DROPDOWN, expectedYear);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, MyAccountUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, MyAccountUI.EMAIL_TEXTBOX, email);
	}

	public void inputToCompanyTextbox(String company) {
		waitForElementVisible(driver, MyAccountUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, MyAccountUI.COMPANY_TEXTBOX, company);
		
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, MyAccountUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountUI.SAVE_BUTTON);
	}

	public String getFirstNameValue() {
		waitForElementVisible(driver, MyAccountUI.FIRST_NAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getLastNameValue() {
		waitForElementVisible(driver, MyAccountUI.LAST_NAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getEmailValue() {
		waitForElementVisible(driver, MyAccountUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, MyAccountUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyValue() {
		waitForElementVisible(driver, MyAccountUI.COMPANY_TEXTBOX);
		return getAttributeValue(driver, MyAccountUI.COMPANY_TEXTBOX, "value");
	}

	public boolean isAddressAccountNameDisplayed(WebDriver driver, String accName) {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_ACCOUNT_NAME_INFOR, accName);
		return isElementDisplayed(driver, MyAccountUI.ADDRESS_ACCOUNT_NAME_INFOR, accName);
	}
	public String getAddressAccountInforByClass(WebDriver driver, String classValue) {
		waitForElementVisible(driver, MyAccountUI.DYNAMIC_ADDRESS_TEXT_INFOR, classValue);
		return getTextElement(driver, MyAccountUI.DYNAMIC_ADDRESS_TEXT_INFOR, classValue);
	}
	public boolean isAddressInforDisplayedByClass(WebDriver driver, String classValue, String textinfor) {
		waitForElementVisible(driver, MyAccountUI.DYNAMIC_ADDRESS_INFOR, classValue, textinfor);
		return isElementDisplayed(driver, MyAccountUI.DYNAMIC_ADDRESS_INFOR, classValue, textinfor);
	}
	public boolean isResultMsgSuccessDisplayed(WebDriver driver, String msgValue) {
		waitForElementVisible(driver, MyAccountUI.DYNAMIC_RESULT_MSG, msgValue);
		return isElementDisplayed(driver, MyAccountUI.DYNAMIC_RESULT_MSG, msgValue);
	}
}
