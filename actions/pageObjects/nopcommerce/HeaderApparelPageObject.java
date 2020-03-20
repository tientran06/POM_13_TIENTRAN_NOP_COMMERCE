package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.nopcommerce.HomePageUI;

public class HeaderApparelPageObject extends AbstractPages{
	private WebDriver driver;
	
	public HeaderApparelPageObject(WebDriver _driver){
		driver = _driver;
	}

}
