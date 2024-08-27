package com.nopcommerce.user;

import commons.BasePage;
import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_18_Handle_Tab_Window extends BaseTest {
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
     log.info("Truy cap trang techpanda");
     driver.get("http://live.techpanda.org/");
     String homePageTitle = driver.getTitle();
     System.out.println(homePageTitle);
     sleepInSecond(2);

     log.info("New 1 window moi");
     driver.switchTo().newWindow(WindowType.WINDOW);
     driver.get("http://live.techpanda.org/index.php/customer/account/login");
     String loginPageTitle = driver.getTitle();
     System.out.println(loginPageTitle);
     driver.findElement(By.id("email")).sendKeys("harry@gmail.com");
     driver.findElement(By.id("pass")).sendKeys("harry@gmail.com");
     sleepInSecond(3);

     log.info("New 1 tab moi");
     driver.switchTo().newWindow(WindowType.TAB);
     driver.get("http://live.techpanda.org/index.php/customer/account/create");
     String createPageTitle = driver.getTitle();
     System.out.println(createPageTitle);

     basePage.switchToWindowByPageTitle(driver,loginPageTitle);
     System.out.println(driver.getTitle());

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
