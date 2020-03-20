package pageUIs.nopcommerce;

public class RegisterPageUI {
	public static final String GENDER_MALE_RADIO = "//input[@id='gender-male']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
	public static final String DAY_DROPDOWN = "//select[@name='DateOfBirthDay']";
	public static final String MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
	public static final String YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String COMPANY_TEXTBOX = "//input[@id='Company']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRMPASS_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//input[@id='register-button']";
	
	public static final String REGISTER_SUCCESS_MSG = "//div[@class = 'result' and text() = '%s']";
	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
	public static final String REGISTER_VALIDATION_ERROR_MSG = "//span[@class = 'field-validation-error']//span[contains(.,'%s')]";
	public static final String VALIDATION_PASSWORD_ERROR_MSG = "//span[@class = 'field-validation-error']//span[@id = 'Password-error' and contains(.,'%s')]";
	public static final String VALIDATION_CONFIRM_PASSWORD_ERROR_MSG = "//span[@class = 'field-validation-error']//span[@id = 'ConfirmPassword-error' and contains(.,'%s')]";
	public static final String EMAIL_ERROR_MSG = "//span[@class = 'field-validation-error' and text() = '%s']";
	public static final String REGISTER_ERROR_MSG = "//div[@class = 'message-error validation-summary-errors']//li[text() = '%s']";
}
