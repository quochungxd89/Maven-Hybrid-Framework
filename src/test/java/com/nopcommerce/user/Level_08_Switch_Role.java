package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.admin.AdminDashBoardPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_08_Switch_Role extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userPassword = "123456";
		userEmailAddress = "abcd12@gmail.com";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";

	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.clickToLoginLink();
		// Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);

		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

		// Homepage ->customer Infor
		userCustomerInforPage = userHomePage.clickToMyAccountLink();

		// customer info -> clik link logout -> Home page
		userHomePage = userCustomerInforPage.userClickToLogoutLink(driver);

		// userHome page -> open admin page -> login page admin
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		// login as Admin role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplay());

		// Dashboard page- >click logout -> login page admin
		adminLoginPage = adminDashboardPage.adminClickToLogoutLink(driver);
	}

	@Test
	public void Role_02_Admin_To_User() {
		// Login page admin -> opem trang portal url ( trang home page cua user)
		adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		// Home page -> login page (user)
		userLoginPage = userHomePage.clickToLoginLink();

		// Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);

		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String userEmailAddress, userPassword, adminEmailAddress, adminPassword;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject userCustomerInforPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashBoardPageObject adminDashboardPage;

}
