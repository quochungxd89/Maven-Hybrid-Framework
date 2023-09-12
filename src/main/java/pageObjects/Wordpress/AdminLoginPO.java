package pageObjects.Wordpress;

import org.openqa.selenium.WebDriver;

import PageUI.wordpress.AdminLoginPageUI;
import commons.BasePage;

public class AdminLoginPO extends BasePage {
	WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserNameTextbox(String adminUsername) {
		waitForElementInvisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX, adminUsername);
		sendkeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, adminUsername);
	}

	public void enterToPasswordTextbox(String adminPassword) {
		waitForElementInvisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);

	}

	public AdminDashboardPO clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboardPage(driver);

	}
}
