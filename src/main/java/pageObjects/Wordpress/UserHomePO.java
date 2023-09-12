package pageObjects.Wordpress;

import org.openqa.selenium.WebDriver;

import PageUI.wordpress.UserHomePageUI;
import commons.BasePage;

public class UserHomePO extends BasePage {
	WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public UserPostDetailPO clickToPostTitle(String postTitle) {
		waitForElementClickable(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		clickToElement(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return PageGeneratorManager.getUserPostDetailPage(driver);
	}

	public boolean isPostInForDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplay(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
	}

	public boolean isPostInForDisplayedWithPostBody(String postTitle, String postBody) {
		waitForElementVisible(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
		return isElementDisplay(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
	}

	public boolean isPostInForDisplayedWithPostAuthor(String postTitle, String authorName) {
		waitForElementVisible(driver, UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
		return isElementDisplay(driver, UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
	}

	public boolean isPostInForDisplayedWithPostCurrentDay(String postTitle, String currentDay) {
		waitForElementVisible(driver, UserHomePageUI.POST_CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle, currentDay);
		return isElementDisplay(driver, UserHomePageUI.POST_CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle, currentDay);
	}

	public boolean isPostInfoUndisplayedWithPostTitle(String editPostTitle) {
		return isElementUndisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, editPostTitle);
	}

	public void enterToSearchTextbox(String editPostTitle) {
		waitForElementVisible(driver, UserHomePageUI.SEARCH_TEXT_BOX, editPostTitle);
		sendkeyToElement(driver, UserHomePageUI.SEARCH_TEXT_BOX, editPostTitle);
	}

	public UserSearchPostPO clickSearchButton() {
		waitForElementClickable(driver, UserHomePageUI.SEARCH_BUTTON);
		clickToElement(driver, UserHomePageUI.SEARCH_BUTTON);
		return PageGeneratorManager.getUserSearchPostPage(driver);
	}

}
