package demoDragAndDrop;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.DemoDragAndDrop.HomePage;
import pageObjects.DemoDragAndDrop.PageGeneratorManager;


public class TestDemoDragAndDrop extends BaseTest {
    private WebDriver driver;
    private HomePage homePage;
    @Parameters({ "browser", "url" })
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);

        homePage = PageGeneratorManager.getHomePage(driver);
    }
    @Test
    public void dragAndDrop(){
        homePage.dragAndDropItem(driver,"angular");
        homePage.dragAndDropItem(driver,"mongo");
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}

