package com.nopcommerce.login;

import org.testng.annotations.Test;


import commons.AbstractTest;
import pageObjects.nopcommerce.HeaderDeskTopPageObject;
import pageObjects.nopcommerce.HeaderApparelPageObject;
import pageObjects.nopcommerce.HeaderBooksPageObject;
import pageObjects.nopcommerce.HeaderComputersPageObject;
import pageObjects.nopcommerce.HeaderGiftCardsPageObject;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Login_13_RegisterAndLogin_DynamicElement extends AbstractTest {

	private WebDriver driver;
	private String firstName, lastName, email, companyName, password, confirmPassword;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HeaderApparelPageObject apparelPage;
	private HeaderBooksPageObject booksPage;
	private HeaderGiftCardsPageObject giftCardsPage;
	private HeaderComputersPageObject computersPage;
	private HeaderDeskTopPageObject desktopPage;

	@Parameters({"browser","url"})
	@BeforeTest
	public void beforeTest(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

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
	public void TC_01_RegisterToSystem() {
		// Click to Register >> Register page
		homePage.clickToHeaderLinkPagesByName(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		// Register page >> input First name / Last name
		registerPage.clickToNopCommerceRadioButtonByID(driver, "gender-female");
		registerPage.inputToNopCommerceTextboxByID(driver, "FirstName", firstName);
		registerPage.inputToNopCommerceTextboxByID(driver, "LastName", lastName);
		
		// Select Date of Birth
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthDay", "2");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthMonth", "June");
		registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthYear", "1987");

		// Input Email / company / pass
		registerPage.inputToNopCommerceTextboxByID(driver, "Email", email);
		registerPage.inputToNopCommerceTextboxByID(driver, "Company", companyName);
		registerPage.inputToNopCommerceTextboxByID(driver, "Password", password);
		registerPage.inputToNopCommerceTextboxByID(driver, "ConfirmPassword", confirmPassword);
		
		registerPage.clickToNopCommerceButtonByValue(driver, "Register");
		verifyTrue(registerPage.isRegisterSuccessMsgDisplayed("Your registration completed"));
		
		// Click Log out link >> HomePage
		registerPage.clickToHeaderLinkPagesByName(driver, "Log out");
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_02_LoginToSystem() {
		// click to log in >> Login Page
		homePage.clickToHeaderLinkPagesByName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.inputToNopCommerceTextboxByID(driver, "Email", email);
		loginPage.inputToNopCommerceTextboxByID(driver, "Password", password);

		// Click to Login button >> Home Page
		loginPage.clickToNopCommerceButtonByValue(driver, "Log in");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		//Verify log in successfully
		verifyTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test(description = "only use in case more pages")
	public void TC_03_Dymamic_Header_Menu_More() {
		// 1.Home Page > Computers
		homePage.openHeaderMenuPagesByName(driver, "Computers");
		computersPage = PageGeneratorManager.getHeaderComputerPage(driver);
		computersPage.sleepInSecond(driver,2);

		// 2. Computers > Apparel
		computersPage.openHeaderMenuPagesByName(driver, "Apparel");
		apparelPage = PageGeneratorManager.getHeaderApparelPage(driver);
		apparelPage.sleepInSecond(driver,2);

		// 3. Apparel > GiftCards
		apparelPage.openHeaderMenuPagesByName(driver, "Gift Cards");
		giftCardsPage = PageGeneratorManager.getHeaderGiftCardsPage(driver);
		giftCardsPage.sleepInSecond(driver,2);

		// 4. GiftCards > BooksPage
		giftCardsPage.openHeaderMenuPagesByName(driver, "Books");
		booksPage = PageGeneratorManager.getHeaderBooksPage(driver);
		booksPage.sleepInSecond(driver,2);

		// 5. BooksPage > Homepage
		booksPage.openHomePage(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.sleepInSecond(driver,2);
	}
	@Test(description = "only use in case more pages")
		public void TC_04_Dymamic_Header_Sub_Menu_More() {
			// 1.Home Page > Computers >> Desktops
			homePage.openHeaderSubMenuPagesByName(driver, "Computers", "Desktops");
			desktopPage = PageGeneratorManager.getHeaderDeskTopPage(driver);
			desktopPage.sleepInSecond(driver,2);

			// 2. Computers > Apparel
			desktopPage.openHeaderSubMenuPagesByName(driver, "Apparel", "Clothing");
			apparelPage = PageGeneratorManager.getHeaderApparelPage(driver);
			apparelPage.sleepInSecond(driver,2);
		}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

}
