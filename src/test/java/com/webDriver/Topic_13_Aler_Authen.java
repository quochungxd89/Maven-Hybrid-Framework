package com.webDriver;

import commons.BasePage;
import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_13_Aler_Authen extends BaseTest {
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
    public void TC_01_Authentication_Pass_URL() {
     String userName = "admin";
     String passWord = "admin";
     //Cach 1
//     log.info("truyen thang user/pass vao URL");
//     driver.get("https://"+ userName + ":" + passWord + "@the-internet.herokuapp.com/basic_auth");
//     Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());

    //Cach 2
     log.info("Dung ham split");
     driver.get("https://the-internet.herokuapp.com/");
     String authenLinkUrl = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
     System.out.println(authenLinkUrl);

//    String[] authenArray = authenLinkUrl.split("//");
//    driver.get(authenArray[0] +"//" + userName + ":" + passWord + "@" + authenArray[1]);
     getAuthenAlertByUrl(authenLinkUrl,userName,passWord);
     Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());

 }
    @Test
    public void TC_02_Authentication_selenium_4x() {

    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }
    public  void getAuthenAlertByUrl(String url,String userName, String passWord) {
        String[] authenArray = url.split("//");
        driver.get(authenArray[0] +"//" + userName + ":" + passWord + "@" + authenArray[1]);
    }
    public void sleepInSecond(long timeInSecond) {

        try {

            Thread.sleep(timeInSecond * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
