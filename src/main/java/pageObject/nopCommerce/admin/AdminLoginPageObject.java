package pageObject.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import Admin.PageUIs.nopCommerce.AdminLoginPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUsernameTextbox(String emailAddress) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public AdminDashBoardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public AdminDashBoardPageObject loginAsAdmin(String emailAddress, String password) {
		inputToUsernameTextbox(emailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();

	}
}
