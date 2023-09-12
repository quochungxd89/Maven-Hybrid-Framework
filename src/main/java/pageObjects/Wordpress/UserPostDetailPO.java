package pageObjects.Wordpress;

import org.openqa.selenium.WebDriver;

import PageUI.wordpress.UserHomePageUI;
import PageUI.wordpress.UserPostDetailPageUI;
import commons.BasePage;

public class UserPostDetailPO extends BasePage {
	WebDriver driver;

	public UserPostDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInForDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplay(driver, UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
	}

	public boolean isPostInForDisplayedWithPostBody(String postTitle, String postBody) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
		return isElementDisplay(driver, UserPostDetailPageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
	}

	public boolean isPostInForDisplayedWithPostAuthor(String postTitle, String authorName) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
		return isElementDisplay(driver, UserPostDetailPageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
	}

	public boolean isPostInForDisplayedWithPostCurrentDay(String postTitle, String currentDay) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle, currentDay);
		return isElementDisplay(driver, UserPostDetailPageUI.POST_CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle, currentDay);
	}

}