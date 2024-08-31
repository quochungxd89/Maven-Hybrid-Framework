package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
	private static final ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();
	private static ExtentReports extentReports;

	/**
	 * Initialize ExtentReports with the provided TestNG XML file name.
	 * @param testngXmlFileName The name of the TestNG XML file to help distinguish reports.
	 */
	public synchronized static void createExtentReports(String testngXmlFileName) {
		extentReports = ExtentManager.createExtentReports(testngXmlFileName);
	}

	/**
	 * Get the ExtentReports instance for the current session.
	 * @return An ExtentReports instance.
	 */
	private synchronized static ExtentReports getExtentReports() {
		return extentReports;
	}

	/**
	 * Start a new test and associate it with the current thread.
	 * @param testName The name of the test.
	 * @param desc A description of the test.
	 * @param testngXmlFileName The name of the TestNG XML file.
	 * @return The ExtentTest instance created.
	 */
	public synchronized static ExtentTest startTest(String testName, String desc, String testngXmlFileName) {
		if (extentReports == null) {
			createExtentReports(testngXmlFileName);
		}
		ExtentTest test = getExtentReports().createTest(testName, desc);
		extentTestThreadLocal.set(test);
		return test;
	}

	/**
	 * Get the ExtentTest instance for the current thread.
	 * @return ExtentTest instance for the current thread.
	 */
	public synchronized static ExtentTest getTest() {
		return extentTestThreadLocal.get();
	}

	/**
	 * Flush the ExtentReports to persist the data.
	 */
	public synchronized static void flushReports() {
		if (extentReports != null) {
			extentReports.flush();
		}
	}
}