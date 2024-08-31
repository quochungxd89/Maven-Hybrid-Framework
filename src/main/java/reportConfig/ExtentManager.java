package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import commons.GlobalConstants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;

public class ExtentManager {

	/**
	 * Create a new instance of ExtentReports with a unique file name for each run.
	 * @param testngXmlFileName The name of the TestNG XML file to help distinguish reports.
	 * @return An ExtentReports instance.
	 */
	public synchronized static ExtentReports createExtentReports(String testngXmlFileName) {
		// Ensure the file name is sanitized to avoid illegal characters
		String sanitizedFileName = testngXmlFileName.replaceAll("[^a-zA-Z0-9.-]", "_");

		// Create a unique report file name based on the sanitized XML file name and current timestamp
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String reportFileName = String.format("Report_%s_%s.html", sanitizedFileName, timestamp);
		String reportPath = GlobalConstants.PROJECT_PATH + "/extentV5/" + reportFileName;

		System.out.println("Report Path: " + reportPath); // Debug output

		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Auto Test");
		reporter.config().setDocumentTitle("Auto Test");
		reporter.config().setTimelineEnabled(true);
		reporter.config().setEncoding("utf-8");
		reporter.config().setTheme(Theme.DARK);

		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Company", "Automation FC");
		extentReports.setSystemInfo("Project", "NopCommerce");
		extentReports.setSystemInfo("Team", "Basus VN");
		extentReports.setSystemInfo("JDK version", GlobalConstants.JAVA_VERSION);

		return extentReports;
	}
}
