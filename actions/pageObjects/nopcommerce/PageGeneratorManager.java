package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

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
	public static HeaderDeskTopPageObject getHeaderDeskTopPage(WebDriver driver) {
		return new HeaderDeskTopPageObject(driver);
	}
}
