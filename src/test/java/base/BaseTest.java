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

        PlaywrightFactory.initBrowser();

        page = PlaywrightFactory.getPage();

        page.navigate(
                ConfigReader.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        try {
            PlaywrightFactory.closeBrowser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}