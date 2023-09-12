package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_12_Assert_Verify extends BaseTest {

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

		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");

		homePage = registerPage.clickToHomePageLink();

		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(Email);
		loginPage.inputToPasswordTextbox(Password);
		loginPage.clickToLoginButton();

		verifyFalse(homePage.isMyAccountLinkDisplayed());

		customerInforPage = homePage.clickToMyAccountLink();
		verifyFalse(customerInforPage.isCustomerInforPageDisplayed());
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
