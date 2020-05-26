package com.nopcommerce.login;

import org.testng.annotations.Test;


import commons.AbstractTest;
import pageObjects.nopcommerce.HeaderDeskTopPageObject;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.PageGeneratorManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Login_14_Sort_Asc_Desc extends AbstractTest {

	private WebDriver driver;

	@Parameters({"browser", "url"})
	@BeforeTest
	public void beforeTest(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.openHeaderSubMenuPagesByName(driver, "Computers", "Desktops");
		
		desktopsPage = PageGeneratorManager.getHeaderDeskTopPage(driver);
	}
	@Test
	public void TC_01_Sort_Name_ASC_DESC() {
		log.info("TC_01_Sort_Ascending - Step 01 : Sorting Name Ascending");
		desktopsPage.selectNopCommerceDropdownByName(driver, "products-orderby", "Name: A to Z");
		
		desktopsPage.sleepInSecond(driver,2);
		verifyTrue(desktopsPage.isNameSortedAscending(driver));
		
		log.info("TC_01_Sort_Ascending - Step 02 : Sorting Name Descending");
		desktopsPage.selectNopCommerceDropdownByName(driver, "products-orderby", "Name: Z to A");
		desktopsPage.sleepInSecond(driver,2);
		verifyTrue(desktopsPage.isNameSortedDescending(driver));
	}

	@Test
	public void TC_02_Sort_Price_ASC_DESC() {
		log.info("TC_02_Sort_Price_ASC_DESC - Step 01 : Sorting Price Ascending");
		desktopsPage.selectNopCommerceDropdownByName(driver, "products-orderby", "Price: Low to High");
		
		desktopsPage.sleepInSecond(driver,2);
		verifyTrue(desktopsPage.isPriceSortedAscending(driver));
		
		log.info("TC_02_Sort_Price_ASC_DESC - Step 02 : Sorting Price Descending");
		desktopsPage.selectNopCommerceDropdownByName(driver, "products-orderby", "Price: High to Low");
		desktopsPage.sleepInSecond(driver,2);
		verifyTrue(desktopsPage.isPriceSortedDescending(driver));
	}
	
	@AfterTest(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

	private HomePageObject homePage;
	private HeaderDeskTopPageObject desktopsPage;
}
