package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_04_Multiple_Browser extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		homePage = new UserHomePageObject(driver);
		// Initial (Khoitao)
		firstName = "Automation";
		lastName = "abc";
		password = "123456";
		emailAddress = "abc" + generateFakeNumber() + "@gmail.com";
	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01 - step 01: click to Register link");
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_01 - step 02: click to Register button");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		System.out.println("Register_02 - step 01: click to Register link");
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox("aasfa123");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_02 - step 02: click to Register button");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	// @Test
	public void Register_03_Success() {
		System.out.println("Register_03 - step 01: click to Register link");
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_03 - step 02: click to Register button");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Register_03 - step 03: click to Home page");
		registerPage.clickToHomePageLink();

	}

	// @Test
	public void Register_04_Existing_Email() {
		System.out.println("Register_04 - step 01: click to Register link");
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_04 - step 02: click to Register button");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");

	}

	// @Test
	public void Register_05_Existing_Password_Less_Than_6_Chars() {
		System.out.println("Register_05 - step 01: click to Register link");
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");

		System.out.println("Register_05 - step 02: click to Register button");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	// @Test
	public void Register_06_Invalid_Confirm_Password() {
		System.out.println("Register_06 - step 01: click to Register link");
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("123654");

		System.out.println("Register_06 - step 02: click to Register button");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

}
