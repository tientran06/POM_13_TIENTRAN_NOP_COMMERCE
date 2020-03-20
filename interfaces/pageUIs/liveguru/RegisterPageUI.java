package pageUIs.liveguru;

public class RegisterPageUI {
	public static final String FIRSTNAME_TEXTBOX = "//input[@id = 'firstname']";
	public static final String LASTNAME_TEXTBOX = "//input[@id = 'lastname']";
	public static final String EMAIL_TEXTBOX = "//input[@type = 'email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id = 'password']";
	public static final String CONFIRM_TEXTBOX = "//input[@id = 'confirmation']";
	public static final String REGISTER_BUTTON = "//span[text() = 'Register']";
	public static final String REQUIRED_FIRSTNAME_ERROR_MSG = "//div[@id = 'advice-required-entry-firstname' and text() = '%s']";
	public static final String REQUIRED_LASTNAME_ERROR_MSG = "//div[@id = 'advice-required-entry-lastname' and text() = '%s']";
	public static final String REQUIRED_EMAILNAME_ERROR_MSG = "//div[@id = 'advice-required-entry-email_address' and text() = '%s']";
	public static final String REQUIRED_PASSWORD_ERROR_MSG = "//div[@id = 'advice-required-entry-password' and text() = '%s']";
	public static final String REQUIRED_CONFIRM_PASSWORD_ERROR_MSG = "//div[@id = 'advice-required-entry-confirmation' and text() = '%s']";
	public static final String VALIDATION_EMAIL_ERROR_MSG = "//div[@id = 'advice-validate-email-email_address' and text() = '%s']";
	public static final String VALIDATION_PASSWORD_ERROR_MSG = "//div[@id = 'advice-validate-password-password' and text() = '%s']";
	public static final String VALIDATION_CONFIRM_PASSWORD_ERROR_MSG = "//div[@id = 'advice-validate-cpassword-confirmation' and text() = '%s']";
	public static final String REGISTER_ERROR_MSG = "//span[contains(text(),'%s')]";
	
	}
