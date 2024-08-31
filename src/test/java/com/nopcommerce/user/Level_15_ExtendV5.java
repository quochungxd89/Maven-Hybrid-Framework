package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_15_ExtendV5 extends BaseTest {

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
	public void User_01_Register(Method method) {
//		ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: enter to lastName textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: enter to Email textbox with value is '" + Email + "'");
		registerPage.inputToEmailTextbox(Email);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: enter to Password textbox with value is '" + Password + "'");
		registerPage.inputToPasswordTextbox(Password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: enter to confirmPassword textbox with value is '" + Password + "'");
		registerPage.inputToConfirmPasswordTextbox(Password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - step 07: click to 'Register' Button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - step 08: verify 'succes message' is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");

		ExtentTestManager.getTest().log(Status.INFO, "Register - step 09: click to 'Home Page' link");
		homePage = registerPage.clickToHomePageLink();

	}

	@Test
	public void User_02_Login(Method method) {
//		ExtentTestManager.startTest(method.getName(), "Login to system successfull");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to 'Login' page");
		loginPage = homePage.clickToLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: enter to Email textbox with value is '" + Email + "'");
		loginPage.inputToEmailTextbox(Email);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: enter to Password textbox with value is '" + Password + "'");
		loginPage.inputToPasswordTextbox(Password);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: click to 'Login' button");
		loginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: verify 'My account link' is displayed");
		verifyFalse(homePage.isMyAccountLinkDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 06: click to 'My account' link");
		customerInforPage = homePage.clickToMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 07: verify 'customer info' page is displayed");
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
