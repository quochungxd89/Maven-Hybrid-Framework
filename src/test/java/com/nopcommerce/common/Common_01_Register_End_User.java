package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Common_01_Register_End_User extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeTest(description = "Creat new Common User for all Classes Test")
	public void Register(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "abc";
		Password = "123456";
		Email = "abc" + generateFakeNumber() + "@gmail.com";

		log.info("Pre-Conditon - Step 01: Navigate to 'Regiser' page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Pre-Conditon - step 02: enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		log.info("Pre-Conditon - step 03: enter to lastName textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		log.info("Pre-Conditon - step 04: enter to Email textbox with value is '" + Email + "'");
		registerPage.inputToEmailTextbox(Email);

		log.info("Pre-Conditon - step 05: enter to Password textbox with value is '" + Password + "'");
		registerPage.inputToPasswordTextbox(Password);

		log.info("Pre-Conditon - step 06: enter to confirmPassword textbox with value is '" + Password + "'");
		registerPage.inputToConfirmPasswordTextbox(Password);

		log.info("Pre-Conditon - step 07: click to 'Register' Button");
		registerPage.clickToRegisterButton();

		log.info("Pre-Conditon - step 08: verify 'succes message' is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Pre-Conditon - step 09: click to 'Home Page' link");
		homePage = registerPage.clickToHomePageLink();

		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName;
	public static String Email, Password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

}
