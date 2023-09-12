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

public class Level_14_Log_ReportNG extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "abc";
		Password = "123456";
		Email = "abc" + generateFakeNumber() + "@gmail.com";

	}

	@Test
	public void User_01_Register() {
		log.info("Register - step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - step 02: enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		log.info("Register - step 03: enter to lastName textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		log.info("Register - step 04: enter to Email textbox with value is '" + Email + "'");
		registerPage.inputToEmailTextbox(Email);

		log.info("Register - step 05: enter to Password textbox with value is '" + Password + "'");
		registerPage.inputToPasswordTextbox(Password);

		log.info("Register - step 06: enter to confirmPassword textbox with value is '" + Password + "'");
		registerPage.inputToConfirmPasswordTextbox(Password);

		log.info("Register - step 07: click to 'Register' Button");
		registerPage.clickToRegisterButton();

		log.info("Register - step 08: verify 'succes message' is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");

		log.info("Register - step 09: click to 'Home Page' link");
		homePage = registerPage.clickToHomePageLink();

	}

	@Test
	public void User_02_Login() {
		log.info("Login - step 01: Navigate to 'Register' page");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - step 02: enter to Email textbox with value is '" + Email + "'");
		loginPage.inputToEmailTextbox(Email);

		log.info("Login - step 03: enter to Password textbox with value is '" + Password + "'");
		loginPage.inputToPasswordTextbox(Password);

		log.info("Login - step 04: click to 'Login' button");
		loginPage.clickToLoginButton();

		log.info("Login - step 05: verify 'My account link' is displayed");
		verifyFalse(homePage.isMyAccountLinkDisplayed());

		log.info("Login - step 06: click to 'My account' link");
		customerInforPage = homePage.clickToMyAccountLink();

		log.info("Login - step 07: verify 'customer info' page is displayed");
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

}
