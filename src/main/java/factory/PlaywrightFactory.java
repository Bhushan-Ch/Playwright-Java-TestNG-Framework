package factory;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.ConfigReader;

public class PlaywrightFactory {
	
	private static ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> context = new ThreadLocal<>();
    private static ThreadLocal<Page> page = new ThreadLocal<>();

    public static void initBrowser() {

        String browserName = ConfigReader.getProperty("browser");
        boolean headless = Boolean.parseBoolean(
                ConfigReader.getProperty("headless"));

        playwright.set(Playwright.create());

        switch (browserName.toLowerCase()) {

        case "firefox":

            browser.set(playwright.get()
                    .firefox()
                    .launch(new BrowserType.LaunchOptions()
                            .setHeadless(headless)));
            break;

        case "webkit":

            browser.set(playwright.get()
                    .webkit()
                    .launch(new BrowserType.LaunchOptions()
                            .setHeadless(headless)));
            break;

        default:

            browser.set(playwright.get()
                    .chromium()
                    .launch(new BrowserType.LaunchOptions()
                            .setHeadless(headless)));
        }

        context.set(browser.get()
                .newContext(new Browser.NewContextOptions()
                        .setRecordVideoDir(Paths.get("videos"))));

        page.set(context.get().newPage());
    }

    public static Page getPage() {
        return page.get();
    }

    public static Browser getBrowser() {
        return browser.get();
    }

    public static BrowserContext getContext() {
        return context.get();
    }

    public static Playwright getPlaywright() {
        return playwright.get();
    }

    public static void closeBrowser() {

        if (page.get() != null) {
            page.get().close();
            page.remove();
        }

        if (context.get() != null) {
            context.get().close();
            context.remove();
        }

        if (browser.get() != null) {
            browser.get().close();
            browser.remove();
        }

        if (playwright.get() != null) {
            playwright.get().close();
            playwright.remove();
        }
    }
}