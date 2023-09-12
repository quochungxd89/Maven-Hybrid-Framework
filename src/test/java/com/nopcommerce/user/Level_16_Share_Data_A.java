package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_16_Share_Data_A extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		Email = Common_01_Register_End_User.Email;
		Password = Common_01_Register_End_User.Password;
		homePage = PageGeneratorManager.getUserHomePage(driver);
		log.info("Login - step 01: Navigate to 'Register' page");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - step 02: enter to Email textbox with value is '" + Email + "'");
		loginPage.inputToEmailTextbox(Email);

		log.info("Login - step 03: enter to Password textbox with value is '" + Password + "'");
		loginPage.inputToPasswordTextbox(Password);

		log.info("Login - step 04: click to 'Login' button");
		loginPage.clickToLoginButton();
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
