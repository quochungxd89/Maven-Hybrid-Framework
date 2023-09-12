package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import User.PageUIs.nopCommerce.UserLoginPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.lOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.lOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);

	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextbox(String EmailAddress) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, EmailAddress);
	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementVisible(driver, UserLoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public UserHomePageObject loginAsUser(String EmailAddress, String password) {
		inputToEmailTextbox(EmailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}

}
