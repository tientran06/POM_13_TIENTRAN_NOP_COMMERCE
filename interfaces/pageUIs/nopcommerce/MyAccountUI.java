package pageUIs.nopcommerce;

public class MyAccountUI {
	public static final String GENDER_FEMALE_RADIO = "//input[@id = 'gender-female']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id = 'FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id = 'LastName']";
	public static final String DAY_DROPDOWN = "//select[@name = 'DateOfBirthDay']";
	public static final String MONTH_DROPDOWN = "//select[@name = 'DateOfBirthMonth']";
	public static final String YEAR_DROPDOWN = "//select[@name = 'DateOfBirthYear']";
	public static final String EMAIL_TEXTBOX = "//input[@id = 'Email']";
	public static final String COMPANY_TEXTBOX = "//input[@id = 'Company']";
	public static final String SAVE_BUTTON = "//input[@value = 'Save']";

	// Dropdown selected
	public static final String DYNAMIC_DROPDOWN_SELECTED = "//select[@name='%s']//option[text() = '%s']";
	// Account address infor
	public static final String ADDRESS_ACCOUNT_NAME_INFOR = "//div[@class = 'title']//strong[text() = '%s']";

	// Address information
	public static final String DYNAMIC_ADDRESS_INFOR = "//ul[@class = 'info']//li[@class = '%s' and contains(.,'%s')]";
	public static final String DYNAMIC_ADDRESS_TEXT_INFOR = "//ul[@class = 'info']//li[@class = '%s']";
	// Result successfully MSG
	public static final String DYNAMIC_RESULT_MSG = "//div[@class = 'result' and contains(.,'%s')]";
	

}
