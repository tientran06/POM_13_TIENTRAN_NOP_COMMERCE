package commons;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopcommerce.FooterMyAccountPageObject;
import pageObjects.nopcommerce.HeaderWishlistPageObject;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.MyAccountPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.SearchPageObject;
import pageObjects.nopcommerce.ShippingReturnPageObject;
import pageObjects.nopcommerce.SitemapPageObject;
import pageUIs.bankguru.AbstractPagesBankGuruUI;
import pageUIs.nopcommerce.AbstractPageNopCommerceUI;

public class AbstractPages {
	private Actions action;
	private WebDriverWait waitExplicit;
	private WebElement element;
	private Select select;
	private By byXpath;
	private JavascriptExecutor jsExecutor;

	public void openUrl(WebDriver driver, String urlvalue) {
		driver.get(urlvalue);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendKeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public WebElement findElementByXpath(WebDriver driver, String locator) {
		return driver.findElement(byXpathLocator(locator));
	}

	public WebElement findElementByXpath(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return driver.findElement(byXpathLocator(locator));
	}

	public List<WebElement> findElementsByXpath(WebDriver driver, String locator) {
		return driver.findElements(byXpathLocator(locator));
	}

	public List<WebElement> findElementsByXpath(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return driver.findElements(byXpathLocator(locator));
	}

	public By byXpathLocator(String locator) {
		return By.xpath(locator);
	}

	public By byXpathLocator(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return By.xpath(locator);
	}

	public void clickToElement(WebDriver driver, String locator) {
		findElementByXpath(driver, locator).click();

	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		findElementByXpath(driver, locator, values).click();

	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		findElementByXpath(driver, locator).sendKeys(value);
	}
	public void sendkeyToElement(WebDriver driver, String locator, int numberValue) {
		String inputValue = String.valueOf(numberValue);
		findElementByXpath(driver, locator).clear();
		findElementByXpath(driver, locator).sendKeys(inputValue);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String inputValue, String... values) {
		findElementByXpath(driver, locator, values).clear();
		findElementByXpath(driver, locator, values).sendKeys(inputValue);
	}
	public void sendkeyToElement(WebDriver driver, String locator, int numberValue, String... values) {
		String inputValue = String.valueOf(numberValue);
		findElementByXpath(driver, locator, values).clear();
		findElementByXpath(driver, locator, values).sendKeys(inputValue);
	}
	

	public String getAttributeValue(WebDriver driver, String locator, String attributeValue) {
		return findElementByXpath(driver, locator).getAttribute(attributeValue);

	}

	public String getTextElement(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).getText();
	}
	public String getTextElement(WebDriver driver, String locator, String... values) {
		return findElementByXpath(driver, locator, values).getText();
	}

	public int countElementNumber(WebDriver driver, String locator) {
		return findElementsByXpath(driver, locator).size();
	}

