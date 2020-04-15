package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class FrontEnd_00_Template extends AbstractTest {

	private WebDriver driver;
	

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);

		
	}

	@BeforeMethod
	public void beforeMethod() {
	}
	@Test
	public void TC_01(){
	
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
