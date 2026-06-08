package factory;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	
	public static Playwright playwright;
	public static Browser browser;
	public static BrowserContext context;
	public static Page page;
	
	public static Page initBrowser()
	{
		playwright =Playwright.create();
		
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos")));
		
		page = context.newPage();
		
		return page;
		
	}
	
	

}
