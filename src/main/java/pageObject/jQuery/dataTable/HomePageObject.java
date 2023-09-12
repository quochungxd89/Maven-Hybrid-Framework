package pageObject.jQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.dataTable.HomePageUIs;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUIs.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUIs.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUIs.PAGINATION_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplay(driver, HomePageUIs.PAGINATION_ACTIVE_BY_NUMBER, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUIs.TOTAL_PAGE_PAGINATION);
		System.out.println("Total size = " + totalPage);
		List<String> allRowValuesAllPage = new ArrayList<String>();

		// Duyệt qua tất cả các paging number
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUIs.PAGINATION_PAGE_INDEX, String.valueOf(index));
			sleepInSecond(1);

			// get text cảu all row mỗi page đưa vào Arraylist
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUIs.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValuesAllPage.add(eachRow.getText());

			}
		}
		// in tất cả các giá trị row ra- tất cả các page
		for (String value : allRowValuesAllPage) {
			System.out.println("---------------------");
			System.out.println(value);
		}
		return allRowValuesAllPage;

	}

	public List<String> getValueEachColumnByLabelAtAllPage(String headerLabel) {
		int totalPage = getElementSize(driver, HomePageUIs.TOTAL_PAGE_PAGINATION);
		System.out.println("Total size = " + totalPage);
		List<String> allColumnValuesByLabelAllPage = new ArrayList<String>();

		// Duyệt qua tất cả các paging number
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUIs.PAGINATION_PAGE_INDEX, String.valueOf(index));
			// sleepInSecond(1);

			// get text cua all column mỗi page theo label đưa vào Arraylist
			List<WebElement> allColumnElementByLabelEachPage = getListWebElement(driver, HomePageUIs.ALL_VALUE_EACH_COLUMN_BY_LABEL, headerLabel);
			for (WebElement eachColumn : allColumnElementByLabelEachPage) {
				allColumnValuesByLabelAllPage.add(eachColumn.getText());

			}
		}
		// in tất cả các giá trị row ra- tất cả các page
		for (String value : allColumnValuesByLabelAllPage) {
			// System.out.println("---------------------");
			System.out.println(value);
		}
		return allColumnValuesByLabelAllPage;

	}

	public void enterToTextboxAtRowNumberByColumnName(String columnName, String rowNumber, String valueToEnter) {
		// lay ra column index dua vao ten cot
		int columnIndex = getElementSize(driver, HomePageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;

		// sendkey vao dong nao
		waitForElementVisible(driver, HomePageUIs.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUIs.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToEnter, rowNumber, String.valueOf(columnIndex));
	}

	public void selectDropDownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSelect) {
		int columnIndex = getElementSize(driver, HomePageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUIs.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUIs.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber, String.valueOf(columnIndex));
	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUIs.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckboxOrRadio(driver, HomePageUIs.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUIs.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		uncheckToDefaultCheckbox(driver, HomePageUIs.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver, HomePageUIs.ICON_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, iconName);
		clickToElement(driver, HomePageUIs.ICON_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, iconName);
	}
}
