package pageObjects.Wordpress;

import org.openqa.selenium.WebDriver;

import PageUI.wordpress.AdminDashboardPageUI;
import commons.BasePage;

public class AdminDashboardPO extends BasePage {
	WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
		{
		}
	}

	public AdminPostSearchPO clickToPostMenuLink() {
		waitForElementClickable(driver, AdminDashboardPageUI.POST_MENU_LINK);
		clickToElement(driver, AdminDashboardPageUI.POST_MENU_LINK);
		return PageGeneratorManager.getAdminPostSearchPage(driver);

	}
}