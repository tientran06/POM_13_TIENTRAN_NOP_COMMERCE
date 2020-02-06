package com.nopcommerce.login;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_02_Login {
	WebDriver driver;
	String email = "automationFC@gmail.com";
	String password = "123456";

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}

	
	@Test
	public void TC_06_LoginToSystem() {
		driver.findElement(By.cssSelector(".ico-login")).click();
		// input email and pass
		driver.findElement(By.cssSelector("#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("#Password")).sendKeys(password);

		driver.findElement(By.cssSelector(".login-button")).click();
		// Verify My Account displayed
		Assert.assertTrue(driver.findElement(By.cssSelector(".ico-account")).isDisplayed());
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
