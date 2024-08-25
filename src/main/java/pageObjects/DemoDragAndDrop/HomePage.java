package pageObjects.DemoDragAndDrop;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void dragAndDropItem(WebDriver driver, String dynamicText) {
        dragAndDrop(driver,HomePageUIs.IMG_BY_DANAMIC_XPATH_ID,HomePageUIs.DIV_BY_DANAMIC_XPATH_ID,dynamicText,"droparea");
        sleepInSecond(2);
    }
}
