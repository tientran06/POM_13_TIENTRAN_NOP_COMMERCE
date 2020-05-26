package com.nopcommerce.login;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commons.AbstractTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Login_12_RegisterAndLogin_Assert_Verify_Log_Report extends AbstractTest {

	private WebDriver driver;
	SoftAssert soft;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	String email, passWord;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(@Optional("chrome") String browserName) {
		driver = getBrowserDriver(browserName);
		soft = new SoftAssert();

		// >> Home page
		homePage = PageGeneratorManager.getHomePage(driver);
		email = "automationFC" + randomNumber() + "@gmail.com";
		passWord = "123456";

	}

	@Test
	public void TC_01_Assert() {
		registerPage = homePage.clickToRegisterLink();

		// Assert True
		System.out.println("TC_01 - Step 01 : Check Element Displayed");
		checkTrue(isElementDisplayed("//input[@id='FirstName']"));

		// Assert False
		System.out.println("TC_01 - Step 02 : Check Element Undisplayed");
		checkTrue(isElementDisplayed("//input[@class='button-1 login-button']"));

		// Assert Equal
		System.out.println("TC_01 - Step 03 : Check text equal");
		checkEqual("Automation FC", "Automation testing");
		soft.assertAll();

	}

	@Test
	public void TC_02_Verify() {
		log.info("TC_02_Verify - Step 01 : Open to Login link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("TC_02_Verify - Step 02 : Input to Email textbox");
		loginPage.inputToEmailTextbox(email);
		
		log.info("TC_02_Verify - Step 03 : Input to Password textbox");
		loginPage.inputToPasswordTextbox(passWord);

		log.info("TC_02_Verify - Step 04 : Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("TC_02_Verify - Step 05 : Verify Login successfully");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	public boolean isElementDisplayed(String locator) {
		try {
			return driver.findElement(By.xpath(locator)).isDisplayed();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;

		}

	}

	public boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			soft.assertTrue(condition);
		} catch (Exception ex) {
			ex.printStackTrace();
			pass = false;
		}
		return pass;
	}

	public boolean checkEqual(Object actual, Object expected) {
		boolean pass = true;
		try {
			soft.assertEquals(actual, expected);
		} catch (Exception ex) {
			ex.printStackTrace();
			pass = false;
		}
		return pass;
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
