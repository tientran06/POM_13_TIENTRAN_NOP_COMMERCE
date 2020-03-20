package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.FooterMyAccountPageObject;
import pageObjects.nopcommerce.HeaderApparelPageObject;
import pageObjects.nopcommerce.HeaderBooksPageObject;
import pageObjects.nopcommerce.HeaderComputersPageObject;
import pageObjects.nopcommerce.HeaderGiftCardsPageObject;
import pageObjects.nopcommerce.HeaderWishlistPageObject;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.RegisterPageObject;
import pageObjects.nopcommerce.SearchPageObject;
import pageObjects.nopcommerce.ShippingReturnPageObject;
import pageObjects.nopcommerce.SitemapPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_10_RegisterAndLogin_DynamicLocator extends AbstractTest {

	private WebDriver driver;
	private String firstName, lastName, email, companyName, password, confirmPassword;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
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

		// Data input
		firstName = "Automation";
		lastName = "Testing";
		email = "automationFC" + randomNumber() + "@gmail.com";
		companyName = "Automation FC Ltd";
		password = "123456";
		confirmPassword = "123456";
	}

	@Test
	public void TC_01_RegisterToSystem() throws InterruptedException {
		// Click to Register >> Register page
		registerPage = homePage.clickToRegisterLink();
		// Register page >> input data
		registerPage.clickToMale();
		registerPage.inputToFirstName(firstName);
		registerPage.inputToLastName(lastName);

		registerPage.selectDayDropDown("2");
		registerPage.selectMonthDropDown("June");
		registerPage.selectYearDropDown("1922");

		registerPage.inputToEmailTextbox(email);
		registerPage.inputToCompanyTextbox(companyName);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);

		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isRegisterSuccessMsgDisplayed("Your registration completed"));
		// Click Log out link >> HomePage
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void TC_02_LoginToSystem() {
		// click to log in >> Login Page
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);

		// Click to Login button >> Home Page
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test(description = "only use in case less pages")
	public void TC_03_DymamicLocator_Less() {

		// 1.Home Page > Search
		searchPage = (SearchPageObject) homePage.openFooterPageByName(driver, "Search");
		searchPage.sleepInSecond(2);

		// 2. Search > Shipping and Return
		shippingReturnPage = (ShippingReturnPageObject) searchPage.openFooterPageByName(driver, "Shipping & returns");
		shippingReturnPage.sleepInSecond(2);

		// 3. Shipping and Return > Sitemap
		sitemapPage = (SitemapPageObject) shippingReturnPage.openFooterPageByName(driver, "Sitemap");
		sitemapPage.sleepInSecond(2);

		// 4. Sitemap > Footer My Account
		footerMyAccountPage = (FooterMyAccountPageObject) sitemapPage.openFooterPageByName(driver, "My account");
		footerMyAccountPage.sleepInSecond(2);
		
		// 5. Footer My Account > Home page
		homePage = footerMyAccountPage.openHomePage(driver);
		homePage.sleepInSecond(2);

		// 6. Home Page > Header Wishlist
		headerWishListPage = homePage.openHeaderWishlistPage(driver);
		headerWishListPage.sleepInSecond(2);
	}

	@Test(description = "only use in case more pages")
	public void TC_04_Dymamic_Footer_More() {
		// 1.Home Page > Search
		homePage.openFooterPagesByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		searchPage.sleepInSecond(2);

		// 2. Search > Shipping and Return
		searchPage.openFooterPagesByName(driver, "Shipping & returns");
		shippingReturnPage = PageGeneratorManager.getShippingPage(driver);
		shippingReturnPage.sleepInSecond(2);

		// 3. Shipping and Return > Sitemap
		shippingReturnPage.openFooterPageByName(driver, "Sitemap");
		sitemapPage = PageGeneratorManager.getSitemapPage(driver);
		sitemapPage.sleepInSecond(2);

		// 4. Sitemap > Footer My Account
		sitemapPage.openFooterPagesByName(driver, "My account");
		footerMyAccountPage = PageGeneratorManager.getFooterMyAccountPage(driver);
		footerMyAccountPage.sleepInSecond(2);
		// 5. Footer My Account > Home page
		homePage = footerMyAccountPage.openHomePage(driver);
		homePage.sleepInSecond(2);

		// 6. Home Page > Header Wishlist
		headerWishListPage = homePage.openHeaderWishlistPage(driver);
		headerWishListPage.sleepInSecond(2);
	}

	@Test(description = "only use in case more pages")
	public void TC_05_Dymamic_Header_More() {
		// 1.Home Page > Computers
		homePage.openHeaderPagesByName(driver, "Computers ");
		computersPage = PageGeneratorManager.getHeaderComputerPage(driver);
		computersPage.sleepInSecond(2);

		// 2. Computers > Apparel
		computersPage.openHeaderPagesByName(driver, "Apparel ");
		apparelPage = PageGeneratorManager.getHeaderApparelPage(driver);
		apparelPage.sleepInSecond(2);

		// 3. Apparel > GiftCards
		apparelPage.openHeaderPagesByName(driver, "Gift Cards ");
		giftCardsPage = PageGeneratorManager.getHeaderGiftCardsPage(driver);
		giftCardsPage.sleepInSecond(2);
		
		// 4. GiftCards > BooksPage
		giftCardsPage.openHeaderPagesByName(driver, "Books ");
		booksPage = PageGeneratorManager.getHeaderBooksPage(driver);
		booksPage.sleepInSecond(2);
		
		// 5. BooksPage > Homepage
		booksPage.openHomePage(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.sleepInSecond(2);

		// 6. Home Page > Header Wishlist
		headerWishListPage = homePage.openHeaderWishlistPage(driver);
		headerWishListPage.sleepInSecond(2);
	}

	public int randomNumber() {
		Random ran = new Random();
		return ran.nextInt(5000);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
