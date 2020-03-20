package com.liveguru.login;

import org.testng.annotations.Test;

import pageObjects.liveguru.LoginPageObject;
import pageObjects.liveguru.MyAccountPageObject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_01_Login_PageObject {
	WebDriver driver;
	private String email, password, name;
	private LoginPageObject loginPage;
	private MyAccountPageObject myAccountPage;
	

  @BeforeTest
  public void beforeTest() {
	  String osName = System.getProperty("os.name");
      if(osName.toLowerCase().contains("windows")) {
              System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
      } else {
              System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver_MAC");
      }
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  
	  email = "auto_FC@gmail.com";
	  password = "123456";
	  name = "automation FC";
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
	  loginPage = new LoginPageObject(driver);
	  
  }
  @Test
  public void TC_01_LoginWithEmptyValue() {
	  loginPage.inputToEmailTextbox("");
	  loginPage.inputToPasswordTextbox("");
	  loginPage.clickToLoginButton();
	  
	  Assert.assertTrue(loginPage.isRequiredEmailErrorMsgDisplayed("This is a required field."));
	  Assert.assertTrue(loginPage.isRequiredPasswordErrorMsgDisplayed("This is a required field."));
	  
  }
  @Test
  public void TC_02_LoginWithInvalidEmail() {
	  loginPage.inputToEmailTextbox("automation@hotcom");
	  loginPage.inputToPasswordTextbox("123456");
	  loginPage.clickToLoginButton();
	  Assert.assertTrue(loginPage.isValidationEmailErrorMsgDisplayed("Please enter a valid email address. For example johndoe@domain.com."));
  }
  @Test
  public void TC_03_LoginWithIncorrectEmail() {
	  loginPage.inputToEmailTextbox("abc123@gmail.com");
	  loginPage.inputToPasswordTextbox("123456");
	  loginPage.clickToLoginButton();
	  Assert.assertTrue(loginPage.isErrorMsgDisplayed("Invalid login or password."));
  }
  @Test
  public void TC_04_LoginWithCorrectEmailAndEmptyPassWord() {
	  loginPage.inputToEmailTextbox(email);
	  loginPage.inputToPasswordTextbox("");
	  loginPage.clickToLoginButton();
	  Assert.assertTrue(loginPage.isRequiredPasswordErrorMsgDisplayed("This is a required field."));
  }
  @Test
  public void TC_05_LoginWithPassWordLessThan6Characters() {
	  loginPage.inputToEmailTextbox(email);
	  loginPage.inputToPasswordTextbox("123");
	  loginPage.clickToLoginButton();
	  Assert.assertTrue(loginPage.isValidationPasswordErrorMsgDisplayed("Please enter 6 or more characters without leading or trailing spaces."));
	  
  }
  @Test
  public void TC_06_LoginWithCorrectValue() {
	  loginPage.inputToEmailTextbox(email);
	  loginPage.inputToPasswordTextbox(password);
	  
	  myAccountPage = loginPage.clickToLoginButton();
	  Assert.assertTrue(myAccountPage.isWellcomeMsgDisplayed("My Dashboard"));
	  Assert.assertTrue(myAccountPage.isAccountNameDisplayed(name));
	  Assert.assertTrue(myAccountPage.isAccountEmailDisplayed(email));
	  
	  myAccountPage.clickToLogoutLink();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
