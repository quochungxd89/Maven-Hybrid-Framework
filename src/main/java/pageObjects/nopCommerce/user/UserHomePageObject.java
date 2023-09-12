package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import User.PageUIs.nopCommerce.UserHomePageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);

		// 2
		// return new RegisterPageObject(driver);

		// 3
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);

		// return new LoginPageObject(driver);
		return PageGeneratorManager.getUserLoginPage(driver);

	}

	public boolean isMyAccountLinkDisplayed() {
		waitForAllElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, UserHomePageUI.MY_ACCOUNT_LINK);

	}

	public UserCustomerInforPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}

}
