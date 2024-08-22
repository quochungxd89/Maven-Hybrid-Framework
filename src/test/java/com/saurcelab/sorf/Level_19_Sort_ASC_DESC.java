package com.saurcelab.sorf;

import commons.BasePage;
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
	private WebDriver driver;
	private LoginPageObject loginPage;
	private ProductPageObject productPage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPageObject(driver);

		loginPage.enterToUserNameTextbox("standard_user");
		loginPage.enterToPasswordTextbox("secret_sauce");
		productPage = loginPage.clickToLoginButton();

	}

	 @Test
	public void Sort_01_Name() {
		// ASC
		 log.info("Sap xep name tu A toi Z");
		productPage.selectItemInProductSortDropdown("Name (A to Z)");

		verifyTrue(productPage.isProductNameSortByASC());

		// DESC
		 log.info("Sap xep name tu Z toi A");
		 productPage.selectItemInProductSortDropdown("Name (Z to A)");

		verifyTrue(productPage.isProductNameSortByDESC());

	}

	@Test
	public void Sort_02_Price() {
		// ASC
		log.info("Sắp xếp giá từ thấp đến cao");
		productPage.selectItemInProductSortDropdown("Price (low to high)");

		verifyTrue(productPage.isProductPriceSortByASC());

		// DESC
		log.info("Sắp xếp giá từ cao đến thấp");
		productPage.selectItemInProductSortDropdown("Price (high to low)");

		verifyTrue(productPage.isProductPriceSortByDESC());
		sleepInSecond(10);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}



	public void sleepInSecond(long timeInSecond) {

		try {

			Thread.sleep(timeInSecond * 1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
