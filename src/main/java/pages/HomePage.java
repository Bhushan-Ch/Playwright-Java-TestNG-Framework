package pages;

import com.microsoft.playwright.Page;

public class HomePage {

	protected Page page;

	// Constructor
	public HomePage(Page page) {
		this.page = page;
	}

	// Locators
	
	private String pageTitle = ".title";
	private String cartIcon = ".shopping_cart_link";
	private String menuButton = "#react-burger-menu-btn";
	private String logoutLink = "#logout_sidebar_link";

	public boolean isHomePageDisplayed() {
		

		return page.locator(pageTitle).textContent().equalsIgnoreCase("Products");
	}
	
	public String getHomePageTitle()
	{
		return page.locator(pageTitle).textContent();
	}
	
	public CartPage clickCart()
	{
		page.click(cartIcon);
		return new CartPage(page);
	}
	
	public LoginPage logout() {
	    page.click("#react-burger-menu-btn");
	    page.click("#logout_sidebar_link");
	    return new LoginPage(page);
	}

}
