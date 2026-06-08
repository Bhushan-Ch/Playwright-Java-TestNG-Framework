package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	static ExtentReports extent;

	public static ExtentReports getReport() {
		if (extent == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");
			extent = new ExtentReports();
			extent.attachReporter(spark);

		}
		return extent;
	}

}
