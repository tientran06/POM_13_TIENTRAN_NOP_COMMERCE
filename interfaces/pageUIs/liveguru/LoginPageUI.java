package pageUIs.liveguru;


public class LoginPageUI {
	public static final String EMAIL_TEXTBOX = "//input[@name = 'login[username]']";
	public static final String PASSWORD_TEXTBOX = "//input[@name = 'login[password]']";
	public static final String LOGIN_BUTTON = "//button[@title ='Login']";
	
	
	public static final String EMAIL_REQUIRED_ERROR_MSG = "//div[@id = 'advice-required-entry-email' and text() ='%s']";
	public static final String PASSWORD_REQUIRED_ERROR_MSG = "//div[@id = 'advice-required-entry-pass' and text() ='%s']";
	public static final String EMAIL_VALIDATION_ERROR_MSG = "//div[@id = 'advice-validate-email-email' and text() = '%s']";
	public static final String LOGIN_ERROR_MSG = "//li[@class = 'error-msg']//span[text() = '%s']";
	public static final String PASSWORD_VALIDATION_ERROR_MSG = "//div[@id = 'advice-validate-password-pass' and text() = '%s']";

}
