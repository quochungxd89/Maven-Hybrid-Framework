package pageObjects.Wordpress;

import org.openqa.selenium.WebDriver;

import PageUI.wordpress.AdminPostSearchPageUI;
import PageUI.wordpress.UserSearchPostPageUI;
import commons.BasePage;

public class UserSearchPostPO extends BasePage {
	WebDriver driver;

	public UserSearchPostPO(WebDriver driver) {
		this.driver = driver;

	}

	public boolean isNothingFoundMessageDisplayed(String message) {
		waitForElementVisible(driver, UserSearchPostPageUI.NOTHING_FOUND_MESSAGE, message);
		return isElementDisplay(driver, UserSearchPostPageUI.NOTHING_FOUND_MESSAGE, message);
	}

}