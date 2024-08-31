package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.uploadFile.HomePageObject;
import pageObject.jQuery.uploadFile.PageGeneratorManager;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Level_11_Upload_File extends BaseTest {
	String beachFileName = "beach.jpg";
	String computerFileName = "computer.jpg";
	String mountainFileName = "mountain.jpg";
	String[] multipleFileNames = { beachFileName, computerFileName, mountainFileName };
	String testngXmlFileName = "runJqueryUpload.xml";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		ExtentTestManager.createExtentReports(testngXmlFileName);
	}

	@Test
	public void Upload_01_One_File_Per_Time(Method method) {
		// step 01- Load single file
		ExtentTestManager.startTest(method.getName(),"Upload_01_One_File_Per_Time",testngXmlFileName);
		homePage.uploadMultipleFiles(driver, beachFileName);
		// step 02- Verify single file load success
		Assert.assertTrue(homePage.isFileloadedByName(beachFileName));
		// step 03- click start upload button
		homePage.clickToStartButton();
		// step 04- Verify single file link uploaded success
		Assert.assertTrue(homePage.isFileLinkUploadedByName(beachFileName));
		// step 05- Verify single file image uploaded success
		Assert.assertTrue(homePage.isFileImageUploadedByName(beachFileName));

	}

	@Test
	public void Upload_02_Multiple_File_Per_Time(Method method) {
		ExtentTestManager.startTest(method.getName(),"Upload_02_Multiple_File_Per_Time",testngXmlFileName);
		homePage.refreshCurrentPage(driver);
		// step 01- Load multiple file
		homePage.uploadMultipleFiles(driver, multipleFileNames);
		// step 02- Verify multiple file load success
		Assert.assertTrue(homePage.isFileloadedByName(beachFileName));
		Assert.assertTrue(homePage.isFileloadedByName(computerFileName));
		Assert.assertTrue(homePage.isFileloadedByName(mountainFileName));
		// step 03- click start upload button
		homePage.clickToStartButton();
		// step 04- Verify multiple file link uploaded success
		Assert.assertTrue(homePage.isFileLinkUploadedByName(beachFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(computerFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(mountainFileName));
		// step 05- Verify multiple file image uploaded success
		Assert.assertTrue(homePage.isFileImageUploadedByName(beachFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(computerFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(mountainFileName));

	}

	// @Test
	public void Table_03_Enter_To_Header() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private HomePageObject homePage;

}
