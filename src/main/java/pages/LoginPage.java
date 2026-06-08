package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	public Page page;

	public LoginPage(Page page) {

	    this.page = page;

	    
	}

	private String txtUsername = "#user-name";
	private String txtPassword = "#password";
	private String loginBtn = "#login-button";

	public void enterUsername(String username) {
		page.fill(txtUsername, username);
	}

	public void enterPassword(String password) {
		page.fill(txtPassword, password);
	}

	public void clickLoginButton() {
		page.click(loginBtn);
	}

	public HomePage login(String username, String password) {

		enterUsername(username);
		enterPassword(password);
		clickLoginButton();

		return new HomePage(page);
	}

	public boolean isLoginButtonDisplayed() {

		return page.locator("#login-button").isVisible();
	}
}
