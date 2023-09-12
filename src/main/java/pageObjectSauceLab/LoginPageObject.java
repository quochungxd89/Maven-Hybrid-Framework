package pageObjectSauceLab;

import org.openqa.selenium.WebDriver;

import PageUI.SouceLab.LoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserNameTextbox(String username) {
		waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, username);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public ProductPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getProductPageObject(driver);
	}

}
