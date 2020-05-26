package com.nopcommerce.login;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_RegisterUser;

import commons.AbstractTest;
import pageObjects.nopcommerce.FooterMyAccountPageObject;
import pageObjects.nopcommerce.HeaderApparelPageObject;
import pageObjects.nopcommerce.HeaderBooksPageObject;
import pageObjects.nopcommerce.HeaderComputersPageObject;
import pageObjects.nopcommerce.HeaderGiftCardsPageObject;
import pageObjects.nopcommerce.HeaderWishlistPageObject;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.SearchPageObject;
import pageObjects.nopcommerce.ShippingReturnPageObject;
import pageObjects.nopcommerce.SitemapPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Login_10_RegisterAndLogin_DynamicLocator extends AbstractTest {

	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private SearchPageObject searchPage;
	private FooterMyAccountPageObject footerMyAccountPage;
	private ShippingReturnPageObject shippingReturnPage;
	private SitemapPageObject sitemapPage;
	private HeaderWishlistPageObject headerWishListPage;
	private HeaderApparelPageObject apparelPage;
	private HeaderBooksPageObject booksPage;
	private HeaderGiftCardsPageObject giftCardsPage;
	private HeaderComputersPageObject computersPage;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);

		// >> Home page
		homePage = PageGeneratorManager.getHomePage(driver);

		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(Common_01_RegisterUser.email);
		loginPage.inputToPasswordTextbox(Common_01_RegisterUser.password);

		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test(description = "only use in case less pages")
	public void TC_03_DymamicLocator_Less() {

		// 1.Home Page > Search
		searchPage = (SearchPageObject) homePage.openFooterPageByName(driver, "Search");
		searchPage.sleepInSecond(driver,2);

		// 2. Search > Shipping and Return
		shippingReturnPage = (ShippingReturnPageObject) searchPage.openFooterPageByName(driver, "Shipping & returns");
		shippingReturnPage.sleepInSecond(driver,2);

		// 3. Shipping and Return > Sitemap
		sitemapPage = (SitemapPageObject) shippingReturnPage.openFooterPageByName(driver, "Sitemap");
		sitemapPage.sleepInSecond(driver,2);

		// 4. Sitemap > Footer My Account
		footerMyAccountPage = (FooterMyAccountPageObject) sitemapPage.openFooterPageByName(driver, "My account");
		footerMyAccountPage.sleepInSecond(driver,2);

		// 5. Footer My Account > Home page
		homePage = footerMyAccountPage.openHomePage(driver);
		homePage.sleepInSecond(driver,2);

		// 6. Home Page > Header Wishlist
		headerWishListPage = homePage.openHeaderWishlistPage(driver);
		headerWishListPage.sleepInSecond(driver,2);
	}

	@Test(description = "only use in case more pages")
	public void TC_04_Dymamic_Footer_More() {
		// 1.Home Page > Search
		homePage.openFooterPagesByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		searchPage.sleepInSecond(driver,2);

		// 2. Search > Shipping and Return
		searchPage.openFooterPagesByName(driver, "Shipping & returns");
		shippingReturnPage = PageGeneratorManager.getShippingPage(driver);
		shippingReturnPage.sleepInSecond(driver,2);

		// 3. Shipping and Return > Sitemap
		shippingReturnPage.openFooterPageByName(driver, "Sitemap");
		sitemapPage = PageGeneratorManager.getSitemapPage(driver);
		sitemapPage.sleepInSecond(driver,2);

		// 4. Sitemap > Footer My Account
		sitemapPage.openFooterPagesByName(driver, "My account");
		footerMyAccountPage = PageGeneratorManager.getFooterMyAccountPage(driver);
		footerMyAccountPage.sleepInSecond(driver,2);
		// 5. Footer My Account > Home page
		homePage = footerMyAccountPage.openHomePage(driver);
		homePage.sleepInSecond(driver,2);

		// 6. Home Page > Header Wishlist
		headerWishListPage = homePage.openHeaderWishlistPage(driver);
		headerWishListPage.sleepInSecond(driver,2);
	}

	@Test(description = "only use in case more pages")
	public void TC_05_Dymamic_Header_More() {
		// 1.Home Page > Computers
		homePage.openHeaderMenuPagesByName(driver, "Computers ");
		computersPage = PageGeneratorManager.getHeaderComputerPage(driver);
		computersPage.sleepInSecond(driver,2);

		// 2. Computers > Apparel
		computersPage.openHeaderMenuPagesByName(driver, "Apparel ");
		apparelPage = PageGeneratorManager.getHeaderApparelPage(driver);
		apparelPage.sleepInSecond(driver,2);

		// 3. Apparel > GiftCards
		apparelPage.openHeaderMenuPagesByName(driver, "Gift Cards ");
		giftCardsPage = PageGeneratorManager.getHeaderGiftCardsPage(driver);
		giftCardsPage.sleepInSecond(driver,2);

		// 4. GiftCards > BooksPage
		giftCardsPage.openHeaderMenuPagesByName(driver, "Books ");
		booksPage = PageGeneratorManager.getHeaderBooksPage(driver);
		booksPage.sleepInSecond(driver,2);

		// 5. BooksPage > Homepage
		booksPage.openHomePage(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.sleepInSecond(driver,2);

		// 6. Home Page > Header Wishlist
		headerWishListPage = homePage.openHeaderWishlistPage(driver);
		headerWishListPage.sleepInSecond(driver,2);
	}
	@Test()
	public void TC_06_Close() {
		verifyTrue(false);
	}
	
	@AfterTest(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

}
