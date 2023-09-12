package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_03_Page_Object_Login {
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, inValidPassword;
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();
		// Initial (Khoitao)
		firstName = "Automation";
		lastName = "abc";
		validPassword = "123456";
		inValidPassword = "654321";
		invalidEmail = "afcc@afc@yahoo.com.aaaa";
		existingEmail = "abc" + generateFakeNumber() + "@gmail.com";
		notFoundEmail = "abc" + generateFakeNumber() + "@gmail.vn";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new UserHomePageObject(driver);

		System.out.println("pre-condition - step 01: click to Register link");
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

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
		homePage = new UserHomePageObject(driver);

	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_Email_Not_Found() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		homePage.clickToLoginLink();
		// chuyen sang trang Login
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Existing_Password_Incorect_Password() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(inValidPassword);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_Valid_Email_Password() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);

		loginPage.clickToLoginButton();
		// login thanh cong -> homepage
		homePage = new UserHomePageObject(driver);
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
