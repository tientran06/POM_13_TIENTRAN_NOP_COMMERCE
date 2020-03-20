package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.nopcommerce.HomePageUI;
import pageUIs.nopcommerce.SiteMapUI;

public class SitemapPageObject extends AbstractPages{
	private WebDriver driver;
	
	public SitemapPageObject(WebDriver _driver){
		driver = _driver;
	}
	

}
