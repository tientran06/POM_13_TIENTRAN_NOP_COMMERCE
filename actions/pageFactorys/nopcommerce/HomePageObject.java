package pageFactorys.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;

public class HomePageObject extends AbstractPageFactory{
	private WebDriver driver;
	
	public HomePageObject(WebDriver _driver){
		driver = _driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='ico-register']")
	private WebElement registerLink;
	@FindBy(how = How.XPATH, using = "//a[@class='ico-login']")
	private WebElement loginLink;
	@FindBy(how = How.CLASS_NAME, using = "ico-account")
	private WebElement myaccountLink;
	
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
		return new RegisterPageObject(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
		return new LoginPageObject(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, myaccountLink);
		return isDisplayed(driver, myaccountLink);
	}

}
