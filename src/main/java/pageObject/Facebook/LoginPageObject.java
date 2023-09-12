package pageObject.Facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Facebook.LoginPageUIS;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreatNewAccountButton() {
		waitForElementClickable(driver, LoginPageUIS.CREAT_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUIS.CREAT_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUIS.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplay(driver, LoginPageUIS.EMAIL_ADDRESS_TEXTBOX);
	}

	public void enterToEmailAddressTextBox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUIS.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUIS.EMAIL_ADDRESS_TEXTBOX, emailAddress);

	}

	public boolean isConfirmEmailAddressTextboxDisplayed() {
		return isElementDisplay(driver, LoginPageUIS.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

	public void clickCloseIconAtRegisterForm() {
		waitForElementClickable(driver, LoginPageUIS.CLOSE_ICON);
		clickToElement(driver, LoginPageUIS.CLOSE_ICON);

	}

	public boolean isConfirmEmailAddressTextboxUndisplayed() {
		waitForElementUndisplayed(driver, LoginPageUIS.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUIS.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

}
