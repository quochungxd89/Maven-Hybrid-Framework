package com.saurcelab.sorf;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectSauceLab.LoginPageObject;
import pageObjectSauceLab.PageGeneratorManager;
import pageObjectSauceLab.ProductPageObject;

public class Level_19_Sort_ASC_DESC extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPageObject(driver);

		loginPage.enterToUserNameTextbox("standard_user");
		loginPage.enterToPasswordTextbox("secret_sauce");
		productPage = loginPage.clickToLoginButton();

	}

	// @Test
	public void Sort_01_Name() {
		// ASC
		productPage.selectItemInProductSortDropdown("Name (A to Z)");

		Assert.assertTrue(productPage.isProductNameSortByASC());

		// DESC
		productPage.selectItemInProductSortDropdown("Name (Z to A)");

		Assert.assertTrue(productPage.isProductNameSortByDESC());

	}

	@Test
	public void Sort_02_Price() {
		// ASC
		productPage.selectItemInProductSortDropdown("Price (low to high)");

		Assert.assertTrue(productPage.isProductPriceSortByASC());

		// DESC
		productPage.selectItemInProductSortDropdown("Price (high to low)");

		Assert.assertTrue(productPage.isProductPriceSortByDESC());

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private LoginPageObject loginPage;
	private ProductPageObject productPage;

}
