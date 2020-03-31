package testing;

import org.testng.annotations.Test;

import commons.AbstractTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Demo_Testing1 extends AbstractTest{
	WebDriver driver;
	WebDriverWait waitExplicit;

	@BeforeTest
	public void beforeTest() {
		  System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
			driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", ".\\libraries\\chromedriver.exe");
//		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		waitExplicit = new WebDriverWait(driver, 15);
	}

	@BeforeMethod
	public void beforeMethod() {

	}

	@Test
	public void TC02_Dropdown() throws InterruptedException {
		driver.get("http://demo.guru99.com/v1/");
		// Click menu Selenium
		WebElement navBar1 = driver.findElement(By.xpath("//a[@class = 'dropdown-toggle' and contains(text(),'Selenium')]"));
		navBar1.click();
		// Chua item vao 1 List
		By menuLists = By.xpath("//ul[@class = 'dropdown-menu']//li/a");
		List<WebElement> itemLists = driver.findElements(menuLists);
		
		// Cho cho all items xuat hien trong DOM
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(menuLists));

		// Duyet qua list va click vao item mong muon
		for (WebElement item : itemLists) {
			System.out.println("Text =" + item.getText());
			if (item.getText().equals("Accessing Link")) {
				item.click();
				Thread.sleep(5000);
				break;
			}
		}
		Assert.assertTrue(driver.findElement(By.linkText("click here")).isDisplayed());
	}
	
	//@Test
	public void TC03_Dropdown() throws InterruptedException{

			driver.get("http://demo.guru99.com/v1/");
	       
	        driver.findElement(By.xpath("//*[text()='UserID']//following::input")).clear();
	        driver.findElement(By.xpath("//*[@type='text']//following::input")).sendKeys("12345678");
	        System.out.println("following");
	        driver.findElement(By.xpath("//*[text()='Password']//preceding::input")).sendKeys("abcdef");
	        System.out.println("preceding");
	        driver.findElement(By.xpath("//*[@type='text']//following::input[2]")).click();
	       System.out.println("Alert is " +driver.switchTo().alert().getText());
	       driver.switchTo().alert().accept();
	       Thread.sleep(2000);
	     
	        
	        WebElement navBar = driver.findElement(By.cssSelector("ul[class = 'nav navbar-nav']"));
		 	By menuLists = By.cssSelector("li.dropdown");
	        List<WebElement> navBarList = navBar.findElements(By.cssSelector("li.dropdown"));
	        waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(menuLists));
	        
	        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	        navBarList.get(0).click();//findElement(By.cssSelector("a.dropdown-toggle")).click();
//	      driver.findElement(By.cssSelector("a[class = 'dropdown-toggle']")).click();
	        System.out.println("open menu");
	        driver.findElement(By.cssSelector("a[href = '../../test/link.html']")).click();
//	      driver.findElement(By.xpath("//a[text()= 'Accessing Link']")).click();
	        System.out.println("click link");
	        driver.findElement(By.cssSelector("a[href='http://demo.guru99.com/V1/index.php']")).click();
	        System.out.println("click Bank");
	}
	@Test
	public void TC04_QuitDriver() {
		Assert.assertTrue(false);
	}
	
	@AfterTest(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

}
