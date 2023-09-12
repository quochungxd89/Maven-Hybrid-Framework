package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import User.PageUIs.nopCommerce.UserCustomerInforPageUI;
import commons.BasePage;

public class UserCustomerInforPageObject extends BasePage {
	private WebDriver driver;

	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInforPageDisplayed() {
		waitForElementVisible(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplay(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_HEADER);

	}

}
