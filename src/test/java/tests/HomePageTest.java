package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void loginToApplication() {

        LoginPage loginPage = new LoginPage(page);

        homePage = loginPage.login(
                "standard_user",
                "secret_sauce");
    }

    @Test
    public void verifyHomePageTitle() {

        Assert.assertEquals(
                homePage.getHomePageTitle(),
                "Products");
    }

    @Test
    public void verifyLogout() {

        LoginPage loginPage = homePage.logout();

        Assert.assertTrue(
                loginPage.isLoginButtonDisplayed(),
                "Logout failed");
    }
}