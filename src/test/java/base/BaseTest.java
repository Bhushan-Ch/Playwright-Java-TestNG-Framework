package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Page;

import factory.PlaywrightFactory;
import utils.ConfigReader;

public class BaseTest {
	protected Page page;

	@BeforeMethod
	public void setUp() {

		page = PlaywrightFactory.initBrowser();

		page.navigate(ConfigReader.getProperty("url"));
	}

	@AfterMethod
	public void tearDown() {
		PlaywrightFactory.context.close();
		PlaywrightFactory.browser.close();
		PlaywrightFactory.page.close();
	}

}
