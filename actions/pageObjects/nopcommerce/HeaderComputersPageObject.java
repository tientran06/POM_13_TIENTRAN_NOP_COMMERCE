package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.nopcommerce.HomePageUI;

public class HeaderComputersPageObject extends AbstractPages{
	private WebDriver driver;
	
	public HeaderComputersPageObject(WebDriver _driver){
		driver = _driver;
	}

}
