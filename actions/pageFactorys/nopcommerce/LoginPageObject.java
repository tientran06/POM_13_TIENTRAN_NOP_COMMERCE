package pageFactorys.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;

public class LoginPageObject extends AbstractPageFactory{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver _driver){
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;
	
	@FindBys({
		@FindBy(xpath = "//span[@id = 'Email-error']"),
		@FindBy(xpath = "//span[text() = 'Please enter your email']")
	})
	private WebElement emailErrorMsg;
	
	@FindBys({
		@FindBy(xpath = "//span[@id = 'Email-error']"),
		@FindBy(xpath = "//span[text() = 'No customer account found']")
	})
	private WebElement validationErrorMsg;

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
		
	}

	public HomePageObject clickToLoginButton() {
		waitForElementVisible(driver, loginButton);
		clickToElement(driver, loginButton);
		return new HomePageObject(driver);
	}

	public boolean isEmptyEmailErrorMsgDisplayed() {
		waitForElementVisible(driver, emailErrorMsg);
		return isDisplayed(driver, emailErrorMsg);
	}

	public boolean isValidationErrorMsgDisplayed() {
		waitForElementVisible(driver, validationErrorMsg);
		return isDisplayed(driver, validationErrorMsg);
	}

	

	
}
