package pageObject.jQuery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.uploadFile.HomePageUIs;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileloadedByName(String fileName) {
		waitForAllElementVisible(driver, HomePageUIs.FILE_NAME_LOADED, fileName);
		return isElementDisplay(driver, HomePageUIs.FILE_NAME_LOADED, fileName);
	}

	public boolean isFileLinkUploadedByName(String fileName) {
		waitForAllElementVisible(driver, HomePageUIs.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisplay(driver, HomePageUIs.FILE_NAME_UPLOADED_LINK, fileName);

	}

	public void clickToStartButton() {
		List<WebElement> startButtons = getListWebElement(driver, HomePageUIs.START_UPLOAD_BUTTON);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
	}

	public boolean isFileImageUploadedByName(String fileName) {
		waitForAllElementVisible(driver, HomePageUIs.FILE_NAME_UPLOADED_IMAGE, fileName);
		return isImageLoaded(driver, HomePageUIs.FILE_NAME_UPLOADED_IMAGE, fileName);
	}

}
