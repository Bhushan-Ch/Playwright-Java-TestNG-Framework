package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

	ExtentReports extent = ExtentManager.getReport();

	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		test.pass("Passed");
	}

	public void onTestFailure(ITestResult result) {
		String screenShot = ScreenshotUtil.captureScreenshot(result.getName());
		test.fail(result.getThrowable());

		try {
			test.addScreenCaptureFromPath(screenShot);

		} catch (Exception e) {

		}
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
