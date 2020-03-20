package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.nopcommerce.HomePageUI;

public class FooterMyAccountPageObject extends AbstractPages{
	private WebDriver driver;
	
	public FooterMyAccountPageObject(WebDriver _driver){
		driver = _driver;
	}


}
