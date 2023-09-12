package PageUI.wordpress;

public class AdminPostAddNewPageUI {
	public static final String POST_TITLE_TEXTBOX = "//h1[@aria-label = 'Add title']";
	public static final String POST_BODY_BUTTON = "//p[contains(@class,'block-editor-rich-text__editable')]";
	public static final String POST_BODY_TEXTBOX = "//p[contains(@class,'block-editor-rich-text__editable')]";
	public static final String PUBLISH_OR_UPDATE_BUTTON = "//div[@aria-label='Editor top bar']//button[text()='Publish']";
	public static final String PRE_PUBLISH_BUTTON = "//div[@aria-label='Editor publish']//button[text()='Publish']";
	public static final String POST_PUBLISH_OR_UPDATE_MESSAGE = "//div[@class='components-snackbar_content' and text()= '%s']";

}
