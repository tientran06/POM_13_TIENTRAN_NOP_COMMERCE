package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.nopcommerce.SearchPageUI;

public class SearchPageObject extends AbstractPages{
	private WebDriver driver;
	
	public SearchPageObject(WebDriver _driver){
		driver = _driver;
	}

	
}
