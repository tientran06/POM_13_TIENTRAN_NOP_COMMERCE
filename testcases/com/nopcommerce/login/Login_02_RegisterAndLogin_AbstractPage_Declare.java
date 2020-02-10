package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.AbstractPage;

import org.testng.annotations.BeforeTest;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Login_02_RegisterAndLogin_AbstractPage_Declare {
	private WebDriver driver;
	private String firstName = "Automation";
	private String lastName = "Testing";
	private String email = "automationFC" + randomNumber() + "@gmail.com";
	private String companyName = "Automation FC Ltd";
	private String password = "123456";
	private String confirmPassword = "123456";

	// Declare an ínstance of Abstract Page
	private AbstractPage abstractPage;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
		driver = new FirefoxDriver();
	// Init Abstract Page
		abstractPage = new AbstractPage(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		abstractPage.openUrl("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_RegisterToSystem() {
		
		abstractPage.clickToElement("//a[text() = 'Register']");

		abstractPage.clickToElement("//input[@id='gender-male']");
		abstractPage.sendkeyToElement("//input[@id = 'FirstName']", firstName);
		abstractPage.sendkeyToElement("//input[@id = 'LastName']", lastName);

		abstractPage.selectDefaultDropdownList("//select[@name = 'DateOfBirthDay']", "2");
		abstractPage.selectDefaultDropdownList("//select[@name = 'DateOfBirthMonth']", "May");
		abstractPage.selectDefaultDropdownList("//select[@name = 'DateOfBirthYear']", "1980");
		
		abstractPage.sendkeyToElement("//input[@name ='Email']", email);
		abstractPage.sendkeyToElement("//input[@name ='Company']", companyName);
		abstractPage.sendkeyToElement("//input[@name ='Password']", password);
		abstractPage.sendkeyToElement("//input[@name ='ConfirmPassword']", confirmPassword);

		abstractPage.clickToElement("//input[@name ='register-button']");
		
		Assert.assertEquals(abstractPage.getTextElement("//div[@class ='result']"), "Your registration completed");
		abstractPage.clickToElement("//a[@class='ico-logout']");

	}
	@Test
	public void TC_02_LoginToSystem() {
		abstractPage.clickToElement("//a[@class='ico-login']");
		
		abstractPage.sendkeyToElement("//input[@id='Email']", email);
		abstractPage.sendkeyToElement("//input[@id='Password']", password);

		abstractPage.clickToElement("//div[@class='buttons']/input[@type='submit']");
		Assert.assertTrue(abstractPage.isDisplayed("//a[@class='ico-account']"));
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
