package pageUIs.liveguru;


public class MyAccountPageUI {
	public static final String ACCOUNT_EMAIL_TEXT = "//h3[text() = 'Contact Information']/parent::div[@class = 'box-title']//following-sibling::div[@class = 'box-content' and contains(.,'%s')]";
	public static final String ACCOUNT_NAME_TEXT = "//h3[text() = 'Contact Information']/parent::div[@class = 'box-title']//following-sibling::div[@class = 'box-content' and contains(.,'%s')]";
	public static final String ACCOUNT_WELLCOME_TEXT = "//h1[text() ='My Dashboard']";
	public static final String ACCOUNT_REGISTER_SUCCESS_MSG = "//span[text() = '%s']";
	
	public static final String ACCOUNT_LINK = "//span[@class = 'label' and text() = 'Account']";
	public static final String LOGOUT_LINK = "//a[text() = 'Log Out']";
	
}
