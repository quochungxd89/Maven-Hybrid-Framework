package pageObjects.Wordpress;

import org.openqa.selenium.WebDriver;

import PageUI.wordpress.AdminPostAddNewPageUI;
import commons.BasePage;

public class AdminPostAddNewPO extends BasePage {
	WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;

	}

	public void enterToAddNewPostTitle(String postTitleValue) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.POST_TITLE_TEXTBOX, postTitleValue);

	}

	public void enterToAddNewPostBody(String postBodyValue) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.POST_BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.POST_BODY_BUTTON);

		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX);
		clearValueInElementByPresskey(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX, postBodyValue);

	}

	public void clickToPublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
	}

	public void clickToPrePublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);

	}

	public boolean isPostPublishMessageDisplayed(String postPublishedMessage) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_PUBLISH_OR_UPDATE_MESSAGE, postPublishedMessage);
		return isElementDisplay(driver, AdminPostAddNewPageUI.POST_PUBLISH_OR_UPDATE_MESSAGE, postPublishedMessage);
	}

	public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
		openPageUrl(driver, searchPostUrl);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}

}
