package testing;

import org.testng.annotations.Test;

import commons.AbstractPages;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Handle_DataTable_Grid extends AbstractPages {
	WebDriver driver;
	String locator, totalValue, closeButton;
	int index;
	

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void TC_01_Click_To_Page() {
		openUrl(driver, "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");

		goToPageByPageNumber("5");
		Assert.assertTrue(isPageNumberActived("5"));
		sleepInSecond(driver,2);

		goToPageByPageNumber("7");
		Assert.assertTrue(isPageNumberActived("7"));
		sleepInSecond(driver,2);

		goToPageByPageNumber("16");
		Assert.assertTrue(isPageNumberActived("16"));
		sleepInSecond(driver,2);

		goToPageByPageNumber("20");
		Assert.assertTrue(isPageNumberActived("20"));
		sleepInSecond(driver,2);
	}

	@Test

	public void TC_02_Click_To_Button_By_Country() {
		
		closeButton = "//button[@class = 'qgrd-modal-dismiss']";
		
		openUrl(driver, "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");

		clickToIconNameByCountry("Algeria", "remove");
		sleepInSecond(driver,5);

		clickToIconNameByCountry("Afghanistan", "edit");
		clickToElement(driver, closeButton);
		sleepInSecond(driver,5);

		clickToIconNameByCountry("Albania", "remove");
		sleepInSecond(driver,5);

		clickToIconNameByCountry("Antigua and Barbuda", "edit");
		clickToElement(driver, closeButton);
		sleepInSecond(driver,5);
	}

	@Test
	public void TC_03_Get_Total_Value_By_Country() {
		openUrl(driver, "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		
		totalValue = getTotalValueByCountry("Albania");
		System.out.println("Albania = " + totalValue);
		Assert.assertEquals(totalValue, "49397");
		
		totalValue = getTotalValueByCountry("AFRICA");
		System.out.println("AFRICA = " + totalValue);
		Assert.assertEquals(totalValue, "24853148");
		
		totalValue = getTotalValueByCountry("Antigua and Barbuda");
		System.out.println("Antigua and Barbuda = " + totalValue);
		Assert.assertEquals(totalValue, "1580");
	}
	
	@Test
	public void TC_04_Input_To_TextBox() {
		openUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		inputToTextBoxByColumnNameAndRowNumber("company", "2", "Automation");
		inputToTextBoxByColumnAndRow("Company", "1", "Selenium Testing");
		sleepInSecond(driver,2);
		
		inputToTextBoxByColumnNameAndRowNumber("orderPlaced", "3", "Testing");
		inputToTextBoxByColumnAndRow("Order Placed", "1", "HCM");
		sleepInSecond(driver,2);
		
		inputToTextBoxByColumnNameAndRowNumber("name", "1", "John Michel");
		inputToTextBoxByColumnAndRow("Contact Person", "2", "Michel Kock");
		sleepInSecond(driver,2);
		
	}
	
	@Test
	public void TC_05_Click_To_Button_By_Row() {
		openUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		clickToButtonByRow("2", "Remove");
		sleepInSecond(driver,2);
		clickToButtonByRow("1", "Insert");
		sleepInSecond(driver,2);
		inputToTextBoxByColumnAndRow("Contact Person", "2", "Michel Kock");
		clickToButtonByRow("2", "Move Up");
		sleepInSecond(driver,3);
		inputToTextBoxByColumnAndRow("Order Placed", "3", "HCM");
		clickToButtonByRow("3", "Move Down");
		sleepInSecond(driver,3);
	}
	// go to page by Page Number
	public void goToPageByPageNumber(String pageNumber) {
		locator = "//a[@class = 'qgrd-pagination-page-link' and text() = '%s']";

		waitForElementClickable(driver, locator, pageNumber);
		clickToElement(driver, locator, pageNumber);
	}

	public boolean isPageNumberActived(String pageNumber) {
		locator = "//a[@class = 'qgrd-pagination-page-link active' and text() = '%s']";

		waitForElementVisible(driver, locator, pageNumber);
		return isElementDisplayed(driver, locator, pageNumber);
	}

	public void clickToIconNameByCountry(String countryName, String iconName) {
		locator = "//td[@data-key = 'country' and text() = '%s']//preceding-sibling::td[@class = 'qgrd-actions']//button[@class = 'qgrd-%s-row-btn']";

		waitForElementClickable(driver, locator, countryName, iconName);
		clickToElement(driver, locator, countryName, iconName);
	}

	
	public String getTotalValueByCountry(String countryName) {
		locator = "//td[@data-key = 'country' and text() = '%s']/following-sibling::td[@data-key = 'total']";

		waitForElementVisible(driver, locator, countryName);
		return getTextElement(driver, locator, countryName);

	}

	public void inputToTextBoxByColumnNameAndRowNumber(String columnName, String rowNumber, String value) {
		
		locator = "//input[@id = 'tblAppendGrid_%s_%s']";
		
		waitForElementVisible(driver, locator, columnName, rowNumber);
		sendkeyToElement(driver, locator, value, columnName, rowNumber);
		
	}
	public void inputToTextBoxByColumnAndRow(String columnName, String rowNumber, String value) {
		locator = "//th[text() = '%s']//preceding-sibling::th";
		index = findElementsByXpath(driver, locator, columnName).size() + 1;
		
		// 1. Từ column Name lấy ra index của cột || 2. Sau đó mapping vs dòng 
		// 3. Tách chuỗi và bỏ row & index column vào để lấy locator mới
		//locator = "//tr[3]//td[3]/input";
		locator = "//tr[" + rowNumber + "]//td[" + index + "]/input";
		
		waitForElementVisible(driver, locator);
		sendkeyToElement(driver, locator, value);
	}
	public void clickToButtonByRow(String rowNumber, String iconName) {
		locator = "//tr[%s]//button[contains(@title,'%s')]";
		waitForElementClickable(driver, locator, rowNumber, iconName);
		clickToElement(driver, locator, rowNumber, iconName);
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
