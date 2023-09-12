package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_16_Share_Data_B extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-Condition - step 01: Navigate to 'Register' page");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-Condition - step 02: Set cookie and reload page");
		loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);
		loginPage.refreshCurrentPage(driver);

		log.info("Pre-Condition - step 03: verify 'My account link' is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void Search_01_Empty_Data() {

	}

	@Test
	public void Search_02_Ralative_Product_Name() {
	}

	@Test
	public void Search_03_Absolute_Product_Name() {
	}

	@Test
	public void Search_04_Parent_Category() {
	}

	@Test
	public void Search_05_Incorrect_Manufactorer() {
	}

	@Test
	public void Search_06_Correct_Manufactorer() {
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String Email, Password;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;

}
