package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.RegisterPageObject;

public class PageGeneratorManager {
	
	// cap phat viec khoi tao cho doi tuong
	public static HomePageObject getHomePage(WebDriver driver){
		return new HomePageObject(driver);
	}
	public static RegisterPageObject getRegisterPage(WebDriver driver){
		return new RegisterPageObject(driver);
	}
	public static LoginPageObject getLoginPage(WebDriver driver){
		return new LoginPageObject(driver);
	}
}
