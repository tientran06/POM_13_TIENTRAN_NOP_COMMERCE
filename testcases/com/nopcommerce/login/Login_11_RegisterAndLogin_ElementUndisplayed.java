package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_11_RegisterAndLogin_ElementUndisplayed extends AbstractTest {

	private WebDriver driver;
	private WebElement element;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);

		// >> Home page
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
	}

	//@Test
	public void TC_01_Check_Displayed() {

		startTime();
		//Assert.assertTrue(isElementDisplayed("//input[@id = 'FirstName']"));
		Assert.assertFalse(isElementUnDisplayed("//input[@id = 'FirstName']"));
		endTime();

	}

	//@Test
	public void TC_02_Check_UnDisplayed_In_DOM() {
		startTime();
		//Assert.assertFalse(isElementDisplayed("//input[@name = '__RequestVerificationToken']"));
		Assert.assertTrue(isElementUnDisplayed("//input[@name = '__RequestVerificationToken']"));
		endTime();

	}

	//@Test
	public void TC_03_Check__UnDisplayed_Not_In_DOM() {
		startTime();
		Assert.assertFalse(isElementDisplayed("//input[@class = 'button-1 register-button']"));
//		Assert.assertTrue(isElementUnDisplayed("//input[@class = 'button-1 register-button']"));
		endTime();
	}

	@Test(description = "Using Common method")
	public void TC_04_Check_Displayed() {
		// 1. Element Displayed - Pass
		Assert.assertTrue(registerPage.isFirstNameDisplayed());
		
		// 2. Element UnDisplayed but in DOM - Pass
		Assert.assertTrue(registerPage.isRequestVerificationUndisplayed());
		
		// 1. Element UnDisplayed not DOM
		//Assert.assertFalse(registerPage.isButtonRegisterDisplayed()); // 1. Check Button is Displayed return False > Assert
		Assert.assertTrue(registerPage.isButtonRegisterUnDisplayed()); // 2. Check Button is UnDisplayed return True > Assert
		
	}

	public void startTime() {
		System.out.println("Start time = " + new Date().toString());
	}

	public void endTime() {
		System.out.println("End time = " + new Date().toString());
	}

	public boolean isElementDisplayed(String locator) {
		overrideGlobalTimeout(driver, 5);
		try {
			element = driver.findElement(By.xpath(locator));
			overrideGlobalTimeout(driver, 15);
			return element.isDisplayed();

		} catch (Exception ex) {
			overrideGlobalTimeout(driver, 15);
			ex.printStackTrace();
			return false;
		}
	}

	public boolean isElementUnDisplayed(String locator) {
		overrideGlobalTimeout(driver, 5);

		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.size() == 0) {
			overrideGlobalTimeout(driver, 15);
			System.out.println("Element is not in DOM");
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			overrideGlobalTimeout(driver, 15);
			System.out.println("Element is in DOM but not Displayed");
			return true;
		} else {
			overrideGlobalTimeout(driver, 15);
			System.out.println("Elemenet is Displayed");
			return false;
		}
	}

	public void overrideGlobalTimeout(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
