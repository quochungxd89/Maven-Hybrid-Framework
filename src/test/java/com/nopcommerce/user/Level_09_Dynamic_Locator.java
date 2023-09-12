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

public class Level_09_Dynamic_Locator extends BaseTest {

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
	public void User_01_Register_Login() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(Email);
		registerPage.inputToPasswordTextbox(Password);
		registerPage.inputToConfirmPasswordTextbox(Password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToHomePageLink();

		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(Email);
		loginPage.inputToPasswordTextbox(Password);
		loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		customerInforPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void User_02_Dynamic_Page() {
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
	public void User_03_Dynamic_Page_01() {
		// my product review -> Reward Point
		rewardPointpage = (UserRewardPointPageObject) myProductReviewPage.openPageAtMyaccountPageByName(driver, "Reward points");

		// Reward Point -> Address
		addresspage = (UserAddressPageObject) rewardPointpage.openPageAtMyaccountPageByName(driver, "Addresses");

		// Address -> reward point
		rewardPointpage = (UserRewardPointPageObject) addresspage.openPageAtMyaccountPageByName(driver, "Reward points");

		// reward point - > my product review
		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointpage.openPageAtMyaccountPageByName(driver, "My product reviews");

		// my product review -> customer info
		customerInforPage = (UserCustomerInforPageObject) myProductReviewPage.openPageAtMyaccountPageByName(driver, "Customer info");

	}

	@Test
	public void User_03_Dynamic_Page_02() {
		// customer info -> my product review
		customerInforPage.openPageAtMyaccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);

		// my product review -> Reward Point
		myProductReviewPage.openPageAtMyaccountByPageName(driver, "Reward points");
		rewardPointpage = PageGeneratorManager.getUserRewardPointPage(driver);

		// Reward Point -> Address
		rewardPointpage.openPageAtMyaccountByPageName(driver, "Addresses");
		addresspage = PageGeneratorManager.getUserAddressPage(driver);

		// Address -> reward point
		addresspage.openPageAtMyaccountByPageName(driver, "Reward points");
		rewardPointpage = PageGeneratorManager.getUserRewardPointPage(driver);

		// reward point - > my product review
		rewardPointpage.openPageAtMyaccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);

		// my product review -> customer info
		myProductReviewPage.openPageAtMyaccountByPageName(driver, "Customer info");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
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
