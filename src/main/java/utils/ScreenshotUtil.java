package utils;

import java.nio.file.Paths;

import com.microsoft.playwright.Page;

import factory.PlaywrightFactory;

public class ScreenshotUtil {

	public static String captureScreenshot(String testName) {
		String path = "screenshots/" + testName + System.currentTimeMillis() + ".png";

		PlaywrightFactory.getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));

		return path;
	}

}
