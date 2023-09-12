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
import pageFactory.nopCommerce.HomePageObject;
import pageFactory.nopCommerce.LoginPageObject;
import pageFactory.nopCommerce.RegisterPageObject;

public class Level_05_Page_Factory extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, inValidPassword;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = new HomePageObject(driver);

		firstName = "Automation";
		lastName = "abc";
		validPassword = "123456";
		inValidPassword = "654321";
		invalidEmail = "afcc@afc@yahoo.com.aaaa";
		existingEmail = "abc" + generateFakeNumber() + "@gmail.com";
		notFoundEmail = "abc" + generateFakeNumber() + "@gmail.vn";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);

		System.out.println("pre-condition - step 01: click to Register link");
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		System.out.println("pre-condition- step 02: click to Register button");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("pre-condition - step 03: click to Home page");
		registerPage.clickToHomePageLink();
		homePage = new HomePageObject(driver);

	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_Email_Not_Found() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		homePage.clickToLoginLink();
		// chuyen sang trang Login
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Existing_Password_Incorect_Password() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(inValidPassword);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_Valid_Email_Password() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);

		loginPage.clickToLoginButton();
		// login thanh cong -> homepage
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

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
