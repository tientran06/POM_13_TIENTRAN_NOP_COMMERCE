package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.MyAccountPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class FrontEnd_03_MyAccount extends AbstractTest {

	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private MyAccountPageObject myAccountPage;
	private String email,password,editFirstName, editLastName,editDate, editMonth, editYear, editCompany;
	//private String editEmail;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		email = "selenium_1319@gmail.com";
		password = "123456";
		// Edit data
		editFirstName = "Selenium Automation";
		editLastName = "FC";
		editDate = "2";
		editMonth = "June";
		editYear = "1990";
	//	editEmail = "automation_FC123@gmail.com";
		editCompany = "Automation Testing Company";
	}

	@BeforeClass
	public void beforeClass() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		
		
	}
	@Test
	public void TC_01_UpdateCustomerInformation(){
		myAccountPage = homePage.clicktoMyAccountLink(driver);
		myAccountPage.clickToFemaleRadio();
		myAccountPage.inputToFirstName(editFirstName);
		myAccountPage.inputToLastName(editLastName);
		myAccountPage.selectDayDropDown(editDate);
		myAccountPage.selectMonthDropDown(editMonth);
		myAccountPage.selectYearDropDown(editYear);
		//myAccountPage.inputToEmailTextbox(editEmail);
		myAccountPage.inputToCompanyTextbox(editCompany);
		myAccountPage.clickToSaveButton();
		
		Assert.assertEquals(myAccountPage.getFirstNameValue(), editFirstName);
		Assert.assertEquals(myAccountPage.getLastNameValue(), editLastName);
		//Assert.assertEquals(myAccountPage.getEmailValue(), editEmail);
		Assert.assertEquals(myAccountPage.getCompanyValue(), editCompany);
	
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
