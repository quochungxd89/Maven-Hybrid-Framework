package PageUI.wordpress;

public class AdminPostSearchPageUI {
	public static final String ADD_NEW_BUTTON = "//a[@class='page-title-action']";
	public static final String SEARCH_TEXTBOX = "//input[@id='post-search-input']";
	public static final String SEARCH_POSTS_BUTTON = "//input[@id='search-submit']";
	public static final String TABLE_HEADER_INDEX_BY_HEADER_NAME = "//table[contains(@class,'table-view-list posts')]//th[@id='%s']/preceding-sibling::td";
	public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "//table[contains(@class,'table-view-list posts')]//tbody/tr/*[%s]//a[text()='%s']";
	public static final String ROW_TITLE_DETAIL_BY_TITLE_NAME = "//table[contains(@class,'table-view-list posts')]//tbody/tr//a[@class='row-title' and text()='%s']";
	public static final String ROW_CHECKBOX_BY_TITLE_NAME = "//table[contains(@class,'table-view-list posts')]//tbody/tr/th/label[contains(text(),'%s')]/following-sibling::input";
	public static final String ACTION_DROPDOWN = "//select[@id='bulk-action-selector-top']";
	public static final String APPLY_BUTTON = "//input[@id='doaction']";
	public static final String MOVE_TO_TRASH_MESSAGE = "//div[@id='message']/p[contains(text(),'%s')]";
	public static final String NO_POST_FOUND_MESSAGE = "//table[contains(@class,'table-view-list posts')]//tr[@class='no-items']/td[text()='%s']";

}
