package com.QuerySQL;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SeleniumTestWithSQL {
    private WebDriver driver;
    private Connection connection;

    @BeforeClass
    public void setUp() {
        // Khởi tạo WebDriver
        WebDriverManager.chromedriver().setup(); // Sử dụng WebDriverManager để tự động tải driver
        driver = new ChromeDriver();

        // Kết nối đến cơ sở dữ liệu
        try {
            String url = "jdbc:mysql://localhost:3306/store"; // URL kết nối
            String user = "root"; // Tên người dùng
            String password = ""; // Mật khẩu
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWebsiteAndDatabase() {
        // Truy vấn cơ sở dữ liệu để kiểm tra dữ liệu
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name FROM tbl_category WHERE name = 'Lap Top'");

            // Kiểm tra kết quả của truy vấn
            boolean found = false;
            while (resultSet.next()) {
                String dbValue = resultSet.getString("name");
                System.out.println("Retrieved from database: " + dbValue);
                if ("Lap Top".equals(dbValue)) {
                    found = true;
                    break;
                }
            }

            // Xác nhận giá trị
            Assert.assertTrue(found, "Expected value 'Lap Top' not found in the database!");

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Database query failed!");
        }
    }
    @Test
    public void count() {
        // Truy vấn cơ sở dữ liệu để kiểm tra số lượng dữ liệu
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name FROM tbl_category");

            // Đếm số lượng hàng trong kết quả
            int rowCount = 0;
            while (resultSet.next()) {
                rowCount++;
                String dbValue = resultSet.getString("name");
                System.out.println("Retrieved from database: " + dbValue);
            }

            // Xác nhận số lượng hàng
            int expectedRowCount = 3; // Thay đổi số lượng hàng mong đợi của bạn
            Assert.assertEquals(rowCount, expectedRowCount, "Number of rows does not match the expected value!");

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Database query failed!");
        }
    }
    @AfterClass
    public void tearDown() {
        // Đóng WebDriver
        if (driver != null) {
            driver.quit();
        }

        // Đóng kết nối cơ sở dữ liệu
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}