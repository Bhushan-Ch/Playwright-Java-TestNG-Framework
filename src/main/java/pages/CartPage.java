package pages;

import com.microsoft.playwright.Page;

public class CartPage {

	private Page page;

	public CartPage(Page page) {
		this.page = page;
	}

	private String cartTitle = ".title";

	public boolean isCartPageDisplayed() {
		return page.locator(cartTitle).textContent().equalsIgnoreCase("Your Cart");
	}

}
