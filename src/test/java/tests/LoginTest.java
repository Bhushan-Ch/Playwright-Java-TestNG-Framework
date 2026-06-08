package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import factory.PlaywrightFactory;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void loginTest() {
		LoginPage loginPage = new LoginPage(PlaywrightFactory.getPage());

		HomePage homePage = loginPage.login("standard_user", "secret_sauce");

		Assert.assertTrue(homePage.isHomePageDisplayed(), "Home Page not displayed after login");

	}

}
