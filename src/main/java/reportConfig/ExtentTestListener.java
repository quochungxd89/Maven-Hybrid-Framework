package reportConfig;

import static reportConfig.ExtentTestManager.getTest;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import commons.BaseTest;

public class ExtentTestListener extends BaseTest implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		// Initialize ExtentReports for the current XML file
		String testngXmlFileName = iTestContext.getSuite().getXmlSuite().getFileName();
		ExtentTestManager.createExtentReports(testngXmlFileName);

		// Set WebDriver instance for the current thread
		iTestContext.setAttribute("WebDriver", this.getDriverInstance());
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		// Ensure ExtentReports is flushed at the end of the suite
		ExtentTestManager.flushReports();
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		// Create a new ExtentTest instance for each test
		String testngXmlFileName = iTestResult.getTestContext().getSuite().getXmlSuite().getFileName();
		ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(), "Description of the test", testngXmlFileName);
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		// Log test success
		if (getTest() != null) {
			getTest().log(Status.PASS, "Test passed");
		} else {
			System.err.println("ExtentTest is null for test: " + getTestMethodName(iTestResult));
		}
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		// Capture screenshot and log test failure
		Object testClass = iTestResult.getInstance();
		WebDriver driver = ((BaseTest) testClass).getDriverInstance();

		if (getTest() != null) {
			if (driver instanceof TakesScreenshot) {
				String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
				getTest().log(Status.FAIL, "Screenshot and Exception", iTestResult.getThrowable(),
						getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
				getTest().log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getName() + " - Failed", ExtentColor.RED));
			} else {
				getTest().log(Status.FAIL, "Failed to capture screenshot because driver does not support TakesScreenshot");
			}
		} else {
			System.err.println("ExtentTest is null for test: " + getTestMethodName(iTestResult));
		}
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		// Log test skip
		if (getTest() != null) {
			getTest().log(Status.SKIP, "Test Skipped");
		} else {
			System.err.println("ExtentTest is null for test: " + getTestMethodName(iTestResult));
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		// Log test failure within success percentage
		if (getTest() != null) {
			getTest().log(Status.FAIL, "Test Failed with percentage " + getTestMethodName(iTestResult));
		} else {
			System.err.println("ExtentTest is null for test: " + getTestMethodName(iTestResult));
		}
	}
}