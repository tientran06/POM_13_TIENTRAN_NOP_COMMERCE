package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.nopcommerce.HomePageUI;

public class HeaderGiftCardsPageObject extends AbstractPages{
	private WebDriver driver;
	
	public HeaderGiftCardsPageObject(WebDriver _driver){
		driver = _driver;
	}

}
