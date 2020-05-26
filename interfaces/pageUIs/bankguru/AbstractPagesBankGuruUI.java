package pageUIs.bankguru;

public class AbstractPagesBankGuruUI {
	
	// Menu
	public static final String DYNAMIC_MENU_LINK = "//a[text() = '%s']";
	
	// Heading text
	public static final String HEADER_TEXT = "//p[@class = 'heading3']";
	
	// Textbox
	public static final String DYNAMIC_TEXTBOX = "//input[@name = '%s']";
	
	// Radio Button
	public static final String DYNAMIC_RADIO_BUTTON = "//input[@type = 'radio' and @value = '%s']";
	
	// TextArea
	public static final String DYNAMIC_TEXTAREA = "//textarea[@name = '%s']";
	
	// Button
	public static final String DYNAMIC_BUTTON = "//input[@value = '%s']";
	
	// Result
	public static final String DYNAMIC_ROW_NAME = "//td[text() = '%s']//following-sibling::td";
	
	// Dropdown
	public static final String DROPDOWN = "//select[@name = '%s']";
	
	// Validation message
	public static final String DYNAMIC_VALIDATION_MSG = "//label[@id = '%s']";
	
}
