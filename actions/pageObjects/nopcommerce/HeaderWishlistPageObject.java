package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.nopcommerce.HomePageUI;

public class HeaderWishlistPageObject extends AbstractPages{
	private WebDriver driver;
	
	public HeaderWishlistPageObject(WebDriver _driver){
		driver = _driver;
	}

}
