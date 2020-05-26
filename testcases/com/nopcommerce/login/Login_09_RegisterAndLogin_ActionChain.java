package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopcommerce.FooterMyAccountPageObject;
import pageObjects.nopcommerce.HeaderWishlistPageObject;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
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

public class Login_09_RegisterAndLogin_ActionChain extends AbstractTest {

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

	@Test
	public void TC_03_ActionChain() {

		//1.Home Page > Search
		searchPage = homePage.openFooterSearchPage(driver);
		searchPage.sleepInSecond(driver,2);
		
		//2. Search > Shipping and Return
		shippingReturnPage = searchPage.openShippingReturnPage(driver);
		shippingReturnPage.sleepInSecond(driver,2);
		
		//3. Shipping and Return > Sitemap
		sitemapPage = shippingReturnPage.openSitemapPage(driver);
		sitemapPage.sleepInSecond(driver,2);
		
		//4. Sitemap > Footer My Account
		footerMyAccountPage = sitemapPage.openFooterMyAccountPage(driver);
		footerMyAccountPage.sleepInSecond(driver,2);
		
		//5. Home Page > Header Wishlist
		headerWishListPage = homePage.openHeaderWishlistPage(driver);
		headerWishListPage.sleepInSecond(driver,2);
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
