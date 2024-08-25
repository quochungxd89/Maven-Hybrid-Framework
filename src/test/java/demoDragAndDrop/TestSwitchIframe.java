package demoDragAndDrop;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.DemoDragAndDrop.HomePage;
import pageObjects.DemoDragAndDrop.IframePage;
import pageObjects.DemoDragAndDrop.PageGeneratorManager;


public class TestSwitchIframe extends BaseTest {
    private WebDriver driver;
    private IframePage iframePage;
    @Parameters({ "browser", "url" })
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);

        iframePage = PageGeneratorManager.getIframePage(driver);
    }
    @Test
    public void swichToiFrame(){
        System.out.println(driver.getWindowHandles());
        iframePage.switchToIframe(driver);
//        iframePage.inputTextBox(driver,"haha");
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}

