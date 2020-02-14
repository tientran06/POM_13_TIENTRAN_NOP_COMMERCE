package commons;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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


public class AbstractPage {
	private WebDriver driver;
	private Actions action;
	private WebDriverWait waitExplicit;
	private WebElement element;
	private Select select;
	private By byXpath;
	private long longTimeout = 30;
	private JavascriptExecutor jsExecutor;
	
	
	public AbstractPage(WebDriver localDriver) {
		driver = localDriver;
	}
	
	public void openUrl(String urlvalue) {
		driver.get(urlvalue);
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	public String getPageTitle() {
		 return driver.getTitle();
	}
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	public String getPageSource() {
		return driver.getPageSource();
	}
	public void back() {
		driver.navigate().back();
	}
	public void forward() {
		driver.navigate().forward();
	}
	public void refresh() {
		driver.navigate().refresh();
	}
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	public void cancelAlert() {
		driver.switchTo().alert().dismiss();
	}
	public String getTextAlert() {
		return driver.switchTo().alert().getText();
	}
	public void sendKeyToAlert(String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	
	public WebElement findElementByXpath(String locator) {
		return driver.findElement(byXpathLocator(locator));
	}
	public List<WebElement> findElementsByXpath(String locator) {
		return driver.findElements(byXpathLocator(locator));
	}
	public By byXpathLocator(String locator) {
		return By.xpath(locator);
	}
	public void clickToElement(String locator) {
		findElementByXpath(locator).click();
		
	}
	public void sendkeyToElement(String locator, String value) {
		findElementByXpath(locator).sendKeys(value);
		
	}
	public String getAttributeValue(String locator, String attributeValue) {
		return findElementByXpath(locator).getAttribute(attributeValue);
		
	}
	public String getTextElement(String locator) {
		return findElementByXpath(locator).getText();
	}
	public int countElementNumber(String locator) {
		return findElementsByXpath(locator).size();
	}
	public void checkTheCheckbox(String locator) {
		element = findElementByXpath(locator);
		if (!element.isSelected()) {
			element.click();
		}
	}
	public void unCheckTheCheckbox(String locator) {
		element = findElementByXpath(locator);
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isDisplayed(String locator) {
		element = findElementByXpath(locator);
		if(element.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isSelected(String locator) {
		element = findElementByXpath(locator);
		if(element.isSelected()) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isEnabled(String locator) {
		element = findElementByXpath(locator);
		if(element.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}
	public boolean dropDownisMultiple(String locator) {
		element = findElementByXpath(locator);
		select = new Select(element);
		if(select.isMultiple()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void switchToWindowByID(String parentID) {
		Set<String> allWindowns = driver.getWindowHandles();

		for (String termWindown : allWindowns) {
			if (!termWindown.equals(parentID)) {
				driver.switchTo().window(termWindown);
				break;
			}
		}
	}
	public void switchToWindownByTitle(String expectedTitle) {
		Set<String> allWindowns = driver.getWindowHandles();
		for(String termWindown : allWindowns) {
			driver.switchTo().window(termWindown);
			String currentTitle = driver.getTitle();
			if(currentTitle.equals(expectedTitle)) {
				break;
			}
		}
	}
	public void closeAllWindownsWithoutParent(String parentID) {
		Set<String> allWindowns = driver.getWindowHandles();
		for(String termWindow : allWindowns) {
			driver.switchTo().window(termWindow);
			if(!termWindow.equals(parentID)) {
				driver.close();
			}
		}
	}
	public void switchToIframe(String locator) {
		element = findElementByXpath(locator);
		driver.switchTo().frame(element);
	}
	public void backToMainPage() {
		driver.switchTo().defaultContent();
	}

	public void moveToElement(String locator) {
		action = new Actions(driver);
		element = findElementByXpath(locator);
		action.moveToElement(element).perform();
	}
	public void doubleClickToElement(String locator) {
		action = new Actions(driver);
		element = findElementByXpath(locator);
		action.doubleClick(element).perform();
	}
	public void rightClickToElement(String locator) {
		action = new Actions(driver);
		element = findElementByXpath(locator);
		action.contextClick(element).perform();
	}
	public void dragAndDrop(String sourcelocator, String targetlocator) {
		action = new Actions(driver);
		action.dragAndDrop(findElementByXpath(sourcelocator), findElementByXpath(targetlocator)).perform();
	}
	public void sendKeyboardToElement(String locator, Keys key) {
		element = findElementByXpath(locator);
		action = new Actions(driver);
		action.sendKeys(element, key).perform();
		
	}
	
	public void waitForElementPresence(String locator) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byXpath = byXpathLocator(locator);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byXpath));
	}
	public void waitForElementVisible(String locator) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byXpath = byXpathLocator(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
	}
	public void waitForElementClickable(String locator) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byXpath = byXpathLocator(locator);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
	}
	public void waitForElementInvisible(String locator) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byXpath = byXpathLocator(locator);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byXpath));
	}
	public void waitForAlertPresence() {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}
	
	public void selectDefaultDropdownList(String locator, String valueItem) {
		element = findElementByXpath(locator);
		select = new Select(element);
		select.selectByVisibleText(valueItem);
		
	}
	public void getSelectItemInHtmlDropdown(String locator) {
		element = findElementByXpath(locator);
		select = new Select(element);
		select.getFirstSelectedOption();
	}
	public void selectCustomDropdownList(String parentXpath, String allItemsXpath, String expectedText) {
		clickToElement(parentXpath);
		List<WebElement> allItems = findElementsByXpath(allItemsXpath);
		waitForElementPresence(allItemsXpath);
		for (WebElement item : allItems) {
			if (item.getText().equals(expectedText)) {
				item.click();
				break;
			}
		}

	}
	public void inputItemInCustomDropdown(String parentXpath, String inputXpath, String expectedText) {
		clickToElement(parentXpath);
		sendkeyToElement(inputXpath, expectedText);
		sendKeyboardToElement(inputXpath, Keys.ENTER);
	}
	
	public Object executeJSForBrowser(String javaSript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaSript);
	}
	public void scrollToBottomPageByJS() {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	public void navigateToUrlByJS(String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}
	public String getTextbyJS(String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.querySelector('" + locator + "').text");
		
	}
	
	public Object executeJSForElement(String javaSript, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = findElementByXpath(locator);
		return jsExecutor.executeScript(javaSript, element);
	}
	public void scrollToElementByJS(String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = findElementByXpath(locator);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void highlightElementByJS(String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = findElementByXpath(locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 5px solid red; border-style: dashed;");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);

	}
	public void clickToElementByJS(String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = findElementByXpath(locator);
		jsExecutor.executeScript("arguments[0].click();", element);
	}
	public void removeAttributeInDOM(String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		element = findElementByXpath(locator);
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}
	public boolean verifyTextInInnerTextByJS(String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}
	public boolean checkAnyImageLoaded(String locator){
		jsExecutor = (JavascriptExecutor) driver;
		element = findElementByXpath(locator);
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
		if(status){
			return true;
		} else {
			return false;
			}
		}
	
	public void upload1File(String uploadFile, String picturePath, String buttonStart) {
		sendkeyToElement(uploadFile, picturePath);
		waitForElementVisible(buttonStart);
		clickToElement(buttonStart);
	}
	public void uploadFileByRobot(String uploadFile, String picturePath, String buttonStart) throws Exception {
		clickToElement(uploadFile);
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
		
		waitForElementVisible(buttonStart);
		clickToElement(buttonStart);
	}
	public void uploadAutoIT(String uploadFile, String picturePath, String buttonStart) throws Exception {
		String chromePath = ".\\uploadAutoIT\\chrome.exe";
		String firefoxPath = ".\\uploadAutoIT\\firefox.exe";
		String iePath = ".\\uploadAutoIT\\ie.exe";
		
		clickToElement(uploadFile);
		Thread.sleep(1000);
		
		if(driver.toString().contains("firefox")) {
			Runtime.getRuntime().exec(new String[] {firefoxPath, picturePath});
			
		} else if(driver.toString().contains("chromePath")){
			Runtime.getRuntime().exec(new String[] {chromePath, picturePath});
		} else {
			Runtime.getRuntime().exec(new String[] {iePath, picturePath});
		}
		
		waitForElementVisible(buttonStart);
		clickToElement(buttonStart);
		
	}
}
