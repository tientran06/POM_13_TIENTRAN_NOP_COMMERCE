package car.factory.pattern;

public class Dymanic_Locator {

	public static void main(String[] arg) {
		String FOOTER_DYNAMIC_LINK = "//ul[@class = 'list']//a[text() = '%s']";
		String HEADER_FOOTER_LINK = "//ul[@class = '%s']//a[text() = '%s']";

		// 1 param
		clickToFooterLink(FOOTER_DYNAMIC_LINK, "Search");
		clickToFooterLink(FOOTER_DYNAMIC_LINK, "Shipping & returns");
		clickToFooterLink(FOOTER_DYNAMIC_LINK, "Wishlist");

		// 2 params
		clickToFooterLink(HEADER_FOOTER_LINK, "footer", "News");
		clickToFooterLink(HEADER_FOOTER_LINK, "footer", "Compare products list");
		clickToFooterLink(HEADER_FOOTER_LINK, "top-menu notmobile", "Computers ");
		clickToFooterLink(HEADER_FOOTER_LINK, "top-menu notmobile", "Books ");
		clickToFooterLink(HEADER_FOOTER_LINK, "top-menu notmobile", "Jewelry ");
		
		// n params
		clickToFooterLink(HEADER_FOOTER_LINK, "footer", "About us");
		clickToFooterLink(HEADER_FOOTER_LINK, "top-menu notmobile", "Gift Cards ");
	}

	// 1 param
	public static void clickToFooterLink(String locator, String pageName) {
		locator = String.format(locator, pageName);
		System.out.println("Click to page with 1 param" + locator);
	}

	// 2 param
	public static void clickToFooterLink(String locator, String headerOrFooterName, String pageName) {
		locator = String.format(locator, headerOrFooterName, pageName);
		System.out.println("Click to page with 2 param" + locator);
	}
	
	// n param
		public static void clickToFooterLink(String locator, String... values) {
			locator = String.format(locator, (Object[]) values);
			System.out.println("Click to page with n param" + locator);
		}

}
