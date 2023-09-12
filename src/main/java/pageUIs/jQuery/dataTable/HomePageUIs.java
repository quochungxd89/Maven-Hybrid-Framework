package pageUIs.jQuery.dataTable;

public class HomePageUIs {
	public static final String PAGINATION_PAGE_BY_NUMBER = "//a[text()='%s']";
	public static final String PAGINATION_ACTIVE_BY_NUMBER = "//a[@class='qgrd-pagination-page-link active' and text() = '%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "//div[text()='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGE_PAGINATION = "//ul[@class='qgrd-pagination-ul']//li";
	public static final String PAGINATION_PAGE_INDEX = "//ul[@class='qgrd-pagination-ul']//li[%s]/a";
	public static final String ALL_VALUE_EACH_COLUMN_BY_LABEL = "//td[@data-key='%s']";
	public static final String ALL_ROW_EACH_PAGE = "//tbody//tr";

	// index cua cai cot ma minh can enter/click/select vao
	public static final String COLUMN_INDEX_BY_NAME = "//tr/th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "//tbody/tr[%s]/td[%s]/div/select";
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "//tbody/tr[%s]/td[%s]/label/input";
	public static final String ICON_BY_COLUMN_INDEX_AND_ROW_INDEX = "//tbody/tr[%s]//button[@title='%s']";

}
