package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import User.PageUIs.nopCommerce.UserRegisterPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);

	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);

	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);

	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);

	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);

	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);

	}

	public void inputToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastnameTextbox(String lastName) {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);

	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);

	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public UserHomePageObject clickToHomePageLink() {
		waitForElementClickable(driver, UserRegisterPageUI.HOME_PAGE_LINK);
		clickToElement(driver, UserRegisterPageUI.HOME_PAGE_LINK);
		// return new HomePageObject(driver);
		return PageGeneratorManager.getUserHomePage(driver);

	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);

	}

}
