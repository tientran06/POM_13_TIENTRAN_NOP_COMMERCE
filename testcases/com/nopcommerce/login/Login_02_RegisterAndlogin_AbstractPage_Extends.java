package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.AbstractPages;

import org.testng.annotations.BeforeTest;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Login_02_RegisterAndlogin_AbstractPage_Extends extends AbstractPages{

	private WebDriver driver; 
	private String firstName = "Automation";
	private String lastName = "Testing";
	private String email = "automationFC" + randomNumber() + "@gmail.com";
	private String companyName = "Automation FC Ltd";
	private String password = "123456";
	private String confirmPassword = "123456";

	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@BeforeMethod
	public void beforeMethod() {
		openUrl(driver, "https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_RegisterToSystem() {
		
		clickToElement(driver, "//a[text() = 'Register']");

		clickToElement(driver, "//input[@id='gender-male']");
		sendkeyToElement(driver, "//input[@id = 'FirstName']", firstName);
		sendkeyToElement(driver, "//input[@id = 'LastName']", lastName);

		selectDefaultDropdownList(driver, "//select[@name = 'DateOfBirthDay']", "2");
		selectDefaultDropdownList(driver, "//select[@name = 'DateOfBirthMonth']", "May");
		selectDefaultDropdownList(driver, "//select[@name = 'DateOfBirthYear']", "1980");
		
		sendkeyToElement(driver, "//input[@name ='Email']", email);
		sendkeyToElement(driver, "//input[@name ='Company']", companyName);
		sendkeyToElement(driver, "//input[@name ='Password']", password);
		sendkeyToElement(driver, "//input[@name ='ConfirmPassword']", confirmPassword);

		clickToElement(driver, "//input[@name ='register-button']");
		
		Assert.assertEquals(getTextElement(driver, "//div[@class ='result']"), "Your registration completed");
		clickToElement(driver, "//a[@class='ico-logout']");

	}
	@Test
	public void TC_02_LoginToSystem() {
		clickToElement(driver, "//a[@class='ico-login']");
		
		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Password']", password);

		clickToElement(driver, "//div[@class='buttons']/input[@type='submit']");
		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));
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
