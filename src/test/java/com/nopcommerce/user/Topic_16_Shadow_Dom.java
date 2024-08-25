package com.nopcommerce.user;

import commons.BasePage;
import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_16_Shadow_Dom extends BaseTest {
 WebDriver driver;
 BasePage basePage;
 @BeforeClass
    public void beforeClass(){
     basePage = new BasePage();
     driver = WebDriverManager.chromedriver().create();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 }
 @Test
    public void TC_01() {
     driver.get("https://automationfc.github.io/shadow-dom/");
     sleepInSecond(2);
     String someText;
     SearchContext shadowRootContext = basePage.getShadowRootContext(driver, "css=div#shadow_host");
     someText = shadowRootContext.findElement(By.cssSelector("span#shadow_content>span")).getText();

     System.out.println(someText);
     verifyEquals(someText, "some text");

     WebElement checkBoxShadow = shadowRootContext.findElement(By.cssSelector("input[type='checkbox']"));
     verifyFalse(checkBoxShadow.isSelected());

     List<WebElement> allInput = shadowRootContext.findElements(By.cssSelector("input"));
     System.out.println(allInput.size());

     shadowRootContext.findElement(By.cssSelector("input[type='text']")).sendKeys("Miumiu");
     sleepInSecond(5);

 }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }
    public void sleepInSecond(long timeInSecond) {

        try {

            Thread.sleep(timeInSecond * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
