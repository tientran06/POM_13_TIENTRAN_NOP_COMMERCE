package pageFactorys.nopcommerce;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;

public class RegisterPageObject extends AbstractPageFactory{
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver _driver){
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "gender-male")
	private WebElement genderMaleRadio;
	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;
	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;
	@FindBy(name = "DateOfBirthDay")
	private WebElement dateDropdownList;
	@FindBy(name = "DateOfBirthMonth")
	private WebElement monthDropdownList;
	@FindBy(name = "DateOfBirthYear")
	private WebElement yearDropdownList;
	@FindBy(id = "Email")
	private WebElement emailTextBox;
	@FindBy(id = "Company")
	private WebElement company;
	@FindBy(id = "Password")
	private WebElement passwordTextBox;
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextBox;
	@FindBy(id = "register-button")
	private WebElement registerButton;
	@FindBy(className = "ico-logout")
	private WebElement logoutLink;
	@FindBy(xpath = "//div[@class = 'result']")
	private WebElement registerSuccessMsg;
	

	public void clickToMale() {
		waitForElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
		
	}

	public void inputToFirstName(String firstNameValue) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstNameValue);
		
	}

	public void inputToLastName(String lastNameValue) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastNameValue);
		
	}

	public void selectDayDropDown(String expectedDay) {
		waitForElementVisible(driver, dateDropdownList);
		selectDefaultDropdownList(driver, dateDropdownList, expectedDay);
	}

	public void selectMonthDropDown(String expectedMonth) {
		waitForElementVisible(driver, monthDropdownList);
		selectDefaultDropdownList(driver, monthDropdownList, expectedMonth);
		
	}

	public void selectYearDropDown(String expectedYear) {
		waitForElementVisible(driver, yearDropdownList);
		selectDefaultDropdownList(driver, yearDropdownList, expectedYear);
		
	}

	public void inputToEmailTextbox(String emailValue) {
		waitForElementVisible(driver, emailTextBox);
		sendkeyToElement(driver, emailTextBox, emailValue);
		
	}

	public void inputToCompanyTextbox(String companyName) {
		waitForElementVisible(driver, company);
		sendkeyToElement(driver, company, companyName);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextBox);
		sendkeyToElement(driver, passwordTextBox, password);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextBox);
		sendkeyToElement(driver, confirmPasswordTextBox, confirmPassword);
		
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
		
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
		return new HomePageObject(driver);
	}


	public String getRegisterSuccessMsg() {
		waitForElementVisible(driver, registerSuccessMsg);
		return getTextElement(driver, registerSuccessMsg);
	}

}
	
