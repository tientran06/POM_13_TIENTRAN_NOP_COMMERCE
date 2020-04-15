package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.bankguru.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPages{
	WebDriver driver;
	
	public NewCustomerPageObject(WebDriver _driver){
		driver = _driver;
	}

	
}
