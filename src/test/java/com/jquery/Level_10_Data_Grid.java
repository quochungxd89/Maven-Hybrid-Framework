package com.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.dataTable.HomePageObject;
import pageObject.jQuery.dataTable.PageGeneratorManager;

public class Level_10_Data_Grid extends BaseTest {
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedlAllCountryValues;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	 @Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		homePage.openPagingByPageNumber("7");
		Assert.assertTrue(homePage.isPageNumberActived("7"));

		homePage.openPagingByPageNumber("8");
		Assert.assertTrue(homePage.isPageNumberActived("8"));

		homePage.openPagingByPageNumber("18");
		Assert.assertTrue(homePage.isPageNumberActived("18"));

	}

	 @Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);

		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextboxByLabel("Females", "338282");
		homePage.enterToHeaderTextboxByLabel("Males", "349238");
		homePage.enterToHeaderTextboxByLabel("Total", "687522");
		homePage.sleepInSecond(2);

		homePage.enterToHeaderTextboxByLabel("Country", "Angola");
		homePage.enterToHeaderTextboxByLabel("Females", "276880");
		homePage.enterToHeaderTextboxByLabel("Males", "276472");
		homePage.enterToHeaderTextboxByLabel("Total", "553353");
		homePage.sleepInSecond(2);

	}

	 @Test
	public void Table_03_Enter_To_Header() {
		// homePage.getValueEachRowAtAllPage();

		// Đọc dữ liệu từ file country.txt ra
		// Lưu vào 1 List<String> = Expected Value = expectedAllCountryValúe
		actualAllCountryValues = homePage.getValueEachColumnByLabelAtAllPage("country");

		Assert.assertEquals(actualAllCountryValues, expectedlAllCountryValues);

	}

	@Test
	public void Table_04_Action_At_Any_Row() {
		// value de nhap lieu - tham so 1
		// Row Number : tai cai row nao
		// ex: nhap vao textbox tai dong so 3/5/7
		// tai cot nao: column name
		homePage.enterToTextboxAtRowNumberByColumnName("Company", "1", "michael 97");
		homePage.enterToTextboxAtRowNumberByColumnName("Contact Person", "2", "michael 98");
		homePage.enterToTextboxAtRowNumberByColumnName("Order Placed", "3", "15");

		homePage.selectDropDownByColumnNameAtRowNumber("Country", "1", "Germany");
		homePage.sleepInSecond(2);
		homePage.selectDropDownByColumnNameAtRowNumber("Country", "2", "Japan");
		homePage.sleepInSecond(2);
		homePage.selectDropDownByColumnNameAtRowNumber("Country", "3", "Taiwan");
		homePage.sleepInSecond(2);

		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "2");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "3");

		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "2");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "3");

		homePage.clickToIconByRowNumber("1", "Move Down");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("2", "Move Up");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("4", "Remove Current Row");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("3", "Remove Current Row");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;

}
