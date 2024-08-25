package pageObjects.DemoDragAndDrop;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class IframePage extends BasePage {
    WebDriver driver;

    public IframePage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToIframe(WebDriver driver) {
        switchToFramIframeByID(driver,"singleframe");
        System.out.println(driver.getWindowHandles());
        sleepInSecond(2);
    }

}
