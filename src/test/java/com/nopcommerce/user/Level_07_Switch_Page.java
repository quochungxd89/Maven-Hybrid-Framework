package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_07_Switch_Page extends BaseTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		// 1
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "abc";
		Password = "123456";
		Email = "abc" + generateFakeNumber() + "@gmail.com";

	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(Email);
		registerPage.inputToPasswordTextbox(Password);
		registerPage.inputToConfirmPasswordTextbox(Password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToHomePageLink();

	}

	@Test
	public void User_02_Login() {

		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(Email);
		loginPage.inputToPasswordTextbox(Password);
		loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void User_03_Customer_Infor() {
		customerInforPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void User_04_Switch_Page() {
		// Customer Infor ->Address
		addresspage = customerInforPage.openAddressPage(driver);
		// Address -> my product review
		myProductReviewPage = addresspage.openMyProductReviewPage(driver);
		// my product review -> Reward Point
		rewardPointpage = myProductReviewPage.openRewardPointPage(driver);

		// Reward Point -> Address
		addresspage = rewardPointpage.openAddressPage(driver);

		// Address -> reward point
		rewardPointpage = addresspage.openRewardPointPage(driver);

		// reward point - > my product review
		myProductReviewPage = rewardPointpage.openMyProductReviewPage(driver);

	}

	@Test
	public void User_05_Switch_Role() {
		// Role User-> Role Admin

		// Role Admin -> Role User

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName, Email, Password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addresspage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointpage;

}
