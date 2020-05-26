package pageFactorys.nopcommerce;

import org.openqa.selenium.WebDriver;

import pageObjects.nopcommerce.HeaderDeskTopPageObject;
import pageObjects.nopcommerce.FooterMyAccountPageObject;
import pageObjects.nopcommerce.HeaderApparelPageObject;
import pageObjects.nopcommerce.HeaderBooksPageObject;
import pageObjects.nopcommerce.HeaderComputersPageObject;
import pageObjects.nopcommerce.HeaderGiftCardsPageObject;
import pageObjects.nopcommerce.HeaderWishlistPageObject;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.MyAccountPageObject;
import pageObjects.nopcommerce.RegisterPageObject;
import pageObjects.nopcommerce.SearchPageObject;
import pageObjects.nopcommerce.ShippingReturnPageObject;
import pageObjects.nopcommerce.SitemapPageObject;

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
	public static MyAccountPageObject getMyAccountPage(WebDriver driver){
		return new MyAccountPageObject(driver);
	}
	public static SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);
	}
	public static FooterMyAccountPageObject getFooterMyAccountPage(WebDriver driver) {
		return new FooterMyAccountPageObject(driver);
	}
	public static ShippingReturnPageObject getShippingPage(WebDriver driver) {
		return new ShippingReturnPageObject(driver);
	}
	public static SitemapPageObject getSitemapPage(WebDriver driver) {
		return new SitemapPageObject(driver);
	}
	public static HeaderWishlistPageObject getHeaderWishlistPage(WebDriver driver) {
		return new HeaderWishlistPageObject(driver);
	}
	public static HeaderComputersPageObject getHeaderComputerPage(WebDriver driver) {
		return new HeaderComputersPageObject(driver);
	}
	public static HeaderApparelPageObject getHeaderApparelPage(WebDriver driver) {
		return new HeaderApparelPageObject(driver);
	}
	public static HeaderBooksPageObject getHeaderBooksPage(WebDriver driver) {
		return new HeaderBooksPageObject(driver);
	}
	public static HeaderGiftCardsPageObject getHeaderGiftCardsPage(WebDriver driver) {
		return new HeaderGiftCardsPageObject(driver);
	}
	public static HeaderDeskTopPageObject getHeaderSubDeskTopPage(WebDriver driver) {
		return new HeaderDeskTopPageObject(driver);
	}
}
