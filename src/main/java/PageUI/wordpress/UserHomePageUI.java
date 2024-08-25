package PageUI.wordpress;

public class UserHomePageUI {
	public static final String POST_TITLE_TEXT = "xpath=//article//h2/a[text()='%s']";
	public static final String POST_CURRENT_DAY_TEXT_BY_POST_TITLE = "xpath=//article//h2/a[text()='%s']/parent::h2/parent::header/following-sibling::div//time[text()='%s']";
	public static final String POST_BODY_TEXT_BY_POST_TITLE = "xpath=//article//h2/a[text()='%s']/ancestor::header/following-sibling::div/p[text()='%s']";
	public static final String POST_AUTHOR_TEXT_BY_POST_TITLE = "xpath=//article//h2/a[text()='%s']/parent::h2/parent::header/following-sibling::div//a[text()='%s']";
	public static final String SEARCH_TEXT_BOX = "xpath=//input[@class='wp-block-search__input']";
	public static final String SEARCH_BUTTON = "xpath=//button[@aria-label='Search']";
}
