package testing;

import org.testng.annotations.Test;

import commons.AbstractPages;
import commons.GlobalConstants;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class UploadMultiFiles extends AbstractPages {
	WebDriver driver;
	String image01 = "picture1.jpg";
	String image02 = "picture2.jpg";
	String image03 = "picture3.jpg";
	String image04 = "picture4.jpg";

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://blueimp.github.com/jQuery-File-Upload/");
	}

	@Test
	public void TC_01_UploadMultipeFiles() throws InterruptedException {

		uploadMutipleFiles(image01, image02, image03, image04);
		Thread.sleep(2000);

		Assert.assertTrue(driver.findElement(By.xpath("//p[text() ='" + image01 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() ='" + image02 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() ='" + image03 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() ='" + image04 + "']")).isDisplayed());
		refresh(driver);
	}

	@Test
	public void TC_02_Upload1File() throws InterruptedException {
		upload1File(driver, "//input[@type ='file']", image01, "//td//button[@class = 'btn btn-primary start']");
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//a[text() = '" + image01 + "']")).isDisplayed());
		refresh(driver);
	}

	@Test
	public void TC_03_UploadMultiFiles() {
		uploadMultipleFiles(driver, "//input[@type ='file']", "//td//button[@class = 'btn btn-primary start']", image01, image02, image03);
		Assert.assertTrue(driver.findElement(By.xpath("//a[text() = '" + image01 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text() = '" + image02 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text() = '" + image03 + "']")).isDisplayed());
		refresh(driver);
	}

	//@Test(description = "Upload 1 file not using common method")
	public void TC_04_Upload1File() throws InterruptedException {
		String fileName = GlobalConstants.UPLOAD_FILE_PATH + image01;

		WebElement uploadFile = driver.findElement(By.xpath("//input[@type ='file']"));
		uploadFile.sendKeys(fileName);
		Thread.sleep(5000);

	}

	public void uploadMutipleFiles(String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_FILE_PATH;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		driver.findElement(By.xpath("//input[@type ='file']")).sendKeys(fullFileName);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
