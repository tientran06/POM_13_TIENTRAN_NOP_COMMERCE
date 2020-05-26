package pageUIs.nopcommerce;

public class AbstractPageNopCommerceUI {
	public static final String HEADER_LOGO_IMG = "//div[@class = 'header-logo']//img";
	public static final String MYACCOUNT_LINK = "//a[@class='ico-account']";
	public static final String FOOTER_MYACCOUNT_LINK = "//div[@class = 'footer']//a[text() = 'My account']";
	public static final String FOOTER_SHIPPING_AND_RETURNS_LINK = "//div[@class = 'footer']//a[text() = 'Shipping & returns']";
	public static final String FOOTER_SITEMAP_LINK = "//div[@class = 'footer']//a[text() = 'Sitemap']";
	public static final String HEADER_WISHLIST_LINK = "//div[@class = 'header']//a[@class = 'ico-wishlist']";
	public static final String FOOTER_SEARCH_LINK = "//div[@class = 'footer']//a[text() = 'Search']";
	
	// Footer
	public static final String DYNAMIC_FOOTER_LINK = "//div[@class = 'footer']//a[text() = '%s']";
	
	// Header
	//1. Header Link
		//a. Register & Login
		public static final String DYNAMIC_HEADER_LINK= "//div[@class = 'header']//a[text() = '%s']";
		//b. Wishlist & Shopping card
		public static final String DYNAMIC_HEADER2_LINK = "//div[@class = 'header']//a[@class = 'ico-%s']/span[@class = '%s-label']";
	//2. Menu / Sub Menu
	public static final String DYNAMIC_HEADER_MENU_LINK = "//ul[@class = 'top-menu notmobile']//a[contains(text(),'%s')]";
	
	// Radio Button
	public static final String DYNAMIC_RADIO = "//input[@type = 'radio' and @id = '%s']";
	
	// Textbox
	public static final String DYNAMIC_TEXTBOX = "//input[@id = '%s']";
	
	// Dropdown
	public static final String DYNAMIC_DROPDOWN = "//select[@name = '%s']";
	
	// Checkbox
	public static final String DYNAMIC_CHECKBOX = "//input[@type = 'checkbox' and @id = '%s']";
	
	// Button
	public static final String DYNAMIC_BUTTON = "//input[@value = '%s']";
	
	//Validation Message
	public static final String DYNAMIC_VALIDATION_MSG = "//span[text() = '%s']";
	
	// Result Message
	public static final String DYNAMIC_RESULT_ERROR_MSG = "//li[text() = '%s']";
	
	// Product Title
	public static final String PRODUCT_TITLES = "//h2[@class = 'product-title']/a";
	
	// Product Price
	public static final String PRODUCT_PRICES = "//div[@class = 'prices']//span";
	
	// Listbox Menu
	public static final String DYNAMIC_LISTBOX_MENU = "//div[@class = 'listbox']//li[@class = '%s']//a";
}
