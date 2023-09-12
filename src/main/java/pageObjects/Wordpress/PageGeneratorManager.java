package pageObjects.Wordpress;

import org.openqa.selenium.WebDriver;

import pageObject.nopCommerce.admin.AdminLoginPageObject;

public class PageGeneratorManager {
	public static AdminLoginPO getLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}

	public static AdminDashboardPO getDashboardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);
	}

	public static AdminPostSearchPO getAdminPostSearchPage(WebDriver driver) {
		return new AdminPostSearchPO(driver);
	}

	public static AdminPostAddNewPO getAdminPostAddNewPage(WebDriver driver) {
		return new AdminPostAddNewPO(driver);
	}

	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}

	public static UserPostDetailPO getUserPostDetailPage(WebDriver driver) {
		return new UserPostDetailPO(driver);
	}

	public static UserSearchPostPO getUserSearchPostPage(WebDriver driver) {
		return new UserSearchPostPO(driver);
	}
}
