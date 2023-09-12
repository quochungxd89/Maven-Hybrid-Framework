package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.Wordpress.AdminDashboardPO;
import pageObjects.Wordpress.AdminLoginPO;
import pageObjects.Wordpress.AdminPostAddNewPO;
import pageObjects.Wordpress.AdminPostSearchPO;
import pageObjects.Wordpress.PageGeneratorManager;
import pageObjects.Wordpress.UserHomePO;
import pageObjects.Wordpress.UserPostDetailPO;
import pageObjects.Wordpress.UserSearchPostPO;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	String adminUsername = "automationfc";
	String adminPassword = "automationfc";
	int randomNumber = generateFakeNumber();
	String postTitle = "Live Coding title" + randomNumber;
	String postBody = "Live Coding body" + randomNumber;
	String editPostTitle = "edit Coding title" + randomNumber;
	String editPostBody = "edit Coding body" + randomNumber;
	String searchPostUrl;
	String authorName = "automation FC";
	String adminUrl, endUserUrl;
	String currenDay = getCurrentDate();

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("Pre-Condition - Step 01: Open browser and admin Url");
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		driver = getBrowserDriver(browserName, this.adminUrl);
		adminLoginPage = PageGeneratorManager.getLoginPage(driver);

		log.info("Pre-Condition - Step 02: Enter to Username textbox with value =" + adminUsername);
		adminLoginPage.enterToUserNameTextbox(adminUsername);

		log.info("Pre-Condition - Step 03: Enter to Password textbox with value =" + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);

		log.info("Pre-Condition - Step 04: Click to login button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();

	}

	@Test
	public void Post_01_Creat_New_Post() {
		log.info("Creat_Post - Step 01: Click to 'Posts menu' Link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Creat_Post - Step 02: Get 'Search Posts' page Url");
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);

		log.info("Creat_Post - Step 03: Click to 'Add new' button");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();

		log.info("Creat_Post - Step 04: Enter to post title");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitle);

		log.info("Creat_Post - Step 04: Enter to body");
		adminPostAddNewPage.enterToAddNewPostBody(postBody);

		log.info("Creat_Post - Step 05: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishButton();

		log.info("Creat_Post - Step 05: Click to 'Pre Publish' button");
		adminPostAddNewPage.clickToPrePublishButton();

		log.info("Creat_Post - Step 06: Verify 'Post published ' message displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));
	}

	@Test
	public void Post_02_Search_Post() {
		log.info("Search_Post - Step 01: Open 'Search Post' Page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

		log.info("Search_Post - Step 02: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextBox(postTitle);

		log.info("Search_Post - Step 03: click to 'Search post' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Search_Post - Step 04: Verify Search table contains '" + postTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("Title", postTitle));

		log.info("Search_Post - Step 05: Verify Search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("Author", authorName));

		log.info("Search_Post - Step 06: Open End User Site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Search_Post - Step 07: Verify post title info displayed at Home Page");
		verifyTrue(userHomePage.isPostInForDisplayedWithPostTitle(postTitle));
		verifyTrue(userHomePage.isPostInForDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userHomePage.isPostInForDisplayedWithPostAuthor(postTitle, authorName));
		verifyTrue(userHomePage.isPostInForDisplayedWithPostCurrentDay(postTitle, currenDay));

		log.info("Search_Post - Step 08: Click to post title ");
		userPostDetailPage = userHomePage.clickToPostTitle(postTitle);

		log.info("Search_Post - Step 09: Verify post inof displayed at Post detail page ");
		verifyTrue(userPostDetailPage.isPostInForDisplayedWithPostTitle(postTitle));
		verifyTrue(userPostDetailPage.isPostInForDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userPostDetailPage.isPostInForDisplayedWithPostAuthor(postTitle, authorName));
		verifyTrue(userPostDetailPage.isPostInForDisplayedWithPostCurrentDay(postTitle, currenDay));
	}

	@Test
	public void Post_03_Edit_Post() {
		log.info("Edit_Post - Step 01: Open 'admin' Page");
		userPostDetailPage.openAdminSite(driver, this.adminUrl);

		log.info("Edit_Post - Step 02: Click to 'Posts menu' Link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Edit_Post - Step 03: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextBox(postTitle);

		log.info("Edit_Post - Step 04: click to 'Search post' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Edit_Post - Step 05: click to 'Post Title' link and navigate to edit post");
		adminPostAddNewPage = adminPostSearchPage.clickToPostTitleLink(postTitle);

		log.info("Edit_Post - Step 06: Enter to edit post title");
		adminPostAddNewPage.enterToAddNewPostTitle(editPostTitle);

		log.info("Edit_Post - Step 07: Enter to edit body");
		adminPostAddNewPage.enterToAddNewPostBody(editPostBody);

		log.info("Edit_Post - Step 08: Click to 'Update' button");
		adminPostAddNewPage.clickToPublishButton();

		log.info("Edit_Post - Step 09: Verify 'Post UPDATE ' message displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post updated."));

		log.info("Edit_Post - Step 10: Open 'Search Post' Page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

		log.info("Edit_Post - Step 11: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextBox(editPostTitle);

		log.info("Edit_Post - Step 12: click to 'Search post' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Edit_Post - Step 13: Verify Search table contains '" + editPostTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("Title", editPostTitle));

		log.info("Edit_Post - Step 14: Verify Search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("Author", authorName));

		log.info("Edit_Post - Step 15: Open End User Site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Search_Post - Step 16: Verify post title info displayed at Home Page");
		verifyTrue(userHomePage.isPostInForDisplayedWithPostTitle(editPostTitle));
		verifyTrue(userHomePage.isPostInForDisplayedWithPostBody(editPostTitle, editPostBody));
		verifyTrue(userHomePage.isPostInForDisplayedWithPostAuthor(editPostTitle, authorName));
		verifyTrue(userHomePage.isPostInForDisplayedWithPostCurrentDay(editPostTitle, currenDay));

		log.info("Search_Post - Step 08: Click to post title ");
		userPostDetailPage = userHomePage.clickToPostTitle(editPostTitle);

		log.info("Search_Post - Step 09: Verify post inof displayed at Post detail page ");
		verifyTrue(userPostDetailPage.isPostInForDisplayedWithPostTitle(editPostTitle));
		verifyTrue(userPostDetailPage.isPostInForDisplayedWithPostBody(editPostTitle, editPostBody));
		verifyTrue(userPostDetailPage.isPostInForDisplayedWithPostAuthor(editPostTitle, authorName));
		verifyTrue(userPostDetailPage.isPostInForDisplayedWithPostCurrentDay(editPostTitle, currenDay));

	}

	@Test
	public void Post_04_Delete_Post() {
		log.info("Delete_Post - Step 01: Open 'admin' Page");
		userPostDetailPage.openAdminSite(driver, this.adminUrl);

		log.info("Delete_Post - Step 02: Click to 'Posts menu' Link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Delete_Post - Step 03: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextBox(editPostTitle);

		log.info("Delete_Post - Step 04: click to 'Search post' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Delete_Post - Step 05: select Post detail checkbox");
		adminPostSearchPage.selectPostCheckboxByTitle(editPostTitle);

		log.info("Delete_Post - Step 06: select 'Move to trash' item in dropdown");
		adminPostSearchPage.selectItemActionDropDown("Move to trash");

		log.info("Delete_Post - Step 07: click to 'Apply' button");
		adminPostSearchPage.clickToApplyButton();

		log.info("Delete_Post - Step 08: Verify '1 post moved to the trash ' message is displayed");
		verifyTrue(adminPostSearchPage.isMoveToTrashMessageDisplayed("1 post moved to The Trash."));

		log.info("Delete_Post - Step 09: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextBox(editPostTitle);

		log.info("Delete_Post - Step 10: click to 'Search post' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Delete_Post - Step 11: Verify 'no posts found ' message is displayed");
		verifyTrue(adminPostSearchPage.isNoPostFoundMessageDisplayed("No posts found."));

		log.info("Delete_Post - Step 12: Open End User Site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Delete_Post - Step 13: Verify post title undisplayed at Home Page");
		verifyTrue(userHomePage.isPostInfoUndisplayedWithPostTitle(editPostTitle));

		log.info("Delete_Post - Step 14: Enter to Search textbox");
		userHomePage.enterToSearchTextbox(editPostTitle);

		log.info("Delete_Post - Step 15: click to 'Search post' button");
		userSearchPostPage = userHomePage.clickSearchButton();

		log.info("Delete_Post - Step 16: Verify 'no posts found ' message is displayed");
		verifyTrue(userSearchPostPage.isNothingFoundMessageDisplayed("Nothing Found"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass(WebDriver driver) {
		driver.quit();
	}

	WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
	UserHomePO userHomePage;
	UserPostDetailPO userPostDetailPage;
	UserSearchPostPO userSearchPostPage;
}
