package PageUI.wordpress;

public class UserPostDetailPageUI {
	public static final String POST_TITLE_TEXT = "xpath=//header/following-sibling::div//h1[contains(text(),'%s')]";
	public static final String POST_CURRENT_DAY_TEXT_BY_POST_TITLE = "xpath=//header/following-sibling::div//h1[contains(text(),'%s')]/ancestor::div//time[@class='entry-date published' and text()='%s']";
	public static final String POST_BODY_TEXT_BY_POST_TITLE = "xpath=//header/following-sibling::div//h1[contains(text(),'%s')]/ancestor::div//p[text()='%s']";
	public static final String POST_AUTHOR_TEXT_BY_POST_TITLE = "xpath=//header/following-sibling::div//h1[contains(text(),'%s')]/ancestor::div//a[text()='%s']";

}
