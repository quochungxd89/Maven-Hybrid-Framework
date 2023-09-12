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
import utilities.DataHelper;

public class Level_20_Faker_Data extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		homePage = PageGeneratorManager.getUserHomePage(driver);
		dataFaker = DataHelper.getDataHelper();
		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		password = dataFaker.getPassword();
		email = dataFaker.getEmailAddress();
		day = "1";
		month = "September";
		year = "1989";
	}

	@Test
	public void User_01_Register() {
		log.info("Register - step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToRadioButtonByLabel(driver, "Female");

		log.info("Register - step 02: enter to Firstname textbox with value is '" + firstName + "'");
		// registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToTextboxById(driver, "FirstName", firstName);

		log.info("Register - step 03: enter to lastName textbox with value is '" + lastName + "'");
		// registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToTextboxById(driver, "LastName", lastName);

		registerPage.selectDropdownByName(driver, "DateOfBirthDay", day);
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register - step 04: enter to Email textbox with value is '" + email + "'");
		// registerPage.inputToEmailTextbox(Email);
		registerPage.inputToTextboxById(driver, "Email", email);

		registerPage.clickToCheckBoxByLabel(driver, "Newsletter");

		log.info("Register - step 05: enter to Password textbox with value is '" + password + "'");
		// registerPage.inputToPasswordTextbox(Password);
		registerPage.inputToTextboxById(driver, "Password", password);

		log.info("Register - step 06: enter to confirmPassword textbox with value is '" + password + "'");
		// registerPage.inputToConfirmPasswordTextbox(Password);
		registerPage.inputToTextboxById(driver, "ConfirmPassword", password);

		log.info("Register - step 07: click to 'Register' Button");
		// registerPage.clickToRegisterButton();
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Login - step 08: verify 'succes message' is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register - step 09: click to 'Home Page' link");
		homePage = registerPage.clickToHomePageLink();
	}

	@Test
	public void User_02_Login() {
		log.info("Login - step 01: Navigate to 'Register' page");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - step 02: enter to Email textbox with value is '" + email + "'");
		loginPage.inputToTextboxById(driver, "Email", email);

		log.info("Login - step 03: enter to Password textbox with value is '" + password + "'");
		loginPage.inputToTextboxById(driver, "Password", password);

		log.info("Login - step 04: click to 'Login' button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login - step 05: verify 'My account link' is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Login - step 06: click to 'My account' link");
		customerInforPage = homePage.clickToMyAccountLink();

		log.info("Login - step 07: verify 'customer info' page is displayed");
		verifyTrue(customerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void User_03_My_Account() {
		log.info("Myaccount - step 01: Navigate to 'My account' Page");
		customerInforPage = homePage.clickToMyAccountLink();

		log.info("Myaccount - step 02: verify 'customer info' page is displayed");
		verifyTrue(customerInforPage.isCustomerInforPageDisplayed());

		log.info("Myaccount - step 03: verify 'Firt Name' value is correctly");
		verifyEquals(customerInforPage.getTextboxValueByID(driver, "FirstName"), firstName);

		log.info("Myaccount - step 03: verify 'Last Name' value is correctly");
		verifyEquals(customerInforPage.getTextboxValueByID(driver, "LastName"), lastName);

		log.info("Myaccount - step 03: verify 'Email Name' value is correctly");
		verifyEquals(customerInforPage.getTextboxValueByID(driver, "Email"), email);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private DataHelper dataFaker;
	private String firstName, lastName, email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private String day, month, year;
}
