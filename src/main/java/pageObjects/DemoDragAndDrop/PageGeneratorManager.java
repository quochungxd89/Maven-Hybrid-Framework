package pageObjects.DemoDragAndDrop;

import org.openqa.selenium.WebDriver;
import pageObjectSauceLab.LoginPageObject;
import pageObjectSauceLab.ProductPageObject;

public class PageGeneratorManager {
	public static HomePage getHomePage(WebDriver driver) {
		return new HomePage(driver);
	}
	public static IframePage getIframePage(WebDriver driver){
		return new IframePage(driver);
	}
}
