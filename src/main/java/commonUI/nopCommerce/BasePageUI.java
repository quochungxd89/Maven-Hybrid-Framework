package commonUI.nopCommerce;

public class BasePageUI {
	public static final String ADDRESS_LINK = "//div[@class='block block-account-navigation']//a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK = "//div[@class='block block-account-navigation']//a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "//div[@class='block block-account-navigation']//a[text()='Reward points']";

	public static final String DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA = "//div[@class='block block-account-navigation']//a[text()='%s']";

	public static final String USER_LOGOUT_LINK = "//a[@class = 'ico-logout']";
	public static final String ADMIN_LOGOUT_LINK = "//a[text() = 'Logout']";

	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "//label[contains(text(),'%s')]/following-sibling::input";
}
