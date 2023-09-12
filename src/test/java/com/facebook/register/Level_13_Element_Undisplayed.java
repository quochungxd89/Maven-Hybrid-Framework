package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.Facebook.LoginPageObject;
import pageObject.Facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);

	}

	@Test
	public void User_01_Verify_Element_Displayed() {
		loginPage.clickToCreatNewAccountButton();
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());

	}

	@Test
	public void User_02_Verify_Element_Undisplayed_In_Dom() {
		// Verify True - mong doi confirm email Display
		loginPage.enterToEmailAddressTextBox("automation@gmail.com");
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());
		// Verify False - cho ham tra ve la Display
		loginPage.enterToEmailAddressTextBox("");
		loginPage.sleepInSecond(3);
		// verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());

	}

	@Test
	public void User_03_Verify_Element_Undisplayed_Not_In_Dom() {
		loginPage.clickCloseIconAtRegisterForm();
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;

}