	public void checkTheCheckbox(WebDriver driver, String locator) {
		element = findElementByXpath(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckTheCheckbox(WebDriver driver, String locator) {
		element = findElementByXpath(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		try {
			element = findElementByXpath(driver, locator);
			overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			return element.isDisplayed();

		} catch (Exception ex) {
			overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		try {
			element = findElementByXpath(driver, locator, values);
			overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			return element.isDisplayed();

		} catch (Exception ex) {
			overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			ex.printStackTrace();
			return false;
		}
	}

	public boolean isElementUnDisplayed(WebDriver driver, String locator) {
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		List<WebElement> elements = findElementsByXpath(driver, locator);
		if (elements.size() == 0) {
			overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			System.out.println("Element is not in DOM");
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			System.out.println("Element is in DOM but not Displayed");
			return true;
		} else {
			overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			System.out.println("Elemenet is Displayed");
			return false;
		}
	}
	public boolean isElementUnDisplayed(WebDriver driver, String locator, String... values) {
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		List<WebElement> elements = findElementsByXpath(driver, locator, values);
		if (elements.size() == 0) {
			overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			System.out.println("Element is not in DOM");
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			System.out.println("Element is in DOM but not Displayed");
			return true;
		} else {
			overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			System.out.println("Elemenet is Displayed");
			return false;
		}
	}
	public boolean isElementSelected(WebDriver driver, String locator) {
		
		element = findElementByXpath(driver, locator);
		if (element.isSelected()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isElementEnabled(WebDriver driver, String locator) {
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		try {
			element = findElementByXpath(driver, locator);
			overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			return element.isEnabled();

		} catch (Exception ex) {
			overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean isElementEnabled(WebDriver driver, String locator, String... values) {
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		try {
			element = findElementByXpath(driver, locator, values);
			overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			return element.isEnabled();

		} catch (Exception ex) {
			overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			ex.printStackTrace();
			return false;
		}
	}

	public boolean dropDownisMultiple(WebDriver driver, String locator) {
		element = findElementByXpath(driver, locator);
		select = new Select(element);
		if (select.isMultiple()) {
			return true;
		} else {
			return false;
		}
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindowns = driver.getWindowHandles();

		for (String termWindown : allWindowns) {
			if (!termWindown.equals(parentID)) {
				driver.switchTo().window(termWindown);
				break;
			}
		}
	}

	public void switchToWindownByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindowns = driver.getWindowHandles();
		for (String termWindown : allWindowns) {
			driver.switchTo().window(termWindown);
			String currentTitle = driver.getTitle();
			if (currentTitle.equals(expectedTitle)) {
				break;
			}
		}
	}

	public void closeAllWindownsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowns = driver.getWindowHandles();
		for (String termWindow : allWindowns) {
			driver.switchTo().window(termWindow);
			if (!termWindow.equals(parentID)) {
				driver.close();
			}
		}
	}

	public void switchToIframe(WebDriver driver, String locator) {
		element = findElementByXpath(driver, locator);
		driver.switchTo().frame(element);
	}

	public void backToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void moveToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = findElementByXpath(driver, locator);
		action.moveToElement(element).perform();
	}
	public void moveToElement(WebDriver driver, String locator, String... values) {
		action = new Actions(driver);
		element = findElementByXpath(driver, locator, values);
		action.moveToElement(element).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = findElementByXpath(driver, locator);
		action.doubleClick(element).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = findElementByXpath(driver, locator);
		action.contextClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, String sourcelocator, String targetlocator) {
		action = new Actions(driver);
		action.dragAndDrop(findElementByXpath(driver, sourcelocator), findElementByXpath(driver, targetlocator)).perform();
	}

	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
		element = findElementByXpath(driver, locator);
		action = new Actions(driver);
		action.sendKeys(element, key).perform();

	}

	public void waitForElementPresence(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		byXpath = byXpathLocator(locator);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byXpath));
	}

	public void waitForElementPresence(WebDriver driver, String locator, String... values) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		byXpath = byXpathLocator(locator, values);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byXpath));
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		byXpath = byXpathLocator(locator);
		try {
			waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
		} catch(Exception ex){
			ex.printStackTrace();
		}
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		byXpath = byXpathLocator(locator, values);
		try {
			waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		byXpath = byXpathLocator(locator);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... values) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		byXpath = byXpathLocator(locator, values);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		byXpath = byXpathLocator(locator);
		//Date date = new Date();
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		try {
			System.out.println("Start time for wait invisible= " + new Date());
			waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byXpath));
			System.out.println("End time for wait invisible= " + new Date());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
	}

	public void waitForElementInvisible(WebDriver driver, String locator, String... values) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		byXpath = byXpathLocator(locator, values);
		//Date date = new Date();
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		try {
			System.out.println("Start time for wait invisible= " + new Date());
			waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byXpath));
			System.out.println("End time for wait invisible= " + new Date());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
	}

	public void waitForAlertPresence(WebDriver driver) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}

	public void selectDefaultDropdownList(WebDriver driver, String locator, String valueItem) {
		element = findElementByXpath(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(valueItem);

	}
	public void selectDefaultDropdownList(WebDriver driver, String locator, String valueItem, String... values) {
		element = findElementByXpath(driver, locator, values);
		select = new Select(element);
		select.selectByVisibleText(valueItem);

	}

	public void getSelectItemInHtmlDropdown(WebDriver driver, String locator) {
		element = findElementByXpath(driver, locator);
		select = new Select(element);
		select.getFirstSelectedOption();
	}

	public void selectCustomDropdownList(WebDriver driver, String parentXpath, String allItemsXpath, String expectedText) {
		clickToElement(driver, parentXpath);
		List<WebElement> allItems = findElementsByXpath(driver, allItemsXpath);
		waitForElementPresence(driver, allItemsXpath);
		for (WebElement item : allItems) {
			if (item.getText().equals(expectedText)) {
				item.click();
				break;
			}
		}

	}

	public void inputItemInCustomDropdown(WebDriver driver, String parentXpath, String inputXpath, String expectedText) {
		clickToElement(driver, parentXpath);
		sendkeyToElement(driver, inputXpath, expectedText);
		sendKeyboardToElement(driver, inputXpath, Keys.ENTER);
	}

	public Object executeJSForBrowser(WebDriver driver, String javaSript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaSript);
	}

	public void scrollToBottomPageByJS(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public String getTextbyJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.querySelector('" + locator + "').text");

	}

	public Object executeJSForElement(WebDriver driver, String javaSript, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = findElementByXpath(driver, locator);
		return jsExecutor.executeScript(javaSript, element);
	}

	public void scrollToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = findElementByXpath(driver, locator);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void highlightElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = findElementByXpath(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 5px solid red; border-style: dashed;");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);

	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = findElementByXpath(driver, locator);
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		element = findElementByXpath(driver, locator);
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
		sleepInSecond(1);
	}
	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove, String... values) {
		jsExecutor = (JavascriptExecutor) driver;
		element = findElementByXpath(driver, locator, values);
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
		sleepInSecond(1);
	}

	public boolean verifyTextInInnerTextByJS(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public boolean checkAnyImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = findElementByXpath(driver, locator);
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void upload1File(WebDriver driver, String uploadFile, String fileName, String buttonStart) {
		String file = GlobalConstants.UPLOAD_FILE_PATH + fileName;
		
		waitForElementPresence(driver, uploadFile);
		sendkeyToElement(driver, uploadFile, file);
		sleepInSecond(2);

		waitForElementVisible(driver, buttonStart);
		clickToElement(driver, buttonStart);
		sleepInSecond(2);
	}

	public void uploadMultipleFiles(WebDriver driver, String uploadFile, String buttonStart, String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_FILE_PATH;
		String fullFileName = "";

		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		
		waitForElementPresence(driver, uploadFile);
		sendkeyToElement(driver, uploadFile, fullFileName);
		sleepInSecond(2);
		
		waitForElementClickable(driver, buttonStart);
		List<WebElement> buttonStarts = findElementsByXpath(driver, buttonStart);
		for (WebElement button : buttonStarts) {
			button.click();
			sleepInSecond(2);
		}
		sleepInSecond(2);
	}

	public void uploadFileByRobot(WebDriver driver, String uploadFile, String picturePath, String buttonStart) throws Exception {
		clickToElement(driver, uploadFile);
		Thread.sleep(1000);

		StringSelection select = new StringSelection(picturePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		waitForElementVisible(driver, buttonStart);
		clickToElement(driver, buttonStart);
	}

	public void uploadAutoIT(WebDriver driver, String uploadFile, String picturePath, String buttonStart) throws Exception {
		String chromePath = ".\\uploadAutoIT\\chrome.exe";
		String firefoxPath = ".\\uploadAutoIT\\firefox.exe";
		String iePath = ".\\uploadAutoIT\\ie.exe";

		clickToElement(driver, uploadFile);
		Thread.sleep(1000);

		if (driver.toString().contains("firefox")) {
			Runtime.getRuntime().exec(new String[] { firefoxPath, picturePath });

		} else if (driver.toString().contains("chromePath")) {
			Runtime.getRuntime().exec(new String[] { chromePath, picturePath });
		} else {
			Runtime.getRuntime().exec(new String[] { iePath, picturePath });
		}

		waitForElementVisible(driver, buttonStart);
		clickToElement(driver, buttonStart);

	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);

	}
	public int convertStringToInt(String value) {
		int i = Integer.parseInt(value);
		return i;
	}
	public String convertIntToString(int numberValue) {
		String value = String.valueOf(numberValue);
		return value;
	}
	
	
		// **************** Common Methods of NOP COMMERCE ************************** // 
	
	// functions to open page objects
	public HomePageObject openHomePage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageNopCommerceUI.HEADER_LOGO_IMG);
		clickToElement(driver, AbstractPageNopCommerceUI.HEADER_LOGO_IMG);
		return PageGeneratorManager.getHomePage(driver);
	}

	public ShippingReturnPageObject openShippingReturnPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageNopCommerceUI.FOOTER_SHIPPING_AND_RETURNS_LINK);
		clickToElement(driver, AbstractPageNopCommerceUI.FOOTER_SHIPPING_AND_RETURNS_LINK);
		return PageGeneratorManager.getShippingPage(driver);
	}

	public SitemapPageObject openSitemapPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageNopCommerceUI.FOOTER_SITEMAP_LINK);
		clickToElement(driver, AbstractPageNopCommerceUI.FOOTER_SITEMAP_LINK);
		return PageGeneratorManager.getSitemapPage(driver);
	}

	public FooterMyAccountPageObject openFooterMyAccountPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageNopCommerceUI.FOOTER_MYACCOUNT_LINK);
		clickToElement(driver, AbstractPageNopCommerceUI.FOOTER_MYACCOUNT_LINK);
		return PageGeneratorManager.getFooterMyAccountPage(driver);
	}

	public SearchPageObject openFooterSearchPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageNopCommerceUI.FOOTER_SEARCH_LINK);
		clickToElement(driver, AbstractPageNopCommerceUI.FOOTER_SEARCH_LINK);
		return PageGeneratorManager.getSearchPage(driver);
	}

	public HeaderWishlistPageObject openHeaderWishlistPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageNopCommerceUI.HEADER_WISHLIST_LINK);
		clickToElement(driver, AbstractPageNopCommerceUI.HEADER_WISHLIST_LINK);
		return PageGeneratorManager.getHeaderWishlistPage(driver);
	}

	public MyAccountPageObject clicktoMyAccountLink(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageNopCommerceUI.MYACCOUNT_LINK);
		clickToElement(driver, AbstractPageNopCommerceUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);

	}
	
	// open Page in case AUT not have many pages (10-15)
	public AbstractPages openFooterPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, AbstractPageNopCommerceUI.DYNAMIC_FOOTER_LINK, pageName);
		clickToElement(driver, AbstractPageNopCommerceUI.DYNAMIC_FOOTER_LINK, pageName);
		// Factory pattern
		switch (pageName) {
		case "My account":
			return PageGeneratorManager.getFooterMyAccountPage(driver);
		case "Sitemap":
			return PageGeneratorManager.getSitemapPage(driver);
		case "Shipping & returns":
			return PageGeneratorManager.getShippingPage(driver);
		default: // open Search Page
			return PageGeneratorManager.getSearchPage(driver);
		}
	}
	// open Page in case AUT has many Pages

	public void openFooterPagesByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, AbstractPageNopCommerceUI.DYNAMIC_FOOTER_LINK, pageName);
		clickToElement(driver, AbstractPageNopCommerceUI.DYNAMIC_FOOTER_LINK, pageName);
	}

	public void openHeaderLinkPagesByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, AbstractPageNopCommerceUI.DYNAMIC_HEADER_LINK, pageName);
		clickToElement(driver, AbstractPageNopCommerceUI.DYNAMIC_HEADER_LINK, pageName);
	}
	public void openHeaderMenuPagesByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, AbstractPageNopCommerceUI.DYNAMIC_HEADER_MENU_LINK, pageName);
		clickToElement(driver, AbstractPageNopCommerceUI.DYNAMIC_HEADER_MENU_LINK, pageName);
	}
	public void openHeaderSubMenuPagesByName(WebDriver driver, String menuPageName, String subMenuPageName) {
		waitForElementClickable(driver, AbstractPageNopCommerceUI.DYNAMIC_HEADER_MENU_LINK, menuPageName);
		moveToElement(driver, AbstractPageNopCommerceUI.DYNAMIC_HEADER_MENU_LINK, menuPageName);
		
		waitForElementClickable(driver, AbstractPageNopCommerceUI.DYNAMIC_HEADER_MENU_LINK, subMenuPageName);
		clickToElement(driver, AbstractPageNopCommerceUI.DYNAMIC_HEADER_MENU_LINK, subMenuPageName);
	}
	public void clickToNopCommerceRadioButtonByID(WebDriver driver, String radioValue) {
		waitForElementClickable(driver, AbstractPageNopCommerceUI.DYNAMIC_RADIO, radioValue);
		clickToElement(driver, AbstractPageNopCommerceUI.DYNAMIC_RADIO, radioValue);
	}
	public void inputToNopCommerceTextboxByID(WebDriver driver, String textboxID, String inputValue) {
		waitForElementVisible(driver, AbstractPageNopCommerceUI.DYNAMIC_TEXTBOX, textboxID);
		sendkeyToElement(driver, AbstractPageNopCommerceUI.DYNAMIC_TEXTBOX, inputValue, textboxID);
	}
	public void selectNopCommerceDropdownByName(WebDriver driver, String dropdownName, String valueItem) {
		waitForElementVisible(driver, AbstractPageNopCommerceUI.DYNAMIC_DROPDOWN, dropdownName);
		selectDefaultDropdownList(driver, AbstractPageNopCommerceUI.DYNAMIC_DROPDOWN, valueItem, dropdownName);
	}
	public void clickToNopCommerceButtonByValue(WebDriver driver, String buttonValue) {
		waitForElementClickable(driver, AbstractPageNopCommerceUI.DYNAMIC_BUTTON, buttonValue);
		clickToElement(driver, AbstractPageNopCommerceUI.DYNAMIC_BUTTON, buttonValue);
	}
	
	
	
		// **************** Common Methods of BANK GURU ************************** // 
	
	public void clickToBankGuruMenuLinkByName(WebDriver driver, String menuName) {
		waitForElementClickable(driver, AbstractPagesBankGuruUI.DYNAMIC_MENU_LINK, menuName);
		clickToElement(driver, AbstractPagesBankGuruUI.DYNAMIC_MENU_LINK, menuName);
	}
	public void inputToBankGuruTextboxByName(WebDriver driver, String textboxName, String inputValue) {
		waitForElementVisible(driver, AbstractPagesBankGuruUI.DYNAMIC_TEXTBOX, textboxName);
		if(textboxName.contains("dob")) {
			removeAttributeInDOM(driver, AbstractPagesBankGuruUI.DYNAMIC_TEXTBOX, "type", textboxName);
		}
		sendkeyToElement(driver, AbstractPagesBankGuruUI.DYNAMIC_TEXTBOX, inputValue, textboxName);
	}
	public void inputToBankGuruTextboxByName(WebDriver driver, String textboxName, int numberValue) {
		waitForElementVisible(driver, AbstractPagesBankGuruUI.DYNAMIC_TEXTBOX, textboxName);
		sendkeyToElement(driver, AbstractPagesBankGuruUI.DYNAMIC_TEXTBOX, numberValue, textboxName);
	}
	
	public void inputToBankGuruTextAreaByName(WebDriver driver, String textareaName, String inputValue) {
		waitForElementVisible(driver, AbstractPagesBankGuruUI.DYNAMIC_TEXTAREA, textareaName);
		sendkeyToElement(driver, AbstractPagesBankGuruUI.DYNAMIC_TEXTAREA, inputValue, textareaName);
	}
	public void clickToBankGuruRadioButtonByValue(WebDriver driver, String radioValue) {
		waitForElementClickable(driver, AbstractPagesBankGuruUI.DYNAMIC_RADIO_BUTTON, radioValue);
		clickToElement(driver, AbstractPagesBankGuruUI.DYNAMIC_RADIO_BUTTON, radioValue);
	}
	public String getBankGuruTextByRowName(WebDriver driver, String rowName) {
		waitForElementVisible(driver, AbstractPagesBankGuruUI.DYNAMIC_ROW_NAME, rowName);
		return getTextElement(driver, AbstractPagesBankGuruUI.DYNAMIC_ROW_NAME, rowName);
	}
	public void clickToBankGuruButtonByValue(WebDriver driver, String buttonValue) {
		waitForElementClickable(driver, AbstractPagesBankGuruUI.DYNAMIC_BUTTON, buttonValue);
		clickToElement(driver, AbstractPagesBankGuruUI.DYNAMIC_BUTTON, buttonValue);
	}
	public String getBankGuruHeaderText(WebDriver driver) {
		waitForElementVisible(driver, AbstractPagesBankGuruUI.HEADER_TEXT);
		return getTextElement(driver, AbstractPagesBankGuruUI.HEADER_TEXT);
	}
	
	public boolean isBankGuruTextboxEnabledByName(WebDriver driver, String textboxName) {
		waitForElementVisible(driver, AbstractPagesBankGuruUI.DYNAMIC_TEXTBOX, textboxName);
		return isElementEnabled(driver, AbstractPagesBankGuruUI.DYNAMIC_TEXTBOX, textboxName);
	}
	public void selectBankGuruDropDownByValue(WebDriver driver, String dropdownName, String valueItem) {
		waitForElementVisible(driver, AbstractPagesBankGuruUI.DROPDOWN, dropdownName);
		selectDefaultDropdownList(driver, AbstractPagesBankGuruUI.DROPDOWN, valueItem, dropdownName);
	}
	public int getBankGuruNumberByRowName(WebDriver driver, String rowName) {
		String value;
		waitForElementVisible(driver, AbstractPagesBankGuruUI.DYNAMIC_ROW_NAME, rowName);
		value = getTextElement(driver, AbstractPagesBankGuruUI.DYNAMIC_ROW_NAME, rowName);
		return convertStringToInt(value);
	}
	public boolean verifyBankGuruAlertTextandAcceptAlert(WebDriver driver, String alertText) {
		waitForAlertPresence(driver);
		String value = getTextAlert(driver);
		sleepInSecond(1);
		
		acceptAlert(driver);
		sleepInSecond(1);
		return value.equals(alertText);
		
	}
	public String getBankGuruValidationMsgByID(WebDriver driver, String idValue) {
		waitForElementVisible(driver, AbstractPagesBankGuruUI.DYNAMIC_VALIDATION_MSG, idValue);
		return getTextElement(driver, AbstractPagesBankGuruUI.DYNAMIC_VALIDATION_MSG, idValue);
	}
}
