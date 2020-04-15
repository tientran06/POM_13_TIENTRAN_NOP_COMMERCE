package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.nopcommerce.HomePageUI;

public class HeaderBooksPageObject extends AbstractPages{
	private WebDriver driver;
	
	public HeaderBooksPageObject(WebDriver _driver){
		driver = _driver;
	}

}
