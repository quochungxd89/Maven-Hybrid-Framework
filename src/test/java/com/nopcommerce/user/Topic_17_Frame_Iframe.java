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

public class Topic_17_Frame_Iframe extends BaseTest {
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
     //Truy cap trang A
     driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
     sleepInSecond(2);
     basePage.scrollToElement(driver,"css=div#imageTemplateContainer>img");
     basePage.clickToElement(driver,"css=div#imageTemplateContainer>img");
     sleepInSecond(3);

     //iframe hien thi
     WebElement formIframe = basePage.getWebElement(driver,"css=div#formTemplateContainer>iframe");
     verifyTrue(formIframe.isDisplayed());

     //swich vao iframe/frame
     basePage.switchToFramIframe(driver,"css=div#formTemplateContainer>iframe");
     basePage.selectItemInDefaultDropdown(driver,"css=select#RESULT_RadioButton-2","Sophomore");
    sleepInSecond(3);

    //switch lai trang a
     basePage.switchToDefaultContent(driver);

    //Thao tac element ngoai iframe
     basePage.clickToElement(driver,"css=nav.header--desktop-floater a.menu-item-login");
     sleepInSecond(3);
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
