package pageObject.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import Admin.PageUIs.nopCommerce.AdminDashBoardPageUI;
import commons.BasePage;

public class AdminDashBoardPageObject extends BasePage {
	private WebDriver driver;

	public AdminDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashboardHeaderDisplay() {
		waitForAllElementVisible(driver, AdminDashBoardPageUI.DASHBOARD_HEADER);
		return isElementDisplay(driver, AdminDashBoardPageUI.DASHBOARD_HEADER);
	}

}
